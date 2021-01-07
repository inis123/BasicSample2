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

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.example.android.persistence.AppExecutors;
import com.example.android.persistence.db.converter.DateConverter;
import com.example.android.persistence.db.dao.AdressDao;
import com.example.android.persistence.db.dao.InteressentDao;
import com.example.android.persistence.db.dao.KundenDao;
import com.example.android.persistence.db.dao.MitarbeiterDao;
import com.example.android.persistence.db.dao.OpportiunityDao;
import com.example.android.persistence.db.dao.PersonDao;
import com.example.android.persistence.db.dao.TerminDao;
import com.example.android.persistence.db.dao.VertragDao;
import com.example.android.persistence.db.entity.AdressEntity;
import com.example.android.persistence.db.entity.AktivitaetEntity;
import com.example.android.persistence.db.entity.InteressentEntity;
import com.example.android.persistence.db.entity.KundenEntity;
import com.example.android.persistence.db.entity.MitarbeiterEntity;
import com.example.android.persistence.db.entity.OpportunityEntity;
import com.example.android.persistence.db.entity.PersonEntity;

import com.example.android.persistence.db.entity.TerminEntity;
import com.example.android.persistence.db.entity.VertragEntity;

import java.util.List;

@Database(entities = {KundenEntity.class, AdressEntity.class, AktivitaetEntity.class,
         InteressentEntity.class, MitarbeiterEntity.class, OpportunityEntity.class, PersonEntity.class, TerminEntity.class, VertragEntity.class,}, version = 2)
@TypeConverters(DateConverter.class)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase sInstance;

    @VisibleForTesting
    public static final String DATABASE_NAME = "basic-sample-db";



    public abstract KundenDao  kundenDao();



    public abstract AdressDao adressDao();

    public abstract InteressentDao interessentDao();

    public abstract MitarbeiterDao mitarbeiterDao();

    public abstract OpportiunityDao opportiunityDao();

    public abstract PersonDao personDao();

    public abstract TerminDao terminDao();

    public abstract VertragDao vertragDao();


    private final MutableLiveData<Boolean> mIsDatabaseCreated = new MutableLiveData<>();

    public static AppDatabase getInstance(final Context context, final AppExecutors executors) {
        if (sInstance == null) {
            synchronized (AppDatabase.class) {
                if (sInstance == null) {
                    sInstance = buildDatabase(context.getApplicationContext(), executors);
                    sInstance.updateDatabaseCreated(context.getApplicationContext());
                }
            }
        }
        com.example.android.persistence.ui.login.de("getinstance");
        return sInstance;
    }

    /**
     * Build the database. {@link Builder#build()} only sets up the database configuration and
     * creates a new instance of the database.
     * The SQLite database is only created when it's accessed for the first time.
     */
    private static AppDatabase buildDatabase(final Context appContext,
                                             final AppExecutors executors) {
        return Room.databaseBuilder(appContext, AppDatabase.class, DATABASE_NAME)
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        executors.diskIO().execute(() -> {
                            // Add a delay to simulate a long-running operation
                            //addDelay();
                            // Generate the data for pre-population
                            AppDatabase database = AppDatabase.getInstance(appContext, executors);

                            List<PersonEntity> person = DataGenerator.generatePerson();
                            List<MitarbeiterEntity> mitarbeiter= DataGenerator.generateMitarbeiter();
                            insertData(database, person,mitarbeiter);
                            //List<KundenEntity> kunden = DataGenerator.generateKunden();
                            //List<ProductEntity> products = DataGenerator.generateProducts();
                            //List<CommentEntity> comments =
                             //       DataGenerator.generateCommentsForProducts(products);

                           // insertData(database, products, comments,kunden);
                            // notify that the database was created and it's ready to be used
                            database.setDatabaseCreated();
                        });
                    }
                })
                .addMigrations(MIGRATION_1_2)
                .build();
    }

    /**
     * Check whether the database already exists and expose it via {@link #getDatabaseCreated()}
     */
    private void updateDatabaseCreated(final Context context) {
        if (context.getDatabasePath(DATABASE_NAME).exists()) {
            setDatabaseCreated();
        }
    }

    private void setDatabaseCreated(){
        mIsDatabaseCreated.postValue(true);
    }

    private static void insertData(final AppDatabase database, final List<PersonEntity> person,final List<MitarbeiterEntity> mitarbeiter) {
        database.runInTransaction(() -> {

            database.personDao().insertAll(person);
            database.mitarbeiterDao().insertAll(mitarbeiter);
        });
    }

   /* private static void insertData(final AppDatabase database, final List<ProductEntity> products,
                                   final List<CommentEntity> comments, final List<KundenEntity> kunden) {
        database.runInTransaction(() -> {
            database.productDao().insertAll(products);
            database.commentDao().insertAll(comments);
            database.kundenDao().insertAll(kunden);
        });
    }
*/
    private static void addDelay() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ignored) {
        }
    }

    public LiveData<Boolean> getDatabaseCreated() {
        return mIsDatabaseCreated;
    }

    private static final Migration MIGRATION_1_2 = new Migration(1, 2) {

        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {

            // database.execSQL("CREATE VIRTUAL TABLE IF NOT EXISTS `productsFts` USING FTS4("
            //    + "`name` TEXT, `description` TEXT, content=`products`)");
            // original BasicSample-code:
            //            database.execSQL("INSERT INTO productsFts (`rowid`, `name`, `description`) "
            //                + "SELECT `id`, `name`, `description` FROM products");
            database.execSQL("INSERT INTO productsFts (`rowid`, `name`, `description`) "
                    + "SELECT `id`, `name`, `description` FROM products");

        }
    };
}
