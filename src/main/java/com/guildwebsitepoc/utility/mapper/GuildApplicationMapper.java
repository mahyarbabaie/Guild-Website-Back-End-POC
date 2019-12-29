package com.guildwebsitepoc.utility.mapper;

import com.guildwebsitepoc.model.GuildApplication;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GuildApplicationMapper implements RowMapper<GuildApplication> {

    @Override
    public GuildApplication mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        GuildApplication guildApplication = new GuildApplication();
        guildApplication.setApplicationId(resultSet.getString("application_id"));
        guildApplication.setEmail(resultSet.getString("email"));
        guildApplication.setBattleTag(resultSet.getString("battle_tag"));
        guildApplication.setCharacterName(resultSet.getString("character_name"));
        guildApplication.setCharacterClass(resultSet.getString("character_class"));
        guildApplication.setCharacterSpec(resultSet.getString("character_spec"));
        guildApplication.setRealm(resultSet.getString("realm"));
        guildApplication.setRaidPreference(resultSet.getString("raid_preference"));
        guildApplication.setRaidExperience(resultSet.getString("raid_experience"));
        guildApplication.setHeroicRaidPreference(resultSet.getString("heroic_raid_preference"));
        guildApplication.setMythicRaidPreference(resultSet.getString("mythic_raid_preference"));
        guildApplication.setCasualPreference(resultSet.getString("casual_preference"));
        guildApplication.setCasualActivities(resultSet.getString("casual_activities"));
        guildApplication.setMythicPlusPreference(resultSet.getString("mythic_plus_preference"));
        guildApplication.setMythicPlusGoals(resultSet.getString("mythic_plus_goals"));
        guildApplication.setPvpPreference(resultSet.getString("pvp_preference"));
        guildApplication.setArenaPreference(resultSet.getString("arena_preference"));
        guildApplication.setBattlegroundsPreference(resultSet.getString("battlegrounds_preference"));
        guildApplication.setWorldPvpPreference(resultSet.getString("world_pvp_preference"));
        guildApplication.setPvpGoals(resultSet.getString("pvp_goals"));
        guildApplication.setAboutYourself(resultSet.getString("about_yourself"));
        guildApplication.setApplicationStatus(resultSet.getInt("application_status"));
        guildApplication.setApplicationDate(resultSet.getDate("application_date"));

        return guildApplication;
    }
}
