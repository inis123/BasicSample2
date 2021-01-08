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

    private static final String[] FIRST = new String[]{
            "Special edition", "New", "Cheap", "Quality", "Used"};
    private static final String[] SECOND = new String[]{
            "Three-headed Monkey", "Rubber Chicken", "Pint of Grog", "Monocle"};
    private static final String[] DESCRIPTION = new String[]{
            "is finally here", "is recommended by Stan S. Stanman",
            "is the best sold product on Mêlée Island", "is \uD83D\uDCAF", "is ❤️", "is fine"};
    private static final String[] COMMENTS = new String[]{
            "Comment 1", "Comment 2", "Comment 3", "Comment 4", "Comment 5", "Comment 6"};

    public static List<KundenEntity> generateKunden() {
        List<KundenEntity> kunde = new ArrayList<>(FIRST.length * SECOND.length);
        Random rnd = new Random();
        for (int i = 0; i < FIRST.length; i++) {
            for (int j = 0; j < SECOND.length; j++) {
                KundenEntity kunden = new KundenEntity();
                kunden.setName(FIRST[i] + " " + SECOND[j]);
                kunden.setNachname(kunden.getName() + " " + DESCRIPTION[j]);
                kunden.setAlter(rnd.nextInt(240));
                kunden.setKundenID(FIRST.length * i + j + 1);
                kunde.add(kunden);
            }
        }
        return kunde;
    }
    public static List<PersonEntity> generatePerson() {
        List<PersonEntity> person = new ArrayList<>(5);
                PersonEntity pe=new PersonEntity();
                pe.setAdressID(1);
                pe.setAlter(1);
                pe.setId(1);
                pe.setNachname("Huber");
                pe.setName("Franz");
                pe.setPersonID(1);
                person.add(pe);


                person.add(new PersonEntity( "User", "User", 41,2));
                person.add(new PersonEntity( "Alex", "Dushke", 23,3));
                person.add(new PersonEntity( "Markus", "Muster", 41,4));

        return person;
    }
    public static List<MitarbeiterEntity> generateMitarbeiter() {
        List<MitarbeiterEntity> mitarbeiter = new ArrayList<>(5);

        mitarbeiter.add(new MitarbeiterEntity( 1,1,"1234"));
        mitarbeiter.add(new MitarbeiterEntity( 2, 2, "lol"));
        mitarbeiter.add(new MitarbeiterEntity( 3, 3,"passwd"));
        mitarbeiter.add(new MitarbeiterEntity( 4, 4, "password"));

        return mitarbeiter;
    }
/*
    public static List<ProductEntity> generateProducts() {
        List<ProductEntity> products = new ArrayList<>(FIRST.length * SECOND.length);
        Random rnd = new Random();
        for (int i = 0; i < FIRST.length; i++) {
            for (int j = 0; j < SECOND.length; j++) {
                ProductEntity product = new ProductEntity();
                product.setName(FIRST[i] + " " + SECOND[j]);
                product.setDescription(product.getName() + " " + DESCRIPTION[j]);
                product.setPrice(rnd.nextInt(240));
                product.setId(FIRST.length * i + j + 1);
                products.add(product);
            }
        }
        return products;
    }

    public static List<CommentEntity> generateCommentsForProducts(
            final List<ProductEntity> products) {
        List<CommentEntity> comments = new ArrayList<>();
        Random rnd = new Random();

        for (Product product : products) {
            int commentsNumber = rnd.nextInt(5) + 1;
            for (int i = 0; i < commentsNumber; i++) {
                CommentEntity comment = new CommentEntity();
                comment.setProductId(product.getId());
                comment.setText(COMMENTS[i] + " for " + product.getName());
                comment.setPostedAt(new Date(System.currentTimeMillis()
                        - TimeUnit.DAYS.toMillis(commentsNumber - i) + TimeUnit.HOURS.toMillis(i)));
                comments.add(comment);
            }
        }

        return comments;
    }*/
}
