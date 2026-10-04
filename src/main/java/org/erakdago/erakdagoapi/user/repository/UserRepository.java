package org.erakdago.erakdagoapi.user.repository;

import org.erakdago.erakdagoapi.config.DatabaseConnection;
import org.erakdago.erakdagoapi.exception.DatabaseException;
import org.erakdago.erakdagoapi.exception.UserNotFoundException;
import org.erakdago.erakdagoapi.user.dto.CreateUserDTO;
import org.erakdago.erakdagoapi.user.dto.UpdateUserDTO;
import org.erakdago.erakdagoapi.user.dto.UserResponse;
import org.erakdago.erakdagoapi.user.model.User;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepository {
    public UserRepository() throws SQLException {
    }

    public UserResponse mapRow(ResultSet rs) throws SQLException {
        return new UserResponse(
                rs.getObject("id", UUID.class),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("username"),
                rs.getString("phone_number"),
                rs.getTimestamp("registration_date").toLocalDateTime(),
                rs.getString("status")
        );
    }

    public Optional<UserResponse> findUserById(UUID id) {
        String findByIdQuery = "SELECT * FROM users WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(findByIdQuery)
        ) {
            ps.setObject(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? Optional.of(mapRow(rs)) : Optional.empty();
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error encountered while trying to find user with id " + id, e);
        }
    }

    public List<UserResponse> findUsers() {
        String findQuery = "SELECT * FROM users";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(findQuery)
        ) {
            try (ResultSet rs = ps.executeQuery()) {
                List<UserResponse> users = new ArrayList<>();
                while (rs.next()) {
                    users.add(mapRow(rs));
                }
                return users;
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error encountered while trying to find users", e);
        }
    }

    public User createUser(CreateUserDTO createUserDTO) {
        String createUserQuery = "INSERT INTO users(first_name,last_name,username,phone_number,email,password,pfp,about)" +
                " VALUES (?,?,?,?,?,?,?,?)" +
                " RETURNING *";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(createUserQuery)
        ) {
            ps.setString(1, createUserDTO.firstName());
            ps.setString(2, createUserDTO.lastName());
            ps.setString(3, createUserDTO.username());
            ps.setString(4, createUserDTO.phoneNumber());
            ps.setString(5, createUserDTO.email());
            ps.setString(6, createUserDTO.password());
            ps.setString(7, createUserDTO.pfp());
            ps.setString(8, createUserDTO.about());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new User(
                            rs.getObject("id", UUID.class),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("username"),
                            rs.getString("phone_number"),
                            rs.getString("email"),
                            rs.getString("password"),
                            rs.getString("pfp"),
                            rs.getString("about"),
                            rs.getTimestamp("registration_date") != null ? rs.getTimestamp("registration_date").toLocalDateTime() : null,
                            rs.getString("status")
                    );
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error encountered while trying to create user", e);
        }
        return null;
    }

    public boolean deleteUser(UUID id) {
        String deleteUserQuery = "DELETE FROM users WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(deleteUserQuery)
        ) {
            ps.setString(1, id.toString());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DatabaseException("Error encountered while trying to delete user: " + id, e);
        }
    }

    public UserResponse updateUser(UUID id, UpdateUserDTO updateUserDTO) {
        String updateUserQuery = """
                UPDATE users
                SET first_name = ?,
                    last_name = ?,
                    username = ?,
                    phone_number = ?,
                    email = ?,
                    pfp = ?,
                    about = ?
                WHERE id = ?
                RETURNING *
                """;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(updateUserQuery)
        ) {
            ps.setString(1, updateUserDTO.firstName());
            ps.setString(2, updateUserDTO.lastName());
            ps.setString(3, updateUserDTO.username());
            ps.setString(4, updateUserDTO.phoneNumber());
            ps.setString(5, updateUserDTO.email());
            ps.setString(6, updateUserDTO.pfp());
            ps.setString(7, updateUserDTO.about());
            ps.setObject(8, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error encountered while trying to update user: " + id, e);
        }
        throw new UserNotFoundException(id);
    }

    public Optional<String> findPasswordHashById(UUID id) {
        String findByIdPasswordQuery = """
                        SELECT password
                         FROM users
                          WHERE id = ?
                """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(findByIdPasswordQuery)
        ) {
            ps.setObject(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(rs.getString("password"));
                }
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error encountered while trying to find password for id: " + id, e);
        }
    }

    public 

}
