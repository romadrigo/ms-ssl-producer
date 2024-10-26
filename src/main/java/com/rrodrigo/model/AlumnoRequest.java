package com.rrodrigo.model;

import java.util.Arrays;

public class AlumnoRequest {
    
    private String dni;
    private String nombres;
    private Integer[] notas;

    public AlumnoRequest() {
    }

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public Integer[] getNotas() {
        return notas;
    }
    public void setNotas(Integer[] notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "AlumnoDTO [dni=" + dni + ", nombres=" + nombres + ", notas=" + Arrays.toString(notas) + "]";
    }
    
}
