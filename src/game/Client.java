package game;

import patrones.factorymethod.uis.JFrameMain;
//import patrones.observer.gameobserver.GameTopic;
import patrones.observer.interfaces.IObserver;

public class Client {
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        
        Game game = new Game();

        JFrameMain ventana = new JFrameMain(game);

        game.addSubscriber((IObserver)ventana);

        //ventana.setSubject(game.getGameTopic());
        ventana.setVisible(true);

    }
}