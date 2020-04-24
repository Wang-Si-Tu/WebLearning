package com.test.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="users")
public class Users implements Serializable {
    @Id
    @GeneratedValue//(strategy=GenerationType.IDENTITY)
    private String account;
    @Column(name="password",nullable=false)
    private String password;
    public String getAccount(){
        return this.account;
    }
    public String getPassword(){
        return this.password;
    }
}
