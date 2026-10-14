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
        
        public String reporteEstudiantes() {
        String reporte = "REPORTE DE ESTUDIANTES\n\n";

        for (int i = 0; i < cantidadEstudiantes; i++) {
            Estudiantes e = estudiantes[i];
            reporte += (i + 1) + ". " + e.getNombre() + "\n";
            reporte += "   Código: " + e.getCodigoEstudiantil() + "\n";
            reporte += "   Dirección: " + e.getDireccion() + "\n";
            reporte += "   Teléfono: " + e.getTelefono() + "\n";
            reporte += "   Nacimiento: " + e.getFechaNacimiento().getDia() + "/"
                    + e.getFechaNacimiento().getMes() + "/"
                    + e.getFechaNacimiento().getAnio() + "\n\n";
        }

        reporte += "Total de estudiantes: " + cantidadEstudiantes + "\n";
        return reporte;
    }
        
        public String reporteEstudiantes() {
        String reporte = "REPORTE DE ESTUDIANTES\n\n";

        for (int i = 0; i < cantidadEstudiantes; i++) {
            Estudiantes e = estudiantes[i];
            reporte += (i + 1) + ". " + e.getNombre() + "\n";
            reporte += "   Código: " + e.getCodigoEstudiantil() + "\n";
            reporte += "   Dirección: " + e.getDireccion() + "\n";
            reporte += "   Teléfono: " + e.getTelefono() + "\n";
            reporte += "   Nacimiento: " + e.getFechaNacimiento().getDia() + "/"
                    + e.getFechaNacimiento().getMes() + "/"
                    + e.getFechaNacimiento().getAnio() + "\n\n";
        }

        reporte += "Total de estudiantes: " + cantidadEstudiantes + "\n";
        return reporte;
    }
        
    public String reporteEstudiantes() {
        String reporte = "REPORTE DE ESTUDIANTES\n\n";

        for (int i = 0; i < cantidadEstudiantes; i++) {
            Estudiantes e = estudiantes[i];
            reporte += (i + 1) + ". " + e.getNombre() + "\n";
            reporte += "   Código: " + e.getCodigoEstudiantil() + "\n";
            reporte += "   Dirección: " + e.getDireccion() + "\n";
            reporte += "   Teléfono: " + e.getTelefono() + "\n";
            reporte += "   Nacimiento: " + e.getFechaNacimiento().getDia() + "/"
                    + e.getFechaNacimiento().getMes() + "/"
                    + e.getFechaNacimiento().getAnio() + "\n\n";
        }
        reporte += "Total de estudiantes: " + cantidadEstudiantes + "\n";
        return reporte;
    }
        public String reporteProfesoresPorSalario() {
        String reporte = "REPORTE DE PROFESORES (de mayor a menor pago)\n\n";

        // Copia de los profesores registrados para ordenarlos
        Profesores[] ordenados = new Profesores[cantidadProfesores];
        for (int i = 0; i < cantidadProfesores; i++) {
            ordenados[i] = profesores[i];
        }

        // Ordenamiento burbuja de mayor a menor pago
        for (int i = 0; i < ordenados.length - 1; i++) {
            for (int j = 0; j < ordenados.length - 1 - i; j++) {
                if (ordenados[j].calcularPagoMensual() < ordenados[j + 1].calcularPagoMensual()) {
                    Profesores temporal = ordenados[j];
                    ordenados[j] = ordenados[j + 1];
                    ordenados[j + 1] = temporal;
                }
            }
        }



}
