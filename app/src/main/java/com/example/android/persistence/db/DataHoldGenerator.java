package com.example.android.persistence.db;

import com.example.android.persistence.db.entity.MitarbeiterEntity;
import com.example.android.persistence.db.entity.PersonEntity;

public class DataHoldGenerator {
    public static void genDummyData(){
        Datahold dh=Datahold.getInstance();
        dh.add(new PersonEntity( 1,"Franz", "Baum", 41,1));
        dh.add(new PersonEntity( 2,"User", "User", 41,2));
        dh.add(new PersonEntity( 3,"Alex", "Dushke", 23,3));
        dh.add(new PersonEntity( 4,"Markus", "Muster", 41,4));

        dh.add(new MitarbeiterEntity( 1,1,"1234"));
        dh.add(new MitarbeiterEntity( 2, 2, "lol"));
        dh.add(new MitarbeiterEntity( 3, 3,"passwd"));
        dh.add(new MitarbeiterEntity( 4, 4, "password"));



    }
}
