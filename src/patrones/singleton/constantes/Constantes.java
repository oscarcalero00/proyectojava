package patrones.singleton.constantes;
import java.awt.Color;
import java.awt.Font;

public class Constantes {

    private static Constantes constantes_instance = null;

    public final String TEXTACEPTAR  = "ACEPTAR";
    public final String TEXTCANCELAR = "CANCELAR";
    public final String TEXTORDENAR  = "ORDENAR";
    public final String PANELINIT    = "PANEL-INIT";
    public final String PANELMENU    = "PANEL-MENU";
    public final String PANELPLAY    = "PANEL-PLAY";
    public final Color  COLORFONDO = new Color(21, 22, 25);
    
    public final Font   FONTTITLE  = new Font("ArcadeClassic", Font.PLAIN, 30);
    public final Font   FONTMENU   = new Font("ArcadeClassic", Font.PLAIN, 15);
    public final Font   FONTNAME   = new Font("ArcadeClassic", Font.PLAIN, 20);

    public final String ACTIONCREARJUGADOR = "CREAR-JUGADOR";
    public final String ACTIONSELECCIONARJUGADOR = "SELECCIONAR-JUGADOR";
    public final String ACTIONACEPTAR = "ACTION-ACEPTAR";
    public final String ACTIONORDENAR = "ACTION-ORDENAR";

    public final String ACTIONJUGADORCREADO       = "ACTION-JUGADOR-CREADO";
    public final String ACTIONJUGADORSELECCIONADO = "ACTION-JUGADOR-SELECCIONADO";

    public final String ACTIONPARTIDACREADA       = "ACTION-PARTIDA-CREADA";
    public final String ACTIONPARTIDASELECCIONADA = "ACTION-PARTIDA-SELECCIONADA";


    private Constantes() {

    }

    public static Constantes getInstance() {

        if (constantes_instance == null) {

            constantes_instance = new Constantes();

        }

        return constantes_instance;
        
    }

}