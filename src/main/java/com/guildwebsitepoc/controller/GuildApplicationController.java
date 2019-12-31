package com.guildwebsitepoc.controller;

import com.guildwebsitepoc.model.GuildApplication;
import com.guildwebsitepoc.service.GuildApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${api.base.url}" + "/GuildApplicationService")
public class GuildApplicationController {

    @Autowired
    private GuildApplicationService guildApplicationService;

    @GetMapping("/pendingApplications")
    public List<GuildApplication> getPendingGuildApplication() {
        return guildApplicationService.getPendingGuildApplication();
    }

    @GetMapping("/declinedApplications")
    public List<GuildApplication> getDeclinedGuildApplication() {
        return guildApplicationService.getDeclinedGuildApplication();
    }
}
