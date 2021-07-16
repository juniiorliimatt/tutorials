package br.com.tutorials.domain.resources;

import br.com.tutorials.domain.models.Tutorial;
import br.com.tutorials.domain.services.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@CrossOrigin(origins="http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TutorialController implements Serializable{

  private final TutorialService service;

  @Autowired
  public TutorialController(TutorialService service){
    this.service=service;
  }

  @GetMapping()
  public ResponseEntity<List<Tutorial>> findAll(@RequestParam(required=false) String title){
    if(title.isEmpty()){
      return ResponseEntity.ok(service.findAll());
    }else{
      return ResponseEntity.ok(service.findByTitle(title));
    }
  }

}
