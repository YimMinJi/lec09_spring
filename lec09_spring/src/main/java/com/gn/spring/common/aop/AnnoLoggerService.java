package com.gn.spring.common.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AnnoLoggerService {
	
	Logger LOGGER = LogManager.getLogger(LoggerService.class);
	
	@Pointcut("execution( * com.gn.spring..*(..))")
	private void boardLogger() {}
	
	
	
	// 특정 메소드 실행 전에 동작할 코드를 만들어준다.
//		@Before("boardLogger()")
//		public void loggerBefore(JoinPoint jp) {
////			클래스 이름 꺼내오기
//			String className = jp.getTarget().getClass().getName();
////			메소드 이름 꺼내오기
//			String methodName = jp.getSignature().getName();
////			이다음에 뭐해? 로거를 찍어보면되지
//			LOGGER.info(className + "." +methodName + "() 실행전" );
//		}
		
//		 특정 메소드 실행 후에 동작 할 메소드
		@After("boardLogger()")
		public void loggerAfter(JoinPoint jp) {
//			클래스 이름 꺼내오기
			String className = jp.getTarget().getClass().getName();
//			메소드 이름 꺼내오기
			String methodName = jp.getSignature().getName();
//			이다음에 뭐해? 로거를 찍어보면되지
			LOGGER.info(className + "." +methodName + "() 실행후" );
			}
}
