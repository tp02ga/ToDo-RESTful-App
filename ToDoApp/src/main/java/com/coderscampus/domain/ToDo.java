package com.coderscampus.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"user"})
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
    int a = this.done.compareTo(toDo.done);
    if (a == 0)
    {
      a = this.priority.compareTo(toDo.priority);
    }
    if (a == 0)
    {
      a = this.id.compareTo(toDo.id);
    }
    return a;
  }
  @Override
  public String toString()
  {
    return "ToDo [id=" + id + ", task=" + task + ", done=" + done + ", priority=" + priority + "]";
  }
  
  
}
