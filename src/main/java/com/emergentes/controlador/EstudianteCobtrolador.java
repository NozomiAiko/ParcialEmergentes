package com.emergentes.controlador;

import com.emergentes.dao.EstudianteDAO;
import com.emergentes.dao.EstudianteDAOimp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EstudianteCobtrolador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EstudianteDAO dao = new EstudianteDAOimp();
        Estudiante est = new Estudiante();
        int id;

        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        switch (action) {

            case "add":
                request.setAttribute("estudiante", est);
                request.getRequestDispatcher("frmEst.jsp").forward(request, response);
                break;
            case "edit":
                id = Integer.parseInt(request.getParameter("id"));

                try {
                    est = dao.getById(id);
                } catch (Exception ex) {
                    Logger.getLogger(EstudianteCobtrolador.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("estudiante", est);
                request.getRequestDispatcher("frmEst.jsp").forward(request, response);

                break;

            case "delete":
                id = Integer.parseInt(request.getParameter("id"));

                try {
                    dao.delete(id);
                } catch (Exception ex) {
                    Logger.getLogger(EstudianteCobtrolador.class.getName()).log(Level.SEVERE, null, ex);
                }

                response.sendRedirect("EstudianteCobtrolador");
                break;
            case "view":
                List<Estudiante> lista = new ArrayList<Estudiante>();
                 {
                    try {
                        lista = dao.getAll();
                    } catch (Exception ex) {
                        Logger.getLogger(EstudianteCobtrolador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                //no se xq esta en plural
                request.setAttribute("estudiantes", lista);
                request.getRequestDispatcher("estudiantes.jsp");
                break;

            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String seminario = request.getParameter("seminario");
        String confirmado = request.getParameter("confirmado");
        String fecha_ins = request.getParameter("fecha_ins");
        Estudiante est= new Estudiante();
        EstudianteDAO dao = new EstudianteDAOimp();
        if (id == 0) {
            try {
                dao.insert(est);
            } catch (Exception ex) {
                Logger.getLogger(EstudianteCobtrolador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                dao.update(est);
            } catch (Exception ex) {
                Logger.getLogger(EstudianteCobtrolador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        response.sendRedirect("EstudianteCobtrolador");

    }

}
