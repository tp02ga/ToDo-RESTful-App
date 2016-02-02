package com.coderscampus.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ToDo
{
  private Long id;
  private String task;
  private Boolean done;
  private Integer priority;
  
  @Id
  @GeneratedValue
  public Long getId()
  {
    return id;
  }
  public void setId(Long id)
  {
    this.id = id;
  }
  public String getTask()
  {
    return task;
  }
  public void setTask(String task)
  {
    this.task = task;
  }
  public Boolean getDone()
  {
    return done;
  }
  public void setDone(Boolean done)
  {
    this.done = done;
  }
  public Integer getPriority()
  {
    return priority;
  }
  public void setPriority(Integer priority)
  {
    this.priority = priority;
  }
  
  
}
