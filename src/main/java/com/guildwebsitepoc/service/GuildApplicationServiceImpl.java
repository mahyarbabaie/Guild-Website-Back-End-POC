package com.guildwebsitepoc.service;

import com.guildwebsitepoc.dao.GuildApplicationRepository;
import com.guildwebsitepoc.model.GuildApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuildApplicationServiceImpl implements GuildApplicationService {

    @Autowired
    private GuildApplicationRepository guildApplicationRepository;

    @Override
    public List<GuildApplication> getPendingGuildApplication() {
        return guildApplicationRepository.getPendingGuildApplication();
    }

    @Override
    public List<GuildApplication> getDeclinedGuildApplication() {
        return guildApplicationRepository.getDeclinedGuildApplication();
    }

    @Override
    public List<GuildApplication> getAcceptedGuildApplication() {
        return guildApplicationRepository.getAcceptedGuildApplication();
    }

    @Override
    public GuildApplication getGuildApplication(String applicationId) {
        if (applicationId == null){
            // TODO throw an error regarding invalid applicationId
        }

        GuildApplication guildApplication = guildApplicationRepository.getGuildApplication(applicationId);

        if (guildApplication == null) {
            // TODO throw an error regarding guild application not found
        }
        return guildApplication;
    }

    // TODO make this request idempotent
    @Override
    public GuildApplication addGuildApplication(GuildApplication guildApplication) {
        // TODO checks here on the guildApplication object
        return guildApplicationRepository.addGuildApplication(guildApplication);
    }

    @Override
    public GuildApplication updateGuildApplication(GuildApplication guildApplication) {
        // TODO checks here on guildApplication object
        return guildApplicationRepository.updateGuildApplication(guildApplication);
    }

    @Override
    public void deleteGuildApplication(String applicationId) {
        if (applicationId == null) {
            // TODO throw an error regarding invalid applicationId
        }

        if (guildApplicationRepository.getGuildApplication(applicationId) == null){
            // TODO throw an error regarding guild application not found
        }

        guildApplicationRepository.deleteGuildApplication(applicationId);

    }
}
