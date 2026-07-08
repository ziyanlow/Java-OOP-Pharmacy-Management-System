import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Date;
import java.text.DecimalFormat;

public class Payment {
	public Payment[] paymentList = new Payment[100000];
	private String paymentID;
    private Date paymentDateTime;
    private String paymentMethod;
    private Staff staff;
    private Order order;
    private Member member;
    private double discount;
    private double totalAmount;
    private static int paymentCount = 0;
    private static int lastPaymentID = 100001;
    String tempOrderID = "";
    Scanner input = new Scanner(System.in);
	
	public Payment(){
		this.paymentID = "";
        this.paymentDateTime = null;
        this.paymentMethod = "";
        this.staff = null;
        this.order = null;
        this.member = null;
        this.discount = 0.0;
        this.totalAmount = 0.0;
	}
	
	public Payment(String paymentMethod, Staff staff, Order order, Member member, double discount, double totalAmount) {
        this.paymentID = "P-" + lastPaymentID;
        this.paymentDateTime = new Date();
        this.paymentMethod = paymentMethod;
        this.staff = staff;
        this.order = order;
        this.member = member;
        this.discount = discount;
        this.totalAmount = totalAmount;
        paymentCount++;
        lastPaymentID++;
    }
     
    // Getter
    public String getPaymentID() { return this.paymentID; }
    public Date getPaymentDateTime() { return this.paymentDateTime; }
    public String getPaymentMethod() { return this.paymentMethod; }
    public Staff getStaff() { return this.staff; }
    public Order getOrder() { return this.order; }
    public Member getMember() { return this.member; }
    public double getDiscount() { return this.discount; }
    public double getTotalAmount() { return this.totalAmount; }
    public static int getPaymentCount() { return Payment.paymentCount; }
    public static int getLastPaymentID() { return Payment.lastPaymentID; }

