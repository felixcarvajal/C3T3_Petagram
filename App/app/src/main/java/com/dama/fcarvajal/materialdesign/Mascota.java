package com.dama.fcarvajal.materialdesign;

import java.io.Serializable;

/**
 * Created by fcarvajal on 19/2/2017.
 */

public class Mascota implements Serializable {

    private String nombre;
    private int raiting;
    private int foto;

    public Mascota(String nombre, int raiting, int foto){
        this.nombre = nombre;
        this.raiting = raiting;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRaiting() {
        return raiting;
    }

    public String getRaiting_string() {
        return getRaiting() + "";
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }

    public void setRaiting() {
        this.raiting = this.raiting + 1;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

}
