package com.udacity.gradle.jokes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Joker {
    private static final List<String> JOKES = new ArrayList<>();
    private static final Random random = new Random();

    static {
        JOKES.add("Can a kangaroo jump higher than a house? Of course, a house doesn\'t jump at all.");
        JOKES.add("What did the elephant say to the naked man? How do you breathe through something so small?");
        JOKES.add("Where do cows go on Saturday nights? To the MOOO-vies!");
        JOKES.add("Why is it hard to play cards in the jungle? here are too many cheetahs!");
        JOKES.add("When is it bad luck to see a black cat? When you’re a mouse!");

        JOKES.add("It is so cold outside I saw a politician with his hands in his own pockets.");
        JOKES.add("What\'s the difference between an accountant and a lawyer? Accountants know they\'re boring.")
        ;
        JOKES.add("How many lawyer jokes are there? Only three. The rest are true stories.");
        JOKES.add("What do dinosaurs and decent lawyers have in common? They\'re both extinct.");
        JOKES.add("Why does the law society prohibit sex between lawyers and their clients? To prevent clients from being billed twice for essentially the same service.")
        ;

        JOKES.add("After finishing our Chinese food, my husband and I " +
                "cracked open our fortune cookies. Mine read, \"Be quiet for a little while.\" " +
                "His read, \"Talk while you have a chance.\".");
        JOKES.add("Marriage is really tough because you have to deal with feelings ... and lawyers.")
        ;
        JOKES.add("If it weren\'t for marriage, women would have to spend most of their adult lives arguing with complete strangers.")
        ;
        JOKES.add("What is the difference between the words Incomplete and Finished?. " +
                "A man without a wife is incomplete. After getting one, he\'s finished.");


        JOKES.add("I wanted to grow my own food but I couldn\'t get bacon seeds anywhere.");
        JOKES.add("I can\'t believe I forgot to go to the gym today. That\'s 7 years in a row now.")
        ;
        JOKES.add("What goes up and down but never moves? The stairs");
        JOKES.add("What\'s the difference between snowmen and snowladies? Snowballs");
        JOKES.add("I am a nobody, nobody is perfect, therefore I am perfect.");
        JOKES.add("Never argue with a fool, they will lower you to their level, and then beat you with experience.")
        ;
        JOKES.add("What do you call two fat people having a chat? -- A heavy discussion");
        JOKES.add("Stalking is when two people go for a long romantic walk together but only one of them knows about it.")
        ;
    }

    ;

    public static String getJoke() {
        int jokeIndex = random.nextInt(JOKES.size()-1);
        return JOKES.get(jokeIndex);
    }
}
