package VueControleur;

import modele.environnement.varietes.Legume;
import modele.environnement.varietes.Varietes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


public class FenetreVendre extends JFrame {
    private ArrayList<Legume> legumesInTheBasket = new ArrayList<Legume>();

    private int argent = 0;

    private JPanel panelVendre = new JPanel();
    private int numSaladeInt;
    private JLabel numSalade = new JLabel("Salade: " + numSaladeInt);

    private int numBananeInt;
    private JLabel numBanane = new JLabel("Banane: " + numBananeInt);

    private int numCeriseInt;
    private JLabel numCerise = new JLabel("Cerise: " + numCeriseInt);

    private int numAnanasInt;
    private JLabel numAnanas = new JLabel("Ananas: " + numAnanasInt);

    private int numChampInt;
    private JLabel numChamp = new JLabel("Champignon: " + numChampInt);

    private int numPecheInt;
    private JLabel numPeche = new JLabel("Peche: " + numPecheInt);

    private int numTomateInt;
    private JLabel numTomate = new JLabel("Tomate: " + numTomateInt);

    private int numCarrotteInt;
    private JLabel numCarrotte = new JLabel("Carrotte: " + numCarrotteInt);

    private int numTotal = numAnanasInt + numCarrotteInt + numCeriseInt + numBananeInt + numPecheInt + numSaladeInt + numTomateInt + numChampInt;

    private String[] legumes = {"Ananas","Banane","Carrotte","Cerise","Champignon","Peche","Salade","Tomate"};
    private JComboBox<String> comboBox = new JComboBox<String>(legumes);

    private JButton sellButton = new JButton("Sell");
    private JButton buyButton = new JButton("Buy");

    private int size_x = 500;
    private int size_y = 200;


