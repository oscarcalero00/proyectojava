package game;

import java.io.Serializable;

import javax.swing.ImageIcon;

import patrones.observer.interfaces.IObserver;


public class Nave implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private int posInicialX;

	private int posIncialY;

	protected int posX;

	protected int posY;

	private int ancho;

	private int alto;

	private String rutaImage;

	private double velocidad;

	ImageIcon imagen ;

	Disparo disparo;

	
    
    
    public Nave() {

		this.velocidad = 0;

		this.posX = 0;

		this.posY = 0;

		
		this.ancho = 0;

		this.alto = 0;

		this.imagen = new ImageIcon("./data/imagenes/Naves/nave.png");


    }
    
    public Nave(double velocidad, int posX, int posY) {

		this.velocidad = velocidad;

		this.posX = posX;

		this.posY = posY;	
	
		this.imagen = new ImageIcon("./data/imagenes/Naves/nave.png");

		this.ancho = imagen.getIconWidth();

		this.alto = imagen.getIconHeight();

		

	}
	
	public ImageIcon getimagen(){

		return this.imagen;

	}
    
    public String getRutaImage() {

		return rutaImage;

	}

	public void setRutaImage(String rutaImage) {

		this.rutaImage = rutaImage;

    }
    
	public int getPosInicialX() {

		return this.posInicialX;

	}
	
	public void setPosInicialX(int posInicialX) {

		this.posInicialX = posInicialX;

	}
	
	public int getPosIncialY() {

		return this.posIncialY;

	}
	
	public void setPosIncialY(int posIncialY) {

		this.posIncialY = posIncialY;

	}
	
	
	public double getVelocidad() {

		return this.velocidad;

	}
	
	public void setVelocidad(double velocidad) {

		this.velocidad = velocidad;

	}

	
	public int getPosX() {

		return this.posX;

	}

	
	public void setPosX(int posX) {

		this.posX = posX;

	}

	
	public int getPosY() {

		return this.posY;

	}

	
	public void setPosY(int posY) {

		this.posY = posY;

	}

		
	public void setAncho(int ancho) {

		this.ancho = ancho;

	}

	
	public int getAncho() {

		return this.ancho;

	}
	
	public int getAlto() {

		return this.alto;

	}

	
	public void setAlto(int alto) {

		this.alto = alto;

	}
		

	public void mover(int dir) {
		
		int posXanterior = posX ;

		posX += dir * 10.0d;

		if(posX < 0 ){

			posX = posXanterior;

		}

		if(posX > 600 ){

			posX = posXanterior;

		}

	}

	public void resetear() {
	}
	
	public void disparar(IObserver observador){

		disparo = new Disparo(getPosX(), getPosY(),1,observador);

		disparo.start();

	}

	public Disparo getDisparo(){

		return disparo;

	}
	
	
	
}