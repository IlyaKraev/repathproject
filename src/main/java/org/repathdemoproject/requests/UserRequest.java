package org.repathdemoproject.requests;

public class UserRequest {

    private Long Id;
    private String name;
    private String email;
    private String company;

    public UserRequest(){}

    public UserRequest(Long id, String name, String email, String company) {
        Id = id;
        this.name = name;
        this.email = email;
        this.company = company;
    }
    public UserRequest(String name, String email, String company) {
        this.name = name;
        this.email = email;
        this.company = company;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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


}
