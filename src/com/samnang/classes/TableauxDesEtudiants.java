package com.samnang.classes;

import java.util.ArrayList;

public class TableauxDesEtudiants implements Sujet {

    private ArrayList<Observer> listeDesObservateurs;
    private int compteurObservateur;
    private ArrayList<Double> listeDesNotesExamen;

    public TableauxDesEtudiants() {
        this.listeDesObservateurs = new ArrayList<Observer>();
        this.compteurObservateur = -1;
        this.listeDesNotesExamen = new ArrayList<Double>();        
    }
    public ArrayList<Double> getListeDesNotesExamen() {
        return listeDesNotesExamen;
    }
    public void setListeDesNotesExamen(ArrayList<Double> listeDesNotesExamen) {
        this.listeDesNotesExamen = listeDesNotesExamen;
        notifyObservers();
    }    
    public void ajouterUneNote(double note) {
        this.listeDesNotesExamen.add( note );
        notifyObservers();
    }
    @Override
    public void registerObserver(Observer observateur) {
        this.listeDesObservateurs.add( observateur );
        this.compteurObservateur++;
    }

    @Override
    public void removeObserver(Observer observateur) {
        int i = listeDesObservateurs.indexOf( observateur );
        if(i >= 0 ) {
            this.listeDesObservateurs.remove( i );
            this.compteurObservateur--;
        }
    }

    @Override
    public void notifyObservers() {
        if( this.compteurObservateur != -1 ) {
            for(int i=0; i < listeDesObservateurs.size(); i++) {
                this.listeDesObservateurs.get(i).update( listeDesNotesExamen );
            }
        }
    }
    
}
