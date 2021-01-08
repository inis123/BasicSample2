package com.example.android.persistence.db;

import com.example.android.persistence.db.entity.*;
import com.example.android.persistence.ui.login;

import java.util.ArrayList;
import java.util.List;

public class Datahold {
    public static Datahold iDatahold;


    public static Datahold getInstance(){
        if(iDatahold==null){
            iDatahold=new Datahold();
            DataHoldGenerator.genDummyData();
        }
        return iDatahold;
    }

    private List<PersonEntity> person=new ArrayList<PersonEntity>();
    private List<AdressEntity> adresse=new ArrayList<AdressEntity>();
    private List<AktivitaetEntity> aktivitaet=new ArrayList<AktivitaetEntity>();
    private List<FavoritenEntity> favoriten=new ArrayList<FavoritenEntity>();
    private List<InteressentEntity> interesent=new ArrayList<InteressentEntity>();
    private List<KundenEntity> kunde=new ArrayList<KundenEntity>();
    private List<MitarbeiterEntity> mitarbeiter=new ArrayList<MitarbeiterEntity>();
    private List<OpportunityEntity> opportunity=new ArrayList<OpportunityEntity>();
    private List<TerminEntity> termin=new ArrayList<TerminEntity>();
    private List<VertragEntity> vertrag=new ArrayList<VertragEntity>();



    public MitarbeiterEntity getMitarbeiterByName(String name){
        login.de(name);
        for (PersonEntity pe:person) {
            if(pe.getName().equals(name))
                for (MitarbeiterEntity me:mitarbeiter ) {
                    if(pe.getPersonID()==me.getPersonId())
                        return me;
                }


        }
        return null;
    }







    public void add(PersonEntity entity){
        person.add(entity);
    }
    public void add(AdressEntity entity){
        adresse.add(entity);
    }
    public void add(AktivitaetEntity entity){
        aktivitaet.add(entity);
    }
    public void add(FavoritenEntity entity){
        favoriten.add(entity);
    }
    public void add(InteressentEntity entity){
        interesent.add(entity);
    }
    public void add(KundenEntity entity){
        kunde.add(entity);
    }
    public void add(MitarbeiterEntity entity){
        mitarbeiter.add(entity);
    }
    public void add(OpportunityEntity entity){
        opportunity.add(entity);
    }
    public void add(TerminEntity entity){
        termin.add(entity);
    }
    public void add(VertragEntity entity){
        vertrag.add(entity);
    }



    public List<PersonEntity> getPerson() {
        return person;
    }

    public List<AdressEntity> getAdresse() {
        return adresse;
    }

    public List<AktivitaetEntity> getAktivitaet() {
        return aktivitaet;
    }

    public List<FavoritenEntity> getFavoriten() {
        return favoriten;
    }

    public List<InteressentEntity> getInteresent() {
        return interesent;
    }

    public List<KundenEntity> getKunde() {
        return kunde;
    }

    public List<MitarbeiterEntity> getMitarbeiter() {
        return mitarbeiter;
    }

    public List<OpportunityEntity> getOpportunity() {
        return opportunity;
    }

    public List<TerminEntity> getTermin() {
        return termin;
    }

    public List<VertragEntity> getVertrag() {
        return vertrag;
    }


    public PersonEntity getPerson(int i) {
        return person.get(i);
    }

    public AdressEntity getAdresse(int i) {
        return adresse.get(i);
    }

    public AktivitaetEntity getAktivitaet(int i) {
        return aktivitaet.get(i);
    }

    public FavoritenEntity getFavoriten(int i) {
        return favoriten.get(i);
    }

    public InteressentEntity getInteresent(int i) {
        return interesent.get(i);
    }

    public KundenEntity getKunde(int i) {
        return kunde.get(i);
    }

    public MitarbeiterEntity getMitarbeiter(int i) {
        return mitarbeiter.get(i);
    }

    public OpportunityEntity getOpportunity(int i) {
        return opportunity.get(i);
    }

    public TerminEntity getTermin(int i) {
        return termin.get(i);
    }

    public VertragEntity getVertrag(int i) {
        return vertrag.get(i);
    }
}
