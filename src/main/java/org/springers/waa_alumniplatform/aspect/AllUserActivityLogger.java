package org.springers.waa_alumniplatform.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AllUserActivityLogger {
    @After("execution(* org.springers.waa_alumniplatform.service.impl.*.*(..))")
    public void before(JoinPoint joinPoint){
        System.out.println( "******* User Activity Log *******\n"
        + "Action performed on " + joinPoint.getSignature().getName() +
        "\n ***** End of Log ******");
    }
}
