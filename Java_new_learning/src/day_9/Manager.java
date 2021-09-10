package day_9;

public class Manager extends Employee{
    private double bonus;

    public Manager(String name, int age, double salary, double bonus) {
        super(name, age, salary);
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("经理有奖金");
    }

    public double getBonus() {
        return bonus;
    }

    @Override
    public void showInfo() {
        System.out.println("Manager: " + "---------\n" + "Name: " + this.getName() + "\n" +
                "Age: " + this.getAge() + "\n" +
                "Salary: " + this.getSalary() + "\n" +
                "Bonus: " + this.getBonus());
    }
}
