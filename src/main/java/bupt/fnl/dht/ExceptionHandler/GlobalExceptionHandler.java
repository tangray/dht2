package bupt.fnl.dht.ExceptionHandler;

import bupt.fnl.dht.SelfDefinedException.DoubleInsertException;
import bupt.fnl.dht.SelfDefinedException.InputNullException;
import bupt.fnl.dht.SelfDefinedException.QueryNotExistException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = InputNullException.class)
    @ResponseBody
    private Map<String, Object> ExceptionHandler(HttpServletRequest req, InputNullException e) {
        Map<String, Object> error = new HashMap<String, Object>();
        error.put("SUCCESS", false);
        error.put("errMsg", e.getMessage());
        return error;
    }

    @ExceptionHandler(value = QueryNotExistException.class)
    @ResponseBody
    private Map<String, Object> ExceptionHandler(HttpServletRequest req, QueryNotExistException e) {
        Map<String, Object> error = new HashMap<String, Object>();
        error.put("SUCCESS", false);
        error.put("errMsg", e.getMessage());
        return error;
    }

    @ExceptionHandler(value = DoubleInsertException.class)
    @ResponseBody
    private Map<String, Object> ExceptionHandler(HttpServletRequest req, DoubleInsertException e) {
        Map<String, Object> error = new HashMap<String, Object>();
        error.put("SUCCESS", false);
        error.put("errMsg", e.getMessage());
        return error;
    }
}
