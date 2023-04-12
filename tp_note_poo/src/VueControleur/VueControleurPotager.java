package VueControleur;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

import modele.SimulateurPotager;
import modele.environnement.*;
import modele.environnement.varietes.Legume;
import modele.environnement.varietes.Varietes;


/** Cette classe a deux fonctions :
 *  (1) Vue : proposer une représentation graphique de l'application (cases graphiques, etc.)
 *  (2) Controleur : écouter les évènements clavier et déclencher le traitement adapté sur le modèle
 *
 */
public class VueControleurPotager extends JFrame implements Observer,ActionListener {
    private SimulateurPotager simulateurPotager; // référence sur une classe de modèle : permet d'accéder aux données du modèle pour le rafraichissement, permet de communiquer les actions clavier (ou souris)

    private int sizeX; // taille de la grille affichée
    private int sizeY;

    // icones affichées dans la grille
    private ImageIcon icoSalade;
    private ImageIcon icoChampignon;
    private ImageIcon icoTomate;
    private ImageIcon icoAnanas;
    private ImageIcon icoBanane;
    private ImageIcon icoCerise;
    private ImageIcon icoPeche;
    private ImageIcon icoCarrotte;
    private ImageIcon icoTerre;
    private ImageIcon icoVide;
    private ImageIcon icoMur;
    private ImageIcon IcoRecolte;

    private JLabel[][] tabJLabel;// cases graphique (au moment du rafraichissement, chaque case va être associée à une icône, suivant ce qui est présent dans le modèle)

    private JPopupMenu popupMenu = new JPopupMenu();
    //TODO remplacer les différent menuSalde menuAnnanas par un seul listener
    private  JMenuItem menuSalade = new JMenuItem("Salade");
    private JMenuItem menuCarrotte = new JMenuItem("Carrotte");

    private JMenuItem menuCerise = new JMenuItem("Cerise");
    private JMenuItem menuChampignon = new JMenuItem("Champignon");
    private JMenuItem menuBanane = new JMenuItem("Banane");
    private JMenuItem menuTomate = new JMenuItem("Tomate");
    private JMenuItem menuPeche = new JMenuItem("Peche");
    private JMenuItem menuAnanas = new JMenuItem("Ananas");
    private JMenuItem menuRecolte = new JMenuItem("récolter");

    private ArrayList<Point> pointArrayList = new ArrayList<Point>();

    private ArrayList<Point> pointHarvestList = new ArrayList<Point>();
    private ArrayList<Legume> legumeArrayList = new ArrayList<Legume>();


   private JLabel valeur_precipitation = new JLabel();
    private JLabel texte_precipitation = new JLabel("Precipitation: ");
    private JLabel valeur_temperature = new JLabel();
    private JLabel texte_temperature = new JLabel("température: ");
    JLabel texte_legume = new JLabel("Legumes: ");
    JLabel texte_argent = new JLabel("Argent: ");

    // verifier si on peut inserer un legume
    private boolean a_deja_legume;

    private int x_actu;
    private int y_actu;
    private int nb_legume;

    public VueControleurPotager(SimulateurPotager _simulateurPotager) {
        sizeX = simulateurPotager.SIZE_X;
        sizeY = _simulateurPotager.SIZE_Y;
        simulateurPotager = _simulateurPotager;

        chargerLesIcones();
        placerLesComposantsGraphiques();
        menuAnanas.setIcon(icoAnanas);
        menuBanane.setIcon(icoBanane);
        menuCerise.setIcon(icoCerise);
        menuCarrotte.setIcon(icoCarrotte);
        menuChampignon.setIcon(icoChampignon);
        menuPeche.setIcon(icoPeche);
        menuTomate.setIcon(icoTomate);
        menuSalade.setIcon(icoSalade);
        menuRecolte.setIcon(IcoRecolte);

        popupMenu.add(menuAnanas);
        popupMenu.add(menuBanane);
        popupMenu.add(menuCarrotte);
        popupMenu.add(menuCerise);
        popupMenu.add(menuChampignon);
        popupMenu.add(menuPeche);
        popupMenu.add(menuSalade);
        popupMenu.add(menuTomate);
        popupMenu.add(menuRecolte);
        //ajouterEcouteurClavier(); // si besoin


    }
    // affichages des données de la météos début



