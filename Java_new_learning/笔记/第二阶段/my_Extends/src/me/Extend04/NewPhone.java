package me.Extend04;

public class NewPhone extends Phone{
   /* public void call(String name){
        System.out.println("Video...");
//        System.out.println("I'm calling for " + name);
        super.call(name);
    }*/
    @Override
    public void call(String name){
        System.out.println("Video...");
//        System.out.println("I'm calling for " + name);
        super.call(name);
    }
}
