package br.com.tutorials.domain.resources;

import br.com.tutorials.domain.event.CreatedEventResource;
import br.com.tutorials.domain.models.Tutorial;
import br.com.tutorials.domain.services.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.List;

//@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TutorialController implements Serializable{

  private final TutorialService service;
  private final ApplicationEventPublisher publisher;

  @Autowired
  public TutorialController(TutorialService service, ApplicationEventPublisher publisher){
    this.service=service;
    this.publisher=publisher;
  }

  @GetMapping()
  public ResponseEntity<List<Tutorial>> findAll(){
    List<Tutorial> tutorials=service.findAll();
    return tutorials.isEmpty()?ResponseEntity.noContent().build():ResponseEntity.ok().body(tutorials);
  }

  @GetMapping("/tutorials/{id}")
  public ResponseEntity<Tutorial> findById(@PathVariable("id") Long id){
    var tutorial=service.findById(id);
    return tutorial.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
  }

  @GetMapping("/tutorials")
  public ResponseEntity<List<Tutorial>> findByTitle(@RequestParam(required=true) String title){
    List<Tutorial> tutorials=service.findByTitle(title);
    return tutorials.isEmpty()?ResponseEntity.noContent().build():ResponseEntity.ok(tutorials);
  }

  @PostMapping
  public ResponseEntity<Tutorial> save(@RequestBody Tutorial tutorial, HttpServletResponse response){
    var saved=service.save(tutorial);
    publisher.publishEvent(new CreatedEventResource(this, response, saved.getId()));
    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
  }

  @PutMapping("/tutorials/{id}")
  public ResponseEntity<Tutorial> update(@RequestBody Tutorial tutorial, @PathVariable("id") Long id){
    return ResponseEntity.ok(service.update(id, tutorial));
  }
}
