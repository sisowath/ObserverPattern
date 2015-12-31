package com.samnang.classes;

import java.util.ArrayList;

public class Moyenne implements Observer {

    private Sujet monSujet;
    private ArrayList<Double> listeDesNotes;
    
    public Moyenne(Sujet sujet) {
        subscribe(sujet);
        this.listeDesNotes = new ArrayList<>();
    }
    public ArrayList<Double> getListeDesNotes() {
        return this.listeDesNotes;
    }
    public double getMoyenne() {
        double somme = 0;
        int taille = this.listeDesNotes.size();
        for(int i=0; i < taille; i++) {
            somme += this.listeDesNotes.get(i);
        }
        return somme/taille;
    }
    @Override
    public void update(ArrayList<Double> listeDesNotesExamen) {
        /*
        `   this.listeDesNotes = listeDesNotesExamen;
        
            L'instruction ci-haut ne fonctionne pas puisqu'il fait une copie par référence. Or,
            lorsque cet observateur ne suit plus le sujet, il ne faut pas que sa « listeDesNotes » est
            un pointeur vers la « listeDesNotesExamens » du sujet...
        */
        ArrayList<Double> temp = new ArrayList<>();
        for(int i=0; i < listeDesNotesExamen.size(); i++) {
            temp.add( listeDesNotesExamen.get(i) );
        }
        this.listeDesNotes = temp;
    }

    @Override
    public void subscribe(Sujet sujet) {
        this.monSujet = sujet;
        this.monSujet.registerObserver( this );
    }

    @Override
    public void unsubscribe() {
        this.monSujet.removeObserver( this );
    }
    
}