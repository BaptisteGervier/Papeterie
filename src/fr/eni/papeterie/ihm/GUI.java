package fr.eni.papeterie.ihm;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private JPanel panneauPrincipal;
    private JPanel panneauSecondaire;
    private JPanel panneauTrois;
    private JPanel panneauDuBas;
    private JLabel labelRef, labelDes, labelMar, labelSto, labelPrix, labelType, labelGram, labelCouleur;
    private JTextField textFieldRef, textFieldDes, textFieldMar, textFieldSto, textFieldPrix;
    private JRadioButton radioButton, radioButton2;
    private JCheckBox checkBox, checkBox2 ;
    private JComboBox comboBox;
    private JButton btnPrecedent, btnNouveau, btnEnregistrer, btnSupprimer, btnSuivant;

    public GUI(){
        this.setTitle("Papeterie");
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(getPanneauPrincipal());
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
            gbc.gridy = 7;
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
            gbc.gridy = 7;
            gbc.gridx = 1;
            panneauPrincipal.add(getComboBox(), gbc);

            gbc.gridy = 8;
            gbc.gridx = 0;
            gbc.gridwidth = 2;
            panneauPrincipal.add(getPanneauDuBas(), gbc);

        }
        return panneauPrincipal;
    }

        public JPanel getPanneauSecondaire() {
            if (panneauSecondaire == null) {
                panneauSecondaire = new JPanel();
                panneauSecondaire.setLayout(new BoxLayout(panneauSecondaire, BoxLayout.Y_AXIS));
                panneauSecondaire.add(getRadioButton()) ;
                panneauSecondaire.add(getRadioButton2());
                ButtonGroup bg = new ButtonGroup();
                bg.add(getRadioButton());
                bg.add(getRadioButton2());
            }
            return panneauSecondaire;
        }

    public JPanel getPanneauTrois() {
        if (panneauTrois == null) {
            panneauTrois = new JPanel();
            panneauTrois.setLayout(new BoxLayout(panneauTrois, BoxLayout.Y_AXIS));
            panneauTrois.add(getCheckBox()) ;
            panneauTrois.add(getCheckBox2());
            ButtonGroup bg = new ButtonGroup();
            bg.add(getCheckBox());
            bg.add(getCheckBox2());
        }
        return panneauTrois;
    }

    public JPanel getPanneauDuBas() {
        if (panneauDuBas == null) {
            panneauDuBas = new JPanel();
            panneauDuBas.add(getBtnPrecedent());
            panneauDuBas.add(getBtnNouveau());
            panneauDuBas.add(getBtnEnregistrer());
            panneauDuBas.add(getBtnSupprimer());
            panneauDuBas.add(getBtnSuivant());
        }
        return panneauDuBas;
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
            for (Couleur couleur : Couleur.values()){
                comboBox.addItem(couleur);
            }
        }
        return comboBox;
    }
//singleton des boutons
    public JButton getBtnPrecedent(){
        if (btnPrecedent == null){
            btnPrecedent = new JButton(new ImageIcon("image/Back24.gif"));
        }
        return btnPrecedent;
    }

    public JButton getBtnNouveau(){
        if (btnNouveau == null){
            btnNouveau = new JButton(new ImageIcon("image/New24.gif"));
        }
        return btnNouveau;
    }

    public JButton getBtnEnregistrer(){
        if (btnEnregistrer == null){
            btnEnregistrer = new JButton(new ImageIcon("image/Save24.gif"));
        }
        return btnEnregistrer;
    }

    public JButton getBtnSupprimer(){
        if (btnSupprimer == null){
            btnSupprimer = new JButton(new ImageIcon("image/Delete24.gif"));
        }
        return btnSupprimer;
    }

    public JButton getBtnSuivant(){
        if (btnSuivant == null){
            btnSuivant = new JButton(new ImageIcon("image/Forward24.gif"));
        }
        return btnSuivant;
    }
}
