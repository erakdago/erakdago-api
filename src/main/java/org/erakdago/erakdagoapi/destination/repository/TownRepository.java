package org.erakdago.erakdagoapi.destination.repository;

import org.erakdago.erakdagoapi.config.DatabaseConnection;
import org.erakdago.erakdagoapi.destination.model.Town;
import org.erakdago.erakdagoapi.exception.DatabaseException;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


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
}

