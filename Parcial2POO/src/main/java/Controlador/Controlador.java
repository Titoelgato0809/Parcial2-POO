package Controlador;

import Modelo.Estudiantes;
import Modelo.Fecha;
import Modelo.Institucion;
import Modelo.Profesores;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

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

        validarNombre(nombre);
        validarDireccion(direccion);
        validarTelefono(telefono);
        validarFechaNacimiento(dia, mes, anio);
        validarCodigoEstudiantil(codigoEstudiantil);
        validarCodigoNoRepetido(codigoEstudiantil.trim());

        Fecha fecha = new Fecha(dia, mes, anio);

        Estudiantes estudiante = new Estudiantes(
                codigoEstudiantil.trim(),
                nombre.trim(),
                direccion.trim(),
                telefono.trim(),
                fecha
        );

        return institucion.registrarEstudiante(estudiante);
    }

    public boolean registrarProfesores(String nombre,
            String direccion, String telefono,
            int dia, int mes, int anio,
            String cedula, String areaTrabajo,
            double salarioPorHora, int horasTrabajadas) {

        validarNombre(nombre);
        validarDireccion(direccion);
        validarTelefono(telefono);
        LocalDate nacimiento = validarFechaNacimiento(dia, mes, anio);
        if (Period.between(nacimiento, LocalDate.now()).getYears() < 18) {
            throw new IllegalArgumentException("El profesor debe ser mayor de edad.");
        }
        validarCedula(cedula);
        validarArea(areaTrabajo);
        validarSalario(salarioPorHora);
        validarHoras(horasTrabajadas);
        validarCedulaNoRepetida(cedula.trim());

        Fecha fecha = new Fecha(dia, mes, anio);

        Profesores profesor = new Profesores(
                cedula.trim(),
                areaTrabajo.trim(),
                0,
                horasTrabajadas,
                salarioPorHora,
                nombre.trim(),
                direccion.trim(),
                telefono.trim(),
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


    private void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty() || !nombre.trim().matches("[\\p{L} ]+")) {
            throw new IllegalArgumentException("El nombre solo puede contener letras y espacios.");
        }
    }

    private void validarDireccion(String direccion) {
        if (direccion == null || direccion.trim().isEmpty()) {
            throw new IllegalArgumentException("La dirección no puede estar vacía.");
        }
    }

    private void validarTelefono(String telefono) {
        if (telefono == null || !telefono.trim().matches("\\d{7,10}")) {
            throw new IllegalArgumentException("El teléfono debe tener solo números (7 a 10 dígitos).");
        }
    }


    private LocalDate validarFechaNacimiento(int dia, int mes, int anio) {
        LocalDate fecha;
        try {
            fecha = LocalDate.of(anio, mes, dia);
        } catch (DateTimeException ex) {
            throw new IllegalArgumentException("La fecha de nacimiento no es válida (revisa día, mes y año).");
        }
        if (fecha.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser futura.");
        }
        return fecha;
    }

    private void validarCodigoEstudiantil(String codigo) {
        if (codigo == null || !codigo.trim().matches("\\d{4,12}")) {
            throw new IllegalArgumentException("El código debe tener solo números (4 a 12 dígitos).");
        }
    }

    private void validarCedula(String cedula) {
        if (cedula == null || !cedula.trim().matches("\\d{6,10}")) {
            throw new IllegalArgumentException("La cédula debe tener solo números (6 a 10 dígitos).");
        }
    }

    private void validarArea(String area) {
        if (area == null || area.trim().isEmpty()) {
            throw new IllegalArgumentException("El área no puede estar vacía.");
        }
    }

    private void validarSalario(double salarioPorHora) {
        if (salarioPorHora <= 0) {
            throw new IllegalArgumentException("El salario por hora debe ser mayor que cero.");
        }
    }

    private void validarHoras(int horas) {
        if (horas < 0 || horas > 250) {
            throw new IllegalArgumentException("Las horas dictadas deben estar entre 0 y 250 al mes.");
        }
    }


    private void validarCodigoNoRepetido(String codigo) {
        for (int i = 0; i < institucion.getCantidadEstudiantes(); i++) {
            if (institucion.getEstudiantes()[i].getCodigoEstudiantil().equals(codigo)) {
                throw new IllegalArgumentException("Ya existe un estudiante con ese código.");
            }
        }
    }

    private void validarCedulaNoRepetida(String cedula) {
        for (int i = 0; i < institucion.getCantidadProfesores(); i++) {
            if (institucion.getProfesores()[i].getCedula().equals(cedula)) {
                throw new IllegalArgumentException("Ya existe un profesor con esa cédula.");
            }
        }
    }
}