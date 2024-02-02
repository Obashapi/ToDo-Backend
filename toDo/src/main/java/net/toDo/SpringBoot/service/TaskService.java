package net.toDo.SpringBoot.service;

import net.toDo.SpringBoot.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskService {
    Task createTask(Task task);
    Task getTaskById(Long taskId);
   Page<Task> getAllTasks(Pageable pageable);
    Task updateTask(Task task);
    void deleteTask(Long taskId);
}
