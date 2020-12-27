package com.example.hamster.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Aspect
public class LogAspect {
	private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final String POINT_CUT = "execution(public * com.example.hamster.controller.*.*(..))";
    @Pointcut(POINT_CUT)
    public void pointCut(){}

    //   @Before(value = "pointCut()")
    //   public void before(JoinPoint joinPoint){
    //       logger.info("before start");
//
//        Object[] args = joinPoint.getArgs();
//        Arrays.stream(args).forEach(arg->{
//            try {
//                logger.info(OBJECT_MAPPER.writeValueAsString(arg));
//            } catch (JsonProcessingException e) {
//                logger.info(arg.toString());
//            }
//        });
//
//
//        //aop代理对象
//        Object aThis = joinPoint.getThis();
//        logger.info(aThis.toString());
//
//        //被代理对象
//        Object target = joinPoint.getTarget();
//        logger.info(target.toString());
//
//        //获取连接点的方法签名对象
//        Signature signature = joinPoint.getSignature();
//        logger.info(signature.toLongString());
//        logger.info(signature.toShortString());
//        logger.info(signature.toString());
//        //获取方法名
//        logger.info(signature.getName());
//        //获取声明类型名
//        logger.info(signature.getDeclaringTypeName());
//        //获取声明类型  方法所在类的class对象
//        logger.info(signature.getDeclaringType().toString());
//        //和getDeclaringTypeName()一样
//        logger.info(signature.getDeclaringType().getName());
//
//        //连接点类型
//        String kind = joinPoint.getKind();
//        logger.info(kind);//method-execution
//
//        SourceLocation sourceLocation = joinPoint.getSourceLocation();
//        logger.info(sourceLocation.toString());
//        JoinPoint.StaticPart staticPart = joinPoint.getStaticPart();
//        logger.info(staticPart.toLongString());
//
//
//        //attributes可以获取request信息 session信息等
//        ServletRequestAttributes attributes =
//                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        logger.info(request.getRequestURL().toString()); //http://127.0.0.1:8080/hello/getName
//        logger.info(request.getRemoteAddr()); //127.0.0.1
//        logger.info(request.getMethod()); //GET

    //       logger.info("before end");
    //   }


//    /**
//     * 后置返回
//     *      如果第一个参数为JoinPoint，则第二个参数为返回值的信息
//     *      如果第一个参数不为JoinPoint，则第一个参数为returning中对应的参数
//     * returning：限定了只有目标方法返回值与通知方法参数类型匹配时才能执行后置返回通知，否则不执行，
//     *            参数为Object类型将匹配任何目标返回值
//     */
//    @AfterReturning(value = POINT_CUT,returning = "result")
//    public void doAfterReturningAdvice1(JoinPoint joinPoint,Object result){
//        logger.info("第一个后置返回通知的返回值："+result);
//    }
//
//    @AfterReturning(value = POINT_CUT,returning = "result",argNames = "result")
//    public void doAfterReturningAdvice2(String result){
//        logger.info("第二个后置返回通知的返回值："+result);
//    }
//
//
//    /**
//     * 后置异常通知
//     *  定义一个名字，该名字用于匹配通知实现方法的一个参数名，当目标方法抛出异常返回后，将把目标方法抛出的异常传给通知方法；
//     *  throwing:限定了只有目标方法抛出的异常与通知方法相应参数异常类型时才能执行后置异常通知，否则不执行，
//     *            对于throwing对应的通知方法参数为Throwable类型将匹配任何异常。
//     * @param joinPoint
//     * @param exception
//     */
//    @AfterThrowing(value = POINT_CUT,throwing = "exception")
//    public void doAfterThrowingAdvice(JoinPoint joinPoint,Throwable exception){
//        logger.info(joinPoint.getSignature().getName());
//        if(exception instanceof NullPointerException){
//            logger.info("发生了空指针异常!!!!!");
//        }
//    }

    @After(value = POINT_CUT)
    public void doAfterAdvice(JoinPoint joinPoint){
        logger.info("afer");
    }

    @Around(value = POINT_CUT)
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        logger.info("around start："+proceedingJoinPoint.getSignature().toString());
        Object obj = null;
        try {
            obj = proceedingJoinPoint.proceed();
            logger.info(obj.toString());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        logger.info("around end");
        return obj;
    }
}
