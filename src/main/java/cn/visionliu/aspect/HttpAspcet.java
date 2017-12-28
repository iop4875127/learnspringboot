package cn.visionliu.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by VisionLiu on 2017/12/24.
 */
@Aspect
@Component
public class HttpAspcet {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspcet.class);

    @Pointcut("execution(public * cn.visionliu.controller.*.*(..))")
    public void controllerExec(){}

    @Before("controllerExec()")
    public void doBefore(JoinPoint joinPoint) {

        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequestAttributes.getRequest();

        //url
        logger.info("url={}", httpServletRequest.getRequestURL());

        //method
        logger.info("method={}", httpServletRequest.getMethod());

        //ip
        logger.info("ip={}", httpServletRequest.getRemoteHost());

        //class.method
        logger.info("class.method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //args
        logger.info("args={}", joinPoint.getArgs());
    }

    @After("controllerExec()")
    public void doAfter() {
        logger.info("HttpAspcet doAfter controllerExec");
    }

    @AfterReturning(returning = "object", pointcut = "controllerExec()")
    public void afterReturning(Object object){
        logger.info("response={}", object.toString());
    }
}
