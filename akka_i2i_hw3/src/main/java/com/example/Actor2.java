package com.example;

import akka.actor.AbstractActor;
import akka.actor.Props;

public class Actor2 extends AbstractActor {

    public static Props props() {
        return Props.create(Actor2.class, Actor2::new);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, message -> {
                    System.out.println("Actor2 received message: " + message);
                    if ("Hi from Actor1".equals(message)) {
                        System.out.println("Actor2: Sending 'Hi from Actor2' back to Actor1");
                        getSender().tell("Hi from Actor2", getSelf());
                    }
                })
                .build();
    }
}
