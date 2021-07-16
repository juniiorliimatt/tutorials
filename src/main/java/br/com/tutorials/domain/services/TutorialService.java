package br.com.tutorials.domain.services;

import br.com.tutorials.domain.models.Tutorial;
import br.com.tutorials.domain.repositories.TutorialRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class TutorialService implements Serializable{

  private final TutorialRepository repository;

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
    return repository.findByTitleStartingWith(title);
  }

  public Optional<Tutorial> findById(Long id){
    return repository.findById(id);
  }

  @Transactional
  public Tutorial save(Tutorial tutorial){
    return repository.save(tutorial);
  }

  public Tutorial update(Long id, Tutorial tutorial){
    var update=repository.getById(id);
    BeanUtils.copyProperties(tutorial, update);
    return repository.save(update);
  }
}
