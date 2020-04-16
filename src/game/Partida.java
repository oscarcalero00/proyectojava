package game;

import java.io.Serializable;

public class Partida implements Serializable {

    /**
     *
     */

    private static final long serialVersionUID = 1L;

    private String name;

    private int    puntaje;

    private int    vidas;

    private Nave   nave;

    public Partida(String name){

        this.name = name;

        this.puntaje = 100;

        this.vidas = 3;

        this.nave = new Nave (0,100,420);

    }

    public Nave getNave(){

        return nave;

    }

    public String getName(){

        return this.name;

    }

    public void setName(String name){

        this.name = name ;

    }

    public int getPuntaje(){

        return this.puntaje;

    }

    public void setPuntaje(int puntaje){

        this.puntaje = puntaje;

    }

    public int getVidas(){

        return this.vidas;

    }

    public void setVidas(int vidas){

        this.vidas = vidas;

    }

}