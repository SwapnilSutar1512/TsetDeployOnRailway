package com.cursor.controller;
// हिंदी में उत्तर:

import com.cursor.dto.TaskCreationDto;
import com.cursor.entity.Task;
import com.cursor.repository.TaskRepository;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    // POST मेथड: नया Task सेव करने के लिए
    @PostMapping("/create")
    public ResponseEntity<?> saveTask(@Valid @RequestBody TaskCreationDto taskDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // अगर वैलिडेशन में कोई त्रुटि है तो उसे रिटर्न करें
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setDueDate(taskDto.getDueDate());
        task.setCompleted(false); // नया Task डिफ़ॉल्ट रूप से अधूरा होगा

        Task savedTask = taskRepository.save(task);

        return ResponseEntity.ok(savedTask);
    }



    // सभी टास्क्स को प्राप्त करने के लिए GET मेथड और स्टेटस कोड के साथ रिटर्न करें
    @GetMapping("/all")
    public ResponseEntity<?> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        // एक कस्टम रिस्पॉन्स ऑब्जेक्ट जिसमें डाटा और स्टेटस दोनों होंगे
        return ResponseEntity
                .status(200)
                .body(new HashMap<String, Object>() {{
                    put("status", 200);
                    put("tasks", tasks);
                }});
    }

}