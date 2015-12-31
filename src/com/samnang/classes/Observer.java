package com.samnang.classes;

import java.util.ArrayList;

public interface Observer {
    public void update(ArrayList<Double> listeDesNotesExamen);
    public void subscribe(Sujet sujet);
    public void unsubscribe();
}
