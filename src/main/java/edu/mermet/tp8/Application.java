package edu.mermet.tp8;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import javax.swing.*;

import edu.mermet.tp8.Bdialogue.ConfigMenu;
import edu.mermet.tp8.Bdialogue.DialogCommentFaire;
import edu.mermet.tp8.fenetres.FenetreBoutons;
import edu.mermet.tp8.fenetres.FenetreConversion;
import edu.mermet.tp8.fenetres.FenetreDiaporama;
import edu.mermet.tp8.fenetres.FenetreTexte;

/**
 *
 * @author brunomermet
 */
public class Application extends JFrame {
    private JInternalFrame conversion;
    private JInternalFrame texte;
    private JInternalFrame diaporama;
    private JInternalFrame boutons;
    private Action actionAfficherConversion;
    private Action actionAfficherTexte;
    private Action actionAfficherDiaporama;
    private Action actionAfficherBoutons;
    private Action actionAfficherCfaire;
    private Action actionAfficherConfMenu;
    private DialogCommentFaire dialogCommentFaire;
    private ConfigMenu  configMenu;
    private JMenuItem itemConversion;
    private JMenuItem itemTexte;
    private JMenuItem itemDiaporama;
    private JMenuItem itemBoutons;
    private Properties prop;
    public Application() {
        super("multi-fenêtres");
        this.setContentPane(new JDesktopPane());

        // ****** Barre de menu ******
        JMenuBar barre = new JMenuBar();
        // ------ menu Fichier ------
        JMenu menuFichier = new JMenu("Fichier");
        menuFichier.setMnemonic(KeyEvent.VK_F);
        JMenuItem quitter = new JMenuItem("Quitter");
        quitter.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent aev) {
                System.exit(0);
            }
        });
        quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
        menuFichier.add(quitter);
        barre.add(menuFichier);
        this.setJMenuBar(barre);
        // ------ menu Applications ------
        JMenu menuApplication = new JMenu("Applications");
        menuApplication.setMnemonic(KeyEvent.VK_A);
        actionAfficherConversion = new ActionAfficherConversion();
         itemConversion = new JMenuItem(actionAfficherConversion);
        menuApplication.add(itemConversion);
        actionAfficherTexte = new ActionAfficherTexte();
        itemTexte = new JMenuItem(actionAfficherTexte);
        menuApplication.add(itemTexte);
        actionAfficherDiaporama = new ActionAfficherDiaporama();
        itemDiaporama = new JMenuItem(actionAfficherDiaporama);
        menuApplication.add(itemDiaporama);
        actionAfficherBoutons = new ActionAfficherBoutons();
        itemBoutons = new JMenuItem(actionAfficherBoutons);
        menuApplication.add(itemBoutons);
        barre.add(menuApplication);
        //menu aide
        JMenu menuAide = new JMenu("Aide");

        menuAide.setMnemonic(KeyEvent.VK_A);
        actionAfficherCfaire = new ActionAfficherCfaire();
        JMenuItem itemCfaire =new JMenuItem(actionAfficherCfaire);
        menuAide.add(itemCfaire);
        actionAfficherConfMenu = new ActionAfficheConfMenu();
        JMenuItem itemConfMenu = new JMenuItem(actionAfficherConfMenu );
        menuAide.add(itemConfMenu);

        barre.add(menuAide);


        // ****** Fin barre de menu ******
        
        // ****** Création des fenêtres ******
        // ------ fenêtre conversion ------
        conversion = new FenetreConversion(actionAfficherConversion);
        this.add(conversion);
        // ------ fenêtre texte ------
        texte = new FenetreTexte(actionAfficherTexte);
        this.add(texte);
        // ------ fenêtre diaporama ------
        diaporama = new FenetreDiaporama(actionAfficherDiaporama);
        this.add(diaporama);
        // ------ fenêtre boutons ------
        boutons = new FenetreBoutons(this,actionAfficherBoutons);
        this.add(boutons);

        dialogCommentFaire = new DialogCommentFaire(this);
        configMenu = new ConfigMenu(this);
        // ****** Fin création fenêtres ******
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,300);
        this.setLocationRelativeTo(null);
        setVisible(true);
        afficheSuggestion(prop);

    }
