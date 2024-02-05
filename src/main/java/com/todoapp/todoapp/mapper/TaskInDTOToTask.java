package com.todoapp.todoapp.mapper;

import com.todoapp.todoapp.persistence.entity.Task;
import com.todoapp.todoapp.persistence.entity.TaskStatusEnum;
import com.todoapp.todoapp.service.dto.TaskInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskInDTOToTask implements IMapper<TaskInDTO, Task> {

    @Override
    public Task map(TaskInDTO taskInDTO) {
        Task task = new Task();
        task.setTittle(taskInDTO.getTittle());
        task.setDescription(taskInDTO.getDescription());
        task.setEta(taskInDTO.getEta());
        task.setCreatedDate(LocalDateTime.now());
        task.setFinished(Boolean.FALSE);
        task.setTaskStatusEnum(TaskStatusEnum.ON_TIME);
        return task;
    }

}
