package com.inn.cafe.com.inn.cafe.POJO;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
@NamedQuery(name = "User.findByEmail",query="select u from User u where u.email=:email")
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="user")
public class User implements Serializable{

        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        private Integer id;

    public User(Integer id, String name, String contactNumber, String role, String status, String password, String email) {
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
        this.role = role;
        this.status = status;
        this.password = password;
        this.email = email;
    }

    @Column(name = "name")
        private String name;

        @Column(name= "contactNumber")
        private String contactNumber;

          @Column(name= "email")
          private String email;

         @Column(name= "password")
         private String password;

         @Column(name= "status")
         private String status;

         @Column(name= "role")
        private String role;

    public User() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}