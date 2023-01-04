package orlanda;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggerAspect {
    @Pointcut("execution(* *(..))")
    public void allMethods() {
    }

    @AfterReturning(value="allMethods()", returning = "returnedValue")
    public void afterReturningAdvice(JoinPoint joinPoint, Object returnedValue) {
        String methodName = joinPoint.getSignature().getName();
        if (returnedValue == null) {
            System.out.println("Метод " + methodName + " ничего не вернул.");
        } else {
            System.out.println("Метод " + methodName + " вернул:\n" + returnedValue);
        }
    }

    @AfterThrowing(value="allMethods()", throwing = "exception")
    public void afterThrowingException(JoinPoint joinPoint, Exception exception) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Метод " + methodName + " выбросил исключение:\n" + exception);
    }
}
