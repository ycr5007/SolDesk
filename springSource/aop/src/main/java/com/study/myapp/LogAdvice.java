package com.study.myapp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component("log")
public class LogAdvice {
	
	@Before(value="execution(* com.study.myapp.Product.getInfo())")
	public void beforeLog() {
		System.out.println("[AOP 공통로그] 비즈니스 로직 수행 전 호출 ( Before )");
	}
	
	@After(value="execution(* com.study.myapp.Product.getInfo())")
	public void afterLog() {
		System.out.println("[AOP 공통로그] 비즈니스 로직 수행 후 호출 ( After )");
	}

	@AfterReturning(value="execution(* com.study.myapp.Product.getInfo())")
	public void afterReturnLog() {
		System.out.println("[AOP 공통로그] 비즈니스 로직 정상 수행 후 호출 ( AfterReturning )");
	}

	@AfterThrowing(value="execution(* com.study.myapp.Product.getInfo())")
	public void afterThrowLog() {
		System.out.println("[AOP 공통로그] 비즈니스 로직 중 Exception 발생 후 호출 ( AfterThrowing )");
	}

	@Around(value="execution(* com.study.myapp.Product.getInfo())")
	public void aroundLog(ProceedingJoinPoint pjp) {
		/* Around 활용 시, 추가 코드 작성 필요 ( Around 에서 빠져나가는 작업 필요 ) */
		/*
			Aop proxy : AOP 실행 시, 메소드 요청을 인터셉트 하여 관리
				ex ) before :: 	client
								1 . Method 호출
									Aop Proxy : 요청을 인터셉트 하여 관리
								2 . before() advice 실행
									Aop Proxy
								3 . 요청한 메소드 실행
			Around 의 경우, before 를 호출 한 후에, 다시 메소드를 실행한 후, 다시 돌아와야하기 때문에, 다음과 같은 추가 코드작성 필요 
		*/
		System.out.println("[AOP 공통로그] 비즈니스 로직 수행 ( 전 )·후 호출 ( Around )");
		try {
			pjp.proceed(); // 실제 클라이언트가 요청한 메소드 수행
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("[AOP 공통로그] 비즈니스 로직 수행 전·( 후 ) 호출 ( Around )");
	}
}
