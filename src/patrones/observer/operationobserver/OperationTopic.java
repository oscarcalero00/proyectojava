package patrones.observer.operationobserver;

import java.util.ArrayList;
import java.util.List;

import patrones.observer.interfaces.IObserver;
import patrones.observer.interfaces.ISubject;

public class OperationTopic implements ISubject {

    private List<IObserver> observers;

    private String message;

    private boolean changed;

    private final Object MUTEX = new Object();

    public OperationTopic() {

        this.observers = new ArrayList<>();
        
    }

    @Override
    public void register(IObserver obj) {

        if (obj == null)
            throw new NullPointerException("Null Observer");
        synchronized (MUTEX) {
            if (!observers.contains(obj))
                observers.add(obj);
        }
        // System.out.println("bbbb "+this.observers.size());
    }

    @Override
    public void unregister(IObserver obj) {
        synchronized (MUTEX) {
            observers.remove(obj);
        }
    }

    @Override
    public void notifyObservers() {
        List<IObserver> observersLocal = null;
        // synchronization is used to make sure any observer registered after message is
        // received is not notified
        synchronized (MUTEX) {
            if (!changed)
                return;
            observersLocal = new ArrayList<>(this.observers);
            this.changed = false;
        }
        // System.out.println("bbbb "+this.observers.size());
        for (IObserver obj : observersLocal) {
            // System.out.println("bbbb");
            obj.update();
        }

    }

    @Override
    public Object getUpdate(IObserver obj) {
        return this.message;
    }

    // method to post message to the topic
    public void postMessage(String msg) {
        // System.out.println("Message Posted to Topic:" + msg);
        this.message = msg;
        this.changed = true;
        notifyObservers();
    }
}