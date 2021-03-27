package edu.mermet.tp8.fenetres;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.AncestorListener;

/**
 *
 * @author brunomermet
 */
public class FenetreConversion extends AbstractFenetreInterne {
    private JTextField champCelsius;
    private JTextField champFarenheit;
    private JButton boutonConvertir;
    private Action actionConvertir;
    private boolean celsiusAFocus;
    public FenetreConversion(Action action) {
        super(action,"Conversion celsius/Farenheit");
        this.setSize(new Dimension(100,50));
        this.setLayout(new GridLayout(3,1));
        JPanel ligneCelsius = new JPanel();
        ligneCelsius.setLayout(new FlowLayout(FlowLayout.TRAILING));
        JLabel labCelsius = new JLabel("Celsius :");
        champCelsius = new JTextField(15);
        champCelsius.setToolTipText("La valeur en Celsius");
        champCelsius.addMouseListener(new MouseAdapter() {
            FenetreConversion fen;
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(e.getButton()==MouseEvent.BUTTON3){
                JOptionPane.showMessageDialog(fen,"La valeur en Celius","Aide",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        labCelsius.setLabelFor(champCelsius);


        Icon icon = UIManager.getIcon("OptionPane.questionIcon");
        JLabel label = new JLabel(icon);
        label.addMouseListener(new MouseAdapter() {
            FenetreConversion fen;
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(fen,"La valeur en Celius","Aide",JOptionPane.INFORMATION_MESSAGE);

            }
        });

        ligneCelsius.add(labCelsius);
        ligneCelsius.add(champCelsius);
        ligneCelsius.add(label);
        this.add(ligneCelsius);
        celsiusAFocus = true;
        champCelsius.addFocusListener(new EcouteurFocus(true));
        JPanel ligneFarenheit = new JPanel();
        ligneFarenheit.setLayout(new FlowLayout(FlowLayout.TRAILING));
        JLabel labFarenheit = new JLabel("Farenheit :");
        champFarenheit = new JTextField(15);
        champFarenheit.setToolTipText("La valeur en Farenheit");
        champFarenheit.addMouseListener(new MouseAdapter() {
            FenetreConversion fen;
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(e.getButton()==MouseEvent.BUTTON3){
                    JOptionPane.showMessageDialog(fen,"La valeur en Farenheit","Aide",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        labFarenheit.setLabelFor(champFarenheit);
        ligneFarenheit.add(labFarenheit);
        ligneFarenheit.add(champFarenheit);
        Icon icon1 = UIManager.getIcon("OptionPane.questionIcon");
        JLabel label1 = new JLabel(icon);
        label1.addMouseListener(new MouseAdapter() {
            FenetreConversion fen;
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(fen,"La valeur en Farenheit","Aide",JOptionPane.INFORMATION_MESSAGE);


            }
        });
        ligneFarenheit.add(label1);
        this.add(ligneFarenheit);
        champFarenheit.addFocusListener(new EcouteurFocus(false));
        JPanel ligneValider = new JPanel();
        ligneValider.setLayout(new FlowLayout(FlowLayout.CENTER));
        actionConvertir = new ActionConvertir();
        boutonConvertir = new JButton(actionConvertir);
        ligneValider.add(boutonConvertir);
        this.add(ligneValider);
        
        pack();
        getRootPane().setDefaultButton(boutonConvertir);
    }

    private class EcouteurFocus implements FocusListener {
        private boolean aStocker;

        public EcouteurFocus(boolean b) {
            aStocker = b;
        }

        @Override
        public void focusGained(FocusEvent fe) {
            celsiusAFocus = aStocker;
        }

        @Override
        public void focusLost(FocusEvent fe) {
            return;
        }
    }

    private class ActionConvertir extends AbstractAction {

        public ActionConvertir() {
            super("Convertir");
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            double tempCelsius = 0;
            double tempFarenheit = 0;
            if (celsiusAFocus) {
                try {
                    tempCelsius = Double.parseDouble(champCelsius.getText());
                tempFarenheit = 9./5*tempCelsius+32;
                champFarenheit.setText(""+tempFarenheit);
                }
                catch (NumberFormatException nfe) {
                    champFarenheit.setText("Format incorrect");
                }
                }
            else {
                try {
                    tempFarenheit = Double.parseDouble(champFarenheit.getText());
                    tempCelsius = (tempFarenheit - 32) *5./9;
                    champCelsius.setText(""+tempCelsius);
                }
                catch (NumberFormatException nfe) {
                    champCelsius.setText("Format incorrect");
                }
                
            }
        }
    }
    
}
