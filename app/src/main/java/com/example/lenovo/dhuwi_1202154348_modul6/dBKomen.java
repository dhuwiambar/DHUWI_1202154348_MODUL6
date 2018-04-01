package com.example.lenovo.dhuwi_1202154348_modul6;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by LENOVO on 01/04/2018.
 */
@IgnoreExtraProperties
public class dBKomen {
    String sikomen, komen, fotokomen;

    public dBKomen(){

    }
    public dBKomen (String sikomen, String komen, String fotokomen){
        this.sikomen = sikomen;
        this.komen = komen;
        this.fotokomen = fotokomen;
    }

    public String getSikomen() {
        return sikomen;
    }

    public String getKomen() {
        return komen;
    }

    public String getFotokomen() {
        return fotokomen;
    }
}

