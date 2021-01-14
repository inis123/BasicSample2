package com.example.android.persistence.connection;

import android.content.Context;

import com.example.android.persistence.db.AppDatabase;
import com.example.android.persistence.db.entity.AdressEntity;

import java.util.ArrayList;
import java.util.List;


public class locationChooser {

    public static AdressEntity choose(Context context, AdressEntity eigeneAdr) {
        List<Integer> di = new ArrayList<Integer>();

        AppDatabase db = AppDatabase.getInstance(context);

        List<AdressEntity> adr = db.adressDao().getAllAdress();

        geoRadius gr = new geoRadius(context, eigeneAdr);

        AdressEntity ch = adr.get(0);

        double tmp = Double.MAX_VALUE;
        double c;

        for (int i = 0; i < adr.size(); i++) {
            c = gr.getNewDistance(adr.get(i));
            di.add((int) c);
            if (c < tmp) {
                ch = adr.get(i);
                tmp = c;
            }

        }

        return ch;


    }
}
