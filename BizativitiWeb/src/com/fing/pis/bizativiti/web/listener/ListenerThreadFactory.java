package com.fing.pis.bizativiti.web.listener;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ListenerThreadFactory implements ThreadFactory {

	private ThreadFactory factory = null;
	
	public ListenerThreadFactory() {
        this(Executors.defaultThreadFactory());
    }
	
	public ListenerThreadFactory(ThreadFactory factory) {
        if (factory == null){
            throw new NullPointerException("factory cannot be null");
        }
        this.factory = factory;
    }
		
	public ThreadFactory getFactory() {
		return factory;
	}

	@Override
	public Thread newThread(Runnable r) {
		final Thread t = factory.newThread(r);
		/*Deamon threads permite al programa terminar sin
		 *  que hayan terminado de ejecutarse todos los threads caso contrario false*/
        t.setDaemon(true);
        return t;
	}

}
