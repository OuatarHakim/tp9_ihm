package edu.mermet.tp8.Bdialogue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ConfigMenu extends JDialog {


    public ConfigMenu(JFrame parent){
        super(parent, "Configuration des menus",true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 180);
        setLocationRelativeTo(null);
        init();

    }

    private void init(){

         JPanel pnl = (JPanel) getContentPane();
         pnl.add(pnl_milieu(),BorderLayout.CENTER);
         pnl.add(pnl_bas(),BorderLayout.SOUTH);

    }
   private  JPanel pnl_milieu(){
         //parent panel
        JPanel milieu =new JPanel();
        milieu.setLayout(new GridLayout(4,1));

        JPanel pnl1 = new JPanel();
        pnl1.setLayout(new FlowLayout(FlowLayout.TRAILING));

        JPanel pnl2 = new JPanel();
        pnl2.setLayout(new FlowLayout(FlowLayout.TRAILING));

        JPanel pnl3 = new JPanel();
        pnl3.setLayout(new FlowLayout(FlowLayout.TRAILING));

        JPanel pnl4 = new JPanel();
        pnl4.setLayout(new FlowLayout(FlowLayout.TRAILING));
         //creat label
        JLabel conversion = new JLabel("Conversion Celsius/Farenheit",JLabel.RIGHT);
        JLabel saisie = new JLabel("Saisie de texte",JLabel.RIGHT);
        JLabel diaporama = new JLabel("Diaporama",JLabel.RIGHT);
        JLabel boutons  = new JLabel("Boutons",JLabel.RIGHT);
        //create RadioButton
        ButtonGroup grp = new ButtonGroup();
        ButtonGroup grpS = new ButtonGroup();
        ButtonGroup grpD = new ButtonGroup();
        ButtonGroup grpB = new ButtonGroup();
        JRadioButton auto = new JRadioButton("Auto");
        JRadioButton afficher = new JRadioButton("Affichée");
        JRadioButton cacher = new JRadioButton("Cachée");


        JRadioButton Sauto = new JRadioButton("Auto");
        JRadioButton Safficher = new JRadioButton("Affichée");
        JRadioButton Scacher = new JRadioButton("Cachée");

        JRadioButton Dauto = new JRadioButton("Auto");
        JRadioButton Dafficher = new JRadioButton("Affichée");
        JRadioButton Dcacher = new JRadioButton("Cachée");

        JRadioButton Bauto = new JRadioButton("Auto");
        JRadioButton Bafficher = new JRadioButton("Affichée");
        JRadioButton Bcacher = new JRadioButton("Cachée");

        grpS.add(Sauto);
        grpS.add(Safficher);
        grpS.add(Scacher);

        grpD.add(Sauto);
        grpD.add(Safficher);
        grpD.add(Scacher);

        grpB.add(Sauto);
        grpB.add(Safficher);
        grpB.add(Scacher);

        grp.add(auto);
        grp.add(afficher);
        grp.add(cacher);


        conversion.setLabelFor(auto);
        conversion.setLabelFor(afficher);
        conversion.setLabelFor(cacher);

        saisie.setLabelFor(Sauto);
        saisie.setLabelFor(Safficher);
        saisie.setLabelFor(Scacher);

        diaporama.setLabelFor(Dauto);
        diaporama.setLabelFor(Dafficher);
        diaporama.setLabelFor(Dcacher);

        boutons.setLabelFor(Bauto);
        boutons.setLabelFor(Bafficher);
        boutons.setLabelFor(Bcacher);
        //added component in pnl1
        pnl1.add(conversion);
        pnl1.add(auto);
        pnl1.add(afficher);
        pnl1.add(cacher);
       //added component in pnl2
        pnl2.add(saisie);
        pnl2.add(Sauto);
        pnl2.add(Safficher);
        pnl2.add(Scacher);
        //added component in pnl3
        pnl3.add(diaporama);
        pnl3.add(Dauto);
        pnl3.add(Dafficher);
        pnl3.add(Dcacher);
       //added component in pnl4
        pnl4.add(boutons);
        pnl4.add(Bauto);
        pnl4.add(Bafficher);
        pnl4.add(Bcacher);

        milieu.add(pnl1);
        milieu.add(pnl2);
        milieu.add(pnl3);
        milieu.add(pnl4);
        return milieu;

    }
   private JPanel pnl_bas(){
        JPanel bas = new JPanel();
        JButton valider = new JButton("Valider");
        JButton annuler = new JButton("Annuler");
        bas.add(valider);
        bas.add(annuler);
        return bas;
    }


}
