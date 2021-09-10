package day_9.BMW;
/*车生产接口*/
public interface BMWFactory {
    BMW productBMW();//返回BMW对象
}

class BMW3Factory implements BMWFactory {

    @Override
    public BMW productBMW() {
        System.out.println("生产BMW3");
        return new BMW3i();
    }
}

class BMW5Factory implements BMWFactory {

    @Override
    public BMW productBMW() {
        System.out.println("生产BMW5");
        return new BMW5();
    }
}

class BMW7Factory implements BMWFactory {

    @Override
    public BMW productBMW() {
        System.out.println("生产BMW7");
        return new BMW7();
    }
}