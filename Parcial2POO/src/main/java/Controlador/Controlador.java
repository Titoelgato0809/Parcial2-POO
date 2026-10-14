
package Controlador;

import Modelo.Estudiantes;
import Modelo.Fecha;
import Modelo.Institucion;
import Modelo.Profesores;

public class Controlador {

    private Institucion institucion;

    public Controlador() {
        institucion = new Institucion();
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }

    public boolean registrarEstudiantes(String nombre,
            String direccion, String telefono,
            int dia, int mes, int anio,
            String codigoEstudiantil) {

        Fecha fecha = new Fecha(dia, mes, anio);

        Estudiantes estudiante = new Estudiantes(
                codigoEstudiantil,
                nombre,
                direccion,
                telefono,
                fecha
        );

        return institucion.registrarEstudiante(estudiante);
    }

    public boolean registrarProfesores(String nombre,
            String direccion, String telefono,
            int dia, int mes, int anio,
            String cedula, String areaTrabajo,
            double salarioPorHora, int horasTrabajadas) {

        Fecha fecha = new Fecha(dia, mes, anio);

        Profesores profesor = new Profesores(
                cedula,
                areaTrabajo,
                0,
                horasTrabajadas,
                salarioPorHora,
                nombre,
                direccion,
                telefono,
                fecha
        );

        return institucion.registrarProfesor(profesor);
    }

    public String reporteEstudiantes() {
        return institucion.reporteEstudiantes();
    }

    public String reporteProfesores() {
        return institucion.reporteProfesoresPorSalario();
    }
}