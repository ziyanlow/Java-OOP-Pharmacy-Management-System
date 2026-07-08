public class Ewallet extends Payment {
    private String phoneNum;
    private String pin;

    public Ewallet() {
        super();
    }

    public Ewallet(Staff staff, Order order, Member member, double discount, double totalAmount, String phoneNum, String pin) {
        super("Ewallet", staff, order, member, discount, totalAmount);
        this.phoneNum = phoneNum;
        this.pin = pin;
    }

    // Getter
    public String getPhoneNum() { return this.phoneNum; }
    public String getPin() { return this.pin; }

    // Setter
    public void setPhoneNum(String phoneNum) { this.phoneNum = phoneNum; }
    public void setPin(String pin) { this.pin = pin; }
}
