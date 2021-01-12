package com.example.android.persistence.connection;

import android.content.Context;

import com.example.android.persistence.db.AppDatabase;
import com.example.android.persistence.db.entity.AdressEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class locationChooser {
    public static AdressEntity choose(Context context,AdressEntity eigeneAdr){
        List<Integer> di=new ArrayList<Integer>();

        AppDatabase db=AppDatabase.getInstance(context);
        List<AdressEntity> adr=db.adressDao().getAllAdress();
        geoRadius gr=new geoRadius(context,eigeneAdr);
        AdressEntity choosen=adr.get(0);
        double tmp=Double.MAX_VALUE;
        double c;
        for(int i=0;i<adr.size();i++){
             c=gr.getNewDistance(adr.get(i));
             di.add((int)c);
             if(c<tmp) {
                 choosen = adr.get(i);
                 tmp=c;
             }

        }
        return choosen;
    }
}
