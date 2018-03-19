package com.movies;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LatencyDeltaLogAspect  {
	
	private static final Logger LOG = LoggerFactory.getLogger(LatencyDeltaLogAspect.class);
	
	@Around("@annotation(com.movies.OverallLatency) && execution(public * *(..))")
	public Object overallTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		Object value;
		long start = System.currentTimeMillis();
		
		try {
			value = proceedingJoinPoint.proceed();
		} finally {
			long duration = System.currentTimeMillis() - start;
			
			LOG.info("Overall Latency={} ms, method = {}.{}", duration, proceedingJoinPoint.getSignature().getDeclaringType().getSimpleName(),
					proceedingJoinPoint.getSignature().getName());
		}
		return value;
	}
	
	/*protected Object applyAdviceAndProceed(ProceedingJoinPoint proceedingJoinPoint, long start, String dependency) throws Throwable {
		Object value;
		try {
			value = proceedingJoinPoint.proceed();
		} finally {
			long duration = System.currentTimeMillis() - start;
		}
		
		return value;
		
	}*/

}
