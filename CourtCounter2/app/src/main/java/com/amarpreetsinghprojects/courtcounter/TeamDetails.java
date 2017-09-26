package com.amarpreetsinghprojects.courtcounter;

import java.io.Serializable;

/**
 * Created by kulvi on 06/25/17.
 */

public class TeamDetails implements Serializable {

    String TeamName, TeamColor;

    public TeamDetails(String teamName, String teamColor) {
        TeamName = teamName;
        TeamColor = teamColor;
    }

    public String getTeamName() {
        return TeamName;
    }

    public String getTeamColor() {
        return TeamColor;
    }

    public void setTeamName(String teamName) {
        TeamName = teamName;
    }

    public void setTeamColor(String teamColor) {
        TeamColor = teamColor;
    }
}
