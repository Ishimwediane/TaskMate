package com.TaskMate.DoRight;
import java.util.HashMap;
import java.util.Map;

public class TaskCrud {
    private Map<Long, Task> tasks = new HashMap<>();

    public void createTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public Task readTask(Long id) {
        return tasks.get(id);
    }

    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void deleteTask(Long id) {
        tasks.remove(id);
    }

    public Map<Long, Task> getAllTasks() {
        return tasks;
    }
}