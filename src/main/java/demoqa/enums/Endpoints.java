package demoqa.enums;

import io.cucumber.java.uz.Бирок;
import lombok.Getter;

public enum Endpoints {
//    ALERT("/alert"),
    CHECKBOX("/checkbox"),
    PRACTICEFORM("/automation-practice-form"),
    TEXTBOX("/text-box"),
    WEBTABLE("/webtables"),
    PROGRESSBAR("/progress-bar");




    @Getter

    String endpoint;


    Endpoints(String endpoint){
        this.endpoint = endpoint;
    }

}
