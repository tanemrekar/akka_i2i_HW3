package com.example;

import akka.actor.AbstractActor;
import akka.actor.Props;

public class Actor1 extends AbstractActor {

    public static Props props() {
        return Props.create(Actor1.class, Actor1::new);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, message -> {
                    if ("start".equals(message)) {
                        System.out.println("Actor1: Sending 'Hi from Actor1' to Actor2");
                        getSender().tell("Hi from Actor1", getSelf());
                    }
                })
                .build();
    }
}
