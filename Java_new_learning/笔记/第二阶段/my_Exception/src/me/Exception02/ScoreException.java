package me.Exception02;

public class ScoreException extends Exception{
    public ScoreException () {}

    public ScoreException(String score) {
        super(score);
    }
}
