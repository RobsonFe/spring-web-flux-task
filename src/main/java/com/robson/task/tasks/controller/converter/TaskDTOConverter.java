package com.robson.task.tasks.controller.converter;

import com.robson.task.tasks.controller.DTO.TaskDTO;
import com.robson.task.tasks.model.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class TaskDTOConverter {

    public TaskDTO converter(Task task) {
        return Optional.ofNullable(task)
                .map(source -> {
                    TaskDTO dto = new TaskDTO();
                    dto.setTitle(source.getTitle());
                    dto.setDescription(source.getDescription());
                    dto.setPriority(source.getPriority());
                    dto.setState(source.getState());
                    return dto;
                })
                .orElse(null);
    }

    public Task converter(TaskDTO taskDTO) {
        return Optional.ofNullable(taskDTO)
                .map(source -> Task.builder()
                        .withTitle(source.getTitle())
                        .withDescription(source.getDescription())
                        .withPriority(source.getPriority())
                        .withState(source.getState())
                        .build()
                )
                .orElse(null);
    }

    public List<TaskDTO> convertList(List<Task> taskList){
        return Optional.ofNullable(taskList)
                .map(array -> array.stream().map(this::converter).collect(Collectors.toList()))
                .orElse(new ArrayList<>());
    }
}
