package com.guildwebsitepoc.controller;

import com.guildwebsitepoc.model.GuildApplication;
import com.guildwebsitepoc.service.GuildApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/acceptedApplications")
    public List<GuildApplication> getAcceptedGuildApplication() {
        return guildApplicationService.getAcceptedGuildApplication();
    }

    @GetMapping("/guildApplications/{applicationId}")
    public GuildApplication getGuildApplication(@PathVariable String applicationId) {
        return guildApplicationService.getGuildApplication(applicationId);
    }

    // TODO make idempotent
    // applicationId is an UUID generated from the front-end
    @PostMapping("/guildApplications")
    public GuildApplication addGuildApplication(@RequestHeader String applicationId,
                                                @RequestBody GuildApplication guildApplication) {
        guildApplication.setApplicationId(applicationId);
        guildApplicationService.addGuildApplication(guildApplication);

        return guildApplication;
    }

    @PutMapping("/guildApplications/{applicationId}")
    public GuildApplication updateGuildApplication(@PathVariable String applicationId,
                                                   @RequestBody GuildApplication guildApplication) {

        GuildApplication initialGuildApplication = guildApplicationService.getGuildApplication(applicationId);
        if (initialGuildApplication.getApplicationId() != guildApplication.getApplicationId()) {
            // TODO throw guildApplicationId does not match
        }

        guildApplicationService.updateGuildApplication(guildApplication);

        return guildApplication;
    }

    @DeleteMapping("guildApplications/{applicationId}")
    public String deleteGuildApplication(@PathVariable String applicationId) {
        GuildApplication guildApplication = guildApplicationService.getGuildApplication(applicationId);
        guildApplicationService.deleteGuildApplication(guildApplication.getApplicationId());

        return "Deleted account id - " + guildApplication.getApplicationId();
    }
}
