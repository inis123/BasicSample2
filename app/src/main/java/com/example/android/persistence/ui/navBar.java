package com.example.android.persistence.ui;
//Heger Stefan
// Methode zum einbinden des navbar unabhängig der aktivity :
//navBar.initNavBar(getApplicationContext(),this);
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;


import com.example.android.persistence.R;




public class navBar {
    public static void initNavBar(Context c,AppCompatActivity a){


        ImageButton home = (ImageButton) a.findViewById(R.id.homeButton);
        home.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                a.startActivity(new Intent(c, home.class));
            }
        });

        ImageButton kontakte = (ImageButton) a.findViewById(R.id.kontakteButton);
        kontakte.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                a.startActivity(new Intent(c, kontakte.class));
            }
        });

        ImageButton maps = (ImageButton) a.findViewById(R.id.mapsButton);
        maps.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                a.startActivity(new Intent(c, home.class));
            }
        });

        ImageButton search = (ImageButton) a.findViewById(R.id.searchButton);
        search.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                a.startActivity(new Intent(c, home.class));
            }
        });

        ImageButton settings = (ImageButton) a.findViewById(R.id.menuButton);
        settings.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                a.startActivity(new Intent(c, home.class));
            }
        });

    }
}
