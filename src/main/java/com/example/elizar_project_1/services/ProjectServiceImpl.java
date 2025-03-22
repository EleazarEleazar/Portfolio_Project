package com.example.elizar_project_1.services;

import com.example.elizar_project_1.models.Project;
import com.example.elizar_project_1.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));
    }

    @Override
    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project updateProject(Project project) {
        if (!projectRepository.existsById(project.getId())) {
            throw new IllegalArgumentException("Project for updating not found");
        }
        return projectRepository.save(project);
    }

    @Override
    public void deleteProjectById(Long id) {
        if (!projectRepository.existsById(id)) {
            throw new IllegalArgumentException("Project for deletion not found");
        }
        projectRepository.deleteById(id);
    }

    @Override
    public Project findProjectByTitle(String title) {
        return projectRepository.findByTitle(title)
                .orElseThrow(() -> new IllegalArgumentException("Project with this name not found"));
    }

    @Override
    public Project findProjectByUrl(String url) {
        return projectRepository.findByUrl(url)
                .orElseThrow(() -> new IllegalArgumentException("Project with this url not found"));
    }


}
