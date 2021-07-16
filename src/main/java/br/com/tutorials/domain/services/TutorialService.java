package br.com.tutorials.domain.services;

import br.com.tutorials.domain.models.Tutorial;
import br.com.tutorials.domain.repositories.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Service
public class TutorialService implements Serializable{

  private TutorialRepository repository;

  @Autowired
  TutorialService(TutorialRepository repository){
    this.repository=repository;
  }

  @Transactional
  public List<Tutorial> findAll(){
    return repository.findAll();
  }

  @Transactional
  public List<Tutorial> findByTitle(String title){
    return repository.findByTitleContaining(title);
  }
}
