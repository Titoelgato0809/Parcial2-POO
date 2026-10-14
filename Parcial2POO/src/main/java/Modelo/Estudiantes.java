/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Titoelgato
 */
public class Estudiantes extends Persona {
    
    private String codigoEstudiantil;

    public Estudiantes(String codigoEstudiantil, String nombre, String direccion, String telefono, Fecha fechaNacimiento) {
        super(nombre, direccion, telefono, fechaNacimiento);
        this.codigoEstudiantil = codigoEstudiantil;
    }

    
    
}
