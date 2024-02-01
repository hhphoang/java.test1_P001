package org.example.service;

import org.example.entities.Department;
import org.example.entities.Employee;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileManager {

    public String save(List<String> data, String filename, String object) {
        try {
            FileWriter writer = new FileWriter(filename);
            for (String instance : data) {
                writer.write(instance + "\n");
            }
            writer.close();
            return "Data of "  + object + "saved successfully.";
        } catch (IOException e) {
            return "Error occurred while saving customer data.";
        }
    }

//    public void loadDataFromFile(String filename) {
//        try {
//            FileInputStream fileIn = new FileInputStream(filename);
//            ObjectInputStream in = new ObjectInputStream(fileIn);
//            departments = (List<Department>) in.readObject();
//            employees = (List<Employee>) in.readObject();
//            in.close();
//            fileIn.close();
//            System.out.println("Data loaded from " + filename);
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
}
