package net.toDo.SpringBoot.repository;

import net.toDo.SpringBoot.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {

}
