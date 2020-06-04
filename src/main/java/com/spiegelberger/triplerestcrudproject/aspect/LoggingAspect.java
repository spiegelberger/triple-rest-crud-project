package com.spiegelberger.triplerestcrudproject.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {

	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.spiegelberger.simplerestcrudproject.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.spiegelberger.simplerestcrudproject.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.spiegelberger.simplerestcrudproject.dao.*.*(..))")
	private void forDAOPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage() ")
	private void forAppFlow() {}	
	
	
	//Display the methods and arguments the client called:
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		String theMethod = theJoinPoint.getSignature().toShortString();	
		myLogger.info("==> in @Before: calling method: "+ theMethod);
		Object []args = theJoinPoint.getArgs();
		for(Object tempArg : args) {
			myLogger.info("==> argument: " + tempArg);
		}
	}
	
	//Display the returning data 
	@AfterReturning(
			pointcut ="forControllerPackage()",
			returning = "theResult"
			)
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("==> in @AfterReturning: from method: " + theMethod);
		myLogger.info("==> result: " + theResult + "\n" );
	}
	
	//Execution time measurement
	@Around ("forControllerPackage()")
	public Object aroundControllerMethods(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{
		
	String method = theProceedingJoinPoint.getSignature().toShortString();
	
	
	long begin = System.currentTimeMillis();
	Object result = theProceedingJoinPoint.proceed();
	long end = System.currentTimeMillis();
	
	long duration = end - begin;
	myLogger.info("==> in @Around on method: " + method +
	" Duration: " + duration/1000.0 + "s");
			
			
		return result;
	}
	
}
	
