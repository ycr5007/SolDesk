package com.study.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskTest {
	
	// Spring 스케쥴려 사용할 때
	// cron = "" : CronTab 에서의 설정 방식과 같게 사용
		// CronTab :: 소프트웨어 유틸리티 cron은 유닉스 계열 컴퓨터 운영 체제의 시간 기반 잡 스케줄러이다 (linux CronTab)
			// ref : https://wlsvud84.tistory.com/32
			// * * * * * * * :: 초 분 시 일 월 요일 연도
				// ex ) " 0 0 * * * * : 매일, 매시 정각 실행
				//		" 1 * * * * * : 매분 1초마다 실행
	// fixedDelay = int : 이전에 실행 된 Task 종료 시간으로부터 정의된 시간만큼 지난 후 task 실행 ( 밀리세컨드 )
	// fixedRate = int : 이전에 실행 된 Task 시작 시간으로부터 정의된 시간만큼 지난 후 task 실행
	
	
//	@Scheduled(cron = "1 * * * * *")
//	public void schedulerTest1() {
//		System.out.println("매 분 1초마다 스케줄링 ... ");
//	}
//
//	@Scheduled(fixedDelay = 10000)
//	public void schedulerTest2() {
//		System.out.println("10초마다 스케줄링 ... ");
//	}
	
}
