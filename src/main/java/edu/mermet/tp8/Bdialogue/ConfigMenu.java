package edu.mermet.tp8.Bdialogue;

import edu.mermet.tp8.Application;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigMenu extends JDialog {
    private JButton valider;
    private JButton annuler;
    private ButtonGroup grp ;
    private ButtonGroup grpS;
    private ButtonGroup grpD ;
    private ButtonGroup grpB ;
    private Application application;

    public ConfigMenu(Application parent){
        super(parent, "Configuration des menus",true);
        application=parent;
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
         grp = new ButtonGroup();
         grpS = new ButtonGroup();
         grpD = new ButtonGroup();
         grpB = new ButtonGroup();
         // conversion
        JRadioButton auto = new JRadioButton("Auto");
        auto.setActionCommand("auto");
        auto.setSelected(true);
        JRadioButton afficher = new JRadioButton("Affichée");
        afficher.setActionCommand("afficher");
        JRadioButton cacher = new JRadioButton("Cachée");
        cacher.setActionCommand("cacher");

      //saisie
        JRadioButton Sauto = new JRadioButton("Auto");
        Sauto.setSelected(true);
        Sauto.setActionCommand("auto");
        JRadioButton Safficher = new JRadioButton("Affichée");
        Safficher.setActionCommand("afficher");
        JRadioButton Scacher = new JRadioButton("Cachée");
         Scacher.setActionCommand("cacher");

        JRadioButton Dauto = new JRadioButton("Auto");
        Dauto.setSelected(true);
        Dauto.setActionCommand("auto");
        JRadioButton Dafficher = new JRadioButton("Affichée");
        Dafficher.setActionCommand("afficher");
        JRadioButton Dcacher = new JRadioButton("Cachée");
        Dcacher.setActionCommand("cacher");

        JRadioButton Bauto = new JRadioButton("Auto");
        Bauto.setActionCommand("auto");
        Bauto.setSelected(true);
        JRadioButton Bafficher = new JRadioButton("Affichée");
        Bafficher.setActionCommand("afficher");
        JRadioButton Bcacher = new JRadioButton("Cachée");
        Bcacher.setActionCommand("cacher");

        grpS.add(Sauto);
        grpS.add(Safficher);
        grpS.add(Scacher);

        grpD.add(Dauto);
        grpD.add(Dafficher);
        grpD.add(Dcacher);

        grpB.add(Bauto);
        grpB.add(Bafficher);
        grpB.add(Bcacher);

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
        valider = new JButton("Valider");
        valider.addActionListener(new ActionValider());
        annuler = new JButton("Annuler");
        annuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });
        bas.add(valider);
        bas.add(annuler);
        return bas;
    }
  public class ActionValider implements ActionListener {


       @Override
       public void actionPerformed(ActionEvent actionEvent) {
            String actionConvertion = grp.getSelection().getActionCommand();
            String actionSaisie = grpS.getSelection().getActionCommand();
            String actionDiaporama = grpD.getSelection().getActionCommand();
            String actionBouton = grpB.getSelection().getActionCommand();

           if(actionConvertion=="cacher"){

               application.masquerConversion(false);


           }else if(actionConvertion == "afficher") {
               application.enableConversion(true);

           }

           if(actionSaisie=="cacher"){

               application.masquerSaisie(false);


           }else if(actionSaisie == "afficher") {
               application.masquerSaisie(true);

           }

           if(actionDiaporama=="cacher"){
               application.masquerDiaporama(false);

           }else if(actionDiaporama == "afficher") {
                application.masquerDiaporama(true);
           }

           if(actionBouton=="cacher"){
              application.masquerBoutons(false);

           }else if(actionBouton == "afficher") {
              application.masquerBoutons(true);

           }
           dispose();
       }
  }

}
