package cybage.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

//	@Pointcut("execution(* cybage..*.*(..)) !within(cybage.spring.configurtion.*Config) ")
//	public void anyPublicMethod() {
//	}

	@Pointcut("execution(* cybage.dao..*.*(..))")
	public void inDataAccessLayer() {
	}

	@Around("inDataAccessLayer()")
	public Object logAction(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Before method execution");
		Object returnValue = pjp.proceed();
		System.out.println("After method execution");
		return returnValue;
	}

	@Before("inDataAccessLayer()")
	public void doAccessCheck() {
		System.out.println("Check if user has access to method: @Before");
	}

	@After("inDataAccessLayer()")
	public void doReleaseLock() {
		System.out.println("Check if user has access to method:@After");
	}

	@AfterReturning(pointcut = "inDataAccessLayer()", returning = "retVal")
	public void doAccessCheck(Object retVal) {
		System.out.println("Check if user has access to method:@AfterReturning");
	}

	@AfterThrowing(pointcut = "inDataAccessLayer()", throwing = "ex")
	public void doRecoveryActions(RuntimeException ex) {
		System.out.println("Check if user has access to method:@@AfterThrowing");
		// ...
	}

}
