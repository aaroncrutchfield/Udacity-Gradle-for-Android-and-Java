package com.exercise.udacity.jokes;

public class JokeSmith {

    public String getJoke(boolean isFromWizard) {
        if (isFromWizard)
            return "You can tune a piano, but you can't tuna-fish" +
                    "\n-Joke Wizard";
        else
            return "How much wood could a Wood Chuck chuck if a Wood Chuck could chuck wood?" +
                    "\n-Joke Smith";
    }
}
