package br.com.tutorials.domain.event.listener;

import br.com.tutorials.domain.event.CreatedEventResource;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;

@Component
public class CreatedListenerResource implements ApplicationListener<CreatedEventResource>{
  @Override
  public void onApplicationEvent(CreatedEventResource event){
    HttpServletResponse response=event.getResponse();
    Long id=event.getId();

    addHeaderLocation(response, id);
  }

  private void addHeaderLocation(HttpServletResponse response, Long id){
    var uri=ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(id).toUri();
    response.setHeader("Location", uri.toASCIIString());
  }
}
