package dao;

import context.DBContext;
import model.ClassRoom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAODepertment {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public List<ClassRoom> getListDepartment() throws ClassNotFoundException {
        List<ClassRoom> listDepartment = new ArrayList<>();
        String sql = "SELECT * FROM department";
        try {
            connection = new DBContext().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                listDepartment.add(new ClassRoom(
                        resultSet.getInt("id"),
                        resultSet.getInt("staff_id"),
                        resultSet.getString("nameDepartMent")
                ));
            }
        } catch (SQLException e) {
        }
        return listDepartment;
    }

    public ClassRoom getDepartmentByID(int id) {
        ClassRoom classRoom = null;
        String sql = "SELECT * FROM department WHERE id = ?;";
        try {
            connection = new DBContext().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return new ClassRoom(
                    resultSet.getInt("id"),
                    resultSet.getInt("staff_id"),
                    resultSet.getString("nameDepartMent")
            );
        } catch (SQLException | ClassNotFoundException e) {
        }
        return classRoom;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        DAODepertment daoDepertment = new DAODepertment();
        ClassRoom department = daoDepertment.getDepartmentByID(1);
        System.out.println(department);
    }
}
