package com.robson.task.tasks.service;

import com.robson.task.tasks.model.Task;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class TaskService {

    public static List<Task> taskList;

    public Mono<Task> insert(Task task){
        return Mono.just(task)
                .flatMap(this::save);    //it -> this.save(it);
    }

    private Mono<Task> save(Task task){
        return Mono.just(task)
                .map(task::newTask);
    }
}