package org.gerdoc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlujoAlumnoDao implements AlumnoDao {
    private final ConexionBD conexion = new ConexionBD();

    @Override
    public void insertar(Alumno alumno) {
        String sql = "INSERT INTO alumno (nombre, edad) VALUES (?, ?)";
        try (Connection conn = conexion.ObtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, alumno.getNombre());
            ps.setInt(2, alumno.getEdad());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Alumno obtenerPorId(int id) {
        String sql = "SELECT * FROM alumno WHERE id = ?";
        try (Connection conn = conexion.ObtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Alumno(rs.getInt("id"), rs.getString("nombre"), rs.getInt("edad"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Alumno> obtenerTodos() {
        List<Alumno> lista = new ArrayList<>();
        String sql = "SELECT * FROM alumno";
        try (Connection conn = conexion.ObtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Alumno(rs.getInt("id"), rs.getString("nombre"), rs.getInt("edad")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
