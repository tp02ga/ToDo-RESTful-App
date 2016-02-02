package com.coderscampus.web;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.domain.ToDo;
import com.coderscampus.repository.ToDoRepository;

@RestController
@RequestMapping("/todo/api")
public class ToDoController
{
  private ToDoRepository toDoRepo;
  
  // CREATE
  @RequestMapping(value="", method=RequestMethod.POST)
  public ResponseEntity<ToDo> create (@RequestBody ToDo todo)
  {
    ToDo savedToDo = toDoRepo.save(todo);
    
    return new ResponseEntity<ToDo>(savedToDo, HttpStatus.OK);
  }

  
  // READ
  @RequestMapping(value="", method=RequestMethod.GET)
  public ResponseEntity<Collection<ToDo>> getTodos ()
  {
    List<ToDo> toDos = toDoRepo.findAll();
    
    return new ResponseEntity<Collection<ToDo>>(toDos, HttpStatus.OK);
  }
  @RequestMapping(value="{id}", method=RequestMethod.GET)
  public ResponseEntity<ToDo> getTodo (@PathVariable Long id)
  {
    ToDo toDo = toDoRepo.findOne(id);
    
    if (toDo == null)
    {
      return new ResponseEntity<ToDo>(HttpStatus.NO_CONTENT);
    }
    
    return new ResponseEntity<ToDo>(toDo, HttpStatus.OK);
    
  }
  
  // UPDATE
  @RequestMapping(value="{id}", method=RequestMethod.PUT)
  public ResponseEntity<ToDo> updateTodo (@PathVariable Long id, @RequestBody ToDo todo)
  {
    ToDo savedToDo = toDoRepo.findOne(id);
    
    if (savedToDo == null)
    {
      return new ResponseEntity<ToDo>(HttpStatus.NO_CONTENT);
    }
    
    BeanUtils.copyProperties(todo, savedToDo, "id");
    
    savedToDo = toDoRepo.save(savedToDo);
    
    return new ResponseEntity<ToDo>(savedToDo, HttpStatus.OK);
  }
  
  // DELETE
  @RequestMapping(value="{id}", method=RequestMethod.DELETE)
  public ResponseEntity<ToDo> deleteTodo (@PathVariable Long id)
  {
    ToDo toDo = toDoRepo.findOne(id);
    
    if (toDo == null)
    {
      return new ResponseEntity<ToDo>(HttpStatus.NO_CONTENT);
    }
    
    try
    {
      toDoRepo.delete(toDo);
    }
    catch (Exception e)
    {
      return new ResponseEntity<ToDo>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
  
  @Autowired
  public void setToDoRepo(ToDoRepository toDoRepo)
  {
    this.toDoRepo = toDoRepo;
  }
  
}
