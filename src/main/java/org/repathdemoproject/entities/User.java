package org.repathdemoproject.entities;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="company", nullable = false)
    private String company;


    public User(){};

    public User(Long id, String name, String email, String company) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.company = company;
    }
    public User(String name, String email, String company) {
        this.name = name;
        this.email = email;
        this.company = company;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User: ");
        sb.append("id= ").append(id);
        sb.append(", name= '").append(name).append('\'');
        sb.append(", email= '").append(email).append('\'');
        sb.append(", company= '").append(company).append('\'');
        return sb.toString();
    }
}
