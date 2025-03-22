package com.example.elizar_project_1.repositories;

import com.example.elizar_project_1.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    Optional<Project> findByTitle(String title);

    Optional<Project> findByUrl(String url);


}
