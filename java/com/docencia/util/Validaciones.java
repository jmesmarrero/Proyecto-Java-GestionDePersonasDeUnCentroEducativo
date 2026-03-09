package com.docencia.util;


/**
 * @author Jorge Mesa Marrero
 * @version 1.0.0
 * Funcion para validar email y documento (no null y patron correcto)
 */
public class Validaciones{

    public String email;
    public String documento;

    // validaciones
    public  boolean emailValido(String email) {
        if (email == null || !email.matches("^[a-zA-Z\\.+_-]+@[a-zA-Z]+\\.[a-z]{2,}$")) {
            throw new IllegalArgumentException("Email es inválido");
        }
        return true;
    }

    public boolean documentoValido(String documento) {
        if (documento == null || !documento.matches("^[0-9]{8}[A-Z]$")) {
            throw new IllegalArgumentException("Documento inválido");
        }
        return true;
    }

}