import java.util.Scanner;
import java.util.regex.*;

public abstract class Person {
    private String name;
    private String icNumber;
    private String gender;
    private String phoneNum;
    private String email;
    private Address address;
    Scanner input = new Scanner(System.in);

    public Person() {
        this("", "", "", "", "", null);
    }

    public Person(String name, String icNumber, String gender, String phoneNum, String email, Address address) {
        this.name = name;
        this.icNumber = icNumber;
        this.gender = gender;
        this.phoneNum = phoneNum;
        this.email = email;
        this.address = address;
    }

    // Getter
    public String getName() { 
    	return this.name; 
    }
    public String getIcNumber() { 
    	return this.icNumber; 
    }
    public String getGender() { 
    	return this.gender; 
    }
    public String getPhoneNum() { 
    	return this.phoneNum; 
    }
    public String getEmail() { 
    	return this.email; 
    }
    public Address getAddress() { 
    	return this.address; 
    }

    // Setter
    public void setName(String name) { 
    	this.name = name; 
    }
    public void setIcNumber(String icNumber) { 
    	this.icNumber = icNumber; 
    }
    public void setGender(String gender) { 
    	this.gender = gender; 
    }
    public void setPhoneNum(String phoneNum) { 
    	this.phoneNum = phoneNum; 
    }
    public void setEmail(String email) { 
    	this.email = email; 
    }
    public void setAddress(Address address) { 
    	this.address = address; 
    }

    public abstract void addPerson();

    public void editPerson(int choice) {
        if (choice == 1) {
            System.out.print("Enter the New Name: ");
            name = input.nextLine();
            setName(name);
        }

        else if (choice == 2) {
            do {
                System.out.print("Enter the New IC Number (######-##-####): ");
                icNumber = input.nextLine();
                icNumber = validatePersonIC(icNumber);
            } while (!isValidPersonIC(icNumber));

            setIcNumber(icNumber);
        }


        else if (choice == 3) {
            System.out.println("------");
            System.out.println("Gender");
            System.out.println("1. Male");
            System.out.println("2. Female");

            do {
                try {
                    System.out.print("Select the New Gender: ");
                    int select = input.nextInt();

                    if (select == 1) {
                        gender = "Male";
                        input.nextLine();
                        break;
                    }

                    else if (select == 2) {
                        gender = "Female";
                        input.nextLine();
                        break;
                    }

                    else {
                        input.nextLine();
                        System.out.println("*Invalid Gender! Please try again!");
                    }
                }

                catch (Exception error) {
                    System.out.println("*Invalid Choice! It should be an integer.");
                    input.nextLine();
                }
            } while (true);

            setGender(gender);
        }

        else if (choice == 4) {
            do {
                System.out.print("Enter the New Phone Number: ");
                phoneNum = input.nextLine();
                phoneNum = validatePersonPhone(phoneNum);
            } while (!isValidPersonPhone(phoneNum));

            setPhoneNum(phoneNum);
        }

        else if (choice == 5) {
            do {
                System.out.print("Enter the New Email: ");
                email = input.nextLine();
                email = validatePersonEmail(email);
            } while (!isValidPersonEmail(email));

            setEmail(email);
        }

        else if (choice == 6) {
            address.editAddress();
        }
    }

    public static String validatePersonIC(String icNumber){
        if (isValidPersonIC(icNumber)) {
            return icNumber;
        }

        System.out.println("The IC Number should be in format ######-##-####");
        return "";
    }

    public static boolean isValidPersonIC(String icNumber) {
        String regexPersonIC = "(([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01]))-([0-9]{2})-([0-9]{4})";

        Pattern patternPersonIC = Pattern.compile(regexPersonIC);
        if (icNumber == null) {
            return false;
        }

        Matcher matchPersonIC = patternPersonIC.matcher(icNumber);
        return matchPersonIC.matches();
    }

    public static String validatePersonPhone(String phoneNum){
        if (isValidPersonPhone(phoneNum)) {
            return phoneNum;
        }

        System.out.println("The Phone Number format should be in format 01#-#######");
        return "";
    }

    public static boolean isValidPersonPhone(String phoneNum){
        String regexPersonPhone = "\\d{3}-\\d{7,8}";

        Pattern patternPersonPhone = Pattern.compile(regexPersonPhone);
        if (phoneNum == null) {
            return false;
        }

        Matcher matchPersonPhone = patternPersonPhone.matcher(phoneNum);
        return matchPersonPhone.matches();
    }

    public static String validatePersonEmail(String email){
        if (isValidPersonEmail(email)) {
            return email;
        }

        System.out.println("The Email should be in format example@mail.com");
        return "";
    }

    public static boolean isValidPersonEmail(String email){
        String regexPersonEmail = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";

        Pattern patternPersonEmail = Pattern.compile(regexPersonEmail);
        if (email == null) {
            return false;
        }

        Matcher matchPersonEmail = patternPersonEmail.matcher(email);
        return matchPersonEmail.matches();
    }
    @Override
    public String toString() {
        return String.format("%-15s|%-15s|%-7s|%-12s|%-18s|%-58s| \n", this.name, this.icNumber, this.gender, this.phoneNum, this.email, this.address);
    }
}
