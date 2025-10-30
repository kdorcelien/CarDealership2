package com.pluralsight;

import java.io.*;

import java.util.ArrayList;

public class DealershipFileManager {

    public Dealership getDealership(){
        Dealership dealership = null;

        try {
            BufferedReader bufreader = new BufferedReader(
                    new FileReader("src/main/resources/inventory.csv"));

            String[] dealershipInfo = bufreader.readLine().split("\\|");

            String name = dealershipInfo[0];
            String address = dealershipInfo[1];
            String phone = dealershipInfo[2];

            dealership = new Dealership(name, address, phone);

            String input;
            while ((input = bufreader.readLine()) != null) {
                String[] parts = input.split("\\|");
                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                String make = parts[2];
                String model = parts[3];
                String vehicleType = parts[4];
                String color = parts[5];
                int odometer = Integer.parseInt(parts[6]);
                double price = Double.parseDouble(parts[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model,
                        vehicleType, color, odometer, price);
                dealership.addVehicle(vehicle);
            }

            bufreader.close();

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return dealership;
    }

    public static void saveDealership (Dealership record) {
        try {
            BufferedWriter bufwriter = new BufferedWriter(
                    new FileWriter("src/main/resources/inventory.csv", true));
            ArrayList<Vehicle> vehicles = record.getAllVehicle();
            bufwriter.write(record.toString());
            bufwriter.close();

            System.out.println("Inventory saved!");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

