package com.example.elizar_project_1.controllers;

import com.example.elizar_project_1.models.Project;
import com.example.elizar_project_1.repositories.ProjectRepository;
import com.example.elizar_project_1.services.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectServiceImpl projectService;

    @Autowired
    public ProjectController(ProjectServiceImpl projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public String listProjects(Model model) {
        model.addAttribute("projects", projectService.getAllProjects());
        return "projects";
    }

    @GetMapping("/id/{id}")
    public String getProjectById(@PathVariable Long id, Model model) {
        model.addAttribute("project", projectService.getProjectById(id));
        return "project-details";
    }

    @PostMapping("/add")
    public String addProject(
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam String url) {

        Project project = new Project(title, description, url);
        projectService.addProject(project);
        return "redirect:/projects";
    }

    @PostMapping("/update")
    public String updateProject(
            @RequestParam Long id,
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam String url) {

        Project project = new Project(id, title, description, url);
        projectService.updateProject(project);
        return "redirect:/projects";
    }

    @PostMapping("/delete")
    public String deleteProject(@RequestParam Long id) {
        projectService.deleteProjectById(id);
        return "redirect:/projects";
    }

    @GetMapping("/search-by-title")
    public String findProjectByTitle(@RequestParam String title, Model model) {
        model.addAttribute("project", projectService.findProjectByTitle(title));
        return "project-details";
    }

    @GetMapping("/search-by-url")
    public String findProjectByUrl(@RequestParam String url, Model model) {
        Project project = projectService.findProjectByUrl(url);
        model.addAttribute("project", project);
        return "project-details";
    }
}
