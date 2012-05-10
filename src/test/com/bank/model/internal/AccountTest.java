/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.model.internal;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import com.bank.model.Account;
import com.bank.model.InvalidDebitAmountException;
/**
 *
 * @author roofimon
 */
public class AccountTest {
    @Test
    public void debitTen() throws InvalidDebitAmountException{
        Account targetAccount = new Account("1234-5678", 50);
        targetAccount.debit(10);
        assertThat(targetAccount.getBalance(), equalTo(60.00));
    }
    
    @Test
    public void debitHundred() throws InvalidDebitAmountException{
        Account targetAccount = new Account("1234-5678", 50);
        targetAccount.debit(100.00);
        assertThat(targetAccount.getBalance(), equalTo(150.00));
    }
    
    @Test(expected=InvalidDebitAmountException.class)
    public void debitZero() throws InvalidDebitAmountException{
        Account targetAccount = new Account("1234-5678", 50);
        targetAccount.debit(0.00);
        System.out.println(targetAccount.toString());
    }
}
