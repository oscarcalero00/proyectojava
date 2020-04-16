package patrones.state.gamestate;

import game.Game;
//import patrones.singleton.constantes.Constantes;

public class PlayState extends GameState {

    public PlayState(Game game) {
        super(game);
        game.setPlaying(true);
        System.out.println("IN PLAY STATE");  
        //game.getGameTopic().postMessage(Constantes.getInstance().PANELPLAY);
    }

    @Override
    public void menu() {
        // TODO Auto-generated method stub

    }

    @Override
    public void play() {
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