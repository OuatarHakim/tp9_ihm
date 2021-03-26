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
        text.setEditable( false );
        text.setContentType("text/html");

        String[] choix = {"comment faire ?", "conversion Celsius", "conversion Farenhei", " gras ", "changer la couleur", "Quitter"};
        liste = new JList(choix);

        liste.addListSelectionListener(listSelectionEvent -> {
            if (liste.getAnchorSelectionIndex() == 0) {
                System.out.println("index : "+ liste.getAnchorSelectionIndex());

                text.setText("Pour afficher les aides ,sélectionnez<br> l'item <font color=red />Comment Faire ?</font> dans le menu<br> <font color =blue>Aide .</font>");


            } else if (liste.getAnchorSelectionIndex() == 1) {
                text.setText("<html><h1>Contenu au format <b>HTML</b></h1></html>");

            } else if (liste.getAnchorSelectionIndex() == 2) {
                System.out.println("index : "+ liste.getAnchorSelectionIndex());
            }
        });


        JSplitPane pnl =new  JSplitPane(JSplitPane.HORIZONTAL_SPLIT, liste, text );
        pnl.setResizeWeight( 0.4 );
        add(pnl);


    }
}
