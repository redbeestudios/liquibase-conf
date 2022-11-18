package com.redbeeconf.mongoliquibase.persistence;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Team {

    private String name;
    private String lastName;
    private String team;
    private Integer number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
