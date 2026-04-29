package com.ejemplo.akka;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class HundredActor extends AbstractActor {
    private ActorRef printerActor;

    //TODO:
    // crear el constructor
    public HundredActor(ActorRef printerActor) {
        this.printerActor = printerActor;
    }

    public static Props props(ActorRef printerActor) {
        return Props.create(HundredActor.class, printerActor);
    }

    //invocar una instancia de createReceive 
    @Override
    public Receive createReceive() {
        return receiveBuilder()
            .match(Integer.class, n -> {
                if (n >= 100) {
                    printerActor.forward(n, getContext());
                }
            })
            .match(String.class, s -> {
                if ("stop".equals(s)) {
                    printerActor.tell(s, getSelf());
                    getContext().stop(getSelf());
                }
            })
            .build();
    }

    // programar el contenido de la clase como se ha descrito en las transparencias
}
