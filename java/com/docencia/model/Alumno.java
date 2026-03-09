package com.docencia.model;

import java.time.LocalDate;
import java.util.Set;
/**
 * @author Jorge Mesa Marrero
 * @version 1.0.0
 * 
 */
public class Alumno extends Persona {

    private String curso;
    private Set<String> modulos;

    
    /**
     * Constructor con parametro unico
     * @param id identificador único
     */
    public Alumno(int id) {
        super(id);
    }

    /**
     * Constructor con todos los parametros de la clase padre y clase ALumno
     * @param id identificador único
     * @param nombre nombre de la persona
     * @param documento documento de la persona
     * @param email email dado por la persona
     * @param fechaNacimiento LocalDate calculable
     * @param fechaRegistro Localdate del momento de registro
     * @param curso curso que esta el alumno
     * @param modulos modulos que imparte el alumno
     */
    public Alumno(int id, String nombre, String documento, String email,
              LocalDate fechaNacimiento, LocalDate fechaRegistro,
              String curso, Set<String> modulos){
                super(id, nombre, documento, email, fechaNacimiento, fechaRegistro);
                setCurso(curso);
                this.modulos =modulos;
                
            }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        if(curso == null || curso.length() <=3){
            throw new IllegalArgumentException("Curso inválido");
        }
        this.curso = curso;
    }

    public Set<String> getModulos() {
        return modulos;
    }

    public void setModulos(Set<String> modulos) {
        this.modulos = modulos;
    }

    @Override
    public String getTipo(){
        return "ALUMNO";
    }

    public boolean addModulo(String modulo){
           if(modulos == null || modulo.trim().length() <= 2){
            return false;
        }
        return modulos.add(modulo);
    }

    public boolean removeModulo(String modulo){
        if(modulo == null){
            return false;
        }
        return modulos.remove(modulo);
    }



}