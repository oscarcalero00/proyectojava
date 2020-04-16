package patrones.state.gamestate;

import game.Game;


public class InitState extends  GameState {

  

    public InitState(Game game) {
        super(game);
        game.setPlaying(false);
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