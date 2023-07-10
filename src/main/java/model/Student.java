package model;

import java.util.Date;

public class Student {
    private int id;
    private String name;
    private String email;
    private Date birthday;
    private String address;
    private int phone;
    private int classRoom;

    public Student(int id, String name, String email, Date birthday, String address, int phone, int classRoom) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
        this.classRoom = classRoom;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getClassRoom(int classRoom) {
        return classRoom;
    }

    public void setClassRoom(int classRoom) {
        this.classRoom = classRoom;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", classRoom=" + classRoom +
                '}';
    }
}
