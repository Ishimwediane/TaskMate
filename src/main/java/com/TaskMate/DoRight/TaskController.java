package com.TaskMate.DoRight;
import com.TaskMate.DoRight.Task;
import com.TaskMate.DoRight.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        taskService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> readTask(@PathVariable Long id) {
        Task task = taskService.readTask(id);
        if (task != null) {
            return ResponseEntity.ok(task);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        taskService.updateTask(task);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Map<Long, Task>> getAllTasks() {
        Map<Long, Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }
}