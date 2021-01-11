package com.example.android.persistence.viewmodel;
//Heger Stefan
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.persistence.R;
import com.example.android.persistence.db.entity.AdressEntity;
import com.example.android.persistence.db.entity.InteressentEntity;
import com.example.android.persistence.db.entity.PersonEntity;

import java.util.List;

public class kontakteListAdapter extends RecyclerView.Adapter<kontakteListAdapter.MyViewHolder> {

    private Context context;
    private List<PersonEntity> personList;
    private List<AdressEntity> adressList;
    private List<InteressentEntity> interessentList;

    public kontakteListAdapter(Context context){
        this.context=context;
    }

    public void setPersonList(List<PersonEntity> personList){
        this.personList=personList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public kontakteListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.kontakte_recyclerrow,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull kontakteListAdapter.MyViewHolder holder, int position) {
        holder.name.setText(this.personList.get(position).getName());
        holder.nachname.setText(this.personList.get(position).getNachname());
    }

    @Override
    public int getItemCount() {
       return this.personList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView nachname;
        public MyViewHolder(View view){
            super(view);
            name=view.findViewById(R.id.rowtextviewkontaktename);
            nachname=view.findViewById(R.id.rowtextViewkontaktenachnamen);

        }
    }
    public interface OnPersonListener{
        void onPersonClick(int position);
    }
}
