package com.pluralsight.LeaseAndSales;

import com.pluralsight.Dealership;

import java.io.*;

/**
 * Phase 2 should be the construction of your ContractDataManager. The
 * saveContract() method will accept a Contract parameter, but you will need
 * to use instanceof to check the type of contract because the format of what you
 * write to the file changes depending on the contract type.
 */

public class ContractDataManager {

    public static final String FILE_NAME = "src/main/resources/Contract.csv";


    public static void saveContract(Contract contract) {
        try {
            BufferedWriter bufwriter = new BufferedWriter(
                    new FileWriter(FILE_NAME, true));
            if (contract instanceof SalesContract) {
                SalesContract sc = (SalesContract) contract;
                bufwriter.write("SALE" + "|" +
                        sc.getDateOfContract() + "|" +
                        sc.getCustomerName() + "|" +
                        sc.getCustomerEmail() + "|" +
                        sc.getVehicleSold().getVin() + "|" +
                        sc.getVehicleSold().getYear() + "|" +
                        sc.getVehicleSold().getMake() + "|" +
                        sc.getVehicleSold().getModel() + "|" +
                        sc.getVehicleSold().getPrice() + "|" +
                        sc.getSalesTax() + "|" +
                        sc.getRecordingFee() + "|" +
                        sc.getProcessingFee() + "|" +
                        sc.getTotalPrice() + "|" +
                        sc.getMonthlyPayment() + "\n"
                );

            } else if (contract instanceof LeaseContract) {
                LeaseContract lc = (LeaseContract) contract;
                bufwriter.write("LEASE" + "|" +
                        lc.getDateOfContract() + "|" +
                        lc.getCustomerName() + "|" +
                        lc.getCustomerEmail() + "|" +
                        lc.getVehicleSold().getVin() + "|" +
                        lc.getVehicleSold().getYear() + "|" +
                        lc.getVehicleSold().getMake() + "|" +
                        lc.getVehicleSold().getModel() + "|" +
                        lc.getVehicleSold().getPrice() + "|" +
                        lc.getExpectedEndingValue() + "|" +
                        lc.getLeaseFee() + "|" +
                        lc.getTotalPrice() + "|" +
                        lc.getMonthlyPayment() + "|" + "\n");
            }

            System.out.println(" Contract saved successfully.");

        } catch (IOException e) {
            System.out.println(" Error saving contract: " + e.getMessage());
        }
    }
}
