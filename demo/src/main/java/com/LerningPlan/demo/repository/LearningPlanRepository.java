package com.LerningPlan.demo.repository;

import com.LerningPlan.demo.model.LearningPlan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;

public interface LearningPlanRepository extends MongoRepository<LearningPlan, String> {

    @Query("{ $or: [ " +
            "{ 'title':      { $regex: ?0, $options: 'i' } }, " +
            "{ 'goal':       { $regex: ?0, $options: 'i' } }, " +
            "{ 'topics':     { $regex: ?0, $options: 'i' } }, " +
            "{ 'contentLinks': { $regex: ?0, $options: 'i' } } " +
            "] }")
    List<LearningPlan> searchLearningPlans(String keyword);
}
