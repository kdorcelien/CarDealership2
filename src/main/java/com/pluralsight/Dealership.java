package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public ArrayList<Vehicle> getAllVehicle() {
        return this.inventory;
    }

    public ArrayList<Vehicle> getVehicleByPrice(double min, double max) {
        ArrayList<Vehicle> results = new ArrayList<>();
        for (Vehicle vehicle : this.inventory) {
            if (min <= vehicle.getPrice() && max >= vehicle.getPrice()) {
                results.add(vehicle);
            }
        }
        return results;
    }

    public ArrayList<Vehicle> getVehicleByMakeModel(String make, String model) {
        ArrayList<Vehicle> results = new ArrayList<>();
        for (Vehicle vehicle : this.inventory) {
            if ( vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model) ) {
                results.add(vehicle);
            }
        }
        return results;
    }

    public ArrayList<Vehicle> getVehicleByYear(int min, int max) {
        ArrayList<Vehicle> results = new ArrayList<>();
        for (Vehicle vehicle : this.inventory) {
            if (min <= vehicle.getYear() && max >= vehicle.getYear()) {
                results.add(vehicle);
            }
        }
        return results;
    }

    public ArrayList<Vehicle> getVehicleByColor(String color) {
        ArrayList<Vehicle> results = new ArrayList<>();
        for (Vehicle vehicle : this.inventory) {
            if ( vehicle.getColor().equalsIgnoreCase(color)) {
                results.add(vehicle);
            }
        }
        return results;
    }

    public ArrayList<Vehicle> getVehicleByMileage(int min, int max) {
        ArrayList<Vehicle> results = new ArrayList<>();
        for (Vehicle vehicle : this.inventory) {
            if (min <= vehicle.getOdometer() && max >= vehicle.getOdometer()) {
                results.add(vehicle);
            }
        }
        return results;
    }

    public ArrayList<Vehicle> getVehicleByType(String vehicleType) {
        ArrayList<Vehicle> results = new ArrayList<>();
        for (Vehicle vehicle : this.inventory) {
            if ( vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                results.add(vehicle);
            }
        }
        return results;
    }
    public void addVehicle(Vehicle vehicle) {
        this.inventory.add(vehicle);
    }


    public void removeVehicle(int vin) {
        for (int i = 0; i < this.inventory.size(); i++) {
            if (this.inventory.get(i).getVin() == vin) {
                this.inventory.remove(i);
                System.out.println("Vehicle removed successfully!");
                return;
            }
        }
        System.out.println("Vehicle not found!");
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}
