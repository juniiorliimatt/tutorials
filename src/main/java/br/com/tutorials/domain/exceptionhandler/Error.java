package br.com.tutorials.domain.exceptionhandler;

public class Error{
  private final String messageUser;
  private final String messageDev;

  public Error(String messageUser, String messageDev){
    this.messageUser = messageUser;
    this.messageDev = messageDev;
  }

  public String getMessageUser(){
    return this.messageUser;
  }

  public String getMessageDev(){
    return this.messageDev;
  }
}
