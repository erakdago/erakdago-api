package org.erakdago.erakdagoapi.destination.repository;

import org.erakdago.erakdagoapi.config.DatabaseConnection;
import org.erakdago.erakdagoapi.destination.model.Region;
import org.erakdago.erakdagoapi.exception.DatabaseException;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class RegionRepository {
    public List<Region> findRegions() {
        String findQuery = "SELECT * FROM regions";
        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(findQuery);
                ResultSet rs = ps.executeQuery()
                ){
            Array sqlArray = rs.getArray("image");

            List<String> images = sqlArray != null
                    ? Arrays.asList((String[]) sqlArray.getArray())
                    : new ArrayList<>();

            List<Region> regions = new ArrayList<>();
            while(rs.next()) {
                Region region = new Region(
                        rs.getObject("id", UUID.class),
                        rs.getString("name"),
                        rs.getString("description"),
                        null,
                        images,
                        null,
                        null
                );
                regions.add(region);
            }
            return regions;
        }
        catch (SQLException e){
            throw new DatabaseException(
                    "Error encountered while trying to find regions",
                    e
            );
        }
    }
}
