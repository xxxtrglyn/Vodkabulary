package com.example.models;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Username")
    private String Username;
    @Column(name = "Password")
    private String Password;
    @Column(name = "Name")
    private String Name;
    @Column(name = "DOB")
    private Date DOB;
    @Column(name = "Email")
    private String Email;
    @Column(name = "LearnTime")
    private int LearnTime;
    @Column(name = "Point")
    private int Point;
    @Column(name = "RoleID")
    private int RoleID;

    public User(int id, String username, String password, String name) {
        this.id = id;
        Username = username;
        Password = password;
        Name = name;
    }
    public User(){

    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getLearnTime() {
        return LearnTime;
    }

    public void setLearnTime(int learnTime) {
        LearnTime = learnTime;
    }

    public int getPoint() {
        return Point;
    }

    public void setPoint(int point) {
        Point = point;
    }

    public int getRoleID() {
        return RoleID;
    }

    public void setRoleID(int roleID) {
        RoleID = roleID;
    }
}
