package controller;

import dao.DAOStaff;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
@WebServlet("/add")
public class AddStudent extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        try {
            addNewBook(req, resp);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void addNewBook(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int phone = Integer.parseInt(request.getParameter("phone"));
        long birthday = Date.parse(request.getParameter("birthday"));
        int classRoom = Integer.parseInt(request.getParameter("classRoom"));
        DAOStaff dao = new DAOStaff();
        Student student = dao.addStudent(name, email,birthday, address, phone ,classRoom);
        request.setAttribute("listStudent", student);
        response.sendRedirect("show-list");
    }
}
