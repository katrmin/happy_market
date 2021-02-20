package ru.geekbrains.happy.market.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AppLoggingAspect {
// "execution(modifier-pattern? return-type-pattern declaring-type-pattern? method-name-pattern(args-pattern)
// throws-pattern?)"
// execution([модификатор_метода(public, *)?] [тип_возврата] [класс?] [имя_метода]([аргументы]) [исключения?]

    @Around("execution(public void ru.geekbrains.happy.market.controllers.*.*(..))") // pointcut expression
    public Object aroundAnyControllerMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("start profiling");
        long begin = System.currentTimeMillis();
        Object out = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        long duration = end - begin;
        System.out.println((MethodSignature) proceedingJoinPoint.getSignature() + " duration: " + duration);
        System.out.println("end profiling");
        return out;
    }

//    @Before("execution(public void com.geekbrains.aop.UserDAO.*User())") // pointcut expression
//    public void beforeUserModifyInUserDAOClass() {
//        System.out.println("AOP: работа с пользователем в UserDAO");
//    }

//    @Before("execution(public void com.geekbrains.aop.UserDAO.*())") // pointcut expression
//    public void beforeAnyMethodWithoutArgsInUserDAOClass() {
//        System.out.println("AOP: любой void метод без аргументов из UserDAO");
//    }

//    @Before("execution(public void com.geekbrains.aop.*.*(..))") // pointcut expression
//    public void beforeAnyMethodInUserDAOClass() {
//        System.out.println("AOP: любой метод без аргументов из UserDAO");
//    }

//    @Before("execution(public void com.geekbrains.aop.UserDAO.*(..))") // pointcut expression
//    public void beforeAnyMethodInUserDAOClassWithDetails(JoinPoint joinPoint) {
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        System.out.println("В UserDAO был вызван метод: " + methodSignature);
//        Object[] args = joinPoint.getArgs();
//        if (args.length > 0) {
//            System.out.println("Аргументы:");
//            for (Object o : args) {
//                System.out.println(o);
//            }
//        }
//    }

//    @AfterReturning(
//            pointcut = "execution(public * com.geekbrains.aop.UserDAO.getAllUsers(..))",
//            returning = "result")
//    public void afterGetBobInfo(JoinPoint joinPoint, List<String> result) {
//        result.set(0, "Donald Duck");
//    }

//    @AfterThrowing(
//            pointcut = "execution(public * com.geekbrains.aop.UserDAO.*(..))",
//            throwing = "exc")
//    public void afterThrowing(JoinPoint joinPoint, Throwable exc) {
//        System.out.println(exc); // logging
//    }

//    @After("execution(public * com.geekbrains.aop.UserDAO.*(..))")
//    public void afterMethod() {
//        System.out.println("After");
//    }
//
//    @Around("execution(public * com.geekbrains.aop.UserDAO.*(..))")
//    public Object methodProfiling(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        System.out.println("start profiling");
//        long begin = System.currentTimeMillis();
//        Object out = proceedingJoinPoint.proceed();
//        long end = System.currentTimeMillis();
//        long duration = end - begin;
//        System.out.println((MethodSignature) proceedingJoinPoint.getSignature() + " duration: " + duration);
//        System.out.println("end profiling");
//        return out;
//    }
}
