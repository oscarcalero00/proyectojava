package patrones.state.gamestate;

import game.Game;

public abstract class GameState {

    private Game game;

    public GameState(Game game) {

        this.game = game;

    }   

    public Game getGame() {
        return this.game;
    }

    public abstract void menu();

    public abstract void play();

    public abstract void win();

    public abstract void lost();

}
