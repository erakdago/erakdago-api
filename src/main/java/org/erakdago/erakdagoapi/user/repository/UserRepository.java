package org.erakdago.erakdagoapi.user.repository;

import org.erakdago.erakdagoapi.config.DatabaseConnection;
import org.erakdago.erakdagoapi.exception.DatabaseException;
import org.erakdago.erakdagoapi.user.dto.UserResponse;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public Optional<UserResponse> findById(UUID id) {
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
}
