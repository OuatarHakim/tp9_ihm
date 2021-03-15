package edu.mermet.tp8.Bdialogue;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class DialogCommentFaire extends JDialog {
    Border blackline = BorderFactory.createLineBorder(Color.black);
    JPanel droite;
    JPanel gauche;
    JLabel text;
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
        droite = new JPanel();
        gauche = new JPanel();
        text = new JLabel();
        String[] choix = {"comment faire ?", "conversion Celsius", "conversion Farenhei", " gras ", "changer la couleur", "Quitter"};
        liste = new JList(choix);

        liste.addListSelectionListener(listSelectionEvent -> {
            if (liste.getSelectedValue().toString() == "comment faire ?") {

                text.setText("<html>Pour afficher les aides ,sélectionnez<br> l'item <font color=red />Comment Faire ?</font> dans le menu<br> <font color =blue>Aide .</font></html>");


            } else if (liste.getSelectedValue().toString() == "conversion Celsius") {
                text.setText("bonjour , j'espere que pus allez bien ??");

            } else if (liste.getSelectedValue().toString() == "conversion Farenhei") {

            }
        });

        droite.setBackground(Color.white);
        gauche.setBackground(Color.white);
        droite.add(liste);
        droite.setBorder(blackline);
        add(droite, BorderLayout.WEST);
        gauche.add(text);
        gauche.setBorder(blackline);
        add(gauche, BorderLayout.CENTER);
    }
}
