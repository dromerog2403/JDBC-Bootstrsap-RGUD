package org.gerdoc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/MiServlet")
public class MiServlet extends HttpServlet {

    private final AlumnoDao alumnoDao = new FlujoAlumnoDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        List<Alumno> alumnos = alumnoDao.obtenerTodos();

        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"es\">");
            out.println("<head>");
            out.println("<meta charset=\"utf-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
            out.println("<title>Lista de Alumnos</title>");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css\" rel=\"stylesheet\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container mt-5\">");
            out.println("<h2>Alumnos Registrados</h2>");
            out.println("<table class=\"table table-dark table-striped mt-3\">");
            out.println("<thead><tr><th scope=\"col\">ID</th><th scope=\"col\">Nombre</th><th scope=\"col\">Edad</th></tr></thead>");
            out.println("<tbody>");

            for (Alumno a : alumnos) {
                out.println("<tr>");
                out.println("<th scope=\"row\">" + a.getId() + "</th>");
                out.println("<td>" + a.getNombre() + "</td>");
                out.println("<td>" + a.getEdad() + "</td>");
                out.println("</tr>");
            }

            out.println("</tbody>");
            out.println("</table>");
            out.println("<a href=\"index.jsp\" class=\"btn btn-secondary\">Regresar</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("exampleInputName1");
        String edadStr = req.getParameter("exampleInputAge1");

        if (nombre != null && edadStr != null && !nombre.trim().isEmpty()) {
            try {
                int edad = Integer.parseInt(edadStr);
                Alumno alumno = new Alumno(0, nombre, edad);
                alumnoDao.insertar(alumno);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        doGet(req, resp);
    }
}
