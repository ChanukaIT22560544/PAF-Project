package com.LerningPlan.demo.controller;

import com.LerningPlan.demo.model.LearningPlan;
import com.LerningPlan.demo.service.LearningPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/learning-plans")
@CrossOrigin(origins = "http://localhost:3000")
public class LearningPlanController {

    @Autowired
    private LearningPlanService service;

    @GetMapping
    public List<LearningPlan> getAll() {
        return service.getAll();
    }

    @PostMapping
    public LearningPlan create(@RequestBody LearningPlan plan) {
        return service.save(plan);
    }

    @PutMapping("/{id}")
    public LearningPlan update(@PathVariable String id, @RequestBody LearningPlan plan) {
        return service.update(id, plan);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/search")
    public List<LearningPlan> search(@RequestParam String keyword) {
        return service.search(keyword);
    }
}
