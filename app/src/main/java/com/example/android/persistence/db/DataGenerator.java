/*
 * Copyright 2017, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.persistence.db;

import com.example.android.persistence.db.entity.KundenEntity;
import com.example.android.persistence.db.entity.MitarbeiterEntity;
import com.example.android.persistence.db.entity.PersonEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Generates data to pre-populate the database
 */
public class DataGenerator {



    public static List<PersonEntity> genPerson() {
        List<PersonEntity> person = new ArrayList<>(4);


                person.add(new PersonEntity( 1,"Franz", "User", 41,1));
                person.add(new PersonEntity( 2,"User", "User", 41,2));
                person.add(new PersonEntity( 3,"Alex", "Dushke", 23,3));
                person.add(new PersonEntity( 4,"Markus", "Muster", 41,4));

        return person;
    }
    public static List<MitarbeiterEntity> genMitarbeiter() {
        List<MitarbeiterEntity> mitarbeiter = new ArrayList<>(4);

        mitarbeiter.add(new MitarbeiterEntity( 1,1,"1234"));
        mitarbeiter.add(new MitarbeiterEntity( 2, 2, "lol"));
        mitarbeiter.add(new MitarbeiterEntity( 3, 3,"passwd"));
        mitarbeiter.add(new MitarbeiterEntity( 4, 4, "password"));

        return mitarbeiter;
    }

}
