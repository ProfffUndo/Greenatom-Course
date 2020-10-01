package com.company.JDBC;

public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer height;
    private Integer weight;

    User(Integer id,String firstName, String lastName, Integer height, Integer weight){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.height=height;
        this.weight=weight;
    }

    User(String firstName, String lastName, Integer height, Integer weight){
        this.firstName=firstName;
        this.lastName=lastName;
        this.height=height;
        this.weight=weight;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public Integer getWeight() {
        return weight;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
