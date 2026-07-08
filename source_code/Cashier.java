public class Cashier extends Staff {
    private static int cashierCount = 0;

    public Cashier() {
        super();
    }

    public Cashier(String name, String icNumber, String gender, String phoneNum, String email, Address address, String username, String password) {
        super(name, icNumber, gender, phoneNum, email, address, "Cashier", username, password);
        cashierCount++;
    }

    public static int getCashierCount() { return cashierCount; }

    public static void setCashierCount(int cashierCount) { Cashier.cashierCount = cashierCount; }
}
