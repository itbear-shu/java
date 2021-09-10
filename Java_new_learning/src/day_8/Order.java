package day_8;

public class Order {
    private int orderId;
    private String orderName;

    public Order() {
    }

    public Order(int orderId) {
        this.orderId = orderId;
    }

    public Order(String orderName) {
        this.orderName = orderName;
    }

    public Order(int orderId, String orderName) {
        this.orderId = orderId;
        this.orderName = orderName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Order) {
            Order o = (Order) obj;
            if(o.orderId == this.orderId && o.orderName.equals(this.orderName)) {
                return true;
            }
        }
        return false;
    }
}
