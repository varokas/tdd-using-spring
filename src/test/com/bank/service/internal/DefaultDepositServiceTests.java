/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.service.internal;
/*
 * import com.bank.domain.InvalidDepositAmountException; import static
 * com.bank.repository.internal.SimpleAccountRepository.Data.*; import static
 * org.hamcrest.CoreMatchers.equalTo; import static org.junit.Assert.assertThat;
 * import static org.junit.Assert.fail;
 *
 *
 * import com.bank.repository.internal.SimpleAccountRepository; import
 * com.bank.service.DepositService; import com.bank.service.FeePolicy;
 */

import com.bank.model.InvalidDebitAmountException;
import com.bank.repository.AccountRepository;
import com.bank.repository.internal.SimpleAccountRepository;
import static com.bank.repository.internal.SimpleAccountRepository.Data.*;
import com.bank.service.DepositService;



import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author TwinP
 */
public class DefaultDepositServiceTests {

    private AccountRepository accountRepository;
    private DepositService depositService;

    @Before
    public void setUp() {
        accountRepository = new SimpleAccountRepository();        
        depositService = new DefaultDepositService(accountRepository);
        assertThat(accountRepository.findById(A123_ID).getBalance(), equalTo(A123_INITIAL_BAL));
        assertThat(accountRepository.findById(C456_ID).getBalance(), equalTo(C456_INITIAL_BAL));
    }

    @Test
    public void basicDeposit() throws InvalidDebitAmountException {
        double depositAmount = 100.00;
        depositService.deposit(depositAmount, A123_ID);
        assertThat(accountRepository.findById(A123_ID).getBalance(), equalTo(A123_INITIAL_BAL + depositAmount));
    }

    @Test(expected = InvalidDebitAmountException.class)
    public void zeroDeposit() throws InvalidDebitAmountException {
        double depositZero = 0.00;
        depositService.deposit(depositZero, A123_ID);
    }
    
    @Test(expected = InvalidDebitAmountException.class)
    public void minusDeposit() throws InvalidDebitAmountException{
        double depositMinus = -0.5;
        depositService.deposit(depositMinus, A123_ID);
    }
    
    
    /*
     * @Test public void testDepositBelowMinimumAmount() throws
     * InvalidDepositAmountException { double depositAmount = 4.99;
     * depositService.setMinimumDepositAmount(5.00); try {
     * depositService.deposit(depositAmount, A123_ID); fail("expected
     * InvalidDepositAmountException"); } catch (InvalidDepositAmountException
     * error) { assertThat(error.getAttemptedAmount(), equalTo(depositAmount));
     * } assertThat(accountRepository.findById(A123_ID).getBalance(),
     * equalTo(A123_INITIAL_BAL)); }
     */
}