    // affichages des données de la météos fin
/*
    private void ajouterEcouteurClavier() {
        addKeyListener(new KeyAdapter() { // new KeyAdapter() { ... } est une instance de classe anonyme, il s'agit d'un objet qui correspond au controleur dans MVC
            @Override
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyCode()) {  // on regarde quelle touche a été pressée
                    case KeyEvent.VK_LEFT : Controle4Directions.getInstance().setDirectionCourante(Direction.gauche); break;
                    case KeyEvent.VK_RIGHT : Controle4Directions.getInstance().setDirectionCourante(Direction.droite); break;
                    case KeyEvent.VK_DOWN : Controle4Directions.getInstance().setDirectionCourante(Direction.bas); break;
                    case KeyEvent.VK_UP : Controle4Directions.getInstance().setDirectionCourante(Direction.haut); break;
                }
            }
        });
    }
*/

    private void chargerLesIcones() {
    	// image libre de droits utilisée pour les légumes : https://www.vecteezy.com/vector-art/2559196-bundle-of-fruits-and-vegetables-icons
        icoSalade = chargerIcone("Images/data.png", 0, 0, 120, 120);
        icoAnanas = chargerIcone("Images/data.png", 2374, 781, 120, 120);
        icoChampignon = chargerIcone("Images/data.png", 396, 0, 120, 120);
        icoBanane = chargerIcone("Images/data.png", 1951, 1169, 120, 120);
        icoTomate = chargerIcone("Images/data.png", 3121, 1169, 120, 120);
        icoCerise = chargerIcone("Images/data.png", 1953, 789, 120, 120);
        icoPeche = chargerIcone("Images/data.png", 1169, 1192, 120, 120);
        icoCarrotte = chargerIcone("Images/data.png",395,391,120,120);
        icoVide = chargerIcone("Images/Vide.png");
        icoMur = chargerIcone("Images/Mur.png");
        icoTerre = chargerIcone("Images/Terre.png");
        IcoRecolte = chargerIcone("Images/main.svg.png");
    }

    private void placerLesComposantsGraphiques() {
        setTitle("A vegetable garden");
        setSize(1100, 525);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // permet de terminer l'application à la fermeture de la fenêtre
        JPanel infos = new JPanel();
        // affichages des données de la météos début
        // todo afficher les données du simulateur météo
        Point current = new Point(0,0);// on recupere la meteo
        infos.add(texte_precipitation);
        infos.add(valeur_precipitation);
        infos.add(texte_temperature);
        infos.add(valeur_temperature);
        infos.add(texte_legume);

        infos.add(texte_argent);
        // affichages des données de la météos fin
        add(infos, BorderLayout.EAST);




        JComponent grilleJLabels = new JPanel(new GridLayout(sizeY, sizeX)); // grilleJLabels va contenir les cases graphiques et les positionner sous la forme d'une grille

        tabJLabel = new JLabel[sizeX][sizeY];

        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                JLabel jlab = new JLabel();

                tabJLabel[x][y] = jlab; // on conserve les cases graphiques dans tabJLabel pour avoir un accès pratique à celles-ci (voir mettreAJourAffichage() )
                grilleJLabels.add(jlab);
            }
        }
        add(grilleJLabels, BorderLayout.CENTER);

        // écouter les évènements
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                final int xx = x; // constantes utiles au fonctionnement de la classe anonyme
                final int yy = y;

                tabJLabel[x][y].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        //les évenements lorsqu'on clique sur une case

                        // on recupère la case sur laquelle on a cliqué
                        Point point = new Point(xx,yy);
                        Case caseGotten = simulateurPotager.objetALaPosition(point);
                        // si la case est cultivable on affiche le menu d'option
                        if(simulateurPotager.isCultivable(caseGotten)) {
                            popupMenu.show(tabJLabel[xx][yy], e.getX(), e.getY());
                            x_actu=xx;
                            y_actu=yy;
                            // si il a deja un legume sur sur la case on peut pas planter
                            if(simulateurPotager.isPresentLegume((CaseCultivable) caseGotten)) {
                                a_deja_legume=true;
                            }
                            else {
                                // si il a pas de legume on peut planter
                                a_deja_legume=false;
                            }

                        }

                    }
                });
            }
        }
        //on ajoute à chaque option du menu le même listener
        menuAnanas.addActionListener(menuListener);
        menuBanane.addActionListener(menuListener);
        menuCarrotte.addActionListener(menuListener);
        menuCerise.addActionListener(menuListener);
        menuChampignon.addActionListener(menuListener);
        menuPeche.addActionListener(menuListener);
        menuSalade.addActionListener(menuListener);
        menuTomate.addActionListener(menuListener);
        menuRecolte.addActionListener(menuListener);

    }

