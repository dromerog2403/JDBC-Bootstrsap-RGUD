package org.gerdoc;

import java.util.List;

public interface AlumnoDao {
    void insertar(Alumno alumno);
    Alumno obtenerPorId(int id);
    List<Alumno> obtenerTodos();
}
