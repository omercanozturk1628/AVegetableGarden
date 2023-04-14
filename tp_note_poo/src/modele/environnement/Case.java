/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.environnement;

import modele.SimulateurPotager;
import modele.environnement.varietes.Legume;

public abstract class Case implements Runnable {
    protected SimulateurPotager simulateurPotager;

    public void setPrécipitations(int précipitations) {
        this.précipitations = précipitations;
    }

    public void setEnsolleillement(int ensolleillement) {
        this.ensolleillement = ensolleillement;
    }

    public int getPrécipitations() {
        return précipitations;
    }

    public int getEnsolleillement() {
        return ensolleillement;
    }

    private int précipitations;
    private int ensolleillement;

    
    public Case(SimulateurPotager _simulateurPotager) {
        simulateurPotager = _simulateurPotager;
    }

    public abstract void actionUtilisateur();


    //retourne le legume qui se trouve sur une case cultivable
    public Legume getLegumeCaseCultivable() {
        if(this instanceof CaseCultivable){
            return ((CaseCultivable) this).getLegume();
        }
        else {
            return null;
        }
    }


  }
