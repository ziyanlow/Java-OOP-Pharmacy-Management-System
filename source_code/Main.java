import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	String username = "";
        String password = "";
        int choice = 0;
        Scanner input = new Scanner(System.in);
		
    	Medicine medicine = new Medicine();
        medicine.createDefaultMedicine();

        Equipment equipment = new Equipment();
        equipment.createDefaultEquipment();
		
		Member member = new Member();
        member.createDefaultMember();
        
		Staff user;
        Staff staff = new Staff();
        staff.createDefaultStaff();

        Order order = new Order();
        Payment payment = new Payment();
        Receipt receipt = new Receipt();
        Report report = new Report();
		
		do{
			System.out.println("=====================================");
	        System.out.println("                 _   ___ _           ");
       		System.out.println("  /\\/\\   ___  __| | / _ \\ |_   _ ___ ");
        	System.out.println(" /    \\ / _ \\/ _` |/ /_)/ | | | / __|");
        	System.out.println("/ /\\/\\ \\  __/ (_| / ___/| | |_| \\__ \\");
        	System.out.println("\\/    \\/\\___|\\__,_\\/    |_|\\__,_|___/");
        	System.out.println("                                     ");
	        System.out.println("=====================================");
	        
	        do{
	        	System.out.println("[0 to Exit]");
	        	System.out.print("Enter Username: ");
	        	username=input.nextLine();
	        	
	        	if(username.equals("0")){
	        		System.exit(0);
	        	}
	        	
	        	System.out.print("Enter Password: ");
	        	password=input.nextLine();
	        	
	        	if(staff.validateLogin(username,password)){//validate username and password
	        		user=staff.getLoginStaffDetails(username);
	        		System.out.println();
	        		break;
	        		
	        	}else{
	        		System.out.println("**Invalid Username or Password!Please try again.");
	        	}
	        	System.out.println();
	        }while(true);
	        
	        //Admin Part-->receipt,medicine,equipment,staff,report
	        if(user.getPosition().equals("Admin")){
	        	do{
	        		System.out.println("=====================");
	                System.out.println("   Admin Main Menu   ");
	                System.out.println("=====================");
	                System.out.println("User: " + user.getName());
	                System.out.println("1. Order");
	                System.out.println("2. Make Payment");
	                System.out.println("3. Receipt");
	                System.out.println("4. Medicine");
	                System.out.println("5. Equipment");
	                System.out.println("6. Membership");
	                System.out.println("7. Staff");
	                System.out.println("8. Report");
	                System.out.println("0. Logout");
	                
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
					
					if(choice==1){
							order.adminMenuOrder(medicine, equipment);
					}							
					else if(choice==2){
							if(Order.getOrderCount()==0){
								System.out.println("*There is no Order for now.\n");
							}else{
								payment.prePayment(user, member, order);
	                            receipt.addReceipt(payment.paymentList[payment.getPaymentCount() - 1]);  	
							}
					}
					else if(choice==3){
							receipt.adminMenuReceipt();
					}	
					else if(choice==4){
							medicine.adminMenuMedicine();	
					}
					else if(choice==5){
							equipment.adminMenuEquipment();
						}
					else if(choice==6){
							member.menuMember();
						}
						else if(choice==7){
							staff.adminMenuStaff();
						}		
						else if(choice==8){
							report = new Report(receipt);
	                        report.adminMenuReport();
						}		
	                    else if (choice==0){
	                    	break;
	                    }
	                    else{
	                    	System.out.println("Invalid Choice! Please try again.");
	                    }	
	        	}while(true);
	        }
	        
	        //Cashier Part-->order,make payment,membership
	        else if(user.getPosition().equals("Cashier")){
	        	do{
	        		System.out.println("=======================");
	                System.out.println("   Cashier Main Menu   ");
	                System.out.println("=======================");
	                System.out.println("User: " + user.getName());
	                System.out.println("1. Order");
	                System.out.println("2. Make Payment");
	                System.out.println("3. Membership");
	                System.out.println("0. Logout");
	                
	                do{
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
	                }while(true);
	                System.out.println();
	                
	                if (choice==1){
	                	order.cashierMenuOrder(medicine,equipment);
	                }else if(choice==2){
	                	if (Order.getOrderCount() == 0) {
	                      	System.out.println("**Error: There is no Order now.\n");
	                    }else {
	                        payment.prePayment(user, member, order);
	                        receipt.addReceipt(payment.paymentList[Payment.getPaymentCount() - 1]);
	                    }
	                }else if(choice==3){
	                		member.menuMember();
	                }else if(choice==0){
	                	break;
	                }else{
	                	System.out.println("**Invalid Choice! Please try again!\n");		                
	                } 	
	        	}while(true);			
	        }
	    }while(true);  
    } 
}