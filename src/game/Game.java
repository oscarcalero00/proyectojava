package game;

import patrones.facade.GameFacade.GameFacade;
import patrones.observer.gameobserver.GameTopic;
import patrones.observer.interfaces.IObserver;
import patrones.state.gamestate.GameState;
import patrones.state.gamestate.InitState;

public class Game {

    private boolean playing;

    private GameState state;
    
    private GameTopic gameTopic;

    private GameFacade gameFacade;

    

    public Game() {

        this.gameTopic = new GameTopic();

        this.gameFacade = new GameFacade();

        this.state = new InitState(this);

        setPlaying(true);

    }

    public void addSubscriber(IObserver sub) {

        this.gameTopic.register(sub);

    }

    public GameFacade getGameFacade() {

        return this.gameFacade;

    }

    public GameTopic getGameTopic() {

        return this.gameTopic;

    }

    public void changeState(GameState state) {

        this.state = state;

    }

    public GameState getState() {

        return state;

    }

    public boolean getPlaying() {

        return this.playing;

    }

    public void setPlaying(boolean playing) {

        this.playing = playing;
        
    }

    
}