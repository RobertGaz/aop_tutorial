package orlanda;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class HelloAspect {

    @Pointcut("execution(* Main.printName(String))")
    public void greeting() {
    }

    @Before("greeting()")
    public void beforeAdvice() {
        System.out.print("Hello, ");
    }


    @Pointcut("execution(* Main.makeOperation(String))")
    public void operations() {
    }

    @Around(value = "operations()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) {
        System.out.println("In Around aspect...");
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            System.out.println("Неуспех!");
            e.printStackTrace();
        }
        System.out.println("Out of Around aspect...");
        return result;
    }


}
