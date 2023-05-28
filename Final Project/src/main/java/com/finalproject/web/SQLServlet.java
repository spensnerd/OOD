package com.finalproject.web;

import com.finalproject.dao.FinalDAO;
import com.finalproject.model.Projects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

//
//  ControllerServlet.java
//  This servlet acts as a page controller for the application, handling all
//  requests from the user.
//

@WebServlet("/")
public class SQLServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private FinalDAO finalDAO;

    public void init() {
        finalDAO = new FinalDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertProjects(request, response);
                    break;
                case "/delete":
                    deleteProjects(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateProjects(request, response);
                    break;
                default:
                    listProjects(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listProjects(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Projects> listProjects = finalDAO.getAllProjects();
        request.setAttribute("listProjects", listProjects);
        RequestDispatcher dispatcher = request.getRequestDispatcher("projects-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("projects-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Projects existingProjects = FinalDAO.getProjects(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("projects-form.jsp");
        request.setAttribute("project", existingProjects);
        dispatcher.forward(request, response);

    }

    private void insertProjects(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String title = request.getParameter("title");
        int budget = Integer.parseInt(request.getParameter("budget"));
        int time = Integer.parseInt(request.getParameter("time"));
        String importance = request.getParameter("importance");
        Projects newProjects = new Projects(title, budget, time, importance);
        FinalDAO.saveProjects(newProjects);
        response.sendRedirect("list");
    }

    private void updateProjects(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        int budget = Integer.parseInt(request.getParameter("budget"));
        int time = Integer.parseInt(request.getParameter("time"));
        String importance = request.getParameter("importance");

        Projects projects = new Projects(id, title, budget, time, importance);
        FinalDAO.updateProjects(projects);
        response.sendRedirect("list");
    }

    private void deleteProjects(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        FinalDAO.deleteProjects(id);
        response.sendRedirect("list");
    }
}