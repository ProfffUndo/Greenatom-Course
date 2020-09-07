package com.company.Serialization;

import java.io.*;

public class Person implements Externalizable {
    private String firstName;
    private String lastName;
    private int age;
    transient private String job;


    Person(){
    }

    Person(String firstName, String lastName, int age){
        this.firstName=firstName;
        this.lastName=lastName;
        this.age=age;
    }



    public void setJob() {
        if(age>=0 && age<=3) this.job="Home";
        else if (age>3 && age<7) this.job="Kindergarten";
        else if (age>=7 && age<18) this.job="Studying at school";
        else if (age>=18 && age<24) this.job="Studying at university";
        else if (age>=24 && age<65) this.job="Worker";
        else if (age >=65) this.job="Retired";
        else throw new IllegalArgumentException("It is not a person!!!");
        }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName=" + lastName +
                ", age='" + age + '\'' +
                ", job=" + job +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(firstName);
        out.writeObject(lastName);
        out.writeObject(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.firstName = (String) in.readObject();
        this.lastName = (String) in.readObject();
        this.age= (Integer) in.readObject();
         setJob();

    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getJob() {
        return job;
    }

    public String getLastName() {
        return lastName;
    }
}
