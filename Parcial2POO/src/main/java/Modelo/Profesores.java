/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Titoelgato
 */
public class Profesores extends Persona {
   
    private String cedula;
    private String areaTrabajo;
    private double pagoMensual;
    private int horasTrabajadas;
    private double salarioPorHora;

    public Profesores(String cedula, String areaTrabajo, double pagoMensual, int horasTrabajadas, double salarioPorHora, String nombre, String direccion, String telefono, Fecha fechaNacimiento) {
        super(nombre, direccion, telefono, fechaNacimiento);
        this.cedula = cedula;
        this.areaTrabajo = areaTrabajo;
        this.pagoMensual = pagoMensual;
        this.horasTrabajadas = horasTrabajadas;
        this.salarioPorHora = salarioPorHora;
    }

    public String getCedula() {
        return cedula;
    }

    public String getAreaTrabajo() {
        return areaTrabajo;
    }

    public double getPagoMensual() {
        return pagoMensual;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public double getSalarioPorHora() {
        return salarioPorHora;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setAreaTrabajo(String areaTrabajo) {
        this.areaTrabajo = areaTrabajo;
    }

    public void setPagoMensual(double pagoMensual) {
        this.pagoMensual = pagoMensual;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public void setSalarioPorHora(double salarioPorHora) {
        this.salarioPorHora = salarioPorHora;
    }
    
    public double CalcularPagoMensual(){
        pagoMensual = salarioPorHora * horasTrabajadas;
        pagoMensual = pagoMensual * 1.30;
        return pagoMensual;
    }
    
}
