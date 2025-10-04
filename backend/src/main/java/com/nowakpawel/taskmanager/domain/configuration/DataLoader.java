package com.nowakpawel.taskmanager.domain.configuration;

import com.nowakpawel.taskmanager.web.model.Task;
import com.nowakpawel.taskmanager.web.model.TaskStatus;
import com.nowakpawel.taskmanager.web.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DataLoader {
    @Bean
    CommandLineRunner loadData(TaskRepository taskRepository) {
        return args ->
        {
            if (taskRepository.count() == 0) {
                taskRepository.save(new Task("Setup CI/CD pipeline", "Configure Jenkin + Docker"));
                taskRepository.save(new Task("Write Dockerfile", "Multi-stage build for production"));
                taskRepository.save(new Task("Deploy to staging", "Test deployment workflow"));

                Task inProgress = new Task("Learn Kubernetes", "Study pods, deployments, services");
                inProgress.setStatus(TaskStatus.IN_PROGRESS);
                taskRepository.save(inProgress);

                Task done = new Task("Setup PostgreSQL", "Docker compose with volume");
                done.setStatus(TaskStatus.DONE);
                taskRepository.save(done);

                System.out.println("✅ Seed data loaded: " + taskRepository.count() + " tasks");
            }
        };
    }
}
