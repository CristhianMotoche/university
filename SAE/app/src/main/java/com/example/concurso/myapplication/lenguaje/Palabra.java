package com.example.concurso.myapplication.lenguaje;

/**
 * Created by Concurso on 03/06/2016.
 */
public class Palabra {
    private String palabra;
    private String silabas;

    public Palabra() {
    }

    public Palabra(String palabra, String silabas) {
        this.palabra = palabra;
        this.silabas = silabas;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getSilabas() {
        return silabas;
    }

    public void setSilabas(String silabas) {
        this.silabas = silabas;
    }



}
