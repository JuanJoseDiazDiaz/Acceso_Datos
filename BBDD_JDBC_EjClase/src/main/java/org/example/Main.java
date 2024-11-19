package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String urlmSGBBLocal = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "root";
        String bbdd = "concesionario";
        String urlConexion = urlmSGBBLocal + bbdd;
        try (Connection cn = DriverManager.getConnection(urlConexion,user, password)){
            Statement st = cn.createStatement();
            String consulta = "SELECT * FROM coches";
            String actualizacion = "UPDATE coches " +
                    "SET marca=\"FORD\" " +
                    "WHERE matricula=\"1111AAA\"";
            ResultSet rs = st.executeQuery(consulta);

            while (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
            }

            st.execute(actualizacion);
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}