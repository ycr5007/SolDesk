package com.study.calc;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAspect {
	@Around(value="execution(* com.study.calc.*Calc.*(..))")
	public Object measure(ProceedingJoinPoint pjp) throws Throwable {
		// 수행 전
		long start = System.nanoTime();
		
		try {
			Object obj = pjp.proceed();
			return obj;
		} finally {
			// 수행 후
			long end = System.nanoTime();
			System.out.println("Time(nano) : " + (end - start));
		}
		
	}
}
