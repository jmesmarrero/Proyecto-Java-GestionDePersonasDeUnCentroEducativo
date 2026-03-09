package com.docencia.model;

import java.time.LocalDate;
/**
 * @author Jorge Mesa Marrero
 * @version 1.0.0
 * Funcion apra crear la persona profesor
 */
public class Profesor extends Persona {

    private String departamento;

    /**
     * Constructor del padre con parametro unico
     * @param id identificador unico
     */
    public Profesor(int id) {
        super(id);
    }

/**
 * Constructor con parametros finales del padre
 * @param id identificador unico
 * @param fechaRegistro Localdate fechaRegistro
 */
    public Profesor(int id, LocalDate fechaRegistro) {
        super(id, fechaRegistro);
    }

    /**
     * Constructor con todos los parametros
     * @param id identificador único
     * @param nombre nombre de la persona
     * @param documento documento de la persona
     * @param email email dado por la persona
     * @param fechaNacimiento LocalDate calculable
     * @param fechaRegistro Localdate del momento de registro
     * @param departamento String departamento que pertenece el profesor
     */
    public Profesor(int id, String nombre, String documento, String email,
            LocalDate fechaNacimiento, LocalDate fechaRegistro,
            String departamento) {
        super(id, nombre, documento, email, fechaNacimiento, fechaRegistro);
        setDepartamento(departamento);
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        if(departamento == null || departamento.length() <=4){
            throw new IllegalArgumentException("departamento no es válido");
        }
        this.departamento = departamento;
    }
    
    @Override
    public String getTipo(){
        return "PROFESOR";
    }
}
