package com.guildwebsitepoc.dao;

import com.guildwebsitepoc.model.GuildApplication;

import java.util.List;

public interface GuildApplicationRepository {

    // Return all PENDING applications
    List<GuildApplication> getPendingGuildApplication();

    // Return all DECLINED applications
    List<GuildApplication> getDeclinedGuildApplication();

    // Return all ACCEPTED applications
    List<GuildApplication> getAcceptedGuildApplication();

    // Return a specific Guild Application
    GuildApplication getGuildApplication(String applicationId);

    // This method creates a guild application and returns a guild application
    // It will be idempotent where it will return the guild application if the UUID exists
    GuildApplication addGuildApplication(GuildApplication guildApplication);

    // Deletes the guild application
    void deleteGuildApplication(String applicationId);
}
