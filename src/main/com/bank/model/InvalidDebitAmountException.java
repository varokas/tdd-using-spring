/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.model;

/**
 *
 * @author roofimon
 */
public class InvalidDebitAmountException extends Exception{

    private double attemptedAmount;

    
    public InvalidDebitAmountException(double attemptedAmount) {
        this.attemptedAmount = attemptedAmount;
    }

    /**
     * @return the attemptedAmount
     */
    public double getAttemptedAmount() {
        return attemptedAmount;
    }

    /**
     * @param attemptedAmount the attemptedAmount to set
     */
    public void setAttemptedAmount(double attemptedAmount) {
        this.attemptedAmount = attemptedAmount;
    }

    @Override
    public String toString() {
        return "InvalidDebitAmountException{" + "attemptedAmount=" + attemptedAmount + '}';
    }
}
