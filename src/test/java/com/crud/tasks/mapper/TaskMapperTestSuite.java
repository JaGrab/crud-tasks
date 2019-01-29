package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TaskMapperSuite {
    @Test
    public void mapToTaskTest() {
        //Given
        TaskMapper mapper = new TaskMapper();
        TaskDto taskDto = new TaskDto(7L, "Task 1", "Description 1");
        //When
        Task task = mapper.mapToTask(taskDto);
        //Then
        assertEquals(7L, task.getId(), 0);
        assertEquals("Task 1", task.getTitle());
        assertEquals("Description 1", task.getContent());
    }
    @Test
    public void mapToTaskDtoTest() {
        //Given
        TaskMapper mapper = new TaskMapper();
        Task task = new Task(15L, "Task X", "Description A");
        //When
        TaskDto taskDto = mapper.mapToTaskDto(task);
        assertEquals(15L, taskDto.getId(), 0);
        assertEquals("Task X", taskDto.getTitle());
        assertEquals("Description A", taskDto.getContent());
    }
    @Test
    public void mapToTaskDtoListTest() {
        //Given
        TaskMapper mapper = new TaskMapper();
        Task task1 = new Task(7L, "Task 1", "Description 1");
        Task task2 = new Task(15L, "Task X", "Description A");
        List<Task> taskList = new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);
        //When
        List<TaskDto> tasks = mapper.mapToTaskDtoList(taskList);
        //Then
        assertEquals(2, tasks.size());
        assertEquals(7L, tasks.get(0).getId(), 0);
        assertEquals("Description A", tasks.get(1).getContent());
    }
}
