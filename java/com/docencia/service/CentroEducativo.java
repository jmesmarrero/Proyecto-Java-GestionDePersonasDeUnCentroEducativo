package com.docencia.service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.docencia.model.Alumno;
import com.docencia.model.Persona;
import com.docencia.model.Profesor;

public class CentroEducativo {
    private List<Persona> personas;
    private Set<String> documentosRegistrados;
    private Set<String> emailsRegistrados;

    public CentroEducativo() {
        personas = new ArrayList<>();
        documentosRegistrados = new HashSet<>();
        emailsRegistrados = new HashSet<>();
    }

    public void registraPersonas(Persona persona) {

        if (persona == null || persona.getId() <= 0) {
            throw new IllegalArgumentException();
        }
        if (personas.contains(persona)) {
            throw new IllegalArgumentException();
        }

        //////////////////////////////////////////////////

        if (documentosRegistrados.contains(persona.getDocumento())) {
            throw new IllegalArgumentException("Documento duplciado: " + persona.getDocumento());
        }

        if (emailsRegistrados.contains(persona.getEmail())) {
            throw new IllegalArgumentException("Email duplicado: " + persona.getEmail());
        }
        for (Persona existe : personas) {
            if (existe.getId() == persona.getId()) {
                throw new IllegalArgumentException("Id duplicado: " + persona.getId());
            }

        }

        personas.add(persona);
        documentosRegistrados.add(persona.getDocumento());
        emailsRegistrados.add(persona.getEmail());
    }

    public List<Persona> listarPersonas() {
        return new ArrayList<>(personas);
    }

    public Persona buscarPorId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Formato id inválido");
        }

        for (Persona personaValida : personas) {
            if (personaValida.getId() == id) {
                return personaValida;
            }

        }
        return null;

        // Persona personaABuscar = new Alumno(id);
        // int posicion= personas.indexOf(personaABuscar);
        // if(posicion < 0){
        // return null;
        // }
        // return personas.get(posicion);

    }

    public Persona buscarPorDocumento(String documento) {
        if (documento == null || documento.isBlank()) {
            throw new IllegalArgumentException("Camplo obligatorio");
        }
        if (!documentosRegistrados.contains(documento)) {
            return null;
        }

        for (Persona documentoValido : personas) {
            if (documentoValido.getDocumento().equals(documento)) {
                return documentoValido;
            }

        }
        return null;

    }

    public List<Alumno> listarAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();

        for (Persona alumPersona : personas) {
            if (alumPersona instanceof Alumno) {
                alumnos.add((Alumno) alumPersona);
            }
        }

        return alumnos;

    }

    public List<Profesor> listarProfesor() {
        List<Profesor> profesores = new ArrayList<>();

        for (Persona profPersona : personas) {
            if ("PROFESOR".equals(profPersona.getTipo())) {
                profesores.add((Profesor) profPersona);
            }

        }

        return profesores;

    }

    public void registrarPersona(Alumno alumno) {
        registraPersonas(alumno); 
    }

    public void registrarPersona(Profesor profesor) {
        registraPersonas(profesor);
    }

    

    

    

}
