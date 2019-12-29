package com.guildwebsitepoc.model;

import com.guildwebsitepoc.utility.GuildApplicationConstants;

public class GuildApplication {

    private String applicationId;

    private String email;

    private String battleTag;

    private String characterName;

    private String characterClass;

    private String spec;

    private String realm;

    private String raidPreference;

    private String heroicRaidPreference;

    private String mythicRaidPreference;

    private String casualPreference;

    private String casualActivities;

    private String mythicPlusPreference;

    private String mythicPlusGoals;

    private String pvpPreference;

    private String arenaPreference;

    private String battlegroundsPreference;

    private String worldPvpPreference;

    private String pvpGoals;

    private String aboutYourself;

    private Integer applicationStatus;

    private String applicationDate;

    public GuildApplication() {}

    public GuildApplication(String applicationId,
                            String email,
                            String battleTag,
                            String characterName,
                            String characterClass,
                            String spec,
                            String realm,
                            String raidPreference,
                            String heroicRaidPreference,
                            String mythicRaidPreference,
                            String casualPreference,
                            String casualActivities,
                            String mythicPlusPreference,
                            String mythicPlusGoals,
                            String pvpPreference,
                            String arenaPreference,
                            String battlegroundsPreference,
                            String worldPvpPreference,
                            String pvpGoals,
                            String aboutYourself,
                            GuildApplicationConstants.ApplicationStatus applicationStatus,
                            String applicationDate) {
        this.applicationId = applicationId;
        this.email = email;
        this.battleTag = battleTag;
        this.characterName = characterName;
        this.characterClass = characterClass;
        this.spec = spec;
        this.realm = realm;
        this.raidPreference = raidPreference;
        this.heroicRaidPreference = heroicRaidPreference;
        this.mythicRaidPreference = mythicRaidPreference;
        this.casualPreference = casualPreference;
        this.casualActivities = casualActivities;
        this.mythicPlusPreference = mythicPlusPreference;
        this.mythicPlusGoals = mythicPlusGoals;
        this.pvpPreference = pvpPreference;
        this.arenaPreference = arenaPreference;
        this.battlegroundsPreference = battlegroundsPreference;
        this.worldPvpPreference = worldPvpPreference;
        this.pvpGoals = pvpGoals;
        this.aboutYourself = aboutYourself;
        this.applicationStatus = applicationStatus.getValue();
        this.applicationDate = applicationDate;
    }


    public String getApplicationId() { return applicationId; }

    public void setApplicationId(String applicationId) { this.applicationId = applicationId; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getBattleTag() { return battleTag; }

    public void setBattleTag(String battleTag) { this.battleTag = battleTag; }

    public String getCharacterName() { return characterName; }

    public void setCharacterName(String characterName) { this.characterName = characterName; }

    public String getCharacterClass() { return characterClass; }

    public void setCharacterClass(String characterClass) { this.characterClass = characterClass; }

    public String getSpec() { return spec; }

    public void setSpec(String spec) { this.spec = spec; }

    public String getRealm() { return realm; }

    public void setRealm(String realm) { this.realm = realm; }

    public String getRaidPreference() { return raidPreference; }

    public void setRaidPreference(String raidPreference) { this.raidPreference = raidPreference; }

    public String getHeroicRaidPreference() { return heroicRaidPreference; }

    public void setHeroicRaidPreference(String heroicRaidPreference) { this.heroicRaidPreference = heroicRaidPreference; }

    public String getMythicRaidPreference() { return mythicRaidPreference; }

    public void setMythicRaidPreference(String mythicRaidPreference) { this.mythicRaidPreference = mythicRaidPreference; }

    public String getCasualPreference() { return casualPreference; }

    public void setCasualPreference(String casualPreference) { this.casualPreference = casualPreference; }

    public String getCasualActivities() { return casualActivities; }

    public void setCasualActivities(String casualActivities) { this.casualActivities = casualActivities; }

    public String getMythicPlusPreference() { return mythicPlusPreference; }

    public void setMythicPlusPreference(String mythicPlusPreference) { this.mythicPlusPreference = mythicPlusPreference; }

    public String getMythicPlusGoals() { return mythicPlusGoals; }

    public void setMythicPlusGoals(String mythicPlusGoals) { this.mythicPlusGoals = mythicPlusGoals; }

    public String getPvpPreference() { return pvpPreference; }

    public void setPvpPreference(String pvpPreference) { this.pvpPreference = pvpPreference; }

    public String getArenaPreference() { return arenaPreference; }

    public void setArenaPreference(String arenaPreference) { this.arenaPreference = arenaPreference; }

    public String getBattlegroundsPreference() { return battlegroundsPreference; }

    public void setBattlegroundsPreference(String battlegroundsPreference) { this.battlegroundsPreference = battlegroundsPreference; }

    public String getWorldPvpPreference() { return worldPvpPreference; }

    public void setWorldPvpPreference(String worldPvpPreference) { this.worldPvpPreference = worldPvpPreference; }

    public String getPvpGoals() { return pvpGoals; }

    public void setPvpGoals(String pvpGoals) { this.pvpGoals = pvpGoals; }

    public String getAboutYourself() { return aboutYourself; }

    public void setAboutYourself(String aboutYourself) { this.aboutYourself = aboutYourself; }

    public Integer getApplicationStatus() { return applicationStatus; }

    public void setApplicationStatus(GuildApplicationConstants.ApplicationStatus applicationStatus) { this.applicationStatus = applicationStatus.getValue(); }

    public String getApplicationDate() { return applicationDate; }

    public void setApplicationDate(String applicationDate) { this.applicationDate = applicationDate; }

    @Override
    public String toString() {
        return "GuildApplication{" +
                "applicationId='" + applicationId + '\'' +
                ", email='" + email + '\'' +
                ", battleTag='" + battleTag + '\'' +
                ", characterName='" + characterName + '\'' +
                ", characterClass='" + characterClass + '\'' +
                ", spec='" + spec + '\'' +
                ", realm='" + realm + '\'' +
                ", raidPreference='" + raidPreference + '\'' +
                ", heroicRaidPreference='" + heroicRaidPreference + '\'' +
                ", mythicRaidPreference='" + mythicRaidPreference + '\'' +
                ", casualPreference='" + casualPreference + '\'' +
                ", casualActivities='" + casualActivities + '\'' +
                ", mythicPlusPreference='" + mythicPlusPreference + '\'' +
                ", mythicPlusGoals='" + mythicPlusGoals + '\'' +
                ", pvpPreference='" + pvpPreference + '\'' +
                ", arenaPreference='" + arenaPreference + '\'' +
                ", battlegroundsPreference='" + battlegroundsPreference + '\'' +
                ", worldPvpPreference='" + worldPvpPreference + '\'' +
                ", pvpGoals='" + pvpGoals + '\'' +
                ", aboutYourself='" + aboutYourself + '\'' +
                ", applicationStatus=" + applicationStatus +
                ", applicationDate='" + applicationDate + '\'' +
                '}';
    }
}