//les traitements des différentes option du menu déroulant
    ActionListener menuListener = new ActionListener() {
    //action pour Ananas
        public void actionPerformed(ActionEvent event) {
            if(event.getActionCommand()=="Ananas") {
                if(!a_deja_legume) {
                    System.out.println("on plante un Ananas ");
                    simulateurPotager.actionUtilisateur(x_actu,y_actu,"ANANAS");
                    // on met à jours l'affichage
                    mettreAJourAffichage();
                }
                else {
                    System.out.println("il a deja un legume sur cette case");
                }
            }
            // Action pour Banane
            if(event.getActionCommand()=="Banane") {
                if(!a_deja_legume) {
                    System.out.println("on plante une Banane ");
                    simulateurPotager.actionUtilisateur(x_actu,y_actu,"BANANE");
                }
                else {
                    System.out.println("il a deja un legume sur cette case");
                }
            }
            //Action pour Carrotte
            if(event.getActionCommand()=="Carrotte") {
                if(!a_deja_legume) {
                    System.out.println("on plante une Carrotte ");
                    simulateurPotager.actionUtilisateur(x_actu,y_actu,"CARROTTE");
                }
                else {
                    System.out.println("il a deja un legume sur cette case");
                }
            }
            //Action pour Cerise
            if(event.getActionCommand()=="Cerise") {
                if(!a_deja_legume) {
                    System.out.println("on plante une Cerise ");
                    simulateurPotager.actionUtilisateur(x_actu,y_actu,"CERISE");
                }
                else {
                    System.out.println("il a deja un legume sur cette case");
                }
            }
            // Action pour Champignon
            if(event.getActionCommand()=="Champignon") {
                if(!a_deja_legume) {
                    System.out.println("on plante un Champignon ");
                    simulateurPotager.actionUtilisateur(x_actu,y_actu,"CHAMPIGNON");
                }
                else {
                    System.out.println("il a deja un legume sur cette case");
                }
            }
            // Action pour Peche
            if(event.getActionCommand()=="Peche") {
                if(!a_deja_legume) {
                    System.out.println("on plante une peche ");
                    simulateurPotager.actionUtilisateur(x_actu,y_actu,"PECHE");
                }
                else {
                    System.out.println("il a deja un legume sur cette case");
                }
            }
            // Action pour salade
            if(event.getActionCommand()=="Salade") {
                if(!a_deja_legume) {
                    System.out.println("on plante une salade ");
                    simulateurPotager.actionUtilisateur(x_actu,y_actu,"SALADE");
                }
                else {
                    System.out.println("il a deja un legume sur cette case");
                }
            }
            //action pour tomate
            if(event.getActionCommand()=="Tomate") {
                if(!a_deja_legume) {
                    System.out.println("on plante une tomate ");
                    simulateurPotager.actionUtilisateur(x_actu,y_actu,"TOMATE");
                }
                else {
                    System.out.println("il a deja un legume sur cette case");
                }
            }
            //action pour Récolter
            if(event.getActionCommand()=="récolter") {
                if(a_deja_legume) {// si il a un legume on peut le recolter
                    Point point = new Point(x_actu,y_actu);
                    Case case_actu = simulateurPotager.objetALaPosition(point);
                    Legume leg = case_actu.getLegumeCaseCultivable();
                    System.out.println("on récolte un " + leg.getVariete());
                    simulateurPotager.actionUtilisateur(x_actu,y_actu,"TERRE");
                }
                else {
                    System.out.println("il n'y a aucun legume à récolter");
                }

            }
        }
    };






    /**
     * Il y a une grille du côté du modèle ( jeu.getGrille() ) et une grille du côté de la vue (tabJLabel)
     */
    //TODO ajouter un argument qui change aussi la meteo ou pas
    //
    private void mettreAJourAffichage() {
        System.out.println("on met à jour l'affichage **************************************************");
       // while(true) {
            //on change la meteo
            //this.simulateurPotager.getSimMet().run();
            valeur_precipitation.setText(String.valueOf(simulateurPotager.objetALaPosition(new Point(0, 0)).getPrécipitations() + " %"));
            valeur_temperature.setText(String.valueOf(simulateurPotager.objetALaPosition(new Point(0, 0)).getEnsolleillement() + " °"));

            for (int x = 0; x < sizeX; x++) {
                for (int y = 0; y < sizeY; y++) {
                    if (simulateurPotager.getPlateau()[x][y] instanceof CaseCultivable) { // si la grille du modèle contient un Pacman, on associe l'icône Pacman du côté de la vue

                        Legume legume = ((CaseCultivable) simulateurPotager.getPlateau()[x][y]).getLegume();

                        if (legume != null) {

                            switch (legume.getVariete()) {
                                case CARROTTE:
                                    tabJLabel[x][y].setIcon(icoCarrotte);
                                    break;
                                case SALADE:
                                    tabJLabel[x][y].setIcon(icoSalade);
                                    break;

                                case TOMATE:
                                    tabJLabel[x][y].setIcon(icoTomate);
                                    break;
                                case CHAMPIGNON:
                                    tabJLabel[x][y].setIcon(icoChampignon);
                                    break;
                                case PECHE:
                                    tabJLabel[x][y].setIcon(icoPeche);
                                    break;
                                case BANANE:
                                    tabJLabel[x][y].setIcon(icoBanane);
                                    break;
                                case ANANAS:
                                    tabJLabel[x][y].setIcon(icoAnanas);
                                    break;
                                case CERISE:
                                    tabJLabel[x][y].setIcon(icoCerise);
                                    break;
                            }

                        } else {
                            tabJLabel[x][y].setIcon(icoTerre);
                        }

                        // si transparence : images avec canal alpha + dessins manuels (voir ci-dessous + créer composant qui redéfinie paint(Graphics g)), se documenter
                        //BufferedImage bi = getImage("Images/smick.png", 0, 0, 20, 20);
                        //tabJLabel[x][y].getGraphics().drawImage(bi, 0, 0, null);
                    } else if (simulateurPotager.getPlateau()[x][y] instanceof CaseNonCultivable) {
                        tabJLabel[x][y].setIcon(icoMur);
                    } else {

                        tabJLabel[x][y].setIcon(icoVide);
                    }
                }
            }

        //}

    }


    // méthode appélées quand l'ordonanceur prévient d'un changement
    @Override
    public void update(Observable o, Object arg) {
       mettreAJourAffichage();
       // SwingUtilities.invokeLater(new Runnable() {
                  //  @Override
                /*    public void run() {
                        System.out.println("MAJ de l'affichage *******************************************************");
                        mettreAJourAffichage();
                    }*/
            //    });


    }


    // chargement de l'image entière comme icone
    private ImageIcon chargerIcone(String urlIcone) {
        BufferedImage image = null;

        try {
            image = ImageIO.read(new File(urlIcone));
        } catch (IOException ex) {
            Logger.getLogger(VueControleurPotager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }


        return new ImageIcon(image);
    }

    // chargement d'une sous partie de l'image
    private ImageIcon chargerIcone(String urlIcone, int x, int y, int w, int h) {
        // charger une sous partie de l'image à partir de ses coordonnées dans urlIcone
        BufferedImage bi = getSubImage(urlIcone, x, y, w, h);
        // adapter la taille de l'image a la taille du composant (ici : 20x20)
        return new ImageIcon(bi.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
    }

    private BufferedImage getSubImage(String urlIcone, int x, int y, int w, int h) {
        BufferedImage image = null;

        try {
            File f = new File(urlIcone);
            image = ImageIO.read(new File(urlIcone));
        } catch (IOException ex) {
            Logger.getLogger(VueControleurPotager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        BufferedImage bi = image.getSubimage(x, y, w, h);
        return bi;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*
        Point point = new Point(xx,yy);
        Case caseGotten = simulateurPotager.objetALaPosition(point);
        // if(!pointArrayList.contains(point)){//si
        if(simulateurPotager.isCultivable(caseGotten)){//
            if(simulateurPotager.isPresentLegume((CaseCultivable) caseGotten)){
                JOptionPane.showMessageDialog(popupMenu,"Il y a deja un legume!");
            }
            else{
                simulateurPotager.actionUtilisateur(xx,yy,"ANANAS");
                JOptionPane.showMessageDialog(popupMenu,"Un ananas est potagé");
                pointArrayList.add(point);


            }
        }

    }*/
    }


//fin de la class
}
