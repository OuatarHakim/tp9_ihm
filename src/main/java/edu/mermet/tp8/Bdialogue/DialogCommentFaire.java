package edu.mermet.tp8.Bdialogue;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;


public class DialogCommentFaire extends JDialog {
    HashMap<String, String> keyValue;
    JEditorPane text;
    JList<String> liste;

    public DialogCommentFaire(JFrame parent) {
        super(parent, "Comment faire", true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        init();

    }

    public void init() {

        //EditorPanel
        text = new JEditorPane();
        text.setEditable(false);
        text.setContentType("text/html");

        //liste

         DefaultListModel<String> choix = new DefaultListModel<>();
         keyValue =new HashMap<>();
         read("HowTo/titres.properties");
        Iterator<String> iterator = read("HowTo/titres.properties").iterator();

        while(iterator.hasNext()){
            String key = iterator.next();
            String value = readProp("HowTo/titres.properties",key);
            keyValue.put(value,key);
            choix.addElement(readProp("HowTo/titres.properties",key));

        }

        liste = new JList<>(choix);
        liste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        liste.addListSelectionListener(listSelectionEvent -> {


            String titreGuide =  liste.getSelectedValue();
            System.out.println(titreGuide);
            String key = keyValue.get(titreGuide);
            System.out.println(key);

            String te =readProp("HowTo/textes.properties",key);
            text.setText(te);
        });
        // Horizontal JSplitePane
        JSplitPane pnl = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, liste, text);
        pnl.setResizeWeight(0.06);
        add(pnl);


    }

    public String readProp(String file ,String key)  {
        String read="";
        try(InputStream input = new FileInputStream(("src/main/resources/"+file))){

            Properties prop = new Properties();
            prop.load(input);
            read = prop.getProperty(key);
        }catch (IOException ex) {
            ex.printStackTrace();
        }
        return read;
    }


      private Set<String> read(String file){
        Set<String> set = new HashSet<>();
          try(InputStream input = new FileInputStream(("src/main/resources/"+file))){

              Properties prop = new Properties();
              prop.load(input);
              set =prop.stringPropertyNames();
          }catch (IOException ex) {
              ex.printStackTrace();
          }
          return set;
      }
}
