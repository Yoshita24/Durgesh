package com.substring.foodie.substring_foodie.exception;

import com.substring.foodie.substring_foodie.example.AuthController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(NullPointerException.class)
    public String handleNullPointerException(NullPointerException ex)
    {
        logger.error(ex.getMessage());
        return ex.getMessage();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String > handleMethodArgumentNotValidException(MethodArgumentNotValidException ex)
    {
        Map<String,String > errorMap = new HashMap<>();
        //fetch all error list from bindingresult
        List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
        //iterate all error and put in the map
        allErrors.stream().forEach(error -> {
            //error: we have to fetch the field
            String fieldName = ((FieldError)error).getField();
            String message = error.getDefaultMessage();
            errorMap.put(fieldName,message);
        });
        return errorMap;
    }
}
