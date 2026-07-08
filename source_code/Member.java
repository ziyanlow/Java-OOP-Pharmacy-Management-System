 
import java.util.Scanner;
import java.util.Date;
import java.util.regex.*;

public class Member extends Person {
	//data member
    public Member[] memberList = new Member[100000];
    private String memberID;
    private String memberType;
    private Date joinDate;
    private Date expiryDate;
    private double discountRate;
    private double memberFee;
    private static int memberCount = 0;
    private static int totalMember = 0;
    private static int lastMemberID = 10001;
  
    Scanner input = new Scanner(System.in);

    public Member() {
        super();
        this.memberID = "";
        this.memberType = "";
        this.joinDate = null;
        this.expiryDate = null;
        this.discountRate = 0.0;
        this.memberFee = 0.0;
    }

    public Member(String name, String icNumber, String gender, String phoneNum, String email, Address address, String memberType, double discountRate, double memberFee) {
        super(name, icNumber, gender, phoneNum, email, address);
        this.memberID = "M" + lastMemberID;
        this.memberType = memberType;
        this.joinDate = new Date();
        this.expiryDate = new Date();      
        this.expiryDate.setYear(this.joinDate.getYear() + 2);
        memberCount++;
        totalMember++;
        lastMemberID++;
        
         // Calculate member fee and discount rate
        if ("Gold".equals(memberType)) {
            this.memberFee = 100.0;
            this.discountRate = 0.2; 
        } else if ("Silver".equals(memberType)) {
            this.memberFee = 200.0;
            this.discountRate = 0.1; 
        } else {
            //other member (regular customer)
            this.memberFee = 0.0;
            this.discountRate = 0.0; 
        }      
    }
    
    // Getter
    public String getMemberID() { 
    	return this.memberID; 
    }
    public String getMemberType() { 
    	return this.memberType; 
    }
    
    public String getJoinDate() {
       return String.format("%02d/%02d/%4d", this.joinDate.getDate(), this.joinDate.getMonth() + 1, this.joinDate.getYear() + 1900);

    }
    
    public String getExpiryDate() {
      return String.format("%02d/%02d/%4d", this.expiryDate.getDate(), this.expiryDate.getMonth() + 1, this.expiryDate.getYear() + 1900);

    }
    
    public double getDiscountRate() {
        return this.discountRate;
    }

    public double getMemberFee() {
        return this.memberFee;
    }

    public static int getMemberCount() {
        return memberCount;
    }

    public static int getTotalMember() {
        return totalMember;
    }

    public static int getLastMemberID() {
        return lastMemberID;
    }
    // Setter
    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public void setMemberFee(double memberFee) {
        this.memberFee = memberFee;
    }

    public static void setMemberCount(int memberCount) {
        Member.memberCount = memberCount;
    }

    public static void setTotalMember(int totalMember) {
        Member.totalMember = totalMember;
    }

    public static void setLastMemberID(int lastMemberID) {
        Member.lastMemberID = lastMemberID;
    }


	public void createDefaultMember() {
        Address[] addressList = new Address[5];
        addressList[0] = new Address("5", "Jalan 38D", "14010", "Georgetown", "Penang");
        addressList[1] = new Address("33", "Jalan Raja Uda", "14130", "Seberang Perai", "Penang");
        addressList[2] = new Address("10", "Jalan 42E", "14020", "Georgetown", "Penang");
        addressList[3] = new Address("44", "Jalan Permatang", "14140", "Seberang Perai", "Penang");
        addressList[4] = new Address("22", "Jalan Bagan Lallang", "14150", "Seberang Perai", "Penang");

        memberList[0] = new Silver("John Doe", "040101-07-1234", "Male", "012-3219238", "johndoe@gmail.com", addressList[0]);
        memberList[1] = new Gold("Jane Smith", "050202-07-5678", "Female", "019-8765432", "jsmith@gmail.com", addressList[1]);
        memberList[2] = new Gold("Alice Johnson", "030410-07-1239",  "Female", "011-9876543", "alice@gmail.com", addressList[2]);
        memberList[3] = new Gold("Bob Williams", "021212-02-9876", "Male", "017-8765432", "williams@gmail.com", addressList[3]);
        memberList[4] = new Silver("Tan Xin Yee", "000410-07-0009", "Female", "014-5678901", "xinyee@gmail.com", addressList[4]);
    }

