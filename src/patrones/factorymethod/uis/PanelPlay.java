package patrones.factorymethod.uis;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;

import game.Disparo;
import game.Game;
import game.Jugador;
import game.Nave;
import patrones.factorymethod.abstracts.AbstractPanel;
import patrones.observer.interfaces.IObserver;
import patrones.observer.interfaces.ISubject;
import patrones.singleton.constantes.Constantes;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PanelPlay extends AbstractPanel implements KeyListener, IObserver {

    private static final long serialVersionUID = 1L;

    JPanel panelMain;

    Nave naveActual;

    Jugador jugadorActual;

    private ISubject topic;

    public PanelPlay(Game game) {

        super(game);

        setSize(640, 480);

    }

    @Override
    protected JPanel init() {

        panelMain = new JPanel();

        return null;

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        jugadorActual = getGame().getGameFacade().getJugadorActual();

        naveActual = jugadorActual.getPartidaActual().getNave();

        ImageIcon iconFondo = new ImageIcon("./data/imagenes/fondoJuego.jpg");

        g.drawImage(iconFondo.getImage(), 0, 0, null);

        // DIBUJAR INFORMACI�N DEL JUGADOR
        g.setColor(Color.WHITE);

        g.setFont(Constantes.getInstance().FONTMENU);

        g.drawString("NICKNAME", 30, 40);

        g.drawString("PUNTUACION ", 350, 40);

        g.setColor(Color.GREEN);

        g.drawImage(naveActual.getimagen().getImage(), naveActual.getPosX(), naveActual.getPosY(),
                naveActual.getAncho(), naveActual.getAlto(), null);

        g.drawString(jugadorActual.getNickname(), 140, 40);

        g.drawString(Integer.toString(jugadorActual.getPartidaActual().getPuntaje()), 500, 40);

        g.drawString("Vidas jugador : " + Integer.toString(jugadorActual.getPartidaActual().getVidas()), 100, 470);

        Disparo a = (Disparo) naveActual.getDisparo();

        if (a != null) {

            if(a.getActive()){

                g.setColor(Color.WHITE);

                g.fillOval(a.getPosX() + 13, a.getPosY(), 7, 7);

            }
           // a.move();

            

            /*
             * if (a.getPosY() == 0 || a.getImpacto()) { ImageIcon choque = new
             * ImageIcon("./data/imagenes/Naves/muereBicho.png");
             * g.drawImage(choque.getImage(), a.getPosX(), a.getPosY() - 6, null); }
             */

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            
            if( naveActual.getDisparo() == null ){                
                    naveActual.disparar((IObserver) this);
                    setSubject(naveActual.getDisparo().getDisparoObserver());
                
            }else{
                if(!naveActual.getDisparo().getActive()){
                    naveActual.disparar((IObserver) this);
                    setSubject(naveActual.getDisparo().getDisparoObserver());
                }
            }
            
            /*
             * if (navesita.getDisparoUno() == null) {
             * navesita.disparar(interfaz.darPosActualJugador(), 410);
             * interfaz.startHiloJugador(); }
             */
        }

        // TODO Auto-generated method stub
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            naveActual.mover(-1);
            this.updateUI();
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            naveActual.mover(1);
            this.updateUI();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        this.updateUI();
    }

    @Override
    public void setSubject(ISubject sub) {
        // TODO Auto-generated method stub
        this.topic = sub;
    }

}