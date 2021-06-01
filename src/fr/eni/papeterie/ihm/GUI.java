package fr.eni.papeterie.ihm;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private JPanel panneauPrincipal;
    private JPanel panneauSecondaire;
    private JPanel panneauTrois;
    private JLabel labelRef;
    private JLabel labelDes;
    private JLabel labelMar;
    private JLabel labelSto;
    private JLabel labelPrix;
    private JLabel labelType;
    private JLabel labelGram;
    private JLabel labelCouleur;
    private JTextField textFieldRef;
    private JTextField textFieldDes;
    private JTextField textFieldMar;
    private JTextField textFieldSto;
    private JTextField textFieldPrix;
    private JRadioButton radioButton;
    private JRadioButton radioButton2;
    private JCheckBox checkBox;
    private JCheckBox checkBox2;
    private JComboBox comboBox;

    public GUI(){
        this.setTitle("");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(getPanneauPrincipal());
        String laf = "javax.swing.plaf.metal.MetalLookAndFeel";
        this.pack();
        this.setVisible(true);
    }

    public JPanel getPanneauPrincipal() {
        if (panneauPrincipal == null) {
            panneauPrincipal = new JPanel();
            panneauPrincipal.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5); // Marge pour les textes

            // Insertion des Textes
            gbc.gridy = 0;
            gbc.gridx = 0;
            panneauPrincipal.add(getLabelRef(), gbc);
            gbc.gridy = 1;
            gbc.gridx = 0;
            panneauPrincipal.add(getLabelDes(), gbc);
            gbc.gridy = 2;
            gbc.gridx = 0;
            panneauPrincipal.add(getLabelMar(), gbc);
            gbc.gridy = 3;
            gbc.gridx = 0;
            panneauPrincipal.add(getLabelSto(), gbc);
            gbc.gridy = 4;
            gbc.gridx = 0;
            panneauPrincipal.add(getLabelPrix(), gbc);
            gbc.gridy = 5;
            gbc.gridx = 0;
            panneauPrincipal.add(getLabelType(), gbc);
            gbc.gridy = 6;
            gbc.gridx = 0;
            panneauPrincipal.add(getLabelGram(), gbc);
            gbc.gridy = 9;
            gbc.gridx = 0;
            panneauPrincipal.add(getLabelCouleur(), gbc);

            // Insertion des Case à remplir
            gbc.gridy = 0;
            gbc.gridx = 1;
            panneauPrincipal.add(getTextFieldRef(), gbc);
            gbc.gridy = 1;
            gbc.gridx = 1;
            panneauPrincipal.add(getTextFieldDes(), gbc);
            gbc.gridy = 2;
            gbc.gridx = 1;
            panneauPrincipal.add(getTextFieldMar(), gbc);
            gbc.gridy = 3;
            gbc.gridx = 1;
            panneauPrincipal.add(getTextFieldSto(), gbc);
            gbc.gridy = 4;
            gbc.gridx = 1;
            panneauPrincipal.add(getTextFieldPrix(), gbc);

            gbc.gridy = 5;
            gbc.gridx = 1;
            panneauPrincipal.add(getPanneauSecondaire(), gbc);

            gbc.gridy = 6;
            gbc.gridx = 1;
            panneauPrincipal.add(getPanneauTrois(), gbc);

            // insertion de la comboBox de couleur
            gbc.gridy = 9;
            gbc.gridx = 1;
            panneauPrincipal.add(getComboBox(), gbc);

        }
        return panneauPrincipal;
    }

        public JPanel getPanneauSecondaire() {
            if (panneauSecondaire == null) {
                panneauSecondaire = new JPanel();
                panneauSecondaire.setLayout(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.insets = new Insets(5, 5, 5, 5);

                // insertion du RadioButton
                gbc.gridy = 0;
                gbc.gridx = 1;
                panneauSecondaire.add(getRadioButton(), gbc);
                gbc.gridy = 2;
                gbc.gridx = 1;
                panneauSecondaire.add(getRadioButton2(), gbc);
            }
            return panneauSecondaire;
        }

    public JPanel getPanneauTrois() {
        if (panneauTrois == null) {
            panneauTrois = new JPanel();
            panneauTrois.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5);
            // insertion des checkBox
            gbc.gridy = 0;
            gbc.gridx = 1;
            panneauTrois.add(getCheckBox(), gbc);
            gbc.gridy = 2;
            gbc.gridx = 1;
            panneauTrois.add(getCheckBox2(), gbc);
        }
        return panneauTrois;
    }


    // singleton des textes
    public JLabel getLabelRef(){
        if (labelRef == null){
            labelRef = new JLabel("Référence");
        }
        return labelRef;
    }

    public JLabel getLabelDes(){
        if (labelDes == null){
            labelDes = new JLabel("Designation");
        }
        return labelDes;
    }

    public JLabel getLabelMar(){
        if (labelMar == null){
            labelMar = new JLabel("Marque");
        }
        return labelMar;
    }

    public JLabel getLabelSto(){
        if (labelSto == null){
            labelSto = new JLabel("Stock");
        }
        return labelSto;
    }

    public JLabel getLabelPrix(){
        if (labelPrix == null){
            labelPrix = new JLabel("Prix");
        }
        return labelPrix;
    }

    public JLabel getLabelType(){
        if (labelType == null){
            labelType = new JLabel("Type");
        }
        return labelType;
    }

    public JLabel getLabelGram(){
        if (labelGram == null){
            labelGram = new JLabel("Grammage");
        }
        return labelGram;
    }

    public JLabel getLabelCouleur(){
        if (labelCouleur == null){
            labelCouleur = new JLabel("Couleur");
        }
        return labelCouleur;
    }
    // sigleton des barre de remplissage
    public JTextField getTextFieldRef(){
        if (textFieldRef == null){
            textFieldRef = new JTextField();
            textFieldRef.setPreferredSize(new Dimension(200, 24));
        }
        return textFieldRef;
    }

    public JTextField getTextFieldDes(){
        if (textFieldDes == null){
            textFieldDes = new JTextField();
            textFieldDes.setPreferredSize(new Dimension(200, 24));
        }
        return textFieldDes;
    }

    public JTextField getTextFieldMar(){
        if (textFieldMar == null){
            textFieldMar = new JTextField();
            textFieldMar.setPreferredSize(new Dimension(200, 24));
        }
        return textFieldMar;
    }

    public JTextField getTextFieldSto(){
        if (textFieldSto == null){
            textFieldSto = new JTextField();
            textFieldSto.setPreferredSize(new Dimension(200, 24));
        }
        return textFieldSto;
    }

    public JTextField getTextFieldPrix(){
        if (textFieldPrix == null){
            textFieldPrix = new JTextField();
            textFieldPrix.setPreferredSize(new Dimension(200, 24));
        }
        return textFieldPrix;
    }

    // Singleton des radioButton
    public JRadioButton getRadioButton(){
        if (radioButton == null){
            radioButton = new JRadioButton();
            radioButton.setText("Ramette");
        }
        return radioButton;
    }
    public JRadioButton getRadioButton2(){
        if (radioButton2 == null){
            radioButton2 = new JRadioButton();
            radioButton2.setText("Stylo");
        }
        return radioButton2;
    }

// Singleton des checkbox
    public JCheckBox getCheckBox(){
        if (checkBox == null){
            checkBox = new JCheckBox();
            checkBox.setText("80 grammes");
        }
        return checkBox;
    }
    public JCheckBox getCheckBox2(){
        if (checkBox2 == null){
            checkBox2 = new JCheckBox();
            checkBox2.setText("100 grammes");
        }
        return checkBox2;
    }

// Singleton de la comboBox
    public JComboBox getComboBox(){
        if (comboBox == null){
            comboBox = new JComboBox<>();
            comboBox.setPreferredSize(new Dimension(100,24));
        }
        return comboBox;
    }
}


//flowLayout