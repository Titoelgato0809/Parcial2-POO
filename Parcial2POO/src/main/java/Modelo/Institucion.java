/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Titoelgato
 */
public class Institucion {
    private Estudiantes[] estudiantes;
    private Profesores[] profesores;
    
    private int cantidadEstudiantes;
    private int cantidadProfesores;
    
    public Institucion() {
        estudiantes = new Estudiantes[100];
        profesores = new Profesores[100];

        cantidadEstudiantes = 0;
        cantidadProfesores = 0;
    }
    
        public boolean registrarEstudiante(Estudiantes estudiante) {
        if (cantidadEstudiantes < estudiantes.length) {
            estudiantes[cantidadEstudiantes] = estudiante;
            cantidadEstudiantes++;
            return true;
        }
        return false;
    }
        
        public boolean registrarProfesor(Profesores profesor) {
        if (cantidadProfesores < profesores.length) {
            profesores[cantidadProfesores] = profesor;
            cantidadProfesores++;
            return true;
        }
        return false;
    }
}
