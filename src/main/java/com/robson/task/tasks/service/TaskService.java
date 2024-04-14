package com.robson.task.tasks.service;

import com.robson.task.tasks.model.Task;
import com.robson.task.tasks.repository.TaskRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

//    public static List<Task> taskList = new ArrayList<>();
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Mono<Task> insert(Task task){
        return Mono.just(task)
                .map(Task::insert)
                .flatMap(this::save);    //it -> this.save(it);
    }

    public Mono<List<Task>> list(){
        return Mono.just(taskRepository.findAll());
    }

    private Mono<Task> save(Task task){
        return Mono.just(task)
                .map(taskRepository::save);
    }
}
