package com.bank.service.internal;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.bank.service.internal.VariableFeePolicy;

public class VariableFeePolicyTests {

	private VariableFeePolicy feePolicy;

	@Before
	public void before() {
		feePolicy = new VariableFeePolicy();
	}
	
    @Test
    public void testVariableFeeCalculateByPercentage() {
        feePolicy.setFeePercentage(1.00); // 1% fee
        feePolicy.setMinimumFee(1.00); // $1.00

        assertThat(feePolicy.calculateFee(1000.00), equalTo(10.00));
        assertThat(feePolicy.calculateFee(100.00), equalTo(1.00));
    }
    
    @Test
    public void testVariableFeeCalculateRespectMinimumFee() {
        feePolicy.setFeePercentage(1.00); // 1% fee
        feePolicy.setMinimumFee(1.00); // $1.00

        assertThat(feePolicy.calculateFee(10.00), equalTo(1.00));
    }
}
