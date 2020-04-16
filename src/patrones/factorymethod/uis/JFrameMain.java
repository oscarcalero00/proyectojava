package patrones.factorymethod.uis;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import game.Game;
import patrones.factorymethod.abstracts.AbstractPanel;

import patrones.observer.interfaces.IObserver;
import patrones.observer.interfaces.ISubject;
import patrones.singleton.constantes.Constantes;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.KeyListener;

public class JFrameMain extends JFrame implements IObserver {

    Game game;

    AbstractPanel panelInicial;

    AbstractPanel panelMenu,panelPlay;
    
    private String name;

	private ISubject topic;

    private static final long serialVersionUID = -6826850758679360096L;

    public static CardLayout card = new CardLayout();

    public JFrameMain(Game game) {

        this.game = game;

        this.panelInicial = new PanelInicial(game);

        addKeyListener((KeyListener) this.panelInicial);
        
        this.panelMenu = new PanelMenu(game);

        this.panelPlay = new PanelPlay(game);

        addKeyListener((KeyListener) this.panelPlay);
        
                
        card.addLayoutComponent(this.panelInicial, Constantes.getInstance().PANELINIT);

        card.addLayoutComponent(this.panelMenu, Constantes.getInstance().PANELMENU);

        card.addLayoutComponent(this.panelPlay, Constantes.getInstance().PANELPLAY);

        this.getContentPane().add(this.panelInicial);

        this.getContentPane().add(this.panelMenu);

        this.getContentPane().add(this.panelPlay);

        this.getContentPane().setLayout(card);

        card.show(this.getContentPane(), Constantes.getInstance().PANELINIT);
        
        setSize(640, 480);

        setUndecorated(true);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        getRootPane().setBorder(BorderFactory.createLineBorder(Color.WHITE));

        this.setSubject(game.getGameTopic());
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        String msg = (String) topic.getUpdate(this);
		if(msg == null){
			System.out.println(name+":: No new message");
		}else{
            card.show(this.getContentPane(), msg);
        }
        System.out.println(name+":: Consuming message::"+msg);
        
    }

    @Override
    public void setSubject(ISubject sub) {
        // TODO Auto-generated method stub
        this.topic=sub;

    }

}