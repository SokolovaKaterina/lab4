package com.university.domain;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private static int instances = 0;
    String name = "";
    int quantity = 0;
    List<String> nameOfRooms = new ArrayList<>();

    public Department() {}
    public Department(String name, int quantity, List<String> nameOfRooms) {
        this.id = instances;
        this.name = name;
        this.quantity = quantity;
        this.nameOfRooms = nameOfRooms;
        instances++;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<String> getNameOfRooms() {
        return nameOfRooms;
    }
    public void setNameOfRooms(List<String> nameOfRooms) {
        this.nameOfRooms = nameOfRooms;
    }

    public void updateRecordDepartment(Department department) {
        this.name = department.name;
        this.quantity = department.quantity;
        this.nameOfRooms = department.nameOfRooms;
    }
    public String toString() {
        return "\nId: " + id +
                ", Name: " + name +
                ", Quantity: " + quantity +
                ", NameOfRooms: " + nameOfRooms + ";";
    }
}
