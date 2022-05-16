package com.study.calc;

import org.springframework.stereotype.Component;

// for 문으로 factorial 구현

@Component("forc")
public class ForCalc implements Calc {
	@Override
	public long factorial(long num) {
		long result = 1;
		for(long i = num; i > 0; i--) {
			result *= i;
		}
		return result;
	}
}
