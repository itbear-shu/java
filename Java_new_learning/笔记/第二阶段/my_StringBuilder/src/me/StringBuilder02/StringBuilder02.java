package me.StringBuilder02;

public class StringBuilder02 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

//        StringBuilder sb2 = sb.append("Hello");
//        System.out.println("sb: " + sb);
//        System.out.println("sb2: " + sb2);
//        System.out.println(sb == sb2);

//        sb.append("Hello");
//        sb.append("World");
//        sb.append(1000);

        sb.append("Hello").append("World").append(1080);
        System.out.println("sb: " + sb);
        sb.reverse();
        System.out.println("sb: " + sb);
        sb.insert(0, "100");
        System.out.println("sb: " + sb);

    }
}