    public void menuMember() {
        int choice;

        do {
            System.out.println("===========================");
            System.out.println("   Member Menu   ");
            System.out.println("===========================");
            System.out.println("1. Display Member");
            System.out.println("2. Add Member");
            System.out.println("3. Search Member");
            System.out.println("4. Delete Expired Member");
            System.out.println("5. Modify Member");
            System.out.println("6. Renew Member");
            System.out.println("0. Quit");

            do {
                try {
                    System.out.print("Enter your choice: ");
                    choice = input.nextInt();
                    input.nextLine();
                    break;
                } catch (Exception error) {
                    System.out.println("*Invalid Choice! It should be an integer.");
                    input.nextLine();
                }
            } while (true);

            System.out.println();

            switch (choice) {
                case 1:
                    displayMember();
                    break;
                case 2:
                    addPerson();
                    break;
                case 3:
                    searchMember();
                    break;
                case 4:
                    deleteMember();
                    break;
                case 5:
                    modifyMember();
                    break;
                case 6:
                    renewMember();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice! Please Try Again!");
            }
        } while (true);
    }
    
    public void displayMember() {
        System.out.println("===============================================================================================================================================================================");
        System.out.printf("%-100s%s%99s\n", "|", "Member List", "|");
        System.out.println("===============================================================================================================================================================================");
        System.out.printf("|%-9s |%-10s |%-10s|%-6s |%-13s  |%-13s  |%-7s|%-10s|%-17s |%-58s|\n", "Member ID", "Join Date", "Expiry Date", "Level", "Name", "ICNumber", "Gender", "Phone Number", "Email", "Address");
        System.out.println("|----------|-----------|-----------|-------|---------------|---------------|-------|------------|------------------|----------------------------------------------------------|");
        for (int i = 0; i < totalMember; i++) {
            if (!memberList[i].memberID.equals("")) {
                System.out.print(memberList[i].toString());
            }
        }
        System.out.println("===============================================================================================================================================================================");
        System.out.print("Silver:  " + Silver.getSilverCount());
        System.out.print("\nGold: " + Gold.getGoldCount());
        System.out.println("\nTotal Member: " + memberCount);
        System.out.println();
    }

 	
    public void addPerson() {
        String icNumber = "";
        String gender = "";
        String phoneNum = "";
        String email = "";
        char confirmation;

        System.out.println("================");
        System.out.println("   Add Member   ");
        System.out.println("================");

        System.out.print("Enter the Name: ");
        String name = input.nextLine();

        do {
            System.out.print("Enter the IC Number (YYMMDD-XX-XXXX): ");
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
                    
                } else if (choice == 2) {
                    gender = "Female";
                    input.nextLine();
                    break;
                    
                } else {
                    input.nextLine();
                    System.out.println("*Invalid Gender! Please try again!");
                }
            } catch (Exception error) {
                System.out.println("*Invalid Choice! ");
                input.nextLine();
            }
        } while (true);

        do {
            System.out.print("Enter the Phone Number: ");
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

         System.out.println("------------");
        System.out.println("Member Level");
        System.out.println("1. Silver");
        System.out.println("2. Gold");

        do {
            try {
                System.out.print("Select the Member Type: ");
                int choice = input.nextInt();

                if (choice == 1) {
                    String memberType = "Silver";
                    input.nextLine();

                    do {
                        do {
                            try {
                                System.out.print("Are you sure to add " + name + " as " + memberType + " Member (Y/N): ");
                                confirmation = input.nextLine().charAt(0);
                                if (Character.toUpperCase(confirmation) == 'Y') {
                                    memberList[totalMember] = new Silver(name, icNumber, gender, phoneNum, email, address);
                                    System.out.printf("The new Silver Member (%s) is created successfully! \n", name);
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

                else if (choice == 2) {
                    String memberType = "Gold";
                    input.nextLine();

                    do {
                        do {
                            try {
                                System.out.print("Are you sure to add " + name + " as " + memberType + " Member (Y/N): ");
                                confirmation = input.nextLine().charAt(0);
                                if (Character.toUpperCase(confirmation) == 'Y') {
                                    memberList[totalMember] = new Gold(name, icNumber, gender, phoneNum, email, address);
                                    System.out.printf("The new Gold Member (%s) is created successfully! \n", name);
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
                    System.out.println("*Invalid Member Type! Please try again!");
                }
            }

            catch (Exception error) {
                System.out.println("*Invalid Choice! It should be an integer.");
                input.nextLine();
            }
        } while (true);
        System.out.println();
 }
    public void searchMember() {
        int found = 0;

        System.out.println("===================");
        System.out.println("   Search Member   ");
        System.out.println("===================");

        do {
            System.out.print("Enter the IC Number: ");
            String icNumber = input.nextLine();
			/*
			System.out.println("===============================================================================================================================================================================");
	        System.out.printf("%-100s%s%99s\n", "|", "Member List", "|");
	        System.out.println("===============================================================================================================================================================================");
	        System.out.printf("|%-9s |%-10s |%-10s|%-6s |%-13s  |%-13s  |%-7s|%-10s|%-17s |%-58s|\n", "Member ID", "Join Date", "Expiry Date", "Level", "Name", "ICNumber", "Gender", "Phone Number", "Email", "Address");
	        System.out.println("|----------|-----------|-----------|-------|---------------|---------------|-------|------------|------------------|----------------------------------------------------------|");
	        for (int i = 0; i < totalMember; i++) {
	            if (!memberList[i].memberID.equals("")) {
	                System.out.print(memberList[i].toString());
	            }
	        }
	        System.out.println("===============================================================================================================================================================================");
	        */
            for (int i = 0; i < totalMember; i++) {
                if (icNumber.equals(memberList[i].getIcNumber())) {
                    System.out.println("===============================================================================================================================================================================");
			        System.out.printf("%-100s%s%99s\n", "|", "Member List", "|");
			        System.out.println("===============================================================================================================================================================================");
			        System.out.printf("|%-9s |%-10s |%-10s|%-6s |%-13s  |%-13s  |%-7s|%-10s|%-17s |%-58s|\n", "Member ID", "Join Date", "Expiry Date", "Level", "Name", "ICNumber", "Gender", "Phone Number", "Email", "Address");
			        System.out.println("|----------|-----------|-----------|-------|---------------|---------------|-------|------------|------------------|----------------------------------------------------------|");
			        System.out.print(memberList[i].toString());
		            System.out.println("===============================================================================================================================================================================");
	        		System.out.println();
                    found++;
                    break;
                }
            }

            if (found == 0) {
                System.out.println("*This Member is not existed.");
            }
        } while (found == 0);
        return;
    }

	public void deleteMember() {
        int found = 0;
        int deleteIndex = 0;
        char confirmation = 'N';

        System.out.println("===================");
        System.out.println("   Delete Member   ");
        System.out.println("===================");

        do {
            System.out.print("Enter the Member ID: ");
            memberID = input.nextLine().toUpperCase();

            for (int i = 0; i < totalMember; i++) {
                if (memberID.equals(memberList[i].memberID)) {
                    System.out.println("===============================================================================================================================================================================");
			        System.out.printf("%-100s%s%99s\n", "|", "Member List", "|");
			        System.out.println("===============================================================================================================================================================================");
			        System.out.printf("|%-9s |%-10s |%-10s|%-6s |%-13s  |%-13s  |%-7s|%-10s|%-17s |%-58s|\n", "Member ID", "Join Date", "Expiry Date", "Level", "Name", "ICNumber", "Gender", "Phone Number", "Email", "Address");
			        System.out.println("|----------|-----------|-----------|-------|---------------|---------------|-------|------------|------------------|----------------------------------------------------------|");
			        System.out.print(memberList[i].toString());
		            System.out.println("===============================================================================================================================================================================");
	        		found++;
                    deleteIndex = i;
                    break;
                }
            }

            if (found == 0) {
                System.out.println("*This Member ID is not existed. Please try again!");
            }
        } while (found == 0);

        do {
            do {
                try {
                    System.out.print("Are you sure to delete " + memberList[deleteIndex].getName() + " (Y/N): ");
                    confirmation = input.nextLine().charAt(0);
                    if (Character.toUpperCase(confirmation) == 'Y') {
                        if (memberList[deleteIndex].getClass().getSimpleName().equals("Silver")) {
                            memberList[deleteIndex] = new Silver();
                            Silver.setSilverCount(Silver.getSilverCount() - 1);
                        }

                        else if (memberList[deleteIndex].getClass().getSimpleName().equals("Gold")) {
                            memberList[deleteIndex] = new Gold();
                            Gold.setGoldCount(Gold.getGoldCount() - 1);
                        }
                        
                        memberCount--;
                        System.out.printf("The Member (%s) is deleted successfully! \n", memberID);
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


    public void modifyMember() {
        int found = 0;
        int editIndex = 0;
        int choice = 0;

        System.out.println("=================");
        System.out.println("   Edit Member   ");
        System.out.println("=================");

        do {
            System.out.print("Enter the Member ID: ");
            memberID = input.nextLine().toUpperCase();

            for (int i = 0; i < totalMember; i++) {
                if (memberID.equals(memberList[i].memberID)) {
                    System.out.println("===============================================================================================================================================================================");
			        System.out.printf("%-100s%s%99s\n", "|", "Member List", "|");
			        System.out.println("===============================================================================================================================================================================");
			        System.out.printf("|%-9s |%-10s |%-10s|%-6s |%-13s  |%-13s  |%-7s|%-10s|%-17s |%-58s|\n", "Member ID", "Join Date", "Expiry Date", "Level", "Name", "ICNumber", "Gender", "Phone Number", "Email", "Address");
			        System.out.println("|----------|-----------|-----------|-------|---------------|---------------|-------|------------|------------------|----------------------------------------------------------|");
			        System.out.print(memberList[i].toString());
		            System.out.println("===============================================================================================================================================================================");
	        		System.out.println();
                    found++;
                    editIndex = i;
                    break;
                }
            }

            if (found == 0) {
                System.out.println("*This Member ID is not existed. ");
            }
        } while (found == 0);

        do {
            System.out.println("============================");
            System.out.printf("   Edit Member  \n");
            System.out.println("============================");
            System.out.println("1. Name");
            System.out.println("2. IC Number");
            System.out.println("3. Gender");
            System.out.println("4. Phone");
            System.out.println("5. Email");
            System.out.println("6. Address");
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
                memberList[editIndex].editPerson(choice);
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
    
   	public void renewMember() {
    int found = 0;
    int renewIndex = -1;
    char confirmation;

    System.out.println("==================");
    System.out.println("   Renew Member   ");
    System.out.println("==================");

    do {
        System.out.print("Enter the Member ID: ");
        String inputMemberID = input.nextLine().toUpperCase();

        for (int i = 0; i < totalMember; i++) {
            if (inputMemberID.equals(memberList[i].getMemberID())) {
                System.out.println("===============================================================================================================================================================================");
			        System.out.printf("%-100s%s%99s\n", "|", "Member List", "|");
			        System.out.println("===============================================================================================================================================================================");
			        System.out.printf("|%-9s |%-10s |%-10s|%-6s |%-13s  |%-13s  |%-7s|%-10s|%-17s |%-58s|\n", "Member ID", "Join Date", "Expiry Date", "Level", "Name", "ICNumber", "Gender", "Phone Number", "Email", "Address");
			        System.out.println("|----------|-----------|-----------|-------|---------------|---------------|-------|------------|------------------|----------------------------------------------------------|");
			        System.out.print(memberList[i].toString());
		            System.out.println("===============================================================================================================================================================================");
	        		found++;
                renewIndex = i;
                break;
            }
        }

        if (found == 0) {
            System.out.println("*This Member ID is not existed. ");
        }
    } while (found == 0);

   
        do {
            do {
                try {
                    System.out.print("Are you sure to renew " + memberList[renewIndex].getName() + " membership for 2 years (Y/N): ");
                    confirmation = input.nextLine().charAt(0);
                    if (Character.toUpperCase(confirmation) == 'Y') {
                        memberList[renewIndex].expiryDate.setYear(memberList[renewIndex].expiryDate.getYear() + 2);
                        System.out.printf("The Member (%s) is renewed successfully! \n", memberID);
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

    public Member getMemberDetails(String icNumber) {
        for (int i = 0; i < totalMember; i++)
            if (icNumber.equals(memberList[i].getIcNumber())) {
                return memberList[i];
            }

        return null;
    }
	    	
    @Override
    public String toString() {
        return String.format("|%-9s |%-10s |%-10s |%-6s |", this.memberID, this.getJoinDate(), this.getExpiryDate(), this.memberType) + super.toString();
    }
}


