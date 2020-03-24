package pe.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.taskmanager.domain.Task;

import java.util.UUID;


public interface TaskRepository extends JpaRepository<Task, UUID> {



}
