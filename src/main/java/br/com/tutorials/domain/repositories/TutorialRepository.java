package br.com.tutorials.domain.repositories;

import br.com.tutorials.domain.models.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TutorialRepository extends JpaRepository<Tutorial, Long>{
  List<Tutorial> findByPublished(Boolean published);

  List<Tutorial> findByTitleStartingWith(String title);
}
