package com.ejemplo.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Crear el sistema de actores 
        ActorSystem system = ActorSystem.create("MySystem");

        // Crear el actor printerActor 
        ActorRef printerActor = system.actorOf(PrinterActor.props(), "printerActor");

        // Crear hundredActor  
        ActorRef hundredActor = system.actorOf(HundredActor.props(printerActor), "hundredActor");

        // Crear evenActor   
        ActorRef evenActor = system.actorOf(EvenActor.props(hundredActor, printerActor), "evenActor");

        int[] ints = {10, 2, 3, 100, 245, 102, 234};
        // enviar cada cifra de la secuencia al actor evenActor
        for (int n : ints) {
            evenActor.tell(n, ActorRef.noSender());
        }

        // esperar 5 segundos
        Thread.sleep(5000);

        // enviar el mensaje "stop" a cada actor
        evenActor.tell("stop", ActorRef.noSender());

        //  terminar el sistema
        system.terminate();

        System.out.println("Actor system terminated");
    }
}
