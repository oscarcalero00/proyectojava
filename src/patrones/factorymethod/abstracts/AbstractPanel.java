package patrones.factorymethod.abstracts;


import javax.swing.JPanel;

import game.Game;

import java.awt.BorderLayout;

public abstract class AbstractPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    protected Game game;

    public AbstractPanel(Game game) {

        super();

        this.game = game;

        setLayout(new BorderLayout());

        JPanel panel = init();

        if(panel!=null)

            add(panel);

    }

    public JPanel getPanel() {

        return this;

    }

    public Game getGame(){

        return this.game;

    }

    protected abstract JPanel init();

    

}