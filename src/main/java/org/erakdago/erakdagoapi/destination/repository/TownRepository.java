package org.erakdago.erakdagoapi.destination.repository;

import org.erakdago.erakdagoapi.config.DatabaseConnection;
import org.erakdago.erakdagoapi.destination.model.Town;
import org.erakdago.erakdagoapi.exception.DatabaseException;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.*;


@Repository
public class TownRepository {

    public List<Town> findTowns() {
        String findQuery = "SELECT * FROM towns";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(findQuery);
             ResultSet rs = ps.executeQuery()) {

            List<Town> towns = new ArrayList<>();

            while (rs.next()) {
                Array sqlArray = rs.getArray("image");

                List<String> images = sqlArray != null
                        ? Arrays.asList((String[]) sqlArray.getArray())
                        : new ArrayList<>();

                Town town = new Town(
                        rs.getObject("id", UUID.class),
                        rs.getString("name"),
                        rs.getString("description"),
                        images,
                        null,
                        null,
                        null,
                        rs.getObject("region_id", UUID.class),
                        null,
                        null,
                        null
                );

                towns.add(town);
            }

            return towns;

        } catch (SQLException e) {
            throw new DatabaseException(
                    "Error encountered while trying to find towns",
                    e
            );
        }
    }

    public Optional<Town> findTownById(UUID id) {
        String findQuery = "SELECT * FROM towns WHERE id = ?";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(findQuery);
            ){
                ps.setObject(1, id);
                try(ResultSet rs = ps.executeQuery()){
                    Array sqlArray = rs.getArray("image");

                    List<String> images = sqlArray != null
                            ? Arrays.asList((String[]) sqlArray.getArray())
                            : new ArrayList<>();
                    if(rs.next()){
                        Town town = new Town(
                                rs.getObject("id", UUID.class),
                                rs.getString("name"),
                                rs.getString("description"),
                                images,
                                null,
                                null,
                                null,
                                rs.getObject("region_id", UUID.class),
                                null,
                                null,
                                null);
                        return Optional.of(town);
                    }
                    return Optional.empty();
                }
            }
        catch (SQLException e) {
            throw new DatabaseException(
                    "Error encountered while trying to find town with id " + id,
                    e
            );
        }
    }
}

