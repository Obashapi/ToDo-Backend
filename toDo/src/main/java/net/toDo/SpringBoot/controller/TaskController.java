package net.toDo.SpringBoot.controller;

import lombok.AllArgsConstructor;
import net.toDo.SpringBoot.entity.Task;
import net.toDo.SpringBoot.service.TaskService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/tasks")

public class TaskController {
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task ){

        task.setCreationDate(new Date());

        Task savedTask = taskService.createTask(task);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }
    //http://localhost:8080/api/v1/tasks/1
    @GetMapping("{id}")
    public ResponseEntity<Task>getTaskById(@PathVariable("id") Long taskId){
        Task task= taskService.getTaskById(taskId);
        return new ResponseEntity<>(task,HttpStatus.OK);
    }



    @GetMapping()
    public ResponseEntity<Map<String, Object>>getAllTasks(Pageable pageable){
        var pagedRes=taskService.getAllTasks(pageable);

        List<Task>tasks=pagedRes.getContent();
        Map<String, Object> res = new HashMap<>();
        res.put("content", tasks);
        res.put("currentPage", pagedRes.getNumber());
        res.put("total", pagedRes.getTotalElements());
        res.put("pages", pagedRes.getTotalPages());

        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    @PatchMapping("{id}")
    public ResponseEntity<Task> updateTask(@PathVariable("id") Long taskId,@RequestBody Task task){
        task.setId(taskId);
         Task updatedUser=taskService.updateTask(task);
         return  new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String>deleteTask(@PathVariable("id") Long taskId){
        taskService.deleteTask(taskId);
        return new ResponseEntity<>("Task successfully deleted!",HttpStatus.OK);
    }

}
