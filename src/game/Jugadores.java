package game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import excepciones.NicknameYaExisteException;

public class Jugadores implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Jugador jugadorActual = null;

	private ArrayList<Jugador> jugadores;

	public Jugadores() {

		jugadores = new ArrayList<>();

		try {

			deserializarJugador();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void agregarJugador(String nombre, String nickname) throws NicknameYaExisteException, IOException {

		if (buscarJugador(nickname) == null) {
			Jugador agregar = new Jugador(nombre, nickname);
			jugadores.add(agregar);
			jugadorActual = agregar;
			System.out.println("agregarJugador");
			/*
			 * jugadorActual.setPosInicialX(300); jugadorActual.setPosIncialY(410);
			 * jugadorActual.setAncho(30); jugadorActual.setAlto(19); serializarJugador();
			 */
			serializarJugador();
		} else
			throw new NicknameYaExisteException(nickname);

	}

	public Jugador buscarJugador(String nickname) {
		Jugador naveBuscada = null;
		boolean buscado = false;

		for (int i = 0; i < jugadores.size() && !buscado; i++) {
			if (jugadores.get(i).getNickname().equalsIgnoreCase(nickname)) {
				naveBuscada = jugadores.get(i);
				buscado = true;
			}
		}

		return naveBuscada;
	}

	public void setJugadorActual(String nombre) {

		this.jugadorActual = buscarJugador(nombre);

	}

	public Jugador getJugadorActual() {
		return jugadorActual;
	}

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public void serializarJugador() throws IOException {

		File archivo = new File("./data/jugador");

		FileOutputStream fos = new FileOutputStream(archivo);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(jugadores);

		oos.close();
		fos.close();

	}

	/**
	 * 
	 * @param ruta
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public void deserializarJugador() throws IOException, ClassNotFoundException {

		File archivo = new File("./data/jugador");

		FileInputStream fis = new FileInputStream(archivo);
		ObjectInputStream ois = new ObjectInputStream(fis);

		jugadores = (ArrayList<Jugador>) ois.readObject();

		ois.close();
		fis.close();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Jugador> getOrdenadosPorNickname() {

		ArrayList<Jugador> jugadoresOrdenados = (ArrayList<Jugador>) jugadores.clone();

		if (jugadores != null) {
			for (int i = 1; i < jugadoresOrdenados.size(); i++) {
				for (int j = i; j > 0 && jugadoresOrdenados.get(j - 1).getNickname()
						.compareTo(jugadoresOrdenados.get(j).getNickname()) > 0; j--) {
					Jugador temp = (Jugador) jugadoresOrdenados.get(j);
					jugadoresOrdenados.set(j, jugadoresOrdenados.get(j - 1));
					jugadoresOrdenados.set(j - 1, temp);
				}
			}

		}
		return jugadoresOrdenados;
	}

	/*
	 * public void actualizarJugadores() { ArrayList<NaveJugador> jugadores =
	 * mundo.getJugadores(); if (jugadores == null) jugadores = new ArrayList<>();
	 * panelMenu.getDialogoSeleccionarJugador().cambiarListaJugadores(jugadores); }
	 */
}