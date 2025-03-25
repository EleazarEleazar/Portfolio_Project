package com.example.elizar_project_1.services;

import com.example.elizar_project_1.models.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getAllProjects();

    Project getProjectById(Long id);

    Project addProject(Project project);

    Project updateProject(Project project);

    void deleteProjectById(Long id);

    // мои кастомные методы из репозитория
    Project findProjectByTitle(String title);

    Project findProjectByUrl(String url);

}
