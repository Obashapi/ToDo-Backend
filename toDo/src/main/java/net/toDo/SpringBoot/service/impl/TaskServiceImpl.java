package net.toDo.SpringBoot.service.impl;

import lombok.AllArgsConstructor;
import net.toDo.SpringBoot.entity.Task;
import net.toDo.SpringBoot.repository.TaskRepository;
import net.toDo.SpringBoot.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task getTaskById(Long taskId) {
            Optional<Task>optionalTask=taskRepository.findById(taskId);
                    return optionalTask.get();
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task updateTask(Task task) {
        Task existingTask = taskRepository.findById(task.getId()).get();
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setPriority(task.getPriority());
        existingTask.setStatus(task.getStatus());
       existingTask.setDueDate(task.getDueDate());
       existingTask.setCreationDate(task.getCreationDate());
       Task updatedTask= taskRepository.save(existingTask);
        return updatedTask;
    }

    @Override
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);

    }
}
