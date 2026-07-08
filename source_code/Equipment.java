import java.util.Scanner;

public class Equipment {
    private static Equipment[] equipmentList = new Equipment[1000];
    private int equipmentID;
    private String equipmentName;
    private double equipmentPrice;   
    private String promotionStartDate;
    private String promotionExpiryDate;
     private String equipmentDescription;
    private static int equipmentCount = 0;
    private static int totalEquipment = 0;
    private static int lastEquipmentID = 9001;
    private boolean discountApplied = false;
    Scanner input = new Scanner(System.in);

    public Equipment() {
        this.equipmentID = 0;
        this.equipmentName = "";
        this.promotionStartDate = "";
        this.promotionExpiryDate = "";
        this.equipmentPrice = 0.0;
        this.equipmentDescription = "";
    }

    public Equipment(String equipmentName, double equipmentPrice, String promotionStartDate, String promotionExpiryDate, String equipmentDescription) {
        this.equipmentID = lastEquipmentID;
        this.equipmentName = equipmentName;
        this.equipmentPrice = equipmentPrice;
        this.promotionStartDate = promotionStartDate;
        this.promotionExpiryDate = promotionExpiryDate;
        this.equipmentDescription = equipmentDescription;
        equipmentCount++;
        totalEquipment++;
        lastEquipmentID++;
    }

    // Getter methods
    public int getEquipmentID() {
        return this.equipmentID;
    }

    public String getEquipmentName() {
        return this.equipmentName;
    }

    public double getEquipmentPrice() {
        return this.equipmentPrice;
    }

    public String getPromotionStartDate() {
        return this.promotionStartDate;
    }

    public String getPromotionExpiryDate() {
        return this.promotionExpiryDate;
    }

    public String getEquipmentDescription() {
        return this.equipmentDescription;
    }

    public static int getEquipmentCount() {
        return equipmentCount;
    }

    public static int getTotalEquipment() {
        return totalEquipment;
    }

    public static int getLastEquipmentID() {
        return lastEquipmentID;
    }
    
    public static Equipment[] getEquipmentList() {
    	return equipmentList;
    }
    
    public boolean isDiscountApplied() {
    	return discountApplied;
    }

