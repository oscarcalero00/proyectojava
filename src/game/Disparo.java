package game;

import java.io.Serializable;

import patrones.observer.disparoobserver.DisparoObserver;
import patrones.observer.interfaces.IObserver;

public class Disparo  extends Thread  implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean impacto;

	private int posX;

	private int posY;

	private int type;

	private boolean isActive;

	DisparoObserver disparoObserver;

	public Disparo(int posX, int posY,int type,IObserver observador) {
		// TODO Auto-generated constructor stub

		isActive = true;

		this.posX = posX;

		this.posY = posY;

		this.type = type;

		impacto = false;

		disparoObserver = new DisparoObserver();

		disparoObserver.register(observador);

		

	}

	@Override
	public void run() {
		while(isActive){
			//System.out.println("Thread Running "+posY);
			move(); 
			disparoObserver.postMessage("Disparo");
			try {
				sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	

	public DisparoObserver getDisparoObserver(){

		return this.disparoObserver;

	}

	public boolean getActive(){

		return this.isActive;

	}

	public boolean getImpacto() {
		return this.impacto;
	}

	public void setImpacto(boolean impacto) {
		this.impacto = impacto;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void shoot() {
		this.posY = this.posY - 1;
	}

	public void move() {

		if(type==1)//NAVE

			this.posY = this.posY - 1;

		else//MARCIANO

			this.posY = this.posY + 5;
		
		if(posY<=0){

			isActive=false;

		}

	}

	
}