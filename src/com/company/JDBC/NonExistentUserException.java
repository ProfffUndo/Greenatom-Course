package com.company.JDBC;

public class NonExistentUserException extends NonExistentEntityException {
    private static final long serialVersionUID = 8633588908169766368L;
    public NonExistentUserException() {
        super("Customer does not exist");
    }
}
