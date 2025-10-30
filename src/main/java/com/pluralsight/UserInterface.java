package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

import static com.pluralsight.DealershipFileManager.saveDealership;

public class UserInterface {
    public Dealership dealership;
    public Scanner scan;

    public UserInterface() {
        this.scan = new Scanner(System.in);
    }
    private void displayMenu() {
        System.out.println("1 - Find vehicles by price");
        System.out.println("2 - Find vehicles by make/model");
        System.out.println("3 - Find vehicles by year");
        System.out.println("4 - Find vehicles by color");
        System.out.println("5 - Find vehicles by mileage");
        System.out.println("6 - Find vehicles by type");
        System.out.println("7 - List ALL vehicles");
        System.out.println("8 - Add a vehicle");
        System.out.println("9 - Remove a vehicle");
        System.out.println("99 - Quit");
        System.out.print("Enter your choice: ");
    }
    private void init() {
        DealershipFileManager manager = new DealershipFileManager();
        this.dealership = manager.getDealership();
        System.out.println("Loaded: " + dealership.getName());
    }
    public void display(){
        init();

        boolean running = true;
        while (running) {
            displayMenu();

            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 99:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }

        scan.close();
    }
    private void displayVehicles(ArrayList<Vehicle> vehicles){
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
    private void processAllVehiclesRequest() {
        ArrayList<Vehicle> vehicles = dealership.getAllVehicle();
        displayVehicles(vehicles);
    }

    private void processGetByPriceRequest() {
        System.out.print("Enter minimum price: ");
        double min = scan.nextDouble();

        System.out.print("Enter maximum price: ");
        double max = scan.nextDouble();
        scan.nextLine();  // Clear buffer

        ArrayList<Vehicle> vehicles = dealership.getVehicleByPrice(min, max);
        displayVehicles(vehicles);
    }
    private void processGetByMakeModelRequest() {
        System.out.print("Enter make: ");
        String make = scan.nextLine();

        System.out.print("Enter model: ");
        String model = scan.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehicleByMakeModel(make, model);
        displayVehicles(vehicles);
    }
    private void processGetByYearRequest() {
        System.out.print("Enter minimum year: ");
        int min = scan.nextInt();

        System.out.print("Enter maximum year: ");
        int max = scan.nextInt();
        scan.nextLine();  // Clear buffer

        ArrayList<Vehicle> vehicles = dealership.getVehicleByYear(min, max);
        displayVehicles(vehicles);
    }
    private void processGetByColorRequest() {
        System.out.print("Enter color: ");
        String color = scan.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehicleByColor(color);
        displayVehicles(vehicles);
    }
    private void processGetByMileageRequest() {
        System.out.print("Enter minimum mileage: ");
        int min = scan.nextInt();

        System.out.print("Enter maximum mileage: ");
        int max = scan.nextInt();
        scan.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehicleByMileage(min, max);
        displayVehicles(vehicles);
    }
    private void processGetByVehicleTypeRequest() {
        System.out.print("Enter vehicle type (car/truck/SUV/van): ");
        String type = scan.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehicleByType(type);
        displayVehicles(vehicles);

    }
    private void processAddVehicleRequest() {
        System.out.print("Enter VIN: ");
        int vin = scan.nextInt();

        System.out.print("Enter year: ");
        int year = scan.nextInt();
        scan.nextLine();  // Clear buffer

        System.out.print("Enter make: ");
        String make = scan.nextLine();

        System.out.print("Enter model: ");
        String model = scan.nextLine();

        System.out.print("Enter vehicle type (car/truck/SUV/van): ");
        String vehicleType = scan.nextLine();

        System.out.print("Enter color: ");
        String color = scan.nextLine();

        System.out.print("Enter odometer: ");
        int odometer = scan.nextInt();

        System.out.print("Enter price: ");
        double price = scan.nextDouble();
        scan.nextLine();

        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(vehicle);

        DealershipFileManager manager = new DealershipFileManager();
        saveDealership(dealership);

        System.out.println(" Vehicle added successfully!");
    }
    private void processRemoveVehicleRequest() {
        System.out.print("Enter VIN of vehicle to remove: ");
        int vin = scan.nextInt();
        scan.nextLine();

        dealership.removeVehicle(vin);


        DealershipFileManager manager = new DealershipFileManager();
        saveDealership(dealership);
    }
}





