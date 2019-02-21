package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@NamedNativeQuery(
        name = "Task.retrieveLastThreeTasks",
        query = "SELECT * FROM TASKS ORDER BY ID DESC LIMIT 3",
        resultClass = Task.class
)
@Entity(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String title;
    @Column(name = "description")
    private String content;
}
