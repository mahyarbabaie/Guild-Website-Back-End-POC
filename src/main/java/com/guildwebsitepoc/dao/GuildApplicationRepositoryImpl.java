package com.guildwebsitepoc.dao;

import com.guildwebsitepoc.model.GuildApplication;
import com.guildwebsitepoc.utility.GuildApplicationConstants;
import com.guildwebsitepoc.utility.mapper.GuildApplicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class GuildApplicationRepositoryImpl implements GuildApplicationRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // This variable references the accounts table in the database
    private static final String guildApplicationTable = "guild_website_poc_app.guild_application";

    @Override
    public List<GuildApplication> getPendingGuildApplication() {
        try {
            String sql = "SELECT * FROM " + guildApplicationTable + " WHERE application_status = ?";
            List<GuildApplication> pendingGuildApplicationList = jdbcTemplate.query(
                    sql,
                    new Object[]{GuildApplicationConstants.ApplicationStatus.PENDING.getValue()},
                    new GuildApplicationMapper());
            return pendingGuildApplicationList;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<GuildApplication> getDeclinedGuildApplication() {
        return null;
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
    public void deleteGuildApplication(String applicationId) {

    }
}