    public FenetreVendre(ArrayList<Legume> legumeArrayList){
        this.legumesInTheBasket = legumeArrayList;
        this.setTitle("Fenetre Vendre");
        this.setSize(size_x,size_y);
        this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        sellButton.setSize(20,40);
        buyButton.setSize(20,40);
        panelVendre.add(numAnanas);
        panelVendre.add(numBanane);
        panelVendre.add(numCarrotte);
        panelVendre.add(numCerise);
        panelVendre.add(numChamp);
        panelVendre.add(numPeche);
        panelVendre.add(numSalade);
        panelVendre.add(numTomate);
        sellButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switch (comboBox.getSelectedIndex()){
                    case 0:
                        if(numAnanasInt > 0){
                            numAnanasInt--;
                            argent += 6;
                            numAnanas.setText("Ananas: " + numAnanasInt);
                            JOptionPane.showMessageDialog(sellButton,"SOLD!");
                            break;

                        }
                        else{
                            JOptionPane.showMessageDialog(panelVendre,"Vous n'avez pas aucun de cet legume!");
                            break;
                        }

                    case 1:
                        if(numBananeInt > 0){
                            numBananeInt--;
                            argent+= 8;
                            numBanane.setText("Banane: " + numBananeInt);
                            JOptionPane.showMessageDialog(sellButton,"SOLD!");
                            break;


                        }
                        else{
                            JOptionPane.showMessageDialog(panelVendre,"Vous n'avez pas aucun de cet legume!");
                            break;
                        }
                    case 2:
                        if(numCarrotteInt > 0){
                            numCarrotteInt--;
                            argent += 3;
                            numCarrotte.setText("Carrotte: " + numCarrotteInt);
                            JOptionPane.showMessageDialog(sellButton,"SOLD!");
                            break;

                        }
                        else{
                            JOptionPane.showMessageDialog(panelVendre,"Vous n'avez pas aucun de cet legume!");
                            break;
                        }
                    case 3:
                        if(numCeriseInt > 0){
                            numCeriseInt--;
                            argent += 4;
                            numCerise.setText("Cerise: " + numCeriseInt);
                            JOptionPane.showMessageDialog(sellButton,"SOLD!");
                            break;

                        }
                        else{
                            JOptionPane.showMessageDialog(panelVendre,"Vous n'avez pas aucun de cet legume!");
                            break;
                        }

                    case 4:
                        if(numChampInt > 0){
                            numChampInt--;
                            argent += 9;
                            numChamp.setText("Champignon: " + numChampInt);
                            JOptionPane.showMessageDialog(sellButton,"SOLD!");
                            break;

                        }
                        else{
                            JOptionPane.showMessageDialog(panelVendre,"Vous n'avez pas aucun de cet legume!");
                            break;
                        }

                    case 5:
                        if(numPecheInt > 0){
                            numPecheInt--;
                            argent += 4;
                            numPeche.setText("Peche: " + numPecheInt);
                            JOptionPane.showMessageDialog(sellButton,"SOLD!");
                            break;

                        }
                        else{
                            JOptionPane.showMessageDialog(panelVendre,"Vous n'avez pas aucun de cet legume!");
                            break;
                        }

                    case 6:
                        if(numSaladeInt > 0){
                            numSaladeInt--;
                            argent += 6;
                            numSalade.setText("Salade: " + numSaladeInt);
                            JOptionPane.showMessageDialog(sellButton,"SOLD!");
                            break;

                        }
                        else{
                            JOptionPane.showMessageDialog(panelVendre,"Vous n'avez pas aucun de cet legume!");
                            break;
                        }
                    case 7:
                        if(numTomateInt > 0){
                            numTomateInt--;
                            argent += 2;
                            numTomate.setText("Tomate: " + numTomateInt);
                            JOptionPane.showMessageDialog(sellButton,"SOLD!");
                            break;

                        }
                        else{
                            JOptionPane.showMessageDialog(panelVendre,"Vous n'avez pas aucun de cet legume!");
                            break;
                        }

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        panelVendre.add(sellButton);

        buyButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switch (comboBox.getSelectedIndex()){
                    case 0:
                        if(argent >= 6){
                            numAnanasInt++;
                            argent -= 6;
                            numAnanas.setText("Ananas: " + numAnanasInt);
                            JOptionPane.showMessageDialog(buyButton,"PURCHASED!");
                            break;

                        }
                        else{
                            JOptionPane.showMessageDialog(panelVendre,"Vous n'avez pas suffi d'argent!");
                            break;
                        }

                    case 1:
                        if(argent >= 8){
                            numBananeInt++;
                            argent-= 8;
                            numBanane.setText("Banane: " + numBananeInt);
                            JOptionPane.showMessageDialog(buyButton,"PURCHASED!");
                            break;


                        }
                        else{
                            JOptionPane.showMessageDialog(panelVendre,"Vous n'avez pas suffi d'argent!");
                            break;
                        }
                    case 2:
                        if(argent >= 3){
                            numCarrotteInt++;
                            argent -= 3;
                            numCarrotte.setText("Carrotte: " + numCarrotteInt);
                            JOptionPane.showMessageDialog(buyButton,"PURCHASED!");
                            break;

                        }
                        else{
                            JOptionPane.showMessageDialog(panelVendre,"Vous n'avez pas suffi d'argent!");
                            break;
                        }
                    case 3:
                        if(argent >= 4){
                            numCeriseInt++;
                            argent -= 4;
                            numCerise.setText("Cerise: " + numCeriseInt);
                            JOptionPane.showMessageDialog(buyButton,"PURCHASED!");
                            break;

                        }
                        else{
                            JOptionPane.showMessageDialog(panelVendre,"Vous n'avez pas suffi d'argent!");
                            break;
                        }

                    case 4:
                        if(argent >= 9){
                            numChampInt++;
                            argent -= 9;
                            numChamp.setText("Champignon: " + numChampInt);
                            JOptionPane.showMessageDialog(buyButton,"PURCHASED!");
                            break;

                        }
                        else{
                            JOptionPane.showMessageDialog(panelVendre,"Vous n'avez pas suffi d'argent!");
                            break;
                        }

                    case 5:
                        if(argent >= 4){
                            numPecheInt++;
                            argent -= 4;
                            numPeche.setText("Peche: " + numPecheInt);
                            JOptionPane.showMessageDialog(buyButton,"PURCHASED!");
                            break;

                        }
                        else{
                            JOptionPane.showMessageDialog(panelVendre,"Vous n'avez pas suffi d'argent!");
                            break;
                        }

                    case 6:
                        if(argent >= 6){
                            numSaladeInt++;
                            argent -= 6;
                            numSalade.setText("Salade: " + numSaladeInt);
                            JOptionPane.showMessageDialog(buyButton,"PURCHASED!");
                            break;

                        }
                        else{
                            JOptionPane.showMessageDialog(panelVendre,"Vous n'avez pas suffi d'argent!");
                            break;
                        }
                    case 7:
                        if(argent >= 2){
                            numTomateInt++;
                            argent -= 2;
                            numTomate.setText("Tomate: " + numTomateInt);
                            JOptionPane.showMessageDialog(buyButton,"PURCHASED!");
                            break;

                        }
                        else{
                            JOptionPane.showMessageDialog(panelVendre,"Vous n'avez pas suffi d'argent!");
                            break;
                        }

                }


            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        panelVendre.add(buyButton);
        comboBox.setVisible(true);
        panelVendre.add(comboBox);
        panelVendre.setLayout(new FlowLayout());
        this.add(panelVendre);
    }


    public void insertLegume(Legume l){
        this.legumesInTheBasket.add(l);
        if(l.getVariete() == Varietes.ANANAS){
            numAnanasInt++;
            numAnanas.setText("Ananas: " + numAnanasInt);

        }
        else if(l.getVariete() == Varietes.BANANE){
            numBananeInt++;
            numBanane.setText("Banane: " + numBananeInt);

        }
        else if(l.getVariete() == Varietes.CARROTTE){
            numCarrotteInt++;
            numCarrotte.setText("Carrotte: " + numCarrotteInt);

        }
        else if(l.getVariete() == Varietes.CERISE){
            numCeriseInt++;
            numCerise.setText("Cerise: " + numCeriseInt);

        }
        else if(l.getVariete() == Varietes.CHAMPIGNON){
            numChampInt++;
            numChamp.setText("Chmapignon: " + numChampInt);
        }
        else if(l.getVariete() == Varietes.PECHE){
            numPecheInt++;
            numPeche.setText("Peche: " + numPecheInt);
        }
        else if(l.getVariete() == Varietes.SALADE){
            numSaladeInt++;
            numSalade.setText("Salade: " + numSaladeInt);
        }
        else if(l.getVariete() == Varietes.TOMATE){
            numTomateInt++;
            numTomate.setText("Tomate: " + numTomateInt);
        }

        /*
        switch(l.getVariete()){
            case CERISE:
                numCeriseInt++;
                numCerise.setText("Cerise: " + numCeriseInt);
            case BANANE:
                numBananeInt++;
                numBanane.setText("Banane: " + numBananeInt);
            case PECHE:
                numPecheInt++;
                numPeche.setText("Peche: " + numPecheInt);
            case ANANAS:
                numAnanasInt++;
                numAnanas.setText("Ananas: " + numAnanasInt);
            case SALADE:
                numSaladeInt++;
                numSalade.setText("Salade: " + numSaladeInt);
            case CARROTTE:
                numCarrotteInt++;
                numCarrotte.setText("Carrotte: " + numCarrotteInt);
            case TOMATE:
                numTomateInt++;
                numTomate.setText("Tomate: " + numTomateInt);
            case CHAMPIGNON:
                numChampInt++;
                numChamp.setText("Chmapignon: " + numChampInt);
        }
         */
    }

    public int getArgent(){
        return argent;
    }

    public int getNumTotal(){
        return numTotal;
    }
}

