package patrones.factorymethod.uis;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import game.Game;
import patrones.facade.GameFacade.GameFacade;
import patrones.singleton.constantes.Constantes;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.*;

public class PanelOptionMenu extends JPanel {

    private static final long serialVersionUID = 1L;

    GameFacade gameFacade ;

    Game game;

    public PanelOptionMenu(Game game) {

        this.game = game;

        this.gameFacade = game.getGameFacade();
       

        setLayout(new FlowLayout(FlowLayout.CENTER));

        setBackground(Constantes.getInstance().COLORFONDO);

        JButton jugador = new JButton("1-Jugar");
        // next.addActionListener(e -> textField.setText(player.getState().onNext()));
        JButton partida = new JButton("2-Jugador");
       

        JButton login = new JButton("3-Login Rapido");

        JButton instrucciones = new JButton("4-Instrucciones");

        JButton mejorespuntajes = new JButton("5-Mejores Puntajes");

        jugador.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                showPopup(buildMenuJugar(),ae);
            }
        });

      
        partida.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                showPopup(buildMenuJugador(),ae);
            }
        });

        login.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                DialogLogin dialog = new DialogLogin(gameFacade);
                dialog.setVisible(true);
            }
        });

        
        instrucciones.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                DialogInstrucciones dialog = new DialogInstrucciones();
                dialog.setVisible(true);
            }
        });

        mejorespuntajes.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                DialogPuntajes dialog = new DialogPuntajes();
                dialog.setVisible(true);
            }
        });
        

        add(jugador);

        add(partida);

        add(login);

        add(instrucciones);

        add(mejorespuntajes);

    }


    public JPopupMenu buildMenuJugar() {

        JPopupMenu popMenuJugador = new JPopupMenu();

        JMenuItem menuCrearPartida = new JMenuItem("CREAR PARTIDA");

        menuCrearPartida.setFont(Constantes.getInstance().FONTMENU);

        JMenuItem menuSeleccionarPartida = new JMenuItem("SELECCIONAR PARTIDA");

        menuSeleccionarPartida.setFont(Constantes.getInstance().FONTMENU);

        menuCrearPartida.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent ae)
            {
                if(gameFacade.getJugadorActual()==null){
                    JOptionPane.showMessageDialog(getParent(), "Debe seleccionar un jugador",
                        "Error al crear partida", JOptionPane.ERROR_MESSAGE);
                }else{
                    DialogCrearPartida dialog = new DialogCrearPartida(gameFacade);
                    dialog.setVisible(true);
                }
                
            }

        });

        menuSeleccionarPartida.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                if(gameFacade.getJugadorActual()==null){
                    JOptionPane.showMessageDialog(getParent(), "Debe seleccionar un jugador",
                        "Error al crear partida", JOptionPane.ERROR_MESSAGE);
                }else{
                    DialogSeleccionarPartida dialog = new DialogSeleccionarPartida(game);
                    dialog.setVisible(true);
                    dialog.setVisibleOrdenar(true);
                }    
            }
        });

		popMenuJugador.add(menuCrearPartida);

        popMenuJugador.add(menuSeleccionarPartida);
        
        return popMenuJugador;
        
    }

    public JPopupMenu buildMenuJugador() {

        JPopupMenu popMenuJugador = new JPopupMenu();

        JMenuItem menuNuevoJugador = new JMenuItem("NUEVO JUGADOR");

        menuNuevoJugador.setFont(Constantes.getInstance().FONTMENU);

        JMenuItem menuSeleccionarJugador = new JMenuItem("SELECCIONAR JUGADOR");

        menuSeleccionarJugador.setFont(Constantes.getInstance().FONTMENU);


        menuNuevoJugador.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                DialogCrearJugador dialog = new DialogCrearJugador(gameFacade);
                dialog.setVisible(true);
            }
        });

        menuSeleccionarJugador.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                DialogSeleccionarJugador dialog = new DialogSeleccionarJugador(gameFacade);
                dialog.setVisible(true);
                dialog.setVisibleOrdenar(true);
            }
        });

		popMenuJugador.add(menuNuevoJugador);

        popMenuJugador.add(menuSeleccionarJugador);
        
        return popMenuJugador;

    }

   

    private void showPopup(JPopupMenu menu,ActionEvent ae)
    {
        // Get the event source
        Component b=(Component)ae.getSource();
        
        // Get the location of the point 'on the screen'
        Point p=b.getLocationOnScreen();
        
        // Show the JPopupMenu via program
        
        // Parameter desc
        // ----------------
        // this - represents current frame
        // 0,0 is the co ordinate where the popup
        // is shown
        menu.show(this,0,0);
        
        // Now set the location of the JPopupMenu
        // This location is relative to the screen
        menu.setLocation(p.x,p.y+b.getHeight());
    }
}