    // Setter
    public void setPaymentID(String paymentID) { this.paymentID = paymentID; }
    public void setPaymentDateTime(Date paymentDateTime) { this.paymentDateTime = paymentDateTime; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public void setStaff(Staff staff) { this.staff = staff; }
    public void setOrder(Order order) { this.order = order; }
    public void setMember(Member member) { this.member = member; }
    public void setDiscount(double discount) { this.discount = discount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    public static void setPaymentCount(int paymentCount) { Payment.paymentCount = paymentCount; }
    public static void setLastPaymentID(int lastPaymentID) { Payment.lastPaymentID = lastPaymentID; }

	//Method
	//confirm member
    public void prePayment(Staff staff, Member memberList, Order orderList) {
        String icNumber = "";
        char confirmation1 = 'N';
        char confirmation2 = 'N';
        Scanner input = new Scanner(System.in);

        orderList.displayOrderList();
        System.out.println("==================");
        System.out.println("   Make Payment   ");
        System.out.println("==================");

        do {
            System.out.print("Enter the Order ID: ");
            tempOrderID = input.nextLine().toUpperCase();

            if (orderList.getOrderDetails(tempOrderID) != null) {
                order = orderList.getOrderDetails(tempOrderID);
                break;
            }
            else {
                System.out.println("*This Order ID is not exist. Please try again!\n");
            }
        } while (true);

        do {
            do {
                try {
                    System.out.print("Do you have member (Y/N): ");
                    confirmation1 = input.nextLine().charAt(0);
                    if (Character.toUpperCase(confirmation1) == 'Y') {
                        do {
                            System.out.print("Enter the IC Number: ");
                            icNumber = input.nextLine();

                            if (memberList.getMemberDetails(icNumber) != null) {
                                member = memberList.getMemberDetails(icNumber);
                                break;
                            }else {
                                System.out.println("*This Member is not exist. Please try again!");
                            }
                        } while (true);
                    }

                    else if (Character.toUpperCase(confirmation1) == 'N') {
                        do {
                            do {
                                try {
                                    System.out.print("Do you want to subscribe the member (Y/N): ");
                                    confirmation2 = input.nextLine().charAt(0);
                                    if (Character.toUpperCase(confirmation2) == 'Y') {
                                        System.out.println();
                                        memberList.addPerson();
                                        System.out.println("----------");
                                        System.out.println("member");

                                        do {
                                            System.out.print("Enter the IC Number: ");
                                            icNumber = input.nextLine();

                                            if (memberList.getMemberDetails(icNumber) != null) {
                                                member = memberList.getMemberDetails(icNumber);
                                                break;
                                            }

                                            else {
                                                System.out.println("*This Member is not exist. Please try again!");
                                            }
                                        } while (true);
                                    }

                                    else if (Character.toUpperCase(confirmation2) == 'N') {
                                        member = null;
                                    }

                                    else if (Character.toUpperCase(confirmation2) != 'Y' && Character.toUpperCase(confirmation2) != 'N') {
                                        System.out.println("*Invalid! It should be 'Y' or 'N'.");
                                    }
                                    break;
                                }

                                catch (StringIndexOutOfBoundsException error) {
                                    System.out.println("*Invalid! It should be 'Y' or 'N'.");
                                }
                            } while (true);
                        } while (Character.toUpperCase(confirmation2) != 'Y' && Character.toUpperCase(confirmation2) != 'N');
                    }
                    else if (Character.toUpperCase(confirmation1) != 'Y' && Character.toUpperCase(confirmation1) != 'N') {
                        System.out.println("*Invalid! It should be 'Y' or 'N'.");
                    }
                    break;
                }

                catch (StringIndexOutOfBoundsException error) {
                    System.out.println("*Invalid! It should be 'Y' or 'N'.");
                }
            } while (true);
        } while (Character.toUpperCase(confirmation1) != 'Y' && Character.toUpperCase(confirmation1) != 'N');
        System.out.println();

        this.staff = staff;
        makePayment(orderList);
    }

	//make payment
    public void makePayment(Order orderList) {
        if (member != null) {
        	double total=order.getOrderItem().getSubtotal();
            discount = total * member.getDiscountRate();
        }else {
            discount = 0.0;
        }
        
        totalAmount = order.getOrderItem().getSubtotal() - discount;

        order.displayOrderSummary();
        if (member != null) {
            System.out.printf("Discount(%d%%): -RM%.2f \n", (int)(member.getDiscountRate() * 100), discount);
        }else {
            System.out.printf("Discount(0%%): -RM%.2f \n", discount);
        }
        System.out.println("-------------------------------");
        System.out.printf("Total Amount: RM%.2f \n", totalAmount);
        System.out.println("-------------------------------");
        System.out.println();

        System.out.println("Payment Method");
        System.out.println("1. Cash");
        System.out.println("2. Credit/Debit Card");
        System.out.println("3. E-Wallet");

        do {
            try {
                System.out.print("Select the Payment Method: ");
                int choice = input.nextInt();
                input.nextLine();
                System.out.println();
				//cash
                if (choice == 1) {
                    double cashAmount;
                    double change;
                    do {
                        try {
                            System.out.print("Enter the Cash Amount: ");
                            cashAmount = input.nextDouble();
                            input.nextLine();

                            if (cashAmount < totalAmount) {
                                System.out.println("**Error:Insufficient received amount to make payment!");
                            }
                            else {
                                break;
                            }
                        }catch (Exception error) {
                            System.out.println("*Invalid Cash Amount! It should be a number with or without decimal.");
                            input.nextLine();
                        }
                    } while (true);

                    change = cashAmount - totalAmount;
                    paymentList[paymentCount] = new Cash(staff, order, member, discount, totalAmount, cashAmount, change);
                    System.out.println();
                    System.out.printf("Cash Received: RM%.2f \n", cashAmount);
                    System.out.printf("Change: RM%.2f \n", change);
                    break;
                }
				
                else if (choice == 2) {
                    String cardNumber;
                    String expiryDate;
                    String cvc;

                    do {
                        System.out.print("Enter the Card Number: ");
                        cardNumber = input.nextLine();

                        if (cardNumber.length() != 16) {
                            System.out.println("*Invalid Card Number! It should contains sixteen numbers only.");
                        }
                    } while (cardNumber.length() != 16);

                    System.out.print("Enter the Expiry Date (MM/YY): ");
                    expiryDate = input.nextLine();

                    do {
                        try {
                            System.out.print("Enter the CVC: ");
                            cvc = input.nextLine();

                            if (cvc.length() != 3) {
                                System.out.println("*Invalid CVC! It should contains three numbers only.");
                            }

                            else if (!Character.isDigit(cvc.charAt(0)) || !Character.isDigit(cvc.charAt(1)) || !Character.isDigit(cvc.charAt(2))) {
                                System.out.println("*Invalid CVC! It should contains three numbers only.");
                            }

                            else {
                                break;
                            }
                        }

                       catch (StringIndexOutOfBoundsException error) {
                            System.out.println("*Invalid CVC! It should contains three numbers only.");
                        }
                    } while (true);

                    paymentList[paymentCount] = new Card(staff, order, member, discount, totalAmount, cardNumber, expiryDate, cvc);
                    break;
                }

                else if (choice == 3) {
                    String phoneNum;
                    String pin;

                    do {
                        System.out.print("Enter the New Phone Number (###-########): ");
                        phoneNum = input.nextLine();
                        phoneNum = Person.validatePersonPhone(phoneNum);
                    } while (!Person.isValidPersonPhone(phoneNum));

                    do {
                        try {
                            System.out.print("Enter the 6-Digit Pin: ");
                            pin = input.nextLine();

                            if (pin.length() != 6) {
                                System.out.println("*Invalid Pin! It should contains six numbers only.");
                            }else if (!Character.isDigit(pin.charAt(0)) || !Character.isDigit(pin.charAt(1)) || !Character.isDigit(pin.charAt(2)) || !Character.isDigit(pin.charAt(3)) || !Character.isDigit(pin.charAt(4)) || !Character.isDigit(pin.charAt(5))) {
                                System.out.println("*Invalid Pin! It should contains six numbers only.");
                            }else {
                                break;
                            }
                        }catch (StringIndexOutOfBoundsException error) {
                            System.out.println("*Invalid Pin! It should contains six numbers only.");
                        }
                    } while (true);

                    paymentList[paymentCount] = new Ewallet(staff, order, member, discount, totalAmount, phoneNum, pin);
                    break;
                }

                else {
                    input.nextLine();
                    System.out.println("*Invalid Payment Method! Please try again!");
                }
            }

            catch (Exception error) {
                System.out.println("*Invalid Choice! It should be an integer.");
                input.nextLine();
            }
        } while (true);

        orderList.paidOrder(tempOrderID);
        System.out.println("Payment Successful! Thank you! (Payment ID: " + paymentList[paymentCount - 1].paymentID + ")");
        System.out.println();
    }    
}
