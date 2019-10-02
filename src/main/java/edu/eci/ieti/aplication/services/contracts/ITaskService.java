package edu.eci.ieti.aplication.services.contracts;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.eci.ieti.aplication.model.Task;
import edu.eci.ieti.aplication.model.User;

@Service
public interface ITaskService {
    List<Task> geTasksList();

    Task getTaskById(String id);

    List<Task> getTasksByUserId(String userId);

    Task assignTaskToUser(String taskId, User user);

    void removeTask(String taskId);

    Task updateTask(Task task);
}