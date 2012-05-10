/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.service.internal;

import com.bank.model.Account;
import com.bank.model.InvalidDebitAmountException;
import com.bank.repository.AccountRepository;
import com.bank.service.DepositService;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author roofimon
 */
public class DefaultDepositService implements DepositService{
    private AccountRepository accountRepositpry;
    
    public DefaultDepositService(AccountRepository accountRepositpry){
        this.accountRepositpry = accountRepositpry;
    }
    
    
    @Override
    public void deposit(double depositAmount, String destrinationAccount) throws InvalidDebitAmountException {
        Account targetAccount = accountRepositpry.findById(destrinationAccount);
        try {
            targetAccount.debit(depositAmount);
        } catch (InvalidDebitAmountException ex) {
            Logger.getLogger(DefaultDepositService.class.getName()).log(Level.SEVERE, null, ex);
            throw new InvalidDebitAmountException(depositAmount);
          
        }
    }
    
}