//  suggestions
    private void afficheSuggestion(Properties p){
        Set<String> set = new HashSet<>();
        try(InputStream input = new FileInputStream(("src/main/resources/suggestion.properties"))){
            p = new Properties();
            p.load(input);
            set =p.stringPropertyNames();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
        String[] arrayKey = set.toArray(new String[set.size()]);
        Random rndm = new Random();
        int rndmNumber = rndm.nextInt(set.size());

        Object[] options = { "Fermer", "Ne plus Afficher" };
        int choice = JOptionPane.showOptionDialog(this, p.getProperty((arrayKey[rndmNumber])),"Suggestion",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);
        if (choice == JOptionPane.NO_OPTION)
        {
            p.setProperty(arrayKey[rndmNumber],"CHACHER");
        }

    }
    private Set<String> read(String file,Properties p){
        Set<String> set = new HashSet<>();
        try(InputStream input = new FileInputStream(("src/main/resources/"+file))){

            p = new Properties();
            p.load(input);
            set =p.stringPropertyNames();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
        return set;
    }
    private class ActionAfficherBoutons extends AbstractAction {
        public ActionAfficherBoutons() {
            super("Boutons");
            putValue(Action.ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK));
            putValue(Action.MNEMONIC_KEY,KeyEvent.VK_B);
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            boutons.setVisible(true);
            enableBoutons(false);
        }
    }

    private class ActionAfficherDiaporama extends AbstractAction {
        public ActionAfficherDiaporama() {
            super("Diaporama");
            putValue(Action.ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
            putValue(Action.MNEMONIC_KEY,KeyEvent.VK_D);
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            diaporama.setVisible(true);
            enableDiaporama(false);
        }
    }

    private class ActionAfficherTexte extends AbstractAction {
        public ActionAfficherTexte() {
            super("Saisie de texte");
            putValue(Action.ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_DOWN_MASK));
            putValue(Action.MNEMONIC_KEY,KeyEvent.VK_T);
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            texte.setVisible(true);
            enableTexte(false);
        }
    }
    
    public class ActionAfficherConversion extends AbstractAction {
        public ActionAfficherConversion() {
            super("Conversion Celsius/Farenheit");
            putValue(Action.ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
            putValue(Action.MNEMONIC_KEY,KeyEvent.VK_C);
        }

        @Override
        public void actionPerformed(ActionEvent ae) {

            conversion.setVisible(true);
            enableConversion(false);

        }
    }

    public class ActionAfficherCfaire extends AbstractAction {
        public ActionAfficherCfaire() {
            super("Comment faire ?");
            putValue(Action.ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_DOWN_MASK));
            putValue(Action.MNEMONIC_KEY,KeyEvent.VK_F);
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            dialogCommentFaire.setVisible(true);

        }
    }
    public class ActionAfficheConfMenu extends AbstractAction {
        public ActionAfficheConfMenu() {
            super("Configuration Menu");
            putValue(Action.ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_DOWN_MASK));
            putValue(Action.MNEMONIC_KEY,KeyEvent.VK_M);
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            configMenu.setVisible(true);
        }
    }
    public void enableConversion(boolean b) {
        actionAfficherConversion.setEnabled(b);
    }

    public void enableTexte(boolean b) {
        actionAfficherTexte.setEnabled(b);
    }

    public void enableDiaporama(boolean b) {
        actionAfficherDiaporama.setEnabled(b);
    }

    public void enableBoutons(boolean b) {
        actionAfficherBoutons.setEnabled(b);
    }

    public Action getActionAfficherConversion() {
        return actionAfficherConversion;
    }

    public Action getActionAfficherTexte() {
        return actionAfficherTexte;
    }

    public void masquerConversion(boolean b){
           itemConversion.setVisible(b);
    }
    public void masquerSaisie(boolean b){
        itemTexte.setVisible(b);
    }
    public void masquerDiaporama(boolean b){
        itemDiaporama.setVisible(b);
    }
    public void masquerBoutons(boolean b){
        itemBoutons.setVisible(b);
    }

    public Action getActionAfficherDiaporama() {
        return actionAfficherDiaporama;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Application::new);
    }

    
}
