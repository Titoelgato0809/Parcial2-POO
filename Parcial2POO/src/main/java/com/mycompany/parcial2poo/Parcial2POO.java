/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.parcial2poo;
import Controlador.Controlador;
import Vista.Vista;
/**
 *
 * @author Titoelgato
 */
public class Parcial2POO {

    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        Vista vista = new Vista(controlador);
        vista.setVisible(true);
    }
}
