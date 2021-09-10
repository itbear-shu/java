package day_15.Test;

public class DisplayMessage implements Runnable{
    String message;

    public DisplayMessage(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        int i = 0;
        System.out.println("Starting " + Thread.currentThread().getName() + " thread...");
        while (i < 10) {
            i++;
            System.out.println(message);
        }
    }
}
