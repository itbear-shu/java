package day_10;

public class Test02 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        B b = null;
        try{
            System.out.println(arr[3]);
            System.out.println(b.i);
        } catch (ArrayIndexOutOfBoundsException e1) {
            e1.printStackTrace();
        } catch (NullPointerException e2) {
            e2.printStackTrace();
        }

        System.out.println("=====");
    }
}
class B{
    int i;
}
