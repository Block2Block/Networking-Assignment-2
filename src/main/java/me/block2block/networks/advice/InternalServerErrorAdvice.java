package me.block2block.networks.advice;

import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class InternalServerErrorAdvice {

    @ResponseBody
    @ExceptionHandler(JSONException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    String internalServerErrorHandler(JSONException ex) {
        return ex.getMessage();
    }

}