    // Setter methods
    public void setEquipmentID(int equipmentID) {
        this.equipmentID = equipmentID;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public void setEquipmentPrice(double equipmentPrice) {
        this.equipmentPrice = equipmentPrice;
    }

    public void setPromotionStartDate(String promotionStartDate) {
        this.promotionStartDate = promotionStartDate;
    }

    public void setPromotionExpiryDate(String promotionExpiryDate) {
        this.promotionExpiryDate = promotionExpiryDate;
    }

    public void setEquipmentDescription(String equipmentDescription) {
        this.equipmentDescription = equipmentDescription;
    }

    public static void setEquipmentCount(int equipmentCount) {
        Equipment.equipmentCount = equipmentCount;
    }

    public static void setTotalEquipment(int totalEquipment) {
        Equipment.totalEquipment = totalEquipment;
    }

    public static void setLastEquipmentID(int lastEquipmentID) {
        Equipment.lastEquipmentID = lastEquipmentID;
    }
    
    public void setDiscountApplied(boolean discountApplied) {
    	this.discountApplied = discountApplied;
    }
    
    public void createDefaultEquipment() {
        equipmentList[0] = new Equipment("Wheel Chair", 192.00, "2023-09-20", "2023-10-10", "Helps people Movement");
        equipmentList[1] = new Equipment("Thermometers", 25.00, "2023-09-20", "2023-10-10", "Measure Body Temperature");
        equipmentList[2] = new Equipment("Glucometers", 14.00, "2023-09-20", "2023-10-10", "Determine Concentration of Glucose");
        equipmentList[3] = new Equipment("Pulse Oximeters", 10.00, "2023-09-20", "2023-10-10", "Measure Blood Oxygen");
        equipmentList[4] = new Equipment("Stethoscopes", 16.00, "2023-09-20", "2023-10-10", "Listening to Internal Sounds");
        equipmentList[5] = new Equipment("Sphygmomanometers", 46.00, "2023-09-20", "2023-10-10", "Measures Blood Pressure");
        equipmentList[6] = new Equipment("Otoscopes", 7.50, "2023-09-20", "2023-10-10", "Help Examine Ear Canal");
        equipmentList[7] = new Equipment("Bandages", 6.00, "2023-09-20", "2023-10-10", "Bind up Wound");
        equipmentList[8] = new Equipment("Tweezers", 7.50, "2023-09-20", "2023-10-10", "Grad Small Items");
        equipmentList[9] = new Equipment("Heat packs", 11.00, "2023-09-20", "2023-10-10", "Reduces Joint Stiffness");
        equipmentList[10] = new Equipment("Cold packs", 11.00, "2023-09-20", "2023-10-10", "Reduces Pain and Tenderness");
        equipmentList[11] = new Equipment("Adhesive Tapes", 4.00, "2023-09-20", "2023-10-10", "Bind Objects Together");
        equipmentList[12] = new Equipment("Gauze", 2.00, "2023-08-15", "2023-10-10", "Clean Wounds");
        equipmentList[13] = new Equipment("Wound Closure Strips", 4.50, "2023-09-20", "2023-10-10", "Close Small Wounds");
    }


    public void adminMenuEquipment() {
    int choice = 0;
	    do {
	        System.out.println("===========================");
	        System.out.println("   Equipment Menu (Admin)   ");
	        System.out.println("===========================");
	        System.out.println("1. Display Equipment");
	        System.out.println("2. Add Equipment");
	        System.out.println("3. Delete Equipment");
	        System.out.println("4. Edit Equipment");
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
	        if (choice == 1) {
	            displayEquipment();
	        } else if (choice == 2) {
	            addEquipment();
	        } else if (choice == 3) {
	            deleteEquipment();
	        } else if (choice == 4) {
	            editEquipment();
	        } else if (choice == 0) {
	            break;
	        } else {
	            System.out.println("*Invalid Choice! Please try again!");
	            System.out.println();
	        }
	    } while (true);
	}

  	public void displayEquipment() {
    System.out.println("===========================================================================================================================================");
    System.out.printf("%-51s%s%74s\n", "|", "Equipment Menu", "|");
    System.out.println("===========================================================================================================================================");
    System.out.printf("|%-6s |%-20s |%-15s|%-15s|%-20s|%-18s|%-35s|\n", "ID", "Equipment Name", "Original Price", "Promotion Price", "Promotion Start Date", "Promotion Due Date", "Description");
    System.out.println("|-------|---------------------|---------------|---------------|--------------------|------------------|-----------------------------------|");

    for (int i = 0; i < totalEquipment; i++) {
        if (equipmentList[i] != null && equipmentList[i].getEquipmentID() != 0) {
            double originalPrice = equipmentList[i].getEquipmentPrice();
            double discountPercentage = 20.0; // You can set the discount percentage here.

            // Calculate promotion price using the Promotion class
            double promotionPrice = Promotion.applyPromotion(originalPrice, discountPercentage);

            System.out.printf("|%-6d |%-20s |%-14.2f |%-14.2f |%-18s  |%-18s|%-35s|\n",
                    equipmentList[i].getEquipmentID(), equipmentList[i].getEquipmentName(),
                    originalPrice, promotionPrice, equipmentList[i].getPromotionStartDate(),
                    equipmentList[i].getPromotionExpiryDate(), equipmentList[i].getEquipmentDescription());
        }
    }
    
    System.out.println("===========================================================================================================================================");
    System.out.println("Total Equipment: " + equipmentCount);
    System.out.println();
}



    public void addEquipment() {
    int category = 0;
    char confirmation = 'N';

    do {
        System.out.println("=============================");
        System.out.println("   Add Equipment (Category)   ");
        System.out.println("=============================");
        System.out.println("1. Diagnostic Equipment");
        System.out.println("2. FirstAid Equipment");
        System.out.println("0. Quit");

        do {
            try {
                System.out.print("Enter your choice: ");
                category = input.nextInt();
                input.nextLine();
                break;
            } catch (Exception error) {
                System.out.println("*Invalid Choice! It should be an integer.");
                input.nextLine();
            }
        } while (true);

        if (category == 1) {
            System.out.print("Enter the Equipment Name: ");
            equipmentName = input.nextLine();

            do {
                try {
                    System.out.print("Enter the Equipment Price: ");
                    equipmentPrice = input.nextDouble();

                    if (equipmentPrice < 0.01) {
                        System.out.println("*The Equipment Price should not be zero or negative value.");
                    } else {
                        input.nextLine();
                        break;
                    }
                } catch (Exception error) {
                    System.out.println("*Invalid Equipment Price! It should be a number with or without a decimal.");
                    input.nextLine();
                }
            } while (true);
            
            System.out.print("Enter the Promotion Start Date	: ");
            promotionStartDate=input.nextLine();
            System.out.print("Enter the Promotion Expiry Date	: ");
            promotionStartDate=input.nextLine();
            System.out.print("Enter the Equipment Description: ");
            equipmentDescription = input.nextLine();

            do {
                do {
                    try {
                        System.out.print("Are you sure to add " + equipmentName + " (Y/N): ");
                        confirmation = input.nextLine().charAt(0);
                        if (Character.toUpperCase(confirmation) == 'Y') {
                            equipmentList[totalEquipment] = new Diagnostic(equipmentName, equipmentPrice, promotionStartDate, promotionExpiryDate, equipmentDescription);
                            System.out.printf("The new Equipment (%s) is created successfully! \n", equipmentName);
                        } else if (Character.toUpperCase(confirmation) != 'Y' && Character.toUpperCase(confirmation) != 'N') {
                            System.out.println("*Invalid! It should be 'Y' or 'N'.");
                        }
                        break;
                    } catch (StringIndexOutOfBoundsException error) {
                        System.out.println("*Invalid! It should be 'Y' or 'N'.");
                    }
                } while (true);
            } while (Character.toUpperCase(confirmation) != 'Y' && Character.toUpperCase(confirmation) != 'N');
        } else if (category == 2) {
            System.out.print("Enter the Equipment Name: ");
            equipmentName = input.nextLine();

            do {
                try {
                    System.out.print("Enter the Equipment Price: ");
                    equipmentPrice = input.nextDouble();

                    if (equipmentPrice < 0.01) {
                        System.out.println("*The Equipment Price should not be zero or negative value.");
                    } else {
                        input.nextLine();
                        break;
                    }
                } catch (Exception error) {
                    System.out.println("*Invalid Equipment Price! It should be a number with or without a decimal.");
                    input.nextLine();
                }
            } while (true);
			System.out.print("Enter the Promotion Start Date	: ");
            promotionStartDate=input.nextLine();
            System.out.print("Enter the Promotion Expiry Date	: ");
            promotionStartDate=input.nextLine();
            System.out.print("Enter the Equipment Description: ");
            equipmentDescription = input.nextLine();

            do {
                do {
                    try {
                        System.out.print("Are you sure to add " + equipmentName + " (Y/N): ");
                        confirmation = input.nextLine().charAt(0);
                        if (Character.toUpperCase(confirmation) == 'Y') {
                            equipmentList[totalEquipment] = new FirstAid(equipmentName, equipmentPrice, promotionStartDate, promotionExpiryDate, equipmentDescription);
                            System.out.printf("The new Equipment (%s) is created successfully! \n", equipmentName);
                        } else if (Character.toUpperCase(confirmation) != 'Y' && Character.toUpperCase(confirmation) != 'N') {
                            System.out.println("*Invalid! It should be 'Y' or 'N'.");
                        }
                        break;
                    } catch (StringIndexOutOfBoundsException error) {
                        System.out.println("*Invalid! It should be 'Y' or 'N'.");
                    }
                } while (true);
            } while (Character.toUpperCase(confirmation) != 'Y' && Character.toUpperCase(confirmation) != 'N');
        } else if (category == 0) {
            break;
        } else {
            System.out.println("*Invalid Choice! Please try again!");
            System.out.println();
        }
    } while (true);
    System.out.println();
}

    public void deleteEquipment() {
    int found = 0;
    int deleteIndex = 0;
    char confirmation = 'N';

    System.out.println("=====================");
    System.out.println("   Delete Equipment   ");
    System.out.println("=====================");

    do {
        do {
            try {
                System.out.print("Enter the Equipment ID: ");
                equipmentID = input.nextInt();
                input.nextLine();

                if (equipmentID == 0) {
                    adminMenuEquipment();
                }
                break;
            } catch (Exception error) {
                System.out.println("*Invalid Equipment ID! It should be an integer.");
                input.nextLine();
            }
        } while (true);

        for (int i = 0; i < totalEquipment; i++) {
            if (equipmentID == equipmentList[i].equipmentID) {
                System.out.println("==================================================================================================================");
        		System.out.printf("%-51s%s%50s\n", "|", "Equipment Menu", "|");
        		System.out.println("==================================================================================================================");
        		System.out.printf("|%-6s |%-20s |%-14s |%-9s  |%-14s |%-16s |%-39s|\n", "ID", "Equipment Name", "Original Price", "Promotion Price", "Promotion Start Date", "Promotion Due Date", "Description");
       			System.out.println("|-------|---------------------|---------------|--------------|-------------------|----------------|---------------------------------------|");
       			System.out.printf("|%-6d |%-20s |%-14.2f |%-14.2f |%-18s |%-18s |%-50s|\n", equipmentList[i].getEquipmentID(), equipmentList[i].getEquipmentName(), equipmentList[i].getEquipmentPrice(), equipmentList[i].getEquipmentPrice(), equipmentList[i].getPromotionStartDate(), equipmentList[i].getPromotionExpiryDate(), equipmentList[i].getEquipmentDescription());
                found++;
                deleteIndex = i;
                break;
            }
        }

        if (found == 0) {
            System.out.println("*This Equipment ID is not existed. Please try again!");
        }
    } while (found == 0);

    do {
        do {
            try {
                System.out.print("Are you sure to delete " + equipmentList[deleteIndex].equipmentName + " (Y/N): ");
                confirmation = input.nextLine().charAt(0);
                if (Character.toUpperCase(confirmation) == 'Y') {
                    if (equipmentList[deleteIndex].getClass().getSimpleName().equals("Diagnostic")) {
                        equipmentList[deleteIndex] = new Diagnostic();
                        Diagnostic.setDiagnosticCount(Diagnostic.getDiagnosticCount() - 1);
                    } else if (equipmentList[deleteIndex].getClass().getSimpleName().equals("FirstAid")) {
                        equipmentList[deleteIndex] = new FirstAid();
                        FirstAid.setFirstAidCount(FirstAid.getFirstAidCount() - 1);
                    } 
                    equipmentCount--;
                    System.out.printf("The Equipment (%s) is deleted successfully! \n", equipmentID);
                } else if (Character.toUpperCase(confirmation) != 'Y' && Character.toUpperCase(confirmation) != 'N') {
                    System.out.println("*Invalid! It should be 'Y' or 'N'.");
                }
                break;
            } catch (StringIndexOutOfBoundsException error) {
                System.out.println("*Invalid! It should be 'Y' or 'N'.");
            }
        } while (true);
    } while (Character.toUpperCase(confirmation) != 'Y' && Character.toUpperCase(confirmation) != 'N');
    System.out.println();
}

    public void editEquipment() {
    int found = 0;
    int editIndex = 0;
    int choice = 0;

    System.out.println("====================");
    System.out.println("   Edit Equipment   ");
    System.out.println("====================");

    do {
        found = 0;

        do {
            try {
                System.out.print("Enter the Equipment ID: ");
                equipmentID = input.nextInt();
                input.nextLine();
                break;
            } catch (Exception error) {
                System.out.println("*Invalid Equipment ID! It should be an integer.");
                input.nextLine();
            }
        } while (true);

        for (int i = 0; i < totalEquipment; i++) {
            if (equipmentID == equipmentList[i].equipmentID) {
               System.out.println("==================================================================================================================");
        		System.out.printf("%-51s%s%50s\n", "|", "Equipment Menu", "|");
        		System.out.println("==================================================================================================================");
        		System.out.printf("|%-6s |%-20s |%-14s |%-9s  |%-14s |%-16s |%-39s|\n", "ID", "Equipment Name", "Original Price", "Promotion Price", "Promotion Start Date", "Promotion Due Date", "Description");
       			System.out.println("|-------|---------------------|---------------|--------------|-------------------|----------------|---------------------------------------|");
       			System.out.printf("|%-6d |%-20s |%-14.2f |%-14.2f |%-18s |%-18s |%-50s|\n", equipmentList[i].getEquipmentID(), equipmentList[i].getEquipmentName(), equipmentList[i].getEquipmentPrice(), equipmentList[i].getEquipmentPrice(), equipmentList[i].getPromotionStartDate(), equipmentList[i].getPromotionExpiryDate(), equipmentList[i].getEquipmentDescription());

                found++;
                editIndex = i;
                break;
            }
        }

        if (found == 0) {
            System.out.println("*This Equipment ID does not exist. Please try again!");
        }
    } while (found == 0);

    do {
        System.out.println("=======================");
        System.out.printf("   Edit Equipment (%d)   \n", equipmentList[editIndex].equipmentID);
        System.out.println("=======================");
        System.out.println("1. Equipment Name");
        System.out.println("2. Equipment Price");
        System.out.println("3. Equipment Description");
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

        if (choice == 1) {
            System.out.print("Enter the New Equipment Name: ");
            equipmentName = input.nextLine();
            equipmentList[editIndex].setEquipmentName(equipmentName);
        } else if (choice == 2) {
          	do {
                try {
                    System.out.print("Enter the New Equipment Price: ");
                    equipmentPrice = input.nextDouble();

                    if (equipmentPrice < 0.01) {
                        System.out.println("*The Equipment Price should not be zero or a negative value.");
                    } else {
                        input.nextLine();
                        break;
                    }
                } catch (Exception error) {
                    System.out.println("*Invalid Equipment Price! It should be a number with or without a decimal.");
                    input.nextLine();
                }
            } while (true);

            equipmentList[editIndex].setEquipmentPrice(equipmentPrice);
        } else if (choice == 3) {
            System.out.print("Enter the New Equipment Description: ");
            equipmentDescription = input.nextLine();
            equipmentList[editIndex].setEquipmentDescription(equipmentDescription);
        } else if (choice == 0) {
            break;
        } else {
            System.out.println("*Invalid Choice! Please try again!");
            System.out.println();
        }
    } while (true);
    
    System.out.println();
}

	public Equipment searchEquipment(int equipmentID) {
	    for (int i = 0; i < totalEquipment; i++) {
	        if (equipmentID == equipmentList[i].equipmentID) {
	            return equipmentList[i];
	        }
	    }
	    return null;
	}


	//////////////////
	//test promotion
	public double calculatePromotionPrice(double discountPercentage) {
        return Promotion.applyPromotion(this.equipmentPrice, discountPercentage);
    }
    
	/*@Override
	public String toString() {
	    return String.format("|%-6d |%-20s |%-14.2f |%-14.2f |%-18s |%-18s |%-50s|\n",
	            this.equipmentID, this.equipmentName, this.equipmentPrice, this.equipmentPrice,
	            this.promotionStartDate, this.promotionExpiryDate, this.equipmentDescription);
	}*/
	@Override
	public String toString() {
	    // Calculate promotion price based on discount percentage
	    double originalPrice = this.equipmentPrice;
	    double discountPercentage = 20.0; // You can set the discount percentage here.
	    double promotionPrice = Promotion.applyPromotion(originalPrice, discountPercentage);
         //System.out.printf("|%-6d |%-20s |%-14.2f |%-14.2f |%-18s |%-18s |%-50s|\n",
           
	    //return String.format("|%-6d |%-20s|%-14.2f |%-14.2f |%-23s  |%-15s|%-30s |\n",
	    return String.format("|%-6d |%-20s |%-15s   |%-15s |%-19s  |%-18s|%-50s |||||||||0|\n",
	            this.equipmentID, this.equipmentName, originalPrice, promotionPrice,
	            this.promotionStartDate, this.promotionExpiryDate, this.equipmentDescription);
	}
}

