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
        List<GuildApplication> pendingGuildApplicationList = guildApplicationRepository.getPendingGuildApplication();

        return pendingGuildApplicationList;
    }

    @Override
    public List<GuildApplication> getDeclinedGuildApplication() {
        List<GuildApplication> declinedGuildApplicationList = guildApplicationRepository.getDeclinedGuildApplication();

        return declinedGuildApplicationList;
    }

    @Override
    public List<GuildApplication> getAcceptedGuildApplication() {
        return null;
    }

    @Override
    public GuildApplication getGuildApplication(String applicationId) {
        return null;
    }

    @Override
    public GuildApplication addGuildApplication(GuildApplication guildApplication) {
        return null;
    }

    @Override
    public GuildApplication updateGuildApplication(GuildApplication guildApplication) {
        return null;
    }

    @Override
    public void deleteGuildApplication(String applicationId) {

    }
}
