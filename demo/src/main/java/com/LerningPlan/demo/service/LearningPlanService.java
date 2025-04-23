package com.LerningPlan.demo.service;

import com.LerningPlan.demo.model.LearningPlan;
import com.LerningPlan.demo.repository.LearningPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LearningPlanService {

    @Autowired
    private LearningPlanRepository repo;

    public List<LearningPlan> getAll() {
        return repo.findAll();
    }

    public LearningPlan save(LearningPlan plan) {
        return repo.save(plan);
    }

    public LearningPlan update(String id, LearningPlan plan) {
        Optional<LearningPlan> opt = repo.findById(id);
        if (opt.isPresent()) {
            LearningPlan existing = opt.get();
            existing.setTitle(plan.getTitle());
            existing.setGoal(plan.getGoal());
            existing.setTopics(plan.getTopics());
            existing.setContentLinks(plan.getContentLinks());
            existing.setStartDate(plan.getStartDate());
            existing.setDueDate(plan.getDueDate());
            existing.setProgress(plan.getProgress());
            existing.setCompleted(plan.isCompleted());
            return repo.save(existing);
        }
        return null;
    }

    public void delete(String id) {
        repo.deleteById(id);
    }

    public List<LearningPlan> search(String kw) {
        return repo.searchLearningPlans(kw);
    }
}
