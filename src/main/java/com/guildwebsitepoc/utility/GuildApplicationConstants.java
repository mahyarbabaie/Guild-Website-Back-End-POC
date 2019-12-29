package com.guildwebsitepoc.utility;

public class GuildApplicationConstants {

    public enum ApplicationStatus {
        PENDING(1),
        ACCEPTED(2),
        DECLINED(3);

        private final int id;

        ApplicationStatus(int id) { this.id = id; }

        public int getValue() { return id;}
    }

}
