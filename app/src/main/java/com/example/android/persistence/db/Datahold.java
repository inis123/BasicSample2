package com.example.android.persistence.db;

import com.example.android.persistence.db.entity.*;
import com.example.android.persistence.ui.login;

import java.util.ArrayList;
import java.util.List;

public class Datahold {
    public static Datahold iDatahold;
    private AppDatabase db;


    private Datahold(){

    }
    public static Datahold getInstance(){
        if(iDatahold==null){
            iDatahold=new Datahold();
        }
        return iDatahold;
    }


}
