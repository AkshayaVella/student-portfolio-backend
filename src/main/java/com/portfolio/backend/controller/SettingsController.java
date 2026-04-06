package com.portfolio.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.portfolio.backend.model.Settings;
import com.portfolio.backend.repository.SettingsRepository;

import java.util.List;

@RestController
@RequestMapping("/api/settings")
@CrossOrigin("*")
public class SettingsController {

    @Autowired
    private SettingsRepository repo;

    // ✅ GET SETTINGS (latest one)
    @GetMapping
    public Settings getSettings() {
        List<Settings> list = repo.findAll();

        if (list.isEmpty()) {
            // default settings
            Settings s = new Settings();
            s.setTheme("light");
            s.setNotifications(true);
            return repo.save(s);
        }

        return list.get(list.size() - 1);
    }

    // ✅ SAVE / UPDATE SETTINGS
    @PostMapping
    public Settings save(@RequestBody Settings settings) {
        return repo.save(settings);
    }
}