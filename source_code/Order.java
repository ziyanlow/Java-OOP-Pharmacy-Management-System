import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Order {
    public Order[] orderList = new Order[100000];
    private String orderID;
    private Date orderDateTime;
    private Item orderItem;
    private static int orderCount = 0;
    private static int totalOrder = 0;
    private static int lastOrderID = 100001;
    Scanner input = new Scanner(System.in);
    
	//Constructor
    public Order() {
        this.orderID = "";
        this.orderDateTime = null;
        this.orderItem = null;
    }
    
	public Order(Item orderItem) {
        this.orderID = "O-" + lastOrderID;
        this.orderDateTime = new Date();
        this.orderItem = orderItem;
        orderCount++;
        totalOrder++;
        lastOrderID++;
    }
	//Getter
	public String getOrderID() { return this.orderID; }
    public Date getOrderDateTime() { return this.orderDateTime; }
    public Item getOrderItem() { return this.orderItem; }
    public static int getOrderCount() { return orderCount; }
    public static int getTotalOrder() { return totalOrder; }
    public static int getLastOrderID() { return lastOrderID; }
    
    //Setter
    public void setOrderID(String orderID) { this.orderID = orderID; }
    public void setOrderDateTime(Date orderDateTime) { this.orderDateTime = orderDateTime; }
    public void setOrderItem(Item orderItem) { this.orderItem = orderItem; }
    public static void setOrderCount(int orderCount) { Order.orderCount = orderCount; }
    public static void setTotalOrder(int totalOrder) { Order.totalOrder = totalOrder; }
    public static void setLastOrderID(int lastOrderID) { Order.lastOrderID = lastOrderID; }

	//Method
	//adminMenuOrder
	public void adminMenuOrder(Medicine medicineList, Equipment equipmentList) {
        int choice = 0;
        do {
            System.out.println("========================");
            System.out.println("   Order Menu (Admin)   ");
            System.out.println("========================");
            System.out.println("1. Display Order List");
            System.out.println("2. Check Order Summary");
            System.out.println("3. Add Order");
            System.out.println("4. Cancel Order");
            System.out.println("5. Edit Order");
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
                displayOrderList();
            }else if (choice == 2) {
                if (orderCount == 0) {
                    System.out.println("*There is no Order for now.");
                    System.out.println();
                }else {
                    checkOrderSummary();
                }
            }
            else if (choice == 3) {
                addOrder(medicineList, equipmentList);
            }
            else if (choice == 4) {
                if (orderCount == 0) {
                    System.out.println("*There is no Order for now.");
                    System.out.println();
                }else {
                    cancelOrder();
                }
            }
            else if (choice == 5) {
                if (orderCount == 0) {
                    System.out.println("*There is no Order for now.");
                    System.out.println();
                }
                else {
                    editOrder(medicineList, equipmentList);
                }
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
	
	//cashierMenuOrder
	public void cashierMenuOrder(Medicine medicineList, Equipment equipmentList) {
        int choice = 0;
        do {
            System.out.println("==========================");
            System.out.println("   Order Menu (Cashier)   ");
            System.out.println("==========================");
            System.out.println("1. Display Order List");
            System.out.println("2. Check Order Summary");
            System.out.println("3. Add Order");
            System.out.println("4. Edit Order");
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

            System.out.println();
            if (choice == 1) {
                displayOrderList();
            }

            else if (choice == 2) {
                if (orderCount == 0) {
                    System.out.println("*There is no Order for now.");
                    System.out.println();
                }else {
                    checkOrderSummary();
                }
            }

            else if (choice == 3) {
                addOrder(medicineList, equipmentList);
            }

            else if (choice == 4) {
                if (orderCount == 0) {
                    System.out.println("*There is no Order for now.");
                    System.out.println();
                }

                else {
                    editOrder(medicineList, equipmentList);
                }
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
	
	//displayOrderList
	public void displayOrderList() {
        System.out.println("==========================================================================================================");
        System.out.printf("%-47s%s%49s\n", "|", "Order List", "|");
        System.out.println("==========================================================================================================");
        System.out.printf("|%-10s |%90s  | \n", "Order ID","Subtotal(RM)");
        System.out.println("|-----------|--------------------------------------------------------------------------------------------|");
        for (int i = 0; i < totalOrder; i++) {
            if (!orderList[i].orderID.equals("")) {
                System.out.print(orderList[i].toString());
            }
        }
        System.out.println("==========================================================================================================");
        System.out.println();
    }
	
	//displayOrderSummary
	public void displayOrderSummary() {
        System.out.println("==========================================================================================================");
        System.out.printf("%-46s%s%47s\n", "|", "Order Summary", "|");
        System.out.println("==========================================================================================================");
        System.out.printf("|Order Date & Time: %-85s| \n", orderDateTime);
        System.out.printf("|Order ID: %-94s| \n", orderID);
        System.out.println("==========================================================================================================");
        orderItem.displayItem();
    }
    
    //checkOrderSummary
    public void checkOrderSummary() {
        int found = 0;
        displayOrderList();
        System.out.println("=========================");
        System.out.println("   Check Order Summary   ");
        System.out.println("=========================");

        do {
            System.out.print("Enter the Order ID: ");
            orderID = input.nextLine().toUpperCase();

            for (int i = 0; i < totalOrder; i++) {
                if (orderID.equals(orderList[i].orderID)) {
                    orderList[i].displayOrderSummary();
                    found++;
                    break;
                }
            }

            if (found == 0) {
                System.out.println("*This Order ID is not existed. Please try again!");
                System.out.println("*Tips: The Order ID starts with #O- (It is a character O, not a zero)");
                System.out.println();
            }
        } while (found == 0);
    }
	
	//addOrder
	//inside the addOrder method
	public void addOrder(Medicine medicineList, Equipment equipmentList) {
	    char confirmation = 'Y'; // Start with 'Y' to enter the loop
	    do {
	        orderItem = new Item();
	        orderItem.addItem(medicineList, equipmentList);
	        orderList[totalOrder] = new Order(orderItem);
	        orderList[totalOrder - 1].displayOrderSummary();
			
	        do {
	            try {
	                System.out.print("Add more order (Y/N): ");
	                confirmation = input.nextLine().charAt(0);
	                if (Character.toUpperCase(confirmation) != 'Y' && Character.toUpperCase(confirmation) != 'N') {
	                    System.out.println("*Invalid! It should be 'Y' or 'N'.");
	                }
	                System.out.println();
	                break;
	            } catch (StringIndexOutOfBoundsException error) {
	                System.out.println("*Invalid! It should be 'Y' or 'N'.");
	                System.out.println();
	            }
	        } while (true);
	    } while (Character.toUpperCase(confirmation) == 'Y');
	}
	
	//cancelOrder
	public void cancelOrder() {
        int found = 0;
        int cancelIndex = 0;
        char confirmation = 'N';

        displayOrderList();
        System.out.println("==================");
        System.out.println("   Cancel Order   ");
        System.out.println("==================");

        do {
            System.out.print("Enter the Order ID: ");
            orderID = input.nextLine().toUpperCase();
            for (int i = 0; i < totalOrder; i++) {
                if (orderID.equals(orderList[i].orderID)) {
                    orderList[i].displayOrderSummary();
                    found++;
                    cancelIndex = i;
                    break;
                }
            }
            if (found == 0) {
                System.out.println("*This Order ID is not existed. Please try again!");
                System.out.println("*Tips: The Order ID starts with #O- (It is a character O, not a zero)");
                System.out.println();
            }
        } while (found == 0);

        do {
            do {
                try {
                    System.out.print("Are you sure to cancel Order " + orderID + " (Y/N): ");
                    confirmation = input.nextLine().charAt(0);
                    if (Character.toUpperCase(confirmation) == 'Y'){
                    
                        orderList[cancelIndex] = new Order();
                        orderCount--;
                        System.out.printf("The Order (%s) is cancelled successfully! \n", orderID);
                        
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
        System.out.println();
    }
	
	//editOrder
	public void editOrder(Medicine medicineList, Equipment equipmentList) {
        int found = 0;
        int editIndex = 0;
        int choice = 0;

        displayOrderList();
        System.out.println("================");
        System.out.println("   Edit Order   ");
        System.out.println("================");

        do {
            System.out.print("Enter the Order ID: ");
            orderID = input.nextLine().toUpperCase();

            for (int i = 0; i < totalOrder; i++) {
                if (orderID.equals(orderList[i].orderID)) {
                    orderList[i].displayOrderSummary();
                    found++;
                    editIndex = i;
                    break;
                }
            }

            if (found == 0) {
                System.out.println("*This Order ID is not existed. Please try again!");
                System.out.println("*Tips: The Order ID starts with #O- (It is a character O, not a zero)");
                System.out.println();
            }
        } while (found == 0);

        do {
            System.out.println("============================");
            System.out.printf("   Edit Order (%s)   \n", orderList[editIndex].orderID);
            System.out.println("============================");
            System.out.println("1. Add Item");
            System.out.println("2. Delete Item");
            System.out.println("3. Modify Quantity");
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
                orderList[editIndex].orderItem.addItem(medicineList, equipmentList);
            }else if (choice == 2) {
                orderList[editIndex].orderItem.deleteItem();
            }else if (choice == 3) {
                int orderQty = 0;
                System.out.println("================================");
                System.out.println("         Modify Quantity        ");
                System.out.println("================================");
                do {
                    try {
                        System.out.print("Enter the order quantity: ");
                        orderQty = input.nextInt();
                    }catch (Exception error) {
                        System.out.println("*Invalid Number of Customers! It should be an integer.");
                        input.nextLine();
                    }
                } while (true); 
            }else if (choice == 0) {
                break;
            }else {
                System.out.println("*Invalid Choice! Please try again!");
                System.out.println();
            }
        } while (true);
	}
	
	//getOrderDetails
	public Order getOrderDetails(String orderID) {
        for (int i = 0; i < totalOrder; i++)
            if (orderID.equals(orderList[i].orderID)) {
                return orderList[i];
            }
        return null;
    }

	//paidOrder
    public void paidOrder(String orderID) {
        int paidIndex = 0;

        for (int i = 0; i < totalOrder; i++) {
            if (orderID.equals(orderList[i].orderID)) {
                paidIndex = i;
                break;
            }
        }
        orderList[paidIndex] = new Order();
        orderCount--;
    }
	
	//dispaly order list
	@Override
    public String toString() {
        return String.format("|%-10s |%90.2f  | \n", this.orderID, this.orderItem.getSubtotal());
    }
    
}