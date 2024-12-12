package com.TaskMate.DoRight;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TaskService {
    private TaskCrud taskCRUD = new TaskCrud();

    public void createTask(Task task) {
        taskCRUD.createTask(task);
    }

    public Task readTask(Long id) {
        return taskCRUD.readTask(id);
    }

    public void updateTask(Task task) {
        taskCRUD.updateTask(task);
    }

    public void deleteTask(Long id) {
        taskCRUD.deleteTask(id);
    }

    public Map<Long, Task> getAllTasks() {
        return taskCRUD.getAllTasks();
    }
}