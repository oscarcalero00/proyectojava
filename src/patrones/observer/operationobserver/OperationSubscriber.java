package patrones.observer.operationobserver;

import patrones.observer.interfaces.IObserver;
import patrones.observer.interfaces.ISubject;

public class OperationSubscriber implements IObserver {
    
    private String name;
	private ISubject topic;
	
	public OperationSubscriber(String nm){
		this.name=nm;
	}
	@Override
	public void update() {
		String msg = (String) topic.getUpdate(this);
		if(msg == null){
			System.out.println(name+":: No new message");
		}else
		System.out.println(name+":: Consuming message::"+msg);
	}

	@Override
	public void setSubject(ISubject sub) {
		this.topic=sub;
	}
}