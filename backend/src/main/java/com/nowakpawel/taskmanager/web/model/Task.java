package com.nowakpawel.taskmanager.web.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "task")
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    @Column(nullable = false)
    @Getter
    @Setter
    private String title;

    @Column(length = 1000)
    @Getter
    @Setter
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Getter
    @Setter
    private TaskStatus status = TaskStatus.TODO;

    @Column(name = "created_at", nullable = false, updatable = false)
    @Getter
    @Setter
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    @Getter
    @Setter
    private LocalDateTime updatedAt;

    //constructors
    public Task() {}

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}
