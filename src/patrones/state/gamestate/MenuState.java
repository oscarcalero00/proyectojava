package patrones.state.gamestate;

import game.Game;
import patrones.singleton.constantes.Constantes;


public class MenuState extends GameState {

    public MenuState(Game game) {
        super(game);
        game.setPlaying(false);
        game.getGameTopic().postMessage(Constantes.getInstance().PANELMENU);
        System.out.println("IN MENU STATE");  
    }

    @Override
    public void menu() {
        // TODO Auto-generated method stub

    }

    @Override
    public void play() {
        getGame().getGameTopic().postMessage(Constantes.getInstance().PANELPLAY);
        getGame().changeState(new PlayState(getGame()));
        // TODO Auto-generated method stub

    }

    @Override
    public void win() {
        // TODO Auto-generated method stub

    }

    @Override
    public void lost() {
        // TODO Auto-generated method stub

    }

}