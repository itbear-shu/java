package cn.it.Multi;

/**
 * @author jx
 * @date 2021/8/21
 **/
public class Demo {
    public static void main(String[] args) {
        Fu f = new Zi();
        Zi zi = (Zi)f;
        zi.method();
        int n1 = (int) 10.5;
        System.out.println(n1);
        Season.AUTUNM.show();
    }

    enum Season{
        SPRING("aa", "bb"),
        AUTUNM("bb", "Cc"),
        SUMMER("GG", "VV")
        ;
        private final String A;
        private final String B;

        Season(String A, String B) {
            this.A = A;
            this.B = B;
        }
        public void show() {
            System.out.println(A + ":" + B);
        }
    }
}
