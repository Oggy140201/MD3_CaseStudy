package dao;

import context.DBContext;
import model.ClassRoom;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DAOStaff {
    DAODepertment daoDepertment = new DAODepertment();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    // hiển thị toàn bộ danh sách sinh viên
    public List<Student> getlistStudent() throws ClassNotFoundException {
        List<Student> studentList = new ArrayList<>();
        String sql = "SELECT * FROM student";
        try {
            connection = new DBContext().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                Date birthday = resultSet.getDate("birthday");
                String address = resultSet.getString("address");
                int phoneNumber = resultSet.getInt("phone");
                int classRoom = resultSet.getInt("idclass");


                ClassRoom classRoom1 = daoDepertment.getDepartmentByID(classRoom);
                Student student = new Student(id, name, email, birthday, address, phoneNumber, classRoom);
                studentList.add(student);
            }
        } catch (SQLException e) {
        }
        return studentList;
    }

    //thêm nhân viên
    public Student addStudent(String name, String email, long birthday, String address, int phone, int classRoom) {
        Student student = null;
        String sql = "INSERT INTO staff(name, email, birthday, address, phone, salary, classRoom) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            connection = new DBContext().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, String.valueOf(birthday));
            preparedStatement.setInt(5, phone);
            preparedStatement.setInt(6, classRoom);
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
        }
        return student;
    }

    public Student updateStudent(int id, String name, String email, Date birthday, String address, int phone, int classRoom) {
        Student student = null;
        String sql = "UPDATE staff SET classRoom = ?, name = ?, email = ?, birthday = ?, address = ?, phone = ? WHERE id = ?;";
        try {
            connection = new DBContext().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, classRoom);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, email);
            preparedStatement.setDate(4, (java.sql.Date) birthday);
            preparedStatement.setInt(5, Integer.parseInt(address));
            preparedStatement.setInt(6, phone);
            preparedStatement.setInt(7, id);
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
        }
        return student;
    }

    public Student getStudentID(int id) {
        Student student = null;
        String sql = "SELECT * FROM staff WHERE id = ?;";
        try {
            connection = new DBContext().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idd = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                Date birthday = resultSet.getDate("birthday");
                String address = resultSet.getString("address");
                int phone = Integer.parseInt(resultSet.getString("phone"));
                int classRoom = Integer.parseInt(String.valueOf(resultSet.getInt("classroom")));

                ClassRoom classRoom1 = daoDepertment.getDepartmentByID(classRoom);
                student = new Student(idd, name, email,new Date(String.valueOf(birthday)),address, phone,classRoom);
            }
        } catch (SQLException | ClassNotFoundException e) {
        }
        return student;
    }

    public boolean deleteStudent(int id) throws ClassNotFoundException {
        boolean isDelete = false;
        String sql = "DELETE student FROM student WHERE id = ?";
        try {
            connection = new DBContext().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() >= 1;
        } catch (SQLException e) {
        }
        return isDelete;
    }

    public List<Student> searchStudentName(String name){
        List<Student> studentList = new ArrayList<>();
        String sql = "SELECT * FROM staff WHERE name LIKE ?;";
        try {
            connection = new DBContext().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + name + "%");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String namee = resultSet.getString("name");
                String email = resultSet.getString("email");
                Date birthday = resultSet.getDate("birthday");
                String address = resultSet.getString("address");
                int phone = Integer.parseInt(resultSet.getString("phone"));
                int classRoom = Integer.parseInt(String.valueOf(resultSet.getInt("classRoom")));

                ClassRoom classRoom1 = daoDepertment.getDepartmentByID(classRoom);

                Student student = new Student(id, namee, email,new Date(String.valueOf(birthday)), address, phone, classRoom);
                studentList.add(student);
            }
        } catch (SQLException | ClassNotFoundException e){
        }
        return studentList;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        DAOStaff dao = new DAOStaff();
        List<Student> getlistStudent = dao.getlistStudent();
        for (Student s: getlistStudent) {
            System.out.println(s);
        }
    }
}
