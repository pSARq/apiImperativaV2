package com.todoapp.todoapp.persistence.repository;

import com.todoapp.todoapp.persistence.entity.Task;
import com.todoapp.todoapp.persistence.entity.TaskStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByTaskStatusEnum(TaskStatusEnum taskStatusEnum);

    @Modifying
    @Query(value = "UPDATE task SET finished = true WHERE id = :id", nativeQuery = true)
    void markTaskAsFinished(@Param("id") Long id);

}
