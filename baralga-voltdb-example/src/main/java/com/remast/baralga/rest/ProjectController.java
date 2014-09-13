package com.remast.baralga.rest;

import com.remast.baralga.ProjectRepository;
import com.remast.baralga.model.Project;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
public class ProjectController {

    @Resource
    private ProjectRepository projectRepository;

    @RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
    public @ResponseBody Project findPersonById(@PathVariable("id") String id) {
        return projectRepository.findById(id);
    }


    @RequestMapping(value = "/project", method = RequestMethod.GET)
    @ResponseBody
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @RequestMapping(value = "/project", method= RequestMethod.POST)
    public Project save(@RequestBody @Valid Project project) {
        return projectRepository.save(project);
    }

}
