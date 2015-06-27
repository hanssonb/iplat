package com.hanssonb.iplat.config;

public class Config {
    private String name;
    private String version;

    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Config [version=%s,  name=%s]", version, name);
    }
}
