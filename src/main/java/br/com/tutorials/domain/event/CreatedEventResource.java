package br.com.tutorials.domain.event;

import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

public class CreatedEventResource extends ApplicationEvent{
  private final HttpServletResponse response;
  private final Long id;

  public CreatedEventResource(Object source, HttpServletResponse response, Long id){
    super(source);
    this.response=response;
    this.id=id;
  }

  public HttpServletResponse getResponse(){
    return this.response;
  }

  public Long getId(){
    return this.id;
  }
}
