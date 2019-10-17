package bupt.fnl.dht.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class JudgeInputNotNull {

    @Pointcut("execution(* bupt.fnl.dht.controller.Controller.queryByIdentity(..))")
    public void InsertInputNotNull() {
    }

    @Before("InsertInputNotNull()")
    public void beforeInsert(JoinPoint joinPoint) {

    }
}
