package day_10;

public class InsufficientFundsException extends Exception{
    //银行取钱时的异常
    double amount;//amount存储取钱时不足的钱

    public InsufficientFundsException(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
