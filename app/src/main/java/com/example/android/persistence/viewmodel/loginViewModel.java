package com.example.android.persistence.viewmodel;


import android.app.Application;
import android.content.Context;


import com.example.android.persistence.db.AppDatabase;


import com.example.android.persistence.db.entity.MitarbeiterEntity;
import com.example.android.persistence.db.entity.PersonEntity;


import androidx.annotation.NonNull;

import androidx.lifecycle.AndroidViewModel;


import java.util.List;

// standart Usename : name+nachname+alter
public class loginViewModel extends AndroidViewModel {


    public loginViewModel(@NonNull Application application) {
        super(application);
    }

    public static int checkLogin(Context context, String username, String password) { //0:keiner gefunden 1:kein Zutritt 2:pw stimmt 3:pw falsch

        List<MitarbeiterEntity> me = AppDatabase.getInstance(context).personDao().getMitarbeiterbyName(username);
        List<PersonEntity> pe = AppDatabase.getInstance(context).personDao().getByName(username);

        if (pe.isEmpty())
            return 0;

        else {
            if (me.isEmpty())
                return 1;

            else if (me.get(0).getPassword().equals(password))
                return 2;

            else return 3;
        }

    }

}
