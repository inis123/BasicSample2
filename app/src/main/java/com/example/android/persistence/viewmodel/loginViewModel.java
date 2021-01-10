package com.example.android.persistence.viewmodel;




import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

//import com.example.android.persistence.BasicApp;
//import com.example.android.persistence.DataRepository;
import com.example.android.persistence.db.AppDatabase;
import com.example.android.persistence.db.Datahold;

import com.example.android.persistence.db.entity.MitarbeiterEntity;
import com.example.android.persistence.db.entity.PersonEntity;
import com.example.android.persistence.ui.login;


import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.Transformations;

import java.util.List;
// standart Usename : name+nachname+alter
public class loginViewModel extends AndroidViewModel {

    LiveData<MitarbeiterEntity> m;
    public loginViewModel(@NonNull Application application) {super(application);    }
   
    public static int checkLogin(Context context, String username, String password){ //0:keiner gefunden 1:kein Zutritt 2:pw stimmt 3:pw falsch
        List<MitarbeiterEntity> me= AppDatabase.getInstance(context).personDao().getMitarbeiterbyName(username);
        List<PersonEntity> pe= AppDatabase.getInstance(context).personDao().getByName(username);
        if(pe.isEmpty())
            return 0;
        else{
            if(me.isEmpty())
                return 1;
            else
                if(me.get(0).getPassword().equals(password))
                    return 2;
                else return 3;
        }

    }

}
