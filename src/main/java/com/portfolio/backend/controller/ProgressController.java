package com.portfolio.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.portfolio.backend.model.Progress;
import com.portfolio.backend.repository.ProgressRepository;

import java.util.*;

@RestController
@RequestMapping("/api/progress")
@CrossOrigin("*")
public class ProgressController {

    @Autowired
    private ProgressRepository repo;

    // ✅ GET ALL DATA
    @GetMapping
    public List<Progress> getAll() {
        return repo.findAll();
    }

    // ✅ ADD DATA
    @PostMapping
    public Progress add(@RequestBody Progress p) {
        return repo.save(p);
    }

    // ✅ GET WEEKLY DATA (LINE CHART)
    @GetMapping("/weekly")
    public List<Map<String, Object>> getWeekly() {
        List<Progress> list = repo.findAll();

        List<Map<String, Object>> result = new ArrayList<>();

        for (Progress p : list) {
            Map<String, Object> map = new HashMap<>();
            map.put("week", p.getWeek());
            map.put("progress", p.getProgress());
            result.add(map);
        }

        return result;
    }

    // ✅ GET COURSE DATA (PIE CHART)
    @GetMapping("/courses")
    public List<Map<String, Object>> getCourses() {
        List<Progress> list = repo.findAll();

        List<Map<String, Object>> result = new ArrayList<>();

        for (Progress p : list) {
            if (p.getCourseName() != null) {
                Map<String, Object> map = new HashMap<>();
                map.put("name", p.getCourseName());
                map.put("value", p.getCourseProgress());
                result.add(map);
            }
        }

        return result;
    }
}