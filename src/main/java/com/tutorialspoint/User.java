package com.tutorialspoint;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;

//@XmlRootElement(name = "user")
@Entity
@Table(name = "users")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
    private long user_id;
    @Column(name = "active")
    private int active;
    @Column(name = "email")
    private String email;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;

    public User(){}


    public User( int active, String email, String last_name, String name, String password) {
        this.active = active;
        this.email = email;
        this.last_name = last_name;
        this.name = name;
        this.password = password;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public int getActive() {
        return active;
    }
    @XmlElement
    public void setActive(int active) {
        this.active = active;
    }

    public String getEmail() {
        return email;
    }
    @XmlElement
    public void setEmail(String email) {
        this.email = email;
    }

    public String getLast_name() {
        return last_name;
    }
    @XmlElement
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getName() {
        return name;
    }
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }
    @XmlElement
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", active=" + active +
                ", email='" + email + '\'' +
                ", last_name='" + last_name + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
