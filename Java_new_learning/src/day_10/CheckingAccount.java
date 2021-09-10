package day_10;

public class CheckingAccount {
    private double balance;//余额
    private int number;//卡号

    //创建带参构造方法，必须输入卡号
    public CheckingAccount(int number) {
        this.number = number;
    }

    //存钱
    public void deposit(double balance) {
        this.balance = balance;
    }

    //取钱
    public void withdraw(double amount) throws InsufficientFundsException {
        if(amount <= balance) {
            this.balance -= amount;
            System.out.println("你的余额剩余：" + this.getBalance());
        } else {
            double needs = amount - this.balance;
            throw new InsufficientFundsException(needs);
        }
    }
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
