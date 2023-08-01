package org.springers.waa_alumniplatform.enums;

public enum EducationalLevel {
    BSC("bsc"),
    BA("ba"),
    MSC("ma"),
    MBA("mba"),
    MA("ma"),
    PHD("phd");
    private String eduLevel;

    EducationalLevel(String eduLevel) {
        this.eduLevel = eduLevel;
    }

    public String getEduLevel() {
        return eduLevel;
    }
}
