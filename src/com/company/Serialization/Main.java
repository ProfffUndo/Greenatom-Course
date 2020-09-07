package com.company.Serialization;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person randy = new Person("Randy", "Orton", 43);
        Person pavel = new Person("Pavel", "Perviy", 48);

        /* //Сериализация в файл с помощью класса ObjectOutputStream
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("person.out"));
        objectOutputStream.writeObject(randy);
        objectOutputStream.writeObject(pavel);
        objectOutputStream.close();

        // Востановление из файла с помощью класса ObjectInputStream
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("person.out"));
        Person newRandy = (Person) objectInputStream.readObject();
        Person newPavel = (Person) objectInputStream.readObject();
        objectInputStream.close();*/

        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Username\\Desktop\\save.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);



        objectOutputStream.writeObject(randy);
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Username\\Desktop\\save.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);


        Person newRandy  = (Person) objectInputStream.readObject();
        System.out.println(newRandy);

        objectInputStream.close();


        System.out.println("Before Serialize: " + "\n" + randy + "\n" + pavel);
        System.out.println("After Restored: " + "\n" + newRandy + "\n");
    }
}
