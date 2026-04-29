package com.ejemplo.akka;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class EvenActor extends AbstractActor {
    private ActorRef hundredActor;
    private ActorRef printerActor;

    //TODO:
    // crear el constructor
    public EvenActor(ActorRef hundredActor, ActorRef printerActor) {
        this.hundredActor = hundredActor;
        this.printerActor = printerActor;
    }

    public static Props props(ActorRef hundredActor, ActorRef printerActor) {
        return Props.create(EvenActor.class, hundredActor, printerActor);
    }

    //invocar una instancia de createReceive 
    @Override
    public Receive createReceive() {
        return receiveBuilder()
            .match(Integer.class, n -> {
                if (n % 2 == 0) {
                    hundredActor.forward(n, getContext());
                } else {
                    printerActor.forward(n, getContext());
                }
            })
            .match(String.class, s -> {
                if ("stop".equals(s)) {
                    hundredActor.tell(s, getSelf());
                    printerActor.tell(s, getSelf());
                    getContext().stop(getSelf());
                }
            })
            .build();
    }

    // programar el contenido de la clase como se ha descrito en las transparencias
}
