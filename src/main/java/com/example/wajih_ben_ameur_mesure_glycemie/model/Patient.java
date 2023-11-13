package com.example.wajih_ben_ameur_mesure_glycemie.model;

public class Patient {
    private int age ;
    private float valeur ;
    private boolean isfasting ;
    private String result ;
    //update controller--> model
    public Patient() {
        this.age = age ;
        this.valeur = valeur ;
        this.isfasting = isfasting ;
        calculer();
    }

    private void calculer () {
        if (isfasting) {
            if (age < 6) {
                if (valeur <= 10 && valeur >= 5.5)
                    result = "niveau de glysémie normale";
                else if (valeur < 5.5)
                    result = "niveau de glysémie trop bas";
                else result = "niveau de glysemie trop elevé";
            } else if (age <= 12 && age >= 6) {
                if (valeur <= 10 && valeur >= 5)
                    result = "niveau de glysémie normale";
                else if (valeur < 5)
                    result = "niveau de glysémie trop bas";
                else result = "niveau de glysemie trop elevé";
            } else {
                if (valeur <= 7.2 && valeur >= 5)
                    result = "niveau de glysémie normale";
                else if (valeur < 5)
                    result = "niveau de glysémie trop bas";
                else result = "niveau de glysemie trop elevé";
            }
        } else {
            if (valeur <= 10.5)
                result = "niveau de glysémie normale";
            else result = "niveau de glysemie trop elevé";
        }
    }

    public String getResult(){
        return result;
    }

}
