import java.util.Scanner;

public class Receipt {
	public Receipt[]receiptList=new Receipt[100000];
	private String receiptID;
	private Payment receiptPayment;
	private static int receiptCount=0;
	private static int lastReceiptID=100001;
	Scanner input=new Scanner(System.in);
	
	//Constructor
    public Receipt() {
    	this.receiptID="";
    	this.receiptPayment=null;
    }
    
    public Receipt(Payment receiptPayment){
    	this.receiptID="R-"+lastReceiptID;
    	this.receiptPayment=receiptPayment;
    	receiptCount++;
    	lastReceiptID++;
    }
    
    //Getter
    public String getReceiptID(){return this.receiptID;}
    public Payment getReceiptPayment(){return this.receiptPayment;}
    public static int getReceiptCount(){return receiptCount;}
    public static int getLastReceiptID(){return lastReceiptID;}
    
    //Setter
    public void setReceiptID(String receiptID){this.receiptID=receiptID;}
    public void setReceiptPayment(Payment receiptPayment){this.receiptPayment=receiptPayment;}
    public static void setReceiptCount(int receiptCount) { Receipt.receiptCount = receiptCount; }
    public static void setLastReceiptID(int lastReceiptID) { Receipt.lastReceiptID = lastReceiptID; }

    //Method
    //adminMenuReceipt-->select choice in menu
    public void adminMenuReceipt(){
    	int choice =0;
    	do{
    		System.out.println("==========================");
            System.out.println("   Receipt Menu (Admin)   ");
            System.out.println("==========================");
            System.out.println("1. Display Receipt List");
            System.out.println("2. Check Receipt");
            System.out.println("0. Quit");
            
            do {
                try {
                    System.out.print("Enter your choice: ");
                    choice = input.nextInt();
                    input.nextLine();
                    break;
                }

                catch (Exception error) {
                    System.out.println("*Invalid Input! Please try again.");
                    input.nextLine();
                }
            } while (true);
            System.out.println();
            
            if(choice==1){
            	displayReceiptList();
            }else if(choice==2){
            	if(receiptCount==0){//No receipt
            			System.out.println("*There is no Receipt for now.\n");
            	}else{
            			checkReceipt();
            	}
            }
            else if(choice==0){
            	break;
            }
            else{
            	System.out.println("*Invalid Input! Please try again.");
                input.nextLine();
            }
    	}while(true);
    }
    
    //display receipt list
    public void displayReceiptList() {
        System.out.println("==========================================================================================================");
        System.out.printf("%-47s%s%47s\n", "|", "Receipt List", "|");
        System.out.println("==========================================================================================================");
        System.out.printf("|%-10s |%-10s |%-13s |%63s  | \n", "Receipt ID", "Order ID", "Staff ID", "Total (RM)");
        System.out.println("|-----------|-----------|--------------|-----------------------------------------------------------------|");
        for (int i = 0; i < receiptCount; i++) {
            if (!receiptList[i].receiptID.equals("")) {
                System.out.printf("|%-10s |%-10s |%-13s |%63.2f  | \n", receiptList[i].receiptID, receiptList[i].receiptPayment.getOrder().getOrderID(), receiptList[i].receiptPayment.getStaff().getStaffID(), receiptList[i].receiptPayment.getTotalAmount());
            }
        }
        System.out.println("==========================================================================================================");
        System.out.println();
    }
    
    //display receipt
    public void displayReceipt() {
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.printf("%-47s%s\n", "", "Medplus Pharmacy");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.printf("%-35s%s\n", "", "88, Jalan Flower, Lorong Lembah Permai,");
        System.out.printf("%-40s%s\n", "", "11500 Tanjung Bungah, Pulau Pinang");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.printf("%s%-85s\n", "Order Date & Time  : ", receiptPayment.getOrder().getOrderDateTime());
        System.out.printf("%s%-85s\n", "Payment Date & Time: ", receiptPayment.getPaymentDateTime());
        System.out.printf("%s%-94s\n", "Order ID		   : ", receiptPayment.getOrder().getOrderID());
        System.out.printf("%s%-94s\n", "Payment ID         : ", receiptPayment.getPaymentID());
        System.out.printf("%s%-94s\n", "Staff Name         : ", receiptPayment.getStaff().getName());
        if (receiptPayment.getMember() != null) {//is a member
        	System.out.printf("%s%-94s\n", "Member             : ",receiptPayment.getMember().getName());
        }
        System.out.println("=========================================================================================================="); 
        System.out.printf("|%-6s |%-30s |%-6s |%-9s |%-40s     | \n", "ID", "Item Name", "Price", "Quantity", "Subtotal (RM) ");
       	System.out.println("|-------|-------------------------------|-------|----------|---------------------------------------------|");
        for (int i = 0; i < receiptPayment.getOrder().getOrderItem().getTotalOrderItem(); i++) {
            System.out.print(receiptPayment.getOrder().getOrderItem().itemList[i].toString());
        }
        System.out.println("==========================================================================================================");
        System.out.printf("%-72s%s%5.2f\n", "", "Subtotal            : RM  ", receiptPayment.getOrder().getOrderItem().getSubtotal());
        System.out.printf("%-72s%s%5.2f\n", "", "Discount            :-RM  ", receiptPayment.getDiscount());
        System.out.printf("%-72s%s%5.2f\n", "", "Total               : RM  ", receiptPayment.getTotalAmount());
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.printf("%-40s%s\n", "", "Thank You & Come Again");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println();
    }	
    	
    //check receipt
    public void checkReceipt(){
    	int found =0; 
    	displayReceiptList();
    	System.out.println("===================");
        System.out.println("   Check Receipt   ");
        System.out.println("===================");
        
        do{
        	System.out.print("Enter the Receipt ID: ");
        	receiptID=input.nextLine().toUpperCase();
        	
        	for(int i=0;i<receiptCount;i++){
        		if(receiptID.equals(receiptList[i].receiptID)){
        			receiptList[i].displayReceipt();
        			found++;
        			break;
        		}
        	}
        	if(found==0){//not found
        		System.out.println("This Receipt ID is not exist.Please try again.\n");
        	}
        }while(found==0);  
    }
    
    //add receipt
    public void addReceipt(Payment payment) {
        receiptList[receiptCount] = new Receipt(payment);
        receiptList[receiptCount - 1].displayReceipt();
    }
    
}