package com.robson.task.tasks.service;

import com.robson.task.tasks.model.Task;
import com.robson.task.tasks.repository.TaskCustomRepository;
import com.robson.task.tasks.repository.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
public class TaskService {

//    public static List<Task> taskList = new ArrayList<>();
    private final TaskRepository taskRepository;
    private final TaskCustomRepository taskCustomRepository;

    public TaskService(TaskRepository taskRepository, TaskCustomRepository taskCustomRepository) {
        this.taskRepository = taskRepository;
        this.taskCustomRepository = taskCustomRepository;
    }

    public Mono<Task> insert(Task task){
        return Mono.just(task)
                .map(Task::insert)
                .flatMap(this::save);    //it -> this.save(it);
    }

    public Page<Task> findPaginated(Task task, Integer pageNumber, Integer pageSize){
        return taskCustomRepository.findPaginated(task, pageNumber, pageSize);
    }

    private Mono<Task> save(Task task){
        return Mono.just(task)
                .map(taskRepository::save);
    }

    public Mono<Void> deleteById(String id){
        return Mono.fromRunnable(()-> taskRepository.deleteById(id));
    }
}
