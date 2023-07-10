package controller;

import dao.DAOStaff;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            DAOStaff dao = new DAOStaff();
            boolean isDelete = dao.deleteStudent(id);
            if (isDelete) {
                resp.sendRedirect("show-list");
            } else {
                resp.sendRedirect("/delete");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
