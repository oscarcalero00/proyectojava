package game;

import java.io.Serializable;
import java.util.ArrayList;

public class Jugador implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String nickname;

    private String nombre;

    private ArrayList<Partida> partidasJugador;
    
    private Partida partidaActual = null;

    public Jugador(String nombre, String nickname) {

        super();

        this.nombre = nombre;

        this.nickname = nickname;

        this.partidasJugador = new ArrayList<Partida>();

    }

    public String getNombre() {

        return nombre;

    }

    public void setNombre(String nombre) {

        this.nombre = nombre;

    }

    public String getNickname() {

        return nickname;

    }

    public void setNickname(String nickname) {

        this.nickname = nickname;

    }

    public ArrayList<Partida> getPartidas() {

        return partidasJugador;

    }

    public void addPartida(Partida partida) {

        this.partidasJugador.add(partida);

    }

    public void setPartidaActual(String name) {

		this.partidaActual = buscarPartida(name);

	}

	public Partida getPartidaActual() {

        return partidaActual;
        
    }
    
    public Partida buscarPartida(String name) {

        Partida partidaBuscada = null;
        
		boolean buscado = false;

		for (int i = 0; i < partidasJugador.size() && !buscado; i++) {

			if (partidasJugador.get(i).getName().equalsIgnoreCase(name)) {

                partidaBuscada = partidasJugador.get(i);
                
                buscado = true;
                
            }
            
		}

        return partidaBuscada;
        
	}

    // @SuppressWarnings("unchecked")
    public ArrayList<Partida> getPartidasOrdenadas() {

        ArrayList<Partida> partidasOrdenados = getPartidas();

        if (partidasOrdenados != null) {

            for (int i = 1; i < partidasOrdenados.size(); i++) {

                for (int j = i; j > 0 && partidasOrdenados.get(j - 1).getName()

                        .compareTo(partidasOrdenados.get(j).getName()) > 0; j--) {

                    Partida temp = (Partida) partidasOrdenados.get(j);

                    partidasOrdenados.set(j, partidasOrdenados.get(j - 1));

                    partidasOrdenados.set(j - 1, temp);

                }

            }            

        }

        return partidasOrdenados;
        
    }

}