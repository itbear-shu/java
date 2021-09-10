package day_9.BMW;
/*产品接口*/
public interface BMW {
    void showInfo();
}
/*构建具体类*/
class BMW3i implements BMW {

    @Override
    public void showInfo() {
        System.out.println("BMW3");
    }
}

class BMW5 implements BMW {

    @Override
    public void showInfo() {
        System.out.println("BMW5");
    }
}

class BMW7 implements BMW {

    @Override
    public void showInfo() {
        System.out.println("BMW7");
    }
}