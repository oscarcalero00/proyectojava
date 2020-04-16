package patrones.factorymethod.uis;

import javax.swing.JPanel;

import game.Game;

import java.awt.BorderLayout;

import patrones.factorymethod.abstracts.AbstractPanel;
import patrones.observer.interfaces.IObserver;
import patrones.observer.interfaces.ISubject;
import patrones.singleton.constantes.Constantes;

public class PanelMenu extends AbstractPanel implements IObserver {

    private static final long serialVersionUID = 1L;

    JPanel panelMain;

    PanelJugadorActual jugadorActual;

    

    public PanelMenu(Game game) {

        super(game);

        

        game.getGameFacade().getOperationTopic().register((IObserver)this);
    }

    @Override
    public JPanel init() {

        panelMain = new JPanel();

        panelMain.setLayout(new BorderLayout());

        panelMain.setBackground(Constantes.getInstance().COLORFONDO);
       
        panelMain.add(new PanelTitle("Space Invaders"), BorderLayout.NORTH);
        panelMain.add(new PanelOptionMenu(game), BorderLayout.CENTER);

        this.jugadorActual = new PanelJugadorActual(null,null);
        panelMain.add(this.jugadorActual, BorderLayout.SOUTH);
        
        // panelMain.add(labImagen, BorderLayout.CENTER);
        // panelMain.add(flow, BorderLayout.SOUTH);

        return panelMain;

        // return this;
    }

    @Override
    public void update() {

        this.jugadorActual.changeName(game.getGameFacade().getJugadorActual().getNombre());
        this.jugadorActual.changeNick(game.getGameFacade().getJugadorActual().getNickname());
        // TODO Auto-generated method stub
       
    }

    @Override
    public void setSubject(ISubject sub) {
        // TODO Auto-generated method stub

    }

}