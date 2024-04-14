package com.robson.task.tasks.controller;

import com.robson.task.tasks.controller.DTO.TaskDTO;
import com.robson.task.tasks.controller.converter.TaskDTOConverter;
import com.robson.task.tasks.model.Task;
import com.robson.task.tasks.service.TaskService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {


    private final TaskService service;

    private final TaskDTOConverter converter;

    public TaskController(TaskService service, TaskDTOConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @GetMapping
    public Mono<List<TaskDTO>> getTasks() {
        return service.list()
                .map(converter::convertList);
    }

    @PostMapping
    public Mono<TaskDTO> createTask(@RequestBody Task task) {
        return service.insert(task)
                .map(converter::converter);
    }

}
