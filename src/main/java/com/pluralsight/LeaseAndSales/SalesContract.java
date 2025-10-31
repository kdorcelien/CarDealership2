package com.pluralsight.LeaseAndSales;

import com.pluralsight.Vehicle;

public class SalesContract extends Contract {
    private double salesTax;
    private double recordingFee;
    private double processingFee;
    private boolean financeOption;

    public SalesContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold, boolean financeOption) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.financeOption = financeOption;

    }

    @Override
    public double getTotalPrice() {
        return vehicleSold.getPrice() +
                getSalesTax() +
                getRecordingFee() +
                getProcessingFee();
    }

    /**
     * All loans are at 4.25% 0.0425 for 48 months if the price is $10,000 or more
     * • Otherwise they are at 5.25% 0.0525 for 24 month
     */

    @Override
    public double getMonthlyPayment() {
        double annualRate = 0;
        int months;

        if (isFinanceOption() && vehicleSold.getPrice() >= 10000) {
            annualRate = 0.0425; // 4.25%
            months = 48;         // 4 years
        } else if (isFinanceOption()) {
            annualRate = 0.0525; // 5.25%
            months = 24;         // 2 years
        } else {
            return 0;
        }

        double principal = getTotalPrice();
        double monthlyRate = annualRate / 12;

        // Formula: M = P * [r(1+r)^n] / [(1+r)^n - 1]
        double numerator = monthlyRate * Math.pow(1 + monthlyRate, months);
        double denominator = Math.pow(1 + monthlyRate, months) - 1;

        return principal * (numerator / denominator);
    }

    public double getSalesTax() {
        salesTax = vehicleSold.getPrice() * 0.05;
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getRecordingFee() {
        return 100.0;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        if (vehicleSold.getPrice() < 10000) {
            processingFee = 295;
        } else {
            processingFee = 495;
        }
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanceOption() {
        return financeOption;
    }

    public void setFinanceOption(boolean financeOption) {
        this.financeOption = financeOption;
    }
}
