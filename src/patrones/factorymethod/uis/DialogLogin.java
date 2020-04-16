package patrones.factorymethod.uis;

import javax.swing.JPanel;

import patrones.factorymethod.abstracts.AbstractDialog;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;

import game.Jugador;
import patrones.facade.GameFacade.GameFacade;
import patrones.singleton.constantes.Constantes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;


public class DialogLogin  extends AbstractDialog implements ActionListener{

    private static final long serialVersionUID = 1L;

    GameFacade gameFacade;

    JLabel labNombre;

    JTextField txtNombre;

    public DialogLogin(GameFacade gameFacade) {
        super();
        setTitle("Login");
        setVisible(true);
        
        this.gameFacade = gameFacade;

        add(init());
    }

    @Override
    protected JPanel init() {
        JPanel panelMain = new JPanel();
        JPanel panelNombre = new JPanel();
        JPanel panelNick = new JPanel();

        panelMain.setLayout(null);
        // panelMain.setLayout(new FlowLayout(FlowLayout.CENTER));
        // panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        panelNombre.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelNick.setLayout(new FlowLayout(FlowLayout.CENTER));

        labNombre = new JLabel("POR FAVOR DIGITA TU NICKNAME");
        labNombre.setForeground(Color.RED);
        labNombre.setFont(Constantes.getInstance().FONTMENU);
        labNombre.setBounds(10, 60, 350, 20);

        txtNombre = new JTextField();
        txtNombre.setBackground(Color.orange);
        txtNombre.setBounds(10, 85, 205, 25);
        txtNombre.setForeground(Color.BLUE);
        txtNombre.setFont(Constantes.getInstance().FONTMENU);

        panelNombre.add(labNombre);
        panelNombre.add(txtNombre);

        panelMain.add(labNombre);
        panelMain.add(txtNombre);

        return panelMain;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String comando = e.getActionCommand();
        if (comando.equals(Constantes.getInstance().ACTIONACEPTAR)) {
            if (txtNombre.getText().equals(null) || txtNombre.getText().equals("") ){
                JOptionPane.showMessageDialog(this, "Por favor ingrese un nombre valido",
                        "Error al crear partida", JOptionPane.ERROR_MESSAGE);
            }else{
                Jugador jugador = this.gameFacade.searchByNickName(txtNombre.getText().toString());

                if(jugador==null){

                    JOptionPane.showMessageDialog(this, "Usuario no existe",
                    "Error al crear partida", JOptionPane.ERROR_MESSAGE);

                }else{

                    this.gameFacade.selectJugador(jugador.getNickname().toString()); 

                    this.dispose();                                

                }
                //this.gameFacade.get

                

            }
            
        } 

    }

}