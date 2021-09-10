package day_9;

public class CommonEmployee extends Employee{

    public CommonEmployee(String name, int age, double salary) {
        super(name, age, salary);
    }

    @Override
    public void work() {
        System.out.println("普通员工");
    }

    @Override
    public void showInfo() {
        System.out.println("CommonEmployee: " + "---------\n" + "Name: " + this.getName() + "\n" +
                "Age: " + this.getAge() + "\n" +
                "Salary" + this.getSalary());
    }


}
