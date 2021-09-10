package day_7;

public class Kids extends ManKind{
    int yearsOld;

    public int getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    void printAge() {
        System.out.println(this.yearsOld);
    }

    @Override
    public void employeed() {
        super.employeed();
        System.out.println("But kid should study and no job");
    }

    public void test() {
        super.setSex(1);
        super.setSalary(2);

    }
    public static void main(String[] args) {
        Kids someKid = new Kids();
        someKid.setSex(1);
        someKid.setYearsOld(30);
        someKid.setSalary(1);
        someKid.manOrWoman();
        someKid.employeed();
        someKid.printAge();
    }
}
