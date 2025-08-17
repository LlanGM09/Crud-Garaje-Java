package com.garaje.dao;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import com.garaje.modelo.Auto;
import com.garaje.util.ConfigDB;

public class AutoDao {

    public boolean insertarAuto(Auto auto) {
        String sql = "INSERT INTO autos (marca, modelo, tipo_motor, potencia) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConfigDB.conectar();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, auto.getMarca());
            ps.setString(2, auto.getModelo());
            ps.setString(3, auto.getTipoMotor());
            ps.setInt(4, auto.getPotencia());

            int filas = ps.executeUpdate();

            if (filas > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) auto.setId(rs.getInt(1));
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error al insertar auto: " + e.getMessage());
        }
        return false;
    }

    public List<Auto> listarAutos() {
        List<Auto> autos = new ArrayList<>();
        String sql = "SELECT * FROM autos";

        try (Connection conn = ConfigDB.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Auto auto = new Auto(
                        rs.getInt("id"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("tipo_motor"),
                        rs.getInt("potencia")
                );
                autos.add(auto);
            }

        } catch (SQLException e) {
            System.err.println("Error al listar autos: " + e.getMessage());
        }
        return autos;
    }

    public boolean actualizarAuto(Auto auto) {
        String sql = "UPDATE autos SET marca = ?, modelo = ?, tipo_motor = ?, potencia = ? WHERE id = ?";
        try (Connection conn = ConfigDB.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, auto.getMarca());
            ps.setString(2, auto.getModelo());
            ps.setString(3, auto.getTipoMotor());
            ps.setInt(4, auto.getPotencia());
            ps.setInt(5, auto.getId());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar auto: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarAuto(int id) {
        String sql = "DELETE FROM autos WHERE id = ?";
        try (Connection conn = ConfigDB.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al eliminar auto: " + e.getMessage());
            return false;
        }
    }

    public List<Auto>buscarPorMarca(String marca) throws SQLException {
        List<Auto> autos = new ArrayList<>();
        String sql = "SELECT * FROM autos WHERE UPPER(marca) = UPPER(?)";

        try(Connection conn =ConfigDB.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, "%" + marca + "%"); //Búsqueda por parcial
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Auto auto = new Auto(
                        rs.getInt("id"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("tipo_motor"),
                        rs.getInt("potencia")
                );
                autos.add(auto);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return  autos;
    }

    public Auto buscarPorId(int id) throws SQLException {
        Auto auto = null;
        String sql = "SELECT * FROM autos WHERE id = ?";

        try (Connection conn = ConfigDB.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    auto = new Auto(
                            rs.getInt("id"),
                            rs.getString("marca"),
                            rs.getString("modelo"),
                            rs.getString("tipo_motor"),
                            rs.getInt("potencia")
                    );
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar auto por ID: " + e.getMessage());
        }
        return auto;
    }
}






