package edu.ung.mccb.csci.csci3300.model;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class Car {
    public String getLno() {
        return Lno;
    }

    public void setLno(String lno) {
        Lno = lno;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getModel() { return model; }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


        public int saveCarIntoDatabase(String Lno, String vin, String model, String make, String year) {
            int affectedRow=0;
            String query = "insert into Vehicles" + "(Lno, vin, model, make,year)"
                    + "values(?,?,?,?,?)";

            try (Connection conn = DatabaseConfig.getConnection();
                 PreparedStatement sqlStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);) {
                sqlStatement.setString(1, Lno);
                sqlStatement.setString(2, vin);
                sqlStatement.setString(3, model);
                sqlStatement.setString(4, make);
                sqlStatement.setString(5, year);

                // get the number of return rows
                affectedRow = sqlStatement.executeUpdate();

            } catch (Exception e) {
                System.out.println("Status: operation failed due to " + e);

            }
            return affectedRow;


    }

    String Lno,vin,model,make,year;
}
