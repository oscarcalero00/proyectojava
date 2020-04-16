package patrones.factorymethod.uis;

import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import game.Game;
import game.Jugador;
import game.Partida;
import patrones.facade.GameFacade.GameFacade;
import patrones.factorymethod.abstracts.AbstractDialog;
import patrones.singleton.constantes.Constantes;
//import patrones.state.gamestate.PlayState;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.BorderLayout;

public class DialogSeleccionarPartida extends AbstractDialog implements ActionListener, ListSelectionListener {

    private static final long serialVersionUID = 1L;

    JScrollPane scroll;

    JList<Object> jugadores;

    GameFacade gameFacade;

    Game game;

    public DialogSeleccionarPartida(Game game) {

        super();

        this.game = game;

        this.gameFacade = game.getGameFacade();

        setVisible(true);

        setTitle("Seleccionar Partida");

        scroll = new JScrollPane();

        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        scroll.setPreferredSize(new Dimension(240, 200));

        jugadores = new JList<>();

        jugadores.addListSelectionListener((ListSelectionListener) this);

        jugadores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jugadores.setModel(new DefaultListModel<>());

        scroll.getViewport().add(jugadores);

        jugadores.setFont(Constantes.getInstance().FONTMENU);

        jugadores.setForeground(Color.BLUE);

        add(scroll, BorderLayout.CENTER);


        reloadListaPartidas(this.gameFacade.getJugadorActual());
    }

    @Override
    protected JPanel init() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.equals(Constantes.getInstance().ACTIONACEPTAR)) {
            this.gameFacade.selectPartida(jugadores.getSelectedValue().toString()); 
            //System.out.println("GO PLAY STATE");            
            //game.changeState(new PlayState(game));
            game.getState().play();
            // changeState(new PlayState(game));
            this.dispose();
        }else{
            reloadListaPartidasOrdenada(this.gameFacade.getPartidasOrdenadas()); 
            //getOrdenadosPorNickname
        }  

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        // TODO Auto-generated method stub

    }

    

    public void reloadListaPartidas(Jugador jugadorActual) {

        ArrayList<String> listNombre = new ArrayList<String>();

        ArrayList<Partida> listPartidas = jugadorActual.getPartidas() ;

        for (final Partida p : listPartidas) {

            listNombre.add(p.getName());

        }   

		jugadores.setListData((Object[]) listNombre.toArray());

        if (jugadores.getModel().getSize() > 0)
        
            jugadores.setSelectedIndex(0);
            
    }
    
    public void reloadListaPartidasOrdenada(ArrayList<Partida> listPartidas) {

        ArrayList<String> listNombre = new ArrayList<String>();

        for (final Partida p : listPartidas) {

            listNombre.add(p.getName()) ;

        }   

		jugadores.setListData((Object[]) listNombre.toArray());

        if (jugadores.getModel().getSize() > 0)
        
            jugadores.setSelectedIndex(0);
            
	}
}