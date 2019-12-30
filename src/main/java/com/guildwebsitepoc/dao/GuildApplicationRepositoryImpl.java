package com.guildwebsitepoc.dao;

import com.guildwebsitepoc.model.Account;
import com.guildwebsitepoc.model.GuildApplication;
import com.guildwebsitepoc.utility.GuildApplicationConstants;
import com.guildwebsitepoc.utility.mapper.AccountMapper;
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
            return jdbcTemplate.query(
                    sql,
                    new Object[]{GuildApplicationConstants.ApplicationStatus.PENDING.getValue()},
                    new GuildApplicationMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<GuildApplication> getDeclinedGuildApplication() {
        try {
            String sql = "SELECT * FROM " + guildApplicationTable + " WHERE application_status = ?";
            return jdbcTemplate.query(
                    sql,
                    new Object[]{GuildApplicationConstants.ApplicationStatus.DECLINED.getValue()},
                    new GuildApplicationMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<GuildApplication> getAcceptedGuildApplication() {
        try {
            String sql = "SELECT * FROM " + guildApplicationTable + " WHERE application_status = ?";
            return jdbcTemplate.query(
                    sql,
                    new Object[]{GuildApplicationConstants.ApplicationStatus.ACCEPTED.getValue()},
                    new GuildApplicationMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public GuildApplication getGuildApplication(String applicationId) {
        try {
            String sql = "SELECT * FROM " + guildApplicationTable + " WHERE application_id = ?";
            return jdbcTemplate.queryForObject(sql, new Object[]{applicationId}, new GuildApplicationMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    // TODO make this idempotent
    @Override
    public GuildApplication addGuildApplication(GuildApplication guildApplication) {
        String sql = "INSERT INTO " +
                guildApplicationTable +
                " (" +
                "application_id," +
                "email," +
                "battle_tag," +
                "character_name," +
                "character_class," +
                "character_spec," +
                "realm," +
                "raid_preference," +
                "raid_experience," +
                "heroic_raid_preference," +
                "mythic_raid_preference," +
                "casual_preference," +
                "casual_activities," +
                "mythic_plus_preference," +
                "mythic_plus_goals," +
                "pvp_preference," +
                "arena_preference," +
                "battlegrounds_preference," +
                "world_pvp_preference," +
                "pvp_goals," +
                "about_yourself," +
                "application_status," +
                "application_date" +
                ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        jdbcTemplate.update(
                sql,
                guildApplication.getApplicationId(),
                guildApplication.getEmail(),
                guildApplication.getBattleTag(),
                guildApplication.getCharacterName(),
                guildApplication.getCharacterClass(),
                guildApplication.getCharacterSpec(),
                guildApplication.getRealm(),
                guildApplication.getRaidPreference(),
                guildApplication.getRaidExperience(),
                guildApplication.getHeroicRaidPreference(),
                guildApplication.getMythicRaidPreference(),
                guildApplication.getCasualPreference(),
                guildApplication.getCasualActivities(),
                guildApplication.getMythicPlusPreference(),
                guildApplication.getMythicPlusGoals(),
                guildApplication.getPvpPreference(),
                guildApplication.getArenaPreference(),
                guildApplication.getBattlegroundsPreference(),
                guildApplication.getWorldPvpPreference(),
                guildApplication.getPvpGoals(),
                guildApplication.getAboutYourself(),
                guildApplication.getApplicationStatus(),
                guildApplication.getApplicationDate());

        return guildApplication;
    }

    @Override
    public void deleteGuildApplication(String applicationId) {
        String sql = "DELETE FROM " + guildApplicationTable + " WHERE application_id=?";
        jdbcTemplate.update(sql, applicationId);
    }
}
