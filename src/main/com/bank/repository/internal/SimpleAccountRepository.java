/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.repository.internal;

import com.bank.model.Account;
import com.bank.repository.AccountRepository;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author roofimon
 */
public class SimpleAccountRepository implements AccountRepository {

    public static class Data {

        public static final String A123_ID = "A123";
        public static final String C456_ID = "C456";
        public static final String Z999_ID = "Z999"; // NON EXISTENT ID
        public static final double A123_INITIAL_BAL = 100.00;
        public static final double C456_INITIAL_BAL = 0.00;
    }
    @SuppressWarnings("serial")
    private final Map<String, Account> accountsById = new HashMap<String, Account>() {
        {
            put(Data.A123_ID, new Account(Data.A123_ID, Data.A123_INITIAL_BAL));
            put(Data.C456_ID, new Account(Data.C456_ID, Data.C456_INITIAL_BAL));
        }
    };

    @Override
    public Account findById(String id) {
        return accountsById.get(id);
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
