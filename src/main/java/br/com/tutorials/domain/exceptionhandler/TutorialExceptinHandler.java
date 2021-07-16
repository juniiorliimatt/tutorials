package br.com.tutorials.domain.exceptionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class TutorialExceptinHandler extends ResponseEntityExceptionHandler{

  private final MessageSource message;

  @Autowired
  public TutorialExceptinHandler(MessageSource message){
    this.message=message;
  }
}
