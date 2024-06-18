package demoqa.enums;

import lombok.Getter;

public enum Orange {
    ADMIN("admin/viewSystemUsers"),
    USERMANAGEMENT("User Management"),
    JOB("Job"),
    ORGANIZATION("Organization"),
    NATIONALITIES("Nationalities"),
    CORPORATEBRANDING("Corporate Branding"),
    CONFIGURATION("Configuration");




    @Getter
    String orange;

    Orange(String orange){
        this.orange = orange;
    }
}
