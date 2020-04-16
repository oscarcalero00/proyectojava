package patrones.factorymethod.uis;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Game;
import patrones.factorymethod.abstracts.AbstractPanel;
import patrones.singleton.constantes.Constantes;
import patrones.state.gamestate.MenuState;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PanelInicial extends AbstractPanel implements KeyListener  {

    private static final long serialVersionUID = 1L;
   
    public PanelInicial(Game game) {

        super(game);

    }   

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            System.out.println("GO MENU");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            System.out.println("GO MENU");
            game.changeState(new MenuState(this.game));
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public JPanel init() {
        
      //  setLayout(new BorderLayout());

        JPanel panelMain = new JPanel();

        panelMain.setLayout(new BorderLayout());

        
        JLabel labImagen;
        ImageIcon icono = new ImageIcon("./data/imagenes/menuInicio.gif");
        labImagen = new JLabel(icono);
        //Color fondo = new Color(21, 22, 25);
        setBackground(Constantes.getInstance().COLORFONDO);

        // Texto instructivo: "PRESIONE LA TECLA ESPACIO"
        JPanel flow = new JPanel(new FlowLayout());
        JLabel presione = new JLabel("PRESIONE ");
        presione.setForeground(Color.BLUE);
        JLabel la = new JLabel("LA ");
        la.setForeground(Color.RED);
        JLabel tecla = new JLabel("TECLA ");
        tecla.setForeground(Color.GREEN);
        JLabel espacio = new JLabel("ENTER ");
        espacio.setForeground(Color.YELLOW);
        presione.setFont(new Font("ArcadeClassic", Font.PLAIN, 49));
        la.setFont(new Font("ArcadeClassic", Font.PLAIN, 49));
        tecla.setFont(new Font("ArcadeClassic", Font.PLAIN, 49));
        espacio.setFont(new Font("ArcadeClassic", Font.PLAIN, 49));
        flow.setBackground(Constantes.getInstance().COLORFONDO);
        flow.add(presione);
        flow.add(la);
        flow.add(tecla);
        flow.add(espacio);

        panelMain.add(new PanelTitle("Space Invaders"), BorderLayout.NORTH);
        panelMain.add(labImagen, BorderLayout.CENTER);        
        panelMain.add(flow, BorderLayout.SOUTH);
        
      
        return panelMain;
    }
}