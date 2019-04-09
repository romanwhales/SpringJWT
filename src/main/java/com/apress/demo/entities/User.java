package com.apress.demo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)

    @NotEmpty()
    private String name;

    @Column(nullable = false,unique=true)
    private String email;
    @Size(min=4)
    private String password;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name="user_role",joinColumns = {@JoinColumn(name="USER_ID",
            referencedColumnName = "ID")},inverseJoinColumns =
            {@JoinColumn(name="ROLE_ID",referencedColumnName = "ID")})
    private List<Role> roles;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public List<Role> getRoles(){
        return this.roles;
    }

    public void setRoles(List<Role> roles ){
        this.roles = roles;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }


}
