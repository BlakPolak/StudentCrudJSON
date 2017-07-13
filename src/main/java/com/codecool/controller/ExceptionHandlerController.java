package com.codecool.controller;

import com.codecool.exceptions.NotFoundError;
import com.codecool.exceptions.ValidationError;
import com.codecool.model.ExceptionResponse;
import org.json.JSONObject;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ValidationError.class)
    public ResponseEntity<Object> handleValidationError(ValidationError e, WebRequest request) throws Exception {
        System.out.println(e);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put ("key", "ValidationError");
        jsonObject.put ("msg", "Some validation errors happend");
        jsonObject.put ("params", "firstName: required" +
                " lastName: required" +
                " klass: required}");
        String bodyofResponse = jsonObject.toString();
        return new ResponseEntity<Object>(bodyofResponse, new HttpHeaders(),HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NotFoundError.class)
    public ResponseEntity<Object> handleNotFoundError(NotFoundError e, WebRequest request) throws Exception {
        System.out.println(e);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put ("key", "NotFoundError");
        jsonObject.put ("msg", "Resource not found");
        String bodyofResponse = jsonObject.toString();
        return new ResponseEntity<Object>(bodyofResponse, new HttpHeaders(),HttpStatus.NOT_FOUND);
    }

}

//  "key": "ValidationError",
//          "msg": "Some validation errors happend",
//          "params": {
//          "first_name": "required"
//ResponseEntity<Object>
//JSONObjec jsonObject new JsobObjcect()
//        jsonObjec.put ("key", "NotFound"_
//
//        string body ofRespone = jsonObject.toString())
//return handleExceptionInternal(ex,bofyTrdpodnr, httpHeaders httpstatus, request)