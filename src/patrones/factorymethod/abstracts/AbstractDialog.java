package patrones.factorymethod.abstracts;

import game.Game;
import patrones.singleton.constantes.Constantes;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
//import javax.swing.JPanel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

public abstract class AbstractDialog extends JDialog {

    private static final long serialVersionUID = 1L;

    protected Game game;

    JButton butBotonAceptar,butBotoOrdenar;

    public AbstractDialog() {

        super();

        // this.game = game;

        setLayout(new BorderLayout());

        JPanel actions = new JPanel();

        actions.setLayout(new FlowLayout(FlowLayout.CENTER));

        butBotonAceptar = new JButton(Constantes.getInstance().TEXTACEPTAR);

        butBotonAceptar.setActionCommand(Constantes.getInstance().ACTIONACEPTAR);

        butBotonAceptar.addActionListener((ActionListener) this);
		
		butBotonAceptar.setFont(Constantes.getInstance().FONTMENU);
        
        actions.add(butBotonAceptar);


        butBotoOrdenar = new JButton(Constantes.getInstance().TEXTORDENAR);

        butBotoOrdenar.setActionCommand(Constantes.getInstance().ACTIONORDENAR);

        butBotoOrdenar.addActionListener((ActionListener) this);
		
		butBotoOrdenar.setFont(Constantes.getInstance().FONTMENU);
        
        actions.add(butBotoOrdenar);

        add(actions, BorderLayout.SOUTH);

        setSize(600, 300);

        setLocationRelativeTo(null);

        //add(this.init());
        setVisibleOrdenar(false);

    }

    public void setVisibleOrdenar(boolean visible){
        this.butBotoOrdenar.setVisible(visible);
    }

    public JDialog getPanel() {

        return this;

    }

    public Game getGame(){

        return this.game;

    }

    protected abstract JPanel init();
    
}