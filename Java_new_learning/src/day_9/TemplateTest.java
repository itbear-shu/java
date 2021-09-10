package day_9;

public class TemplateTest extends Template{
    public void code() {
        for (int i = 0; i < 10000;i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TemplateTest templateTest = new TemplateTest();
        templateTest.getTime();
    }
}
