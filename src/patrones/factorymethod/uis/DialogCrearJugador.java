package patrones.factorymethod.uis;

import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import excepciones.NicknameYaExisteException;
import patrones.facade.GameFacade.GameFacade;
import patrones.factorymethod.abstracts.AbstractDialog;
import patrones.singleton.constantes.Constantes;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DialogCrearJugador extends AbstractDialog implements ActionListener {

    private static final long serialVersionUID = 1L;

    JLabel labNombre, labNickname;
    JTextField txtNombre, txtNickame;

    GameFacade gameFacade;

    public DialogCrearJugador(GameFacade gameFacade) {
        super();
        this.gameFacade = gameFacade;
        setVisible(true);
        setTitle("Crear Jugador");
        // TODO Auto-generated constructor stub
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

        labNombre = new JLabel("NOMBRE DEL JUGADOR");
        labNombre.setForeground(Color.RED);
        labNombre.setFont(Constantes.getInstance().FONTMENU);
        labNombre.setBounds(10, 60, 350, 20);

        txtNombre = new JTextField();
        txtNombre.setBackground(Color.orange);
        txtNombre.setBounds(10, 85, 205, 25);
        txtNombre.setForeground(Color.BLUE);
        txtNombre.setFont(Constantes.getInstance().FONTMENU);

        labNickname = new JLabel("NICKNAME");
        labNickname.setForeground(Color.red);
        labNickname.setFont(Constantes.getInstance().FONTMENU);
        labNickname.setBounds(10, 150, 260, 20);

        txtNickame = new JTextField();
        txtNickame.setBackground(Color.orange);
        txtNickame.setBounds(10, 180, 150, 25);
        txtNickame.setForeground(Color.BLUE);
        txtNickame.setFont(Constantes.getInstance().FONTMENU);

        JLabel imagen = new JLabel();
        ImageIcon icono = new ImageIcon("./data/imagenes/fondAgJ.jpg");
        imagen.setIcon(icono);
        imagen.setBounds(0, 0, icono.getIconWidth(), icono.getIconHeight());

        panelNombre.add(labNombre);
        panelNombre.add(txtNombre);

        panelNick.add(labNickname);
        panelNick.add(txtNickame);

        panelMain.add(labNombre);
        panelMain.add(txtNombre);
        panelMain.add(labNickname);
        panelMain.add(txtNickame);
        // panelMain.add(imagen);

        return panelMain;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.equals(Constantes.getInstance().ACTIONACEPTAR)) {
            if (txtNombre.getText().equals(null) || txtNombre.getText().equals("") || txtNickame.getText().equals(null)
                    || txtNickame.getText().equals(""))
                JOptionPane.showMessageDialog(this, "Por favor ingrese un nombre y un nickname v�lido",
                        "Error al crear el jugador", JOptionPane.ERROR_MESSAGE);

            else if (txtNickame.getText().length() != 5) {
                JOptionPane.showMessageDialog(this, "El nickname debe contener 5 caracteres",
                        "Error al asignar el nickname", JOptionPane.ERROR_MESSAGE);
            } else {

                // interfaz.reqAgregarJugador(txtNombre.getText(), txtNickame.getText());
                
                try {
                
                    this.gameFacade.addJugador(txtNombre.getText(), txtNickame.getText());
                } catch (NicknameYaExisteException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                
				this.dispose();
			}
		}
        // TODO Auto-generated method stub
        
        /*Object obj = e.getSource();
        if (obj instanceof DialogCrearJugador) {
            System.out.print("ActionEvent 0");
        }else{
            System.out.print("ActionEvent 1");
        }
        System.out.print("ActionEvent------------------------------");*/
        //System.out.print(e);
        //System.out.print(obj);
    }
}