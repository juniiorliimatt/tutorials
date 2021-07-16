package br.com.tutorials.domain.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Tutorial implements Serializable{

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  private String title;

  private String description;

  private Boolean published;

  public Tutorial(){
  }

  public Tutorial(Long id, String title, String description, Boolean published){
    this.id=id;
    this.title=title;
    this.description=description;
    this.published=published;
  }

  public Long getId(){
    return id;
  }

  public void setId(Long id){
    this.id=id;
  }

  public String getTitle(){
    return title;
  }

  public void setTitle(String title){
    this.title=title;
  }

  public String getDescription(){
    return description;
  }

  public void setDescription(String description){
    this.description=description;
  }

  public Boolean getPublished(){
    return published;
  }

  public void setPublished(Boolean published){
    this.published=published;
  }

  @Override
  public boolean equals(Object o){
    if(this==o) return true;
    if(o==null || getClass()!=o.getClass()) return false;
    var tutorial=(Tutorial) o;
    return Objects.equals(id, tutorial.id);
  }

  @Override
  public int hashCode(){
    return Objects.hash(id);
  }
}
