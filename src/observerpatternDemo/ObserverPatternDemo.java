package observerpatternDemo;

import com.samnang.classes.Moyenne;
import com.samnang.classes.TableauxDesEtudiants;
import java.text.DecimalFormat;

public class ObserverPatternDemo {

    public static void main(String[] args) {
        TableauxDesEtudiants unTableau = new TableauxDesEtudiants();
        Moyenne uneMoyenne = new Moyenne( unTableau );
        unTableau.ajouterUneNote(100);
        unTableau.ajouterUneNote(91.20);
        unTableau.ajouterUneNote(83.49);
        unTableau.ajouterUneNote(74.80);        
        DecimalFormat df = new DecimalFormat("##.##");
        System.out.println( "La moyenne du groupe est " + df.format( uneMoyenne.getMoyenne() ) + " %" );
        unTableau.ajouterUneNote(65.87);
        unTableau.ajouterUneNote(54.09);
        unTableau.ajouterUneNote(43.65);
        unTableau.ajouterUneNote(32.45);        
        System.out.println( "La moyenne du groupe est maintenant " + df.format( uneMoyenne.getMoyenne() ) + " %" );
        /*for(int i=0; i < uneMoyenne.getListeDesNotes().size(); i++) {
            System.out.print( uneMoyenne.getListeDesNotes().get(i) );
        }*/
        uneMoyenne.unsubscribe();
        System.out.println("La moyenne n'est plus un observateur...");
        unTableau.ajouterUneNote(99);
        unTableau.ajouterUneNote(98);
        unTableau.ajouterUneNote(97);
        unTableau.ajouterUneNote(96);        
        System.out.println( "La moyenne du groupe est toujours " + df.format( uneMoyenne.getMoyenne() ) + " %" );
        /*for(int i=0; i < uneMoyenne.getListeDesNotes().size(); i++) {
            System.out.print( uneMoyenne.getListeDesNotes().get(i) );
        }*/
    }
    
}
