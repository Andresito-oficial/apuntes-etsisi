package com.ejemplo.akka;

import akka.actor.AbstractActor;
import akka.actor.Props;

public class PrinterActor extends AbstractActor {

    //TODO:
    // crear el constructor
    public PrinterActor() {
    }

    public static Props props() {
        return Props.create(PrinterActor.class);
    }

    //invocar una instancia de createReceive 
    @Override
    public Receive createReceive() {
        return receiveBuilder()
            .match(Integer.class, n -> {
                System.out.println("PrinterActor received: " + n);
            })
            .match(String.class, s -> {
                if ("stop".equals(s)) {
                    getContext().stop(getSelf());
                }
            })
            .build();
    }

    // programar el contenido de la clase como se ha descrito en las transparencias
}
