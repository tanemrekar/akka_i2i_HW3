package com.example;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public class Main {
    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create("actor-system");

        final ActorRef actor2 = system.actorOf(Actor2.props(), "actor2");
        final ActorRef actor1 = system.actorOf(Actor1.props(), "actor1");

        actor1.tell("start", actor2);
    }
}
