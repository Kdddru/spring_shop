package com.dudu.shop.error;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@ControllerAdvice
public class ExceptionHandlerFun {

  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public ResponseEntity<String>MethodArgumentTypeHandler(){

    return ResponseEntity.status(400).body("에러남");
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String>handler(){

    return ResponseEntity.status(400).body("에러남");
  }

}
