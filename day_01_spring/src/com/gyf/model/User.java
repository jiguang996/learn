package com.gyf.model;

import java.util.*;

public class User<pri> {
    private  String name;


    private Set<String> cars;
    private Map<String,String> pc;
    private Properties properties;
    private String[] member;

    public Map<String, String> getPc() {
        return pc;
    }

    public void setPc(Map<String, String> pc) {
        this.pc = pc;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String[] getMember() {
        return member;
    }

    public void setMember(String[] member) {
        this.member = member;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getCars() {
        return cars;
    }

    public void setCars(Set<String> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", cars=" + cars +
                ", pc=" + pc +
                ", properties=" + properties +
                ", member=" + Arrays.toString(member) +
                '}';
    }
}
