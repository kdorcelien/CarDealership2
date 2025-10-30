package com.pluralsight.LeaseAndSales;

import com.pluralsight.Vehicle;

public class SalesContract extends Contract{
    private double salesTax;
    private double recordingFee;
    private double processingFee;
    private boolean financeOption;

    public SalesContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold, double salesTax, double recordingFee, double processingFee, boolean financeOption) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.salesTax = salesTax;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.financeOption = financeOption;

    }

    @Override
    public double getTotalPrice(){
        if (isFinanceOption()){

        }

        return 0;
    }

    @Override
    public double getMonthlyPayment(){

        return 0;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = 0.05;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
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
