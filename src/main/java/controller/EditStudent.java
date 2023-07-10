package controller;

import dao.DAOStaff;
import model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
@WebServlet("/edit")
public class EditStudent extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            int id = Integer.parseInt(req.getParameter("id"));
            DAOStaff dao = new DAOStaff();
            Student student = dao.getStudentID(id);
            req.setAttribute("listStudent", student);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/edit");
            dispatcher.forward(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
            try {
                updateStudent(req, resp);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        public void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String birthday = request.getParameter("birthday");
            String address = request.getParameter("address");
            int phone = Integer.parseInt(request.getParameter("phone"));
            int classRoom = Integer.parseInt(request.getParameter("classRoom"));
            DAOStaff dao = new DAOStaff();
            Student student = dao.updateStudent(id, name, email, new Date(birthday), address, phone, classRoom);
            request.setAttribute("listStudent", student);
            response.sendRedirect("show-list");
//        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
//        dispatcher.forward(request, response);
        }
    }

