package com.pluralsight.LeaseAndSales;

import com.pluralsight.Vehicle;

public class LeaseContract extends Contract {
    private double expectedEndingValue;
    private double leaseFee;

    public LeaseContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);

    }

    @Override
    public double getTotalPrice() {
        return vehicleSold.getPrice() -
                getExpectedEndingValue() +
                getLeaseFee();
    }

//All leases are financed at 4.0% for 36 months
    @Override
    public double getMonthlyPayment() {
        double annualRate = 0.04;
        int months = 36;
        double principal = getTotalPrice();
        double monthlyRate = annualRate / 12;
        double numerator = monthlyRate * Math.pow(1 + monthlyRate, months);
        double denominator = Math.pow(1 + monthlyRate, months) - 1;

        return principal * (numerator / denominator);
    }

    public double getExpectedEndingValue() {
        expectedEndingValue = vehicleSold.getPrice() * 0.5;
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        leaseFee = vehicleSold.getPrice() + 0.07;
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }
}

