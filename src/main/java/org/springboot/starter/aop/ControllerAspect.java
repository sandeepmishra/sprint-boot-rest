package org.springboot.starter.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author sandeep
 *
 *         Aspect:
 */
@Aspect
@Configuration
public class ControllerAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// What kind of method calls I would intercept
	// execution(* PACKAGE.*.*(..))
	// Weaving & Weaver
	/**
	 * Join point: a point during the execution of a program, such as the execution
	 * of a method or the handling of an exception. In Spring AOP, a join point
	 * always represents a method execution.
	 * 
	 * Advice: action taken by an aspect at a particular join point. Different types
	 * of advice include "around," "before" and "after" advice.
	 * 
	 * Pointcut: a predicate that matches join points. Advice is associated with a
	 * pointcut expression and runs at any join point matched by the pointcut.
	 * 
	 * Target object: object being advised by one or more aspects. Also referred to
	 * as the advised object.
	 * 
	 * @param joinPoint
	 */
	@Before("execution(* org.springboot.starter.controller.*.*(..))")
	public void before(JoinPoint joinPoint) {
		// Advice
		logger.info(" Inside method {}", joinPoint);
	}

	@After(value = "execution(* org.springboot.starter.controller.*.*(..))")
	public void after(JoinPoint joinPoint) {
		logger.info("after execution of {}", joinPoint);
	}
	
	@Around(value = "execution(* org.springboot.starter.controller.*.*(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		Long startTime = System.currentTimeMillis();
		Object output = joinPoint.proceed();
		logger.info("Time taken for execution  {} is {} ", joinPoint, (System.currentTimeMillis() - startTime));
		return output;
	}
}
