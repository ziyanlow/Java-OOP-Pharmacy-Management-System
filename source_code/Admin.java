public class Admin extends Staff {
    private static int adminCount = 0;

    public Admin() {
        super();
    }

    public Admin(String name, String icNumber, String gender, String phoneNum, String email, Address address, String username, String password) {
        super(name, icNumber, gender, phoneNum, email, address, "Admin", username, password);
        adminCount++;
    }

    public static int getAdminCount() { return adminCount; }

    public static void setAdminCount(int adminCount) { Admin.adminCount = adminCount; }
}
