package patrones.factorymethod.uis;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import game.Jugador;
import patrones.facade.GameFacade.GameFacade;
import patrones.factorymethod.abstracts.AbstractDialog;
import patrones.singleton.constantes.Constantes;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.BorderLayout;

public class DialogSeleccionarJugador extends AbstractDialog implements ActionListener, ListSelectionListener {

    private static final long serialVersionUID = 1L;

    JScrollPane scroll;

    JList<Object> jugadores ;

    GameFacade gameFacade;
  
    public DialogSeleccionarJugador( GameFacade gameFacade) {
        super();

        this.gameFacade = gameFacade;

        setVisible(true);

        setTitle("Seleccionar Jugador");
        
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

        reloadListaJugadores(this.gameFacade.getJugadores());
        
    }

    @Override
    protected JPanel init() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        // TODO Auto-generated method stub
        String comando = e.getActionCommand();
        if (comando.equals(Constantes.getInstance().ACTIONACEPTAR)) {
            this.gameFacade.selectJugador(jugadores.getSelectedValue().toString()); 
            this.dispose();
        }else{
            reloadListaJugadores(this.gameFacade.getOrdenadosPorNickname()); 
            //getOrdenadosPorNickname
        }    
        
    }

    @Override
    public void valueChanged(final ListSelectionEvent e) {
        // TODO Auto-generated method stub

    }

  
	public void reloadListaJugadores(final ArrayList<Jugador> lista) {

        final ArrayList<String> listNombre = new ArrayList<String>();

        for (final Jugador p:lista) {

            listNombre.add(p.getNombre());

        }   

		jugadores.setListData((Object[]) listNombre.toArray());

        if (jugadores.getModel().getSize() > 0)
        
            jugadores.setSelectedIndex(0);
            
	}

}