package me.StringBuilder03;

public class StringBuilder03 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("heoo");
        sb.append(100);

        String s = sb.toString();
        System.out.println(sb + "------ " + s);

        StringBuilder sb2 = new StringBuilder(s);
        System.out.println(sb2 + "------ " + s);
    }
}
