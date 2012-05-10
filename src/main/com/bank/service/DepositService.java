/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.service;

import com.bank.model.InvalidDebitAmountException;

/**
 *
 * @author roofimon
 */
public interface DepositService {
    public void deposit(double depositAmount, String destrinationAccount) throws InvalidDebitAmountException;
}
