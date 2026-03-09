package com.docencia.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

import com.docencia.util.Validaciones;

/**
 * @author Jorge Mesa Marrero
 * @version 1.0.0
 */

public abstract class Persona {

    private final int id;
    private String nombre;
    private String documento;
    private String email;
    private LocalDate fechaNacimiento;
    private final LocalDate fechaRegistro;

    /**
     * Constructor con parametro unico
     * 
     * @param id id de la persona
     */
    public Persona(int id) {
        this.id = id;
        fechaRegistro = LocalDate.now();
    }

    /**
     * Constructor con los parametros finales
     * 
     * @param id            id de la persona
     * @param fechaRegistro LocalDate de cuando se registra la persona
     */
    public Persona(int id, LocalDate fechaRegistro) {
        this.id = id;
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Constructor con todos los parametros de la clase
     * 
     * @param id              id de la persona
     * @param nombre          nombre de la persona
     * @param documento       documento de una persona
     * @param email           email de la persona con patron
     * @param fechaNacimiento LocalDate nacimiento de la persona
     * @param fechaRegistro   LocalDate de cuando se registra la persona
     */

    public Persona(int id, String nombre, String documento, String email, LocalDate fechaNacimiento,
            LocalDate fechaRegistro) {
        if (id <= 0) {
            throw new IllegalArgumentException("El id no es válido");
        }
        this.id = id;
        if (fechaRegistro == null || fechaRegistro.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("fecha inválida");
        }
        this.fechaRegistro = fechaRegistro;
        setNombre(nombre);
        this.documento = documento;
        this.email = email;
        setFechaNacimiento(fechaNacimiento);

    }

   

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().length() < 2) {
            throw new IllegalArgumentException("Nombre invalido");
        }
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        Validaciones va1 = new Validaciones();
        va1.documentoValido(documento);
        this.documento = documento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Validaciones va2 = new Validaciones();
        va2.emailValido(email);
        this.email = email;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {

        if (fechaNacimiento == null || fechaNacimiento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Fecha nacimiento inválida");
        }
        this.fechaNacimiento = fechaNacimiento;
    }

    public final LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Metodos
     * 
     * @return
     */
    public int getEdad() {
        if (fechaNacimiento == null) {
            throw new IllegalArgumentException("Campo inválido");

        }
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }
    /**
     * metodo abstracto para definir en las subclases 
     * @return
     */
    public abstract String getTipo();

    // hash & equals
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null)
            return false;
        if (this == obj)
            return true;

        if (getClass() != obj.getClass())
            return false;
        Persona other = (Persona) obj;
        return id == other.id;
    }

    @Override
    public String toString() {
        return "Persona [id=" + id + ", nombre=" + nombre + ", documento=" + documento + ", email=" + email
                + ", fechaNacimiento=" + fechaNacimiento + ", fechaRegistro=" + fechaRegistro + "]";
    }

}
