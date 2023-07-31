package org.springers.waa_alumniplatform.enums;

public enum NewUserAccountType {
    ALUMNI("t1"),
    FACULTY("t2");
    private String type;

   private NewUserAccountType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
