package com.example.android.persistence.viewmodel;




import android.app.Application;
import android.text.TextUtils;

import com.example.android.persistence.BasicApp;
import com.example.android.persistence.DataRepository;
import com.example.android.persistence.db.Datahold;
import com.example.android.persistence.db.dao.MitarbeiterDao_Impl;
import com.example.android.persistence.db.entity.MitarbeiterEntity;
import com.example.android.persistence.ui.login;


import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.Transformations;

public class loginViewModel extends AndroidViewModel {

    LiveData<MitarbeiterEntity> m;
    public loginViewModel(@NonNull Application application) {
        super(application);
    }
   
    public boolean checkLogin(String username,String password){
         LiveData<MitarbeiterEntity> m;

        BasicApp.getBasicApp().getRepository().getMitarbeiterByName(username,this);


        //login.de(Datahold.getInstance().getMitarbeiterByName(username).getPassword());
        //login.de("a");
           //if(Datahold.getInstance().getMitarbeiterByName(username).getPassword().equals(password))
       // if(password== BasicApp.getAkRepository().getMitarbeiterByName(username).getValue().getPassword())
            if( BasicApp.getBasicApp().getDatabase().personDao().getMitarbeiterbyName(username).getValue().getPassword().equals(password))
        return true;
           else return false;
    }
    public void re(LiveData<MitarbeiterEntity> a){
        a=m;
    }
}
