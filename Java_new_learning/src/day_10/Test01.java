package day_10;

public class Test01 {
    public static void main(String[] args) {
        String[] friends = new String[]{"lisa","bily","kessy"};
        try{
            for(int i = 0;i < 5;i++) {
                System.out.println(friends[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("index err!");
        }

        System.out.println("This is the end.");
    }
}
