package com.coderscampus.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class ToDo implements Comparable<ToDo>
{
  private Long id;
  private String task;
  private Boolean done;
  private Integer priority;
  private User user;
  
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
  @ManyToOne
  public User getUser()
  {
    return user;
  }
  public void setUser(User user)
  {
    this.user = user;
  }
  @Override
  public int compareTo(ToDo toDo)
  {
    // this sorting code doesn't work, it will need some TLC 
    int a = this.done.compareTo(toDo.done);
    if (a == 0)
    {
      int b = this.priority.compareTo(toDo.priority);
      if (b == 0)
      {
        return this.id.compareTo(toDo.id);
      }
      else
      {
        return b;
      }
    }
    else
    {
      return a;
    }
  }
  
  
}
