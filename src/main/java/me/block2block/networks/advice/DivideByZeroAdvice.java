package me.block2block.networks.advice;

import me.block2block.networks.exceptions.DivideByZeroException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DivideByZeroAdvice {

    @ResponseBody
    @ExceptionHandler(DivideByZeroException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String divideByZeroHandler(DivideByZeroException ex) {
        return ex.getMessage();
    }

}
