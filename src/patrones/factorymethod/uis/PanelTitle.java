package patrones.factorymethod.uis;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;

import java.awt.Font;
import java.awt.Color;

import patrones.singleton.constantes.Constantes;

public class PanelTitle extends JPanel {

    private static final long serialVersionUID = 1L;

    public PanelTitle(String title) {

        setLayout(new FlowLayout());

        JLabel space = new JLabel(title);

        space.setFont(new Font("ArcadeClassic", Font.PLAIN, 82));

        space.setForeground(Color.WHITE);

        setBackground(Constantes.getInstance().COLORFONDO);

        add(space);
       
    }

}