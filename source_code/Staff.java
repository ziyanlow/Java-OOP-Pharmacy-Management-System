import java.util.Scanner;

public class Staff extends Person {
    public Staff[] staffList = new Staff[100000];
    private String staffID;
    private String position;
    private String username;
    private String password;
    private static int staffCount = 0;
    private static int totalStaff = 0;
    private static int lastStaffID = 100001;
    Scanner input = new Scanner(System.in);

    public Staff() {
        super();
        this.staffID = "";
        this.position = "";
        this.username = "";
        this.password = "";
    }

    public Staff(String name, String icNumber, String gender, String phoneNum, String email, Address address, String position, String username, String password) {
        super(name, icNumber, gender, phoneNum, email, address);
        this.staffID = "S-" + lastStaffID;
        this.position = position;
        this.username = username;
        this.password = password;
        staffCount++;
        totalStaff++;
        lastStaffID++;
    }

    // Getter
    public String getStaffID() { return this.staffID; }
    public String getPosition() { return this.position; }
    public String getUsername() { return this.username; }
    public String getPassword() { return this.password; }
    public static int getStaffCount() { return staffCount; }
    public static int getTotalStaff() { return totalStaff; }
    public static int getLastStaffID() { return lastStaffID; }

    // Setter
    public void setStaffID(String staffID) { this.staffID = staffID; }
    public void setPosition(String position) { this.position = position; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public static void setStaffCount(int staffCount) { Staff.staffCount = staffCount; }
    public static void setTotalStaff(int totalStaff) { Staff.totalStaff = totalStaff; }
    public static void setLastStaffID(int lastStaffID) { Staff.lastStaffID = lastStaffID; }

    public void createDefaultStaff() {
        Address[] addressList = new Address[10];
        addressList[0] = new Address("2-A","Lintang permai","10450","Georgetown","Pulau Pinang");
        addressList[1] = new Address("5","Jalan Air itam","11700","Georgetown","Pulau Pinang");
        addressList[2] = new Address("23","Lebuh Kurau 9","13100","Butterworth","Pulau Pinang");
        addressList[3] = new Address("21","Lorong Ketiga","12000","Georgetown","Pulau Pinang");
        addressList[4] = new Address("1","Jalan Masjlid","14500","Butterworth","Pulau Pinang");
        addressList[5] = new Address("39","lembah permai 3","11450","Butterworth","Pulau Pinang");
        addressList[6] = new Address("212","Jalan Bengkok","11230","Butterworth","Pulau Pinang");
        addressList[7] = new Address("42-A","Jalan Petaling Jaya","19200","Georgetorn","Pulau Pinang");
        addressList[8] = new Address("Block A 13","Jalan Melody","16700","Georgetown","Pulau Pinang");
        addressList[9] = new Address("13","Jalan Sri Pertaling","12600","Georgetown","Pulau Pinang");

		staffList[0] = new Admin("Low Zi Yan", "040718-02-1111", "Female", "011-51034821", "ziyan@gmail.com", addressList[1], "ziyan", "ziyan66");
        staffList[1] = new Admin("Lim Pei Ling", "030410-07-0009", "Female", "012-3456789", "peiling@gmail.com", addressList[1], "peiling", "peiLing12");
        staffList[2] = new Admin("Tan Wan Yong", "030418-07-0011", "Female", "013-4567890", "wanyong@gmail.com", addressList[2], "wanyong", "wy78");
        staffList[3] = new Admin("Lim Xiao Jie", "030527-07-0008", "Male", "010-3428830", "xiaojie@gmail.com", addressList[3], "xiaojie", "xiaojie123");
        staffList[4] = new Admin("Wong Shi Ting", "020918-07-0013", "Female", "017-8628533", "shiting@gmail.com", addressList[4], "shiting", "shiting0");
        staffList[5] = new Cashier("Tan Wei Ken", "040718-02-0000", "Male", "011-10897733", "wenken@gmail.com", addressList[5], "jenny", "jenny");
        staffList[6] = new Cashier("Low Yu Xuan", "030227-07-0012", "Female", "012-7457836", "yuxuan@gmail.com", addressList[6], "yuxuan", "yuxuan");
        staffList[7] = new Cashier("Daniel", "040419-07-0016", "Male", "018-5784706", "daniel@gmail.com", addressList[7], "daniel", "daniel");
        staffList[8] = new Cashier("Ashely Lim", "040112-07-0018", "Female", "011-73122153", "ashley@gmail.com", addressList[8], "ashley", "ashley111");
        staffList[9] = new Cashier("Joavial Bong", "040216-07-0020", "Male", "018-9445256", "jovial@gmail.com", addressList[9], "bong", "jovial");
    }

    public void adminMenuStaff() {
        int choice = 0;

        do {
            System.out.println("========================");
            System.out.println("   Staff Menu (Admin)   ");
            System.out.println("========================");
            System.out.println("1. Display Staff");
            System.out.println("2. Add Staff");
            System.out.println("3. Search Staff");
            System.out.println("4. Delete Staff");
            System.out.println("5. Edit Staff");
            System.out.println("0. Quit");

            do {
                try {
                    System.out.print("Enter your choice: ");
                    choice = input.nextInt();
                    input.nextLine();
                    break;
                }catch (Exception error) {
                    System.out.println("*Invalid Choice! It should be an integer.");
                    input.nextLine();
                }
            } while (true);

            System.out.println();
            if (choice == 1) {
                displayStaff();
            }

            else if (choice == 2) {
                addPerson();
            }

            else if (choice == 3) {
                searchStaff();
            }

            else if (choice == 4) {
                deleteStaff();
            }

            else if (choice == 5) {
                editStaff();
            }

            else if (choice == 0) {
                break;
            }

            else {
                System.out.println("*Invalid Choice! Please try again!");
                System.out.println();
            }
        } while (true);
    }

    public void displayStaff() {
        System.out.println("=========================================================================================================================================================");
        System.out.printf("%-70s%s%73s\n", "|", "Staff List", "|");
        System.out.println("=========================================================================================================================================================");
        System.out.printf("|%-10s|%-9s|%-15s|%-15s|%-7s|%-12s|%-18s|%-58s| \n", "Staff ID", "Position", "Name", "IC Number","Gender", "Phone Number", "Email", "Address");
        System.out.println("|----------|---------|---------------|---------------|-------|------------|------------------|----------------------------------------------------------|");
        for (int i = 0; i < totalStaff; i++) {
            if (!staffList[i].staffID.equals("")) {
                System.out.print(staffList[i].toString());
            }
        }
        System.out.println("=========================================================================================================================================================");
        System.out.println("Admin: " + Admin.getAdminCount());
        System.out.println("Cashier: " + Cashier.getCashierCount());
        System.out.println("Total Staff: " + staffCount);
        System.out.println();
    }

    public void addPerson() {
        String icNumber = "";
        String gender = "";
        String phoneNum = "";
        String email = "";
        int invalid = 0;
        char confirmation = 'N';

        System.out.println("===============");
        System.out.println("   Add Staff   ");
        System.out.println("===============");

        System.out.print("Enter the Name: ");
        String name = input.nextLine();

        do {
            System.out.print("Enter the IC Number (######-##-####): ");
            icNumber = input.nextLine();
            icNumber = validatePersonIC(icNumber);
        } while (!isValidPersonIC(icNumber));
        System.out.println("------");
        System.out.println("Gender");
        System.out.println("1. Male");
        System.out.println("2. Female");

        do {
            try {
                System.out.print("Select the Gender: ");
                int choice = input.nextInt();

                if (choice == 1) {
                    gender = "Male";
                    input.nextLine();
                    break;
                }else if (choice == 2) {
                    gender = "Female";
                    input.nextLine();
                    break;
                }else {
                    input.nextLine();
                    System.out.println("*Invalid Gender! Please try again!");
                }
            }

            catch (Exception error) {
                System.out.println("*Invalid Choice! It should be an integer.");
                input.nextLine();
            }
        } while (true);

        do {
            System.out.print("Enter the Phone Number (###-########): ");
            phoneNum = input.nextLine();
            phoneNum = validatePersonPhone(phoneNum);
        } while (!isValidPersonPhone(phoneNum));

        do {
            System.out.print("Enter the Email: ");
            email = input.nextLine();
            email = validatePersonEmail(email);
        } while (!isValidPersonEmail(email));

        Address address = new Address();
        address.addAddress();

        do {
            invalid = 0;

            System.out.print("Enter the Username: ");
            username = input.nextLine();

            for (int i = 0; i < totalStaff; i++) {
                if (username.equals(staffList[i].username)) {
                    System.out.println("*This Username has already existed. Please try again!");
                    invalid++;
                    break;
                }
            }
        } while (invalid > 0);

        System.out.print("Enter the Password: ");
        password = input.nextLine();

        System.out.println();
        System.out.println("--------------");
        System.out.println("Staff Position");
        System.out.println("1. Admin");
        System.out.println("2. Cashier");

        do {
            try {
                System.out.print("Select the Staff Position: ");
                int choice = input.nextInt();

                if (choice == 1) {
                    String position = "Admin";
                    input.nextLine();

                    do {
                        do {
                            try {
                                System.out.print("Are you sure to add " + name + " as " + position + " (Y/N): ");
                                confirmation = input.nextLine().charAt(0);
                                if (Character.toUpperCase(confirmation) == 'Y') {
                                    staffList[totalStaff] = new Admin(name, icNumber, gender, phoneNum, email, address, username, password);
                                    System.out.printf("The new Admin (%s) is created successfully! \n", name);
                                }else if (Character.toUpperCase(confirmation) != 'Y' && Character.toUpperCase(confirmation) != 'N') {
                                    System.out.println("*Invalid! It should be 'Y' or 'N'.");
                                }
                                break;
                            }

                            catch (StringIndexOutOfBoundsException error) {
                                System.out.println("*Invalid! It should be 'Y' or 'N'.");
                            }
                        } while (true);
                    } while (Character.toUpperCase(confirmation) != 'Y' && Character.toUpperCase(confirmation) != 'N');
                    break;
                }

                else if (choice == 2) {
                    String position = "Cashier";
                    input.nextLine();

                    do {
                        do {
                            try {
                                System.out.print("Are you sure to add " + name + " as " + position + " (Y/N): ");
                                confirmation = input.nextLine().charAt(0);
                                if (Character.toUpperCase(confirmation) == 'Y') {
                                    staffList[totalStaff] = new Cashier(name, icNumber, gender, phoneNum, email, address, username, password);
                                    System.out.printf("The new Cashier (%s) is created successfully! \n", name);
                                }

                                else if (Character.toUpperCase(confirmation) != 'Y' && Character.toUpperCase(confirmation) != 'N') {
                                    System.out.println("*Invalid! It should be 'Y' or 'N'.");
                                }
                                break;
                            }

                            catch (StringIndexOutOfBoundsException error) {
                                System.out.println("*Invalid! It should be 'Y' or 'N'.");
                            }
                        } while (true);
                    } while (Character.toUpperCase(confirmation) != 'Y' && Character.toUpperCase(confirmation) != 'N');
                    break;
                }

                else {
                    input.nextLine();
                    System.out.println("*Invalid Staff Position! Please try again!");
                }
            }

            catch (Exception error) {
                System.out.println("*Invalid Choice! It should be an integer.");
                input.nextLine();
            }
        } while (true);
        System.out.println();
    }

    public void searchStaff() {
        int found = 0;

        System.out.println("==================");
        System.out.println("   Search Staff   ");
        System.out.println("==================");

        do {
            System.out.print("Enter the IC Number: ");
            String icNumber = input.nextLine();

            for (int i = 0; i < totalStaff; i++) {
                if (icNumber.equals(staffList[i].getIcNumber())) {
                    System.out.println("=========================================================================================================================================================");
			        System.out.printf("%-70s%s%73s\n", "|", "Staff List", "|");
			        System.out.println("=========================================================================================================================================================");
			        System.out.printf("|%-10s|%-9s|%-15s|%-15s|%-7s|%-12s|%-18s|%-58s| \n", "Staff ID", "Position", "Name", "IC Number","Gender", "Phone Number", "Email", "Address");
			        System.out.println("|----------|---------|---------------|---------------|-------|------------|------------------|----------------------------------------------------------|");
			        System.out.print(staffList[i].toString());
			        System.out.println("=========================================================================================================================================================");
        			System.out.println();
                    found++;
                    break;
                }
            }

            if (found == 0) {
                System.out.println("*This Staff is not existed. Please try again!");
            }
        } while (found == 0);
    }

    public void deleteStaff() {
        int found = 0;
        int deleteIndex = 0;
        char confirmation = 'N';

        System.out.println("==================");
        System.out.println("   Delete Staff   ");
        System.out.println("==================");

        do {
            System.out.print("Enter the Staff ID: ");
            staffID = input.nextLine().toUpperCase();

            for (int i = 0; i < totalStaff; i++) {
                if (staffID.equals(staffList[i].staffID)) {
                    System.out.println("=========================================================================================================================================================");
			        System.out.printf("%-70s%s%73s\n", "|", "Staff List", "|");
			        System.out.println("=========================================================================================================================================================");
			        System.out.printf("|%-10s|%-9s|%-15s|%-15s|%-7s|%-12s|%-18s|%-58s| \n", "Staff ID", "Position", "Name", "IC Number","Gender", "Phone Number", "Email", "Address");
			        System.out.println("|----------|---------|---------------|---------------|-------|------------|------------------|----------------------------------------------------------|");
			        System.out.print(staffList[i].toString());
                    System.out.println("=========================================================================================================================================================");
        			found++;
                    deleteIndex = i;
                    break;
                }
            }

            if (found == 0) {
                System.out.println("*This Staff ID is not existed. Please try again!");
            }
        } while (found == 0);

        do {
            do {
                try {
                    System.out.print("Are you sure to delete " + staffList[deleteIndex].getName() + " (Y/N): ");
                    confirmation = input.nextLine().charAt(0);
                    if (Character.toUpperCase(confirmation) == 'Y') {
                        if (staffList[deleteIndex].getClass().getSimpleName().equals("Admin")) {
                            staffList[deleteIndex] = new Admin();
                            Admin.setAdminCount(Admin.getAdminCount() - 1);
                        }

                        else if (staffList[deleteIndex].getClass().getSimpleName().equals("Cashier")) {
                            staffList[deleteIndex] = new Cashier();
                            Cashier.setCashierCount(Cashier.getCashierCount() - 1);
                        }

                        staffCount--;
                        System.out.printf("The Staff (%s) is deleted successfully! \n", staffID);
                    }

                    else if (Character.toUpperCase(confirmation) != 'Y' && Character.toUpperCase(confirmation) != 'N') {
                        System.out.println("*Invalid! It should be 'Y' or 'N'.");
                    }
                    break;
                }

                catch (StringIndexOutOfBoundsException error) {
                    System.out.println("*Invalid! It should be 'Y' or 'N'.");
                }
            } while (true);
        } while (Character.toUpperCase(confirmation) != 'Y' && Character.toUpperCase(confirmation) != 'N');
        System.out.println();
    }

    public void editStaff() {
        int found = 0;
        int editIndex = 0;
        int choice = 0;
        int invalid = 0;

        System.out.println("================");
        System.out.println("   Edit Staff   ");
        System.out.println("================");

        do {
            System.out.print("Enter the Staff ID: ");
            staffID = input.nextLine().toUpperCase();

            for (int i = 0; i < totalStaff; i++) {
                if (staffID.equals(staffList[i].staffID)) {
                    System.out.println("=========================================================================================================================================================");
			        System.out.printf("%-70s%s%73s\n", "|", "Staff List", "|");
			        System.out.println("=========================================================================================================================================================");
			        System.out.printf("|%-10s|%-9s|%-15s|%-15s|%-7s|%-12s|%-18s|%-58s| \n", "Staff ID", "Position", "Name", "IC Number","Gender", "Phone Number", "Email", "Address");
			        System.out.println("|----------|---------|---------------|---------------|-------|------------|------------------|----------------------------------------------------------|");
			        System.out.print(staffList[i].toString());
                    System.out.println("=========================================================================================================================================================");
        			System.out.println();
                    found++;
                    editIndex = i;
                    break;
                }
            }

            if (found == 0) {
                System.out.println("*This Staff ID is not existed. Please try again!");
            }
        } while (found == 0);

        do {
            System.out.println("===========================");
            System.out.printf("   Edit Staff (%s)   \n", staffID);
            System.out.println("===========================");
            System.out.println("1. Name");
            System.out.println("2. IC Number");
            System.out.println("3. Gender");
            System.out.println("4. Phone");
            System.out.println("5. Email");
            System.out.println("6. Address");
            System.out.println("9. Position");
            System.out.println("7. Username");
            System.out.println("8. Password");
            System.out.println("0. Quit");

            do {
                try {
                    System.out.print("Enter your choice: ");
                    choice = input.nextInt();
                    input.nextLine();
                    break;
                }

                catch (Exception error) {
                    System.out.println("*Invalid Choice! It should be an integer.");
                    input.nextLine();
                }
            } while (true);

            if (choice >= 1 && choice <= 6) {
                staffList[editIndex].editPerson(choice);
            }

            else if (choice == 7) {
                do {
                    invalid = 0;

                    System.out.print("Enter the New Username: ");
                    username = input.nextLine();

                    for (int i = 0; i < totalStaff; i++) {
                        if (username.equals(staffList[i].username)) {
                            System.out.println("*This Username has already existed. Please try again!");
                            invalid++;
                            break;
                        }
                    }
                } while (invalid > 0);

                staffList[editIndex].setUsername(username);
            }

            else if (choice == 8) {
                System.out.print("Enter the New Password: ");
                password = input.nextLine();
                staffList[editIndex].setPassword(password);
            }
			else if(choice==9){
				System.out.print("Enter the New Position: ");
                position = input.nextLine();
                staffList[editIndex].setPosition(position);
			}
            else if (choice == 0) {
                break;
            }

            else {
                System.out.println("*Invalid Choice! Please try again!");
                System.out.println();
            }
        } while (true);
        System.out.println();
    }

	//validate login of staff
    public boolean validateLogin(String username, String password) {
        for (int i = 0; i < totalStaff; i++) {
            if (staffList[i].username.equals(username)) {
                if (staffList[i].password.equals(password)) {
                    System.out.println("Welcome [" + staffList[i].position + "] " + staffList[i].getName() + "!");
                    return true;
                }
            }
        }

        return false;
    }

    public Staff getLoginStaffDetails(String username) {
        for (int i = 0; i < totalStaff; i++)
            if (staffList[i].username.equals(username)) {
                return staffList[i];
            }

        return null;
    }

    @Override
    public String toString() {
        return String.format("|%-9s |%-8s |", this.staffID,this.position) + super.toString();
    }
}
