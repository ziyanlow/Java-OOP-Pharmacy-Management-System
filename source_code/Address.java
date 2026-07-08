import java.util.Scanner;

public class Address {
    private String unitNum;
    private String street;
    private String postcode;
    private String city;
    private String state;
    Scanner input = new Scanner(System.in);

    public Address() {
        this("", "", "", "", "");
    }

    public Address(String unitNum, String street, String postcode, String city, String state) {
        this.unitNum = unitNum;
        this.street = street;
        this.postcode = postcode;
        this.city = city;
        this.state = state;
    }

    // Getter
    public String getUnitNum() { return this.unitNum; }
    public String getStreet() { return this.street; }
    public String getPostcode() { return this.postcode; }
    public String getCity() { return this.city; }
    public String getState() { return this.state; }

    // Setter
    public void setUnitNum(String unitNum) { this.unitNum = unitNum; }
    public void setStreet(String street) { this.street = street; }
    public void setPostcode(String postcode) { this.postcode = postcode; }
    public void setCity(String city) { this.city = city; }
    public void setState(String state) { this.state = state; }

    public void addAddress() {
        System.out.println();
        System.out.println("-------");
        System.out.println("Address");
        System.out.print("Enter Unit Number: ");
        unitNum = input.nextLine();

        System.out.print("Enter Street: ");
        street = input.nextLine();

        System.out.print("Enter Postcode: ");
        postcode = input.nextLine();

        System.out.print("Enter City: ");
        city = input.nextLine();

        System.out.print("Enter State: ");
        state = input.nextLine();

        Address address = new Address(unitNum, street, postcode, city, state);
        System.out.println();
    }

    public void editAddress() {
        System.out.println("-------");
        System.out.println("Address");
        System.out.print("Enter New Unit Number: ");
        unitNum = input.nextLine();

        System.out.print("Enter New Street: ");
        street = input.nextLine();

        System.out.print("Enter New Postcode: ");
        postcode = input.nextLine();

        System.out.print("Enter New City: ");
        city = input.nextLine();

        System.out.print("Enter New State: ");
        state = input.nextLine();

        setUnitNum(unitNum);
        setStreet(street);
        setPostcode(postcode);
        setCity(city);
        setState(state);
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s %s, %s", this.unitNum, this.street, this.postcode, this.city, this.state);
    }
}
