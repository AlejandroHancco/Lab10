package com.example.lab10.controlador;


import com.example.lab10.entidad.Estadio;
import com.example.lab10.repositorio.EstadioRepository;
import com.example.lab10.repositorio.JugadorRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;


@WebServlet(name="EstadioServlet", urlPatterns = {"/EstadioServlet"})
public class EstadioController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action") == null ? "lista" : req.getParameter("action");
        EstadioRepository daoEstadio = new EstadioRepository();
        RequestDispatcher view;
        ArrayList<String> opciones = new ArrayList<>();

        ArrayList<String> paises = new ArrayList<>();
        paises.add("Peru");
        paises.add("Chile");
        paises.add("Argentina");
        paises.add("Paraguay");
        paises.add("Uruguay");
        paises.add("Colombia");

        opciones.add("Nombre");
        opciones.add("Pais");
        req.setAttribute("opciones", opciones);
        req.setAttribute("paises", paises);

        switch (action) {

            case "guardar":
                Estadio estadio = new Estadio();
                estadio.setNombre(req.getParameter("nombre"));
                estadio.setProvincia(req.getParameter("provincia"));
                estadio.setClub(req.getParameter("club"));
                daoEstadio.crearEstadio(estadio);
                resp.sendRedirect(req.getContextPath()+"/EstadioServlet");
                break;
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EstadioRepository daoEstadio = new EstadioRepository();
        JugadorRepository jugadorDao = new JugadorRepository();
        String action = req.getParameter("action") == null ? "lista" : req.getParameter("action");
        RequestDispatcher view;
        ArrayList<String> paises = new ArrayList<>();
        paises.add("Peru");
        paises.add("Chile");
        paises.add("Argentina");
        paises.add("Paraguay");
        paises.add("Uruguay");
        paises.add("Colombia");
        ArrayList<String> opciones = new ArrayList<>();
        opciones.add("Nombre");
        opciones.add("Pais");
        req.setAttribute("paises", paises);
        req.setAttribute("opciones", opciones);
        switch (action){
            case "lista":
                req.setAttribute("listarEstadios", daoEstadio.listarEstadio());
                view = req.getRequestDispatcher("WEB-INF/estadio/list.jsp");
                view.forward(req, resp);
                break;
            case "crear":
                view =req.getRequestDispatcher("WEB-INF/estadio/form.jsp");
                view.forward(req, resp);
                break;
            case "borrar":
                String idd= req.getParameter("id");

                    daoEstadio.borrarEstadio(Integer.parseInt(idd));

                resp.sendRedirect(req.getContextPath()+"/EstadioServlet");
                break;
        }
    }

}