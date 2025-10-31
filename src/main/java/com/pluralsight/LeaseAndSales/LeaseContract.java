package com.pluralsight.LeaseAndSales;

import com.pluralsight.Vehicle;

public class LeaseContract extends Contract {
    private double expectedEndingValue;
    private double leaseFee;

    public LeaseContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold, double expectedEndingValue, double leaseFee) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.expectedEndingValue = expectedEndingValue;
        this.leaseFee = leaseFee;
    }

    @Override
    public double getTotalPrice() {
        return 0;
    }

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
        expectedEndingValue = vehicleSold.getPrice() / 0.5;
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        leaseFee = vehicleSold.getPrice() / 0.07;
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }
}

