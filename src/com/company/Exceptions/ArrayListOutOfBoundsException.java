package com.company.Exceptions;

public class ArrayListOutOfBoundsException extends RuntimeException{

    @Override
    public String getMessage() {
        return "ArrayListOutOfBoundsException. ArrayList can contain only 10 elements.";
    }

    @Override
    public String getLocalizedMessage() {
        return "ArrayListOutOfBoundsException. ArrayList может хранить в себе не более 10 элементов.";
    }

    public String toString() {
        String clazz = getClass().getName();
        return clazz+ ": " + getMessage();
    }



}
