package model;

public class ClassRoom {
    private int id;
    private int staff_id;
    private String nameDepartment;

    public ClassRoom(int classRoomId) {
    }

    public ClassRoom(int staff_id, String nameDepartment) {
        this.staff_id = staff_id;
        this.nameDepartment = nameDepartment;
    }

    public ClassRoom(int id, int staff_id, String nameDepartment) {
        this.id = id;
        this.staff_id = staff_id;
        this.nameDepartment = nameDepartment;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", staff_id=" + staff_id +
                ", nameDepartment='" + nameDepartment + '\'' +
                '}';
    }
}
