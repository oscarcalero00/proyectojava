package patrones.facade.GameFacade;

import java.io.IOException;
import java.util.ArrayList;
import excepciones.NicknameYaExisteException;
import game.Jugador;
import game.Jugadores;
import game.Partida;
import patrones.observer.operationobserver.OperationTopic;
import patrones.singleton.constantes.Constantes;

public class GameFacade {

	Jugadores jugadores;

	OperationTopic operationTopic;

	public GameFacade(){

		jugadores = new Jugadores();

		operationTopic = new OperationTopic();

	}
	
	public OperationTopic getOperationTopic(){

		return this.operationTopic;

	}

	public void addJugador(String nombre, String nickname) throws NicknameYaExisteException, IOException {

		jugadores.agregarJugador(nombre, nickname);

		jugadores.setJugadorActual(nombre);

		this.operationTopic.postMessage(Constantes.getInstance().ACTIONJUGADORCREADO);

	}

	public void selectJugador(String nombre)  {

		jugadores.setJugadorActual(nombre);

		this.operationTopic.postMessage(Constantes.getInstance().ACTIONJUGADORSELECCIONADO);

	}

	public ArrayList<Jugador> getJugadores()  {		

		return jugadores.getJugadores();

	}

	public Jugador getJugadorActual()  {		

		return jugadores.getJugadorActual();

	}

	public ArrayList<Jugador> getOrdenadosPorNickname()  {		

		return jugadores.getOrdenadosPorNickname();

	}


	public boolean addPartida(String nombre) {

		Jugador jugadorActual = jugadores.getJugadorActual();

		if(jugadorActual!=null){
			jugadorActual.addPartida(new Partida(nombre));
			jugadorActual.setPartidaActual(nombre);

			try {
				jugadores.serializarJugador();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//jugadores.setJugadorActual(nombre);

		//this.operationTopic.postMessage(Constantes.getInstance().ACTIONJUGADORCREADO);
		return true;
	}

	public void selectPartida(String nombre)  {

		Jugador jugadorActual = jugadores.getJugadorActual();

		if(jugadorActual!=null){			

			jugadorActual.setPartidaActual(nombre);

			try {
				jugadores.serializarJugador();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		this.operationTopic.postMessage(Constantes.getInstance().ACTIONPARTIDASELECCIONADA);

	}

	public ArrayList<Partida> getPartidasOrdenadas()  {		
		Jugador jugadorActual = jugadores.getJugadorActual();
		if(jugadorActual==null){
			return new ArrayList<Partida>();
		}else{
			return jugadorActual.getPartidasOrdenadas();
		}
	}

	public Jugador searchByNickName(String nickname)  {		

		return jugadores.buscarJugador(nickname);

	}

	

}