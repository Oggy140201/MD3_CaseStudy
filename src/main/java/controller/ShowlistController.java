package controller;

import dao.DAODepertment;
import dao.DAOStaff;
import model.ClassRoom;
import model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/homeStudent")
public class ShowlistController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            showList(req, resp);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void showList(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, ServletException, IOException {
        DAOStaff dao = new DAOStaff();
        DAODepertment daoDepartment = new DAODepertment();
        List<Student> studentList = dao.getlistStudent();

        for (Student student : studentList) {
            int classRoomObj = student.getClassRoom(1);
            ClassRoom classRoom1 = new ClassRoom((classRoomObj));
            if (classRoom1 != null) {
                ClassRoom classRoom = daoDepartment.getDepartmentByID(classRoom1.getId());
//                student.setClassRoom(classRoom);
            }
        }

        request.setAttribute("listStudent", studentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/homeStudent");
        dispatcher.forward(request, response);
    }
}
