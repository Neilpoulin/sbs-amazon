package com.strumbystrum.model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: neilpoulin
 * Date: 11/12/13
 * Time: 2:16 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue
    @Column(name="USERID")
    Long userId;

    @Column(name="name")
    private String name;

    @Column(name="location")
    private String location;

    public User(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
