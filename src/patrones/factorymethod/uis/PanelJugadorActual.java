package patrones.factorymethod.uis;

import javax.swing.JLabel;
import javax.swing.JPanel;

import patrones.singleton.constantes.Constantes;

import java.awt.FlowLayout;

import java.awt.Color;

public class PanelJugadorActual  extends JPanel {

    private static final long serialVersionUID = 1L;

    JLabel lblname,lblnick;

    public PanelJugadorActual(String name,String nick) {

        setLayout(new FlowLayout());

        String name1 = "Nombre";

        String nick1 = "Nickname";

        if(name!=null){
            name1 = name;
        }

        if(nick!=null){
            nick1 = nick;
        }

        lblname = new JLabel(name1);

        lblnick = new JLabel(nick1);

        lblname.setFont(Constantes.getInstance().FONTNAME);

        lblname.setForeground(Color.WHITE);

        lblnick.setFont(Constantes.getInstance().FONTNAME);

        lblnick.setForeground(Color.WHITE);

        setBackground(Constantes.getInstance().COLORFONDO);

        add(lblname);

        add(lblnick);
       
    }

    public void changeName(String name){
        lblname.setText("Nombre : "+name);
    }

    public void changeNick(String nick){
        lblnick.setText("Nickname : "+nick);
    }
}