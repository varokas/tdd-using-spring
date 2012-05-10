/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.repository;

import com.bank.model.Account;

/**
 *
 * @author roofimon
 */
public interface AccountRepository {
    public Account findById(String id);
}
