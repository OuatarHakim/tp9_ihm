package edu.mermet.tp8.Bdialogue;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class DialogCommentFaire extends JDialog {
    Border blackline = BorderFactory.createLineBorder(Color.black);
    JPanel droite;
    JPanel gauche;
    JEditorPane text;
    JList liste;

    public DialogCommentFaire(JFrame parent) {
        super(parent, "Comment faire");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        init();
        setVisible(true);
    }

    public void init() {



        text = new JEditorPane();
        String[] choix = {"comment faire ?", "conversion Celsius", "conversion Farenhei", " gras ", "changer la couleur", "Quitter"};
        liste = new JList(choix);

        liste.addListSelectionListener(listSelectionEvent -> {
            if (liste.getSelectedValue().toString() == "comment faire ?") {

                text.setText("Pour afficher les aides ,sélectionnez<br> l'item <font color=red />Comment Faire ?</font> dans le menu<br> <font color =blue>Aide .</font>");


            } else if (liste.getSelectedValue().toString() == "conversion Celsius") {
                text.setText("bonjour , j'espere que pus allez bien ??");

            } else if (liste.getSelectedValue().toString() == "conversion Farenhei") {

            }
        });


        JSplitPane pnl =new  JSplitPane(JSplitPane.HORIZONTAL_SPLIT, liste, text );
        pnl.setResizeWeight( 0.33 );
        add(pnl);


    }
}
