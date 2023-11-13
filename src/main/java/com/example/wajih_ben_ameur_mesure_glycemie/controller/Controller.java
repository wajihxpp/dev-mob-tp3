package com.example.wajih_ben_ameur_mesure_glycemie.controller;

import com.example.wajih_ben_ameur_mesure_glycemie.model.Patient;
import com.example.wajih_ben_ameur_mesure_glycemie.view.MainActivity;

public class Controller {

    private MainActivity mainActivity; // Reference to the MainActivity
    private Patient patient;

    public Controller(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        this.patient = new Patient();
    }

    public void handleUserInput(int age, float valeur, boolean isFasting) {
        // Update the Patient model with user input
        patient.setAge(age);
        patient.setValeur(valeur);
        patient.setFasting(isFasting);

        // Perform the calculation using the Patient model
        patient.calculer();

        // Update the UI with the result from the Patient model
        mainActivity.updateUI(patient.getResult());
    }

    // Additional methods for overall application flow
}
