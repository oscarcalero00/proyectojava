package patrones.factorymethod.uis;


import javax.swing.JPanel;

import patrones.factorymethod.abstracts.AbstractDialog;

public class DialogPuntajes extends AbstractDialog {

    private static final long serialVersionUID = 1L;

    public DialogPuntajes() {
        super();
        setVisible(true);
        setTitle("Mejores Puntajes");
        // TODO Auto-generated constructor stub
    }

    @Override
    protected JPanel init() {
        // TODO Auto-generated method stub
        return null;
    }

}