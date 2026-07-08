public class Cash extends Payment {
    private double cashAmount;
    private double change;

    public Cash() {
        super();
    }

    public Cash(Staff staff, Order order, Member member, double discount,double totalAmount, double cashAmount, double change) {
        super("Cash", staff, order, member, discount, totalAmount);
        this.cashAmount = cashAmount;
        this.change = change;
    }

    // Getter
    public double getCashAmount() { return this.cashAmount; }
    public double getChange() { return this.change; }

    // Setter
    public void setCashAmount(double cashAmount) { this.cashAmount = cashAmount; }
    public void setChange(double change) { this.change = change; }
}
