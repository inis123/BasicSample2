

package com.example.android.persistence.db;


import com.example.android.persistence.db.entity.AdressEntity;
import com.example.android.persistence.db.entity.InteressentEntity;
import com.example.android.persistence.db.entity.MitarbeiterEntity;
import com.example.android.persistence.db.entity.PersonEntity;

import java.util.ArrayList;
import java.util.List;


public abstract class DataGenerator {


    public static List<PersonEntity> genPerson() {

        List<PersonEntity> person = new ArrayList<>(4);

        person.add(new PersonEntity(1, "Franz", "User", 41, 1));
        person.add(new PersonEntity(2, "User", "User", 41, 2));
        person.add(new PersonEntity(3, "Alex", "Dushke", 23, 3));
        person.add(new PersonEntity(4, "Markus", "Muster", 41, 4));

        person.add(new PersonEntity(5, "Alexander", "Olafson", 41, 5));
        person.add(new PersonEntity(6, "Mari", "Mainberg", 41, 6));
        person.add(new PersonEntity(7, "Herman", "Pablo", 23, 7));
        person.add(new PersonEntity(8, "Markus", "Muster", 41, 8));

        return person;
    }

    public static List<MitarbeiterEntity> genMitarbeiter() {

        List<MitarbeiterEntity> mitarbeiter = new ArrayList<>(4);

        mitarbeiter.add(new MitarbeiterEntity(1, 1, "1234"));
        mitarbeiter.add(new MitarbeiterEntity(2, 2, "lol"));
        mitarbeiter.add(new MitarbeiterEntity(3, 3, "passwd"));
        mitarbeiter.add(new MitarbeiterEntity(4, 4, "password"));

        return mitarbeiter;
    }

    public static List<InteressentEntity> genInteressent() {

        List<InteressentEntity> interssent = new ArrayList<>(4);

        interssent.add(new InteressentEntity("mag Kekese", "Bereichsleiter", 5));
        interssent.add(new InteressentEntity("hasst Schokolade", "Disponent", 6));
        interssent.add(new InteressentEntity("klaut gern Kugelschreiber", "Mitarbeiter Einkauf", 7));
        interssent.add(new InteressentEntity("ist ein ...", "CEO", 8));

        return interssent;
    }

    public static List<AdressEntity> genAdress() {

        List<AdressEntity> adr = new ArrayList<>(4);

        adr.add(new AdressEntity(1, "Ebershausen", "Bahnhofstr", "3b", "de", "12344", "01234445678", "909248374"));
        adr.add(new AdressEntity(2, "Krumbach", "Bahnhofstr", "34b", "de", "57635", "01234445678", "909248374"));
        adr.add(new AdressEntity(3, "Kempten", "Bahnhofstr", "3", "de", "57634", "345766345756", "909248374"));
        adr.add(new AdressEntity(4, "Memmingen", "Bahnhofstr", "6", "de", "45634", "01234445678", "909248374"));

        adr.add(new AdressEntity(5, "Ulm", "Bahnhofstr", "567", "de", "3457678", "01234445678", "909248374"));
        adr.add(new AdressEntity(6, "Hausen", "Bahnhofstr", "6", "de", "54645", "01234445678", "909248374"));
        adr.add(new AdressEntity(7, "Ronsberg", "Bahnhofstr", "56", "de", "465324", "01234445678", "909248374"));
        adr.add(new AdressEntity(8, "Ebershausen", "Bahnhofstr", "7", "de", "8765", "01234445678", "909248374"));

        return adr;
    }

}
