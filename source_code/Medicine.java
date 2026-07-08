import java.util.Scanner;

public class Medicine {
	public static Medicine[] medicineList = new Medicine[1000];
    private int medicineID;
    private String medicineName;
    private double medicinePrice;
    private String manufactureDate;
    private String expiryDate;
    private String medicineDescription;
    private static int medicineCount = 0;
    private static int totalMedicine = 0;
    private static int lastMedicineID = 1001;
    Scanner input = new Scanner(System.in);


    public Medicine() {
        this.medicineID = 0;
        this.medicineName = "";
        this.manufactureDate="";
        this.expiryDate="";
        this.medicinePrice = 0.0;
        this.medicineDescription = "";
    }

    public Medicine(String medicineName,double medicinePrice,String manufactureDate, String expiryDate,String medicineDescription) {
        this.medicineID = lastMedicineID;
        this.medicineName = medicineName;
        this.medicinePrice = medicinePrice;
        this.manufactureDate=manufactureDate;
        this.expiryDate=expiryDate;
        this.medicineDescription = medicineDescription;
        medicineCount++;
        totalMedicine++;
        lastMedicineID++;
    }

    // Getter
   	public int getMedicineID() { return this.medicineID; }
    public String getMedicineName() { return this.medicineName; }
    public double getMedicinePrice() { return this.medicinePrice; }
    public String getManufactureDate(){ return this.manufactureDate;}
    public String getExpiryDate(){ return this.expiryDate;}
    public String getMedicineDescription() { return this.medicineDescription; }
    public static int getMedicineCount() { return medicineCount; }
    public static int getTotalMedicine() { return totalMedicine; }
    public static int getLastMedicineID() { return lastMedicineID; }


    // Setter 
    public void setMedicineID(int medicineID) { this.medicineID = medicineID; }
	public void setMedicineName(String medicineName) { this.medicineName = medicineName; }
	public void setMedicinePrice(double medicinePrice) { this.medicinePrice = medicinePrice; }
	public void setManufactureDate(String manufactureDate) { this.manufactureDate = manufactureDate; }
	public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }
	public void setMedicineDescription(String medicineDescription) { this.medicineDescription = medicineDescription; }
	public static void setMedicineCount(int medicineCount) { Medicine.medicineCount = medicineCount; }
	public static void setTotalMedicine(int totalMedicine) { Medicine.totalMedicine = totalMedicine; }
	public static void setLastMedicineID(int lastMedicineID) { Medicine.lastMedicineID = lastMedicineID; }

    public void createDefaultMedicine() {
        medicineList[0] = new TabletCapsule("Sore Throat tablet",58.00,"2023-08-15", "2024-08-15","Anti-inflammatory for sore throat. ");
        medicineList[1] = new TabletCapsule("Vitamin E soft capsule",14.50,"2023-09-10", "2024-09-10", "Supports cardiovascular health. ");
        medicineList[2] = new TabletCapsule("Ganoderma Softgel Capsule ",36.00,"2023-07-20", "2024-07-20","Aids liver detoxification. ");
        medicineList[3] = new TabletCapsule("Carusos Natural Health tablets",33.00,"2023-06-05", "2024-06-05", "Relieve symptoms of Stress. ");
        medicineList[4] = new TabletCapsule("Swiss Magnesium Oxide Tablets",7.00,"2023-11-30", "2024-11-30", "Supports bone and muscle health. ");
        medicineList[5] = new TabletCapsule("Serrin Tablets",126.00,"2023-10-12", "2024-10-12", "May affect blood clotting. ");
        medicineList[6] = new TabletCapsule("Kava Kava 30 Capsule",7.50,"2023-09-25", "2024-09-25", "Promotes calm and relaxation.");
        medicineList[7] = new LiquidMedicine("Robitussin Adult Cough",10.00,"2023-12-18", "2024-12-18", "Controls cough and chest congestion.");
        medicineList[8] = new LiquidMedicine("SBL Zincum Carbonicum",95.00,"2023-07-08", "2024-07-08","Alleviates throat inflammation.");
        medicineList[9] = new LiquidMedicine("Hywell Liquid Identification",162.00,"2023-08-30", "2024-08-30", "Rapid reagent for drug testing.");
        medicineList[10] = new LiquidMedicine("NOW Foods Iron Liquid",90.00,"2023-10-15", "2024-10-15", "Supports energy and immunity. ");
        medicineList[11] = new LiquidMedicine("Relief Adults Solution",65.00,"2023-09-01", "2024-09-01", "Enhances the resistance to Allergies. ");
        medicineList[12] = new LiquidMedicine("Olive Leaf Extract",25.00,"2023-07-12", "2024-07-12", "Reduces free radical damage. ");
        medicineList[13] = new LiquidMedicine("Liquid Cellular Energy Boost",80.00,"2023-11-10", "2024-11-10", "Supports fat metabolism. ");
    }

 	public void adminMenuMedicine() {
    	int choice = 0;
	    do {
	        System.out.println("=========================");
            System.out.println("   Medicine Menu (Admin)   ");
            System.out.println("=========================");
            System.out.println("1. Display Medicine");
            System.out.println("2. Add Medicine");
            System.out.println("3. Delete Medicine");
            System.out.println("4. Edit Medicine");
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
	            displayMedicine();
	        } else if (choice == 2) {
	            addMedicine();
	        } else if (choice == 3) {
	            deleteMedicine();
	        } else if (choice == 4) {
	            editMedicine();
	        } else if (choice == 0) {
	            break;
	        } else {
	            System.out.println("*Invalid Choice! Please try again!");
	            System.out.println();
	        }
	    } while (true);
	}
	
	public void displayMedicine() {
	    System.out.println("================================================================================================================================");
	    System.out.printf("%-51s%s%64s\n", "|", "Medicine Menu", "|");
	    System.out.println("================================================================================================================================");
	    System.out.printf("|%-6s | %-30s | %-6s |%-9s   |%-16s|%-39s| \n", "ID", "Medicine Name", "Price", "Manufacture Date","Expiry Date", "Description");
	    System.out.println("|-------|--------------------------------|--------|-------------------|----------------|---------------------------------------|");
	    for (int i = 0; i < totalMedicine; i++) {
	        if (medicineList[i].medicineID != 0) {
	            System.out.printf("|%-6d | %-30s | %-6.2f | %-17s | %-14s | %-38s| \n", medicineList[i].medicineID, medicineList[i].medicineName, medicineList[i].medicinePrice,medicineList[i].manufactureDate,medicineList[i].expiryDate,medicineList[i].medicineDescription);
	        }
	    }
	    System.out.println("================================================================================================================================");
	    System.out.println("Total Medicine: " + medicineCount);
	    System.out.println();
	}
	
	//add medicine
    public void addMedicine() {
        int category = 0;
        char confirmation = 'N';

        do {
            System.out.println("=========================");
            System.out.println("   Add Medicine (Category)   ");
            System.out.println("=========================");
            System.out.println("1. Tablet & Capsule");
            System.out.println("2. Liquid Medicine");
            System.out.println("0. Quit");

            do {
                try {
                    System.out.print("Enter your choice: ");
                    category = input.nextInt();
                    input.nextLine();
                    break;
                }
                catch (Exception error) {
                    System.out.println("*Invalid Choice! It should be an integer.");
                    input.nextLine();
                }
            } while (true);

            if (category == 1) {
                System.out.print("Enter the Medicine Name       : ");
                medicineName = input.nextLine();
			
                do {
                    try {
                        System.out.print("Enter the Medicine Price      : ");
                        medicinePrice = input.nextDouble();
			
                        if (medicinePrice < 0.01) {
                            System.out.println("*The Medicine Price should not be zero or negative value.");
                        }else {
                            input.nextLine();
                            break;
                        }
                    }catch (Exception error) {
                        System.out.println("*Invalid Medicine Price! It should be a number with or without decimal.");
                        input.nextLine();
                    }
                } while (true);

				System.out.print("Enter the Manufacture Date    : ");
				manufactureDate=input.nextLine();
				System.out.print("Enter the Expiry Date         : ");
				expiryDate=input.nextLine();
                System.out.print("Enter the Medicine Description: ");
                medicineDescription = input.nextLine();

                do {
                    do {
                        try {
                            System.out.print("Are you sure to add " + medicineName + " (Y/N): ");
                            confirmation = input.nextLine().charAt(0);
                            if (Character.toUpperCase(confirmation) == 'Y') {
                                medicineList[totalMedicine] = new TabletCapsule(medicineName, medicinePrice,manufactureDate,expiryDate, medicineDescription);
                                System.out.printf("The new medicine (%s) is created successfully! \n", medicineName);
                            }

                            else if (Character.toUpperCase(confirmation) != 'Y' && Character.toUpperCase(confirmation) != 'N') {
                                System.out.println("*Invalid! It should be 'Y' or 'N'.");
                            }
                            break;
                        }catch (StringIndexOutOfBoundsException error) {
                            System.out.println("*Invalid! It should be 'Y' or 'N'.");
                        }
                    } while (true);
                } while (Character.toUpperCase(confirmation) != 'Y' && Character.toUpperCase(confirmation) != 'N');
            }

            else if (category == 2) {
                System.out.print("Enter the Medicine Name       : ");
                medicineName = input.nextLine();

                do {
                    try {
                        System.out.print("Enter the Medicine Price      : ");
                        medicinePrice = input.nextDouble();

                        if (medicinePrice < 0.01) {
                            System.out.println("*The Medicine Price should not be zero or negative value.");
                        }

                        else {
                            input.nextLine();
                            break;
                        }
                    }

                    catch (Exception error) {
                        System.out.println("*Invalid Medicine Price! It should be a number with or without decimal.");
                        input.nextLine();
                    }
                } while (true);

                System.out.print("Enter the Manufacture Date    : ");
				manufactureDate=input.nextLine();
				System.out.print("Enter the Expiry Date         : ");
				expiryDate=input.nextLine();
                System.out.print("Enter the Medicine Description: ");
                medicineDescription = input.nextLine();
                
                do {
                    do {
                        try {
                            System.out.print("Are you sure to add " + medicineName + " (Y/N): ");
                            confirmation = input.nextLine().charAt(0);
                            if (Character.toUpperCase(confirmation) == 'Y') {
                                medicineList[totalMedicine] = new LiquidMedicine(medicineName, medicinePrice,manufactureDate,expiryDate, medicineDescription);
                                System.out.printf("The new Medicine (%s) is created successfully! \n", medicineName);
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
            }
            else if (category == 0) {
                break;
            }
            else {
                System.out.println("*Invalid Choice! Please try again!");
                System.out.println();
            }
        } while (true);
        System.out.println();
    }

    public void deleteMedicine() {
        int found = 0;
        int deleteIndex = 0;
        char confirmation = 'N';

        System.out.println("====================");
        System.out.println("   Delete Medicine   ");
        System.out.println("====================");

        do {
            do {
                try {
                    System.out.print("Enter the Medicine ID: ");
                    medicineID = input.nextInt();
                    input.nextLine();
                    break;
                }catch (Exception error) {
                    System.out.println("*Invalid Medicine ID! It should be an integer.");
                    input.nextLine();
                }
            } while (true);
            for (int i = 0; i < totalMedicine; i++) {
                if (medicineID == medicineList[i].medicineID) {
                    System.out.println("================================================================================================================================");
	    			System.out.printf("%-51s%s%64s\n", "|", "Medicine Menu", "|");
	    			System.out.println("================================================================================================================================");
                    System.out.printf("|%-6s | %-30s | %-6s |%-9s   |%-16s|%-39s| \n", "ID", "Medicine Name", "Price", "Manufacture Date","Expiry Date", "Description");
	    			System.out.println("|-------|--------------------------------|--------|-------------------|----------------|---------------------------------------|");
	    			System.out.print(medicineList[i].toString());
                    System.out.println("================================================================================================================================");
                    found++;
                    deleteIndex = i;
                    break;
                }
            }
            if (found == 0) {
                System.out.println("*This Medicine ID is not existed. Please try again!");
            }
        } while (found == 0);

        do {
            do {
                try {
                    System.out.print("Are you sure to delete " + medicineList[deleteIndex].medicineName + " (Y/N): ");
                    confirmation = input.nextLine().charAt(0);
                    if (Character.toUpperCase(confirmation) == 'Y') {
                        if (medicineList[deleteIndex].getClass().getSimpleName().equals("TabletCapsule")) {
                            medicineList[deleteIndex] = new TabletCapsule();
                            TabletCapsule.setTabletCapsuleCount(TabletCapsule.getTabletCapsuleCount() - 1);
                        }
                        else if (medicineList[deleteIndex].getClass().getSimpleName().equals("LiquidMedicine")) {
                            medicineList[deleteIndex] = new LiquidMedicine();
                            LiquidMedicine.setLiquidMedicineCount(LiquidMedicine.getLiquidMedicineCount() - 1);
                        }
                        medicineCount--;
                        System.out.printf("The Medicine (%s) is deleted successfully! \n", medicineID);
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

    public void editMedicine() {
        int found = 0;
        int editIndex = 0;
        int choice = 0;

        System.out.println("==================");
        System.out.println("   Edit Medicine   ");
        System.out.println("==================");

        do {
            found = 0;
            do {
                try {
                    System.out.print("Enter the Medicine ID: ");
                    medicineID = input.nextInt();
                    input.nextLine();
                    break;
                }
                catch (Exception error) {
                    System.out.println("*Invalid Medicine ID! It should be an integer.");
                    input.nextLine();
                }
            } while (true);

            for (int i = 0; i < totalMedicine; i++) {
                if (medicineID == medicineList[i].medicineID) {
                    System.out.println("================================================================================================================================");
				    System.out.printf("%-51s%s%64s\n", "|", "Medicine Menu", "|");
				    System.out.println("================================================================================================================================");
				    System.out.printf("|%-6s | %-30s | %-6s |%-9s   |%-16s|%-39s| \n", "ID", "Medicine Name", "Price", "Manufacture Date","Expiry Date", "Description");
				    System.out.println("|-------|--------------------------------|--------|-------------------|----------------|---------------------------------------|");
				    System.out.print(medicineList[i].toString());
		            System.out.println("================================================================================================================================");
                    System.out.println();
                    found++;
                    editIndex = i;
                    break;
                }
            }

            if (found == 0) {
                System.out.println("*This Medicine ID is not existed. Please try again!");
            }
        } while (found == 0);

        do {
            System.out.println("======================");
            System.out.printf("   Edit Medicine (%d)   \n", medicineList[editIndex].medicineID);
            System.out.println("======================");
            System.out.println("1. Medicine Name");
            System.out.println("2. Medicine Price");
            System.out.println("3. Medicine Description");
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

            if (choice == 1) {
                System.out.print("Enter the New Medicine Name: ");
                medicineName = input.nextLine();
                medicineList[editIndex].setMedicineName(medicineName);
            }
            else if (choice == 2) {
                do {
                    try {
                        System.out.print("Enter the New Medicine Price: ");
                        medicinePrice = input.nextDouble();

                        if (medicinePrice < 0.01) {
                            System.out.println("*The Medicine Price should not be zero or negative value.");
                        }else {
                            input.nextLine();
                            break;
                        }
                    }catch (Exception error) {
                        System.out.println("*Invalid Medicine Price! It should be a number with or without decimal.");
                        input.nextLine();
                    }
                } while (true);
                medicineList[editIndex].setMedicinePrice(medicinePrice);
            }
            else if (choice == 3) {
                System.out.print("Enter the New Medicine Description: ");
                medicineDescription = input.nextLine();
                medicineList[editIndex].setMedicineDescription(medicineDescription);
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

    public Medicine searchMedicine(int medicineID) {
	    for (int i = 0; i < totalMedicine; i++) {
	        if (medicineID == medicineList[i].medicineID) {
	            return medicineList[i];
	        }
	    }
	    
	    return null;
	}

	@Override
	public String toString() {
	    return String.format("|%-6d | %-30s | %-6.2f | %-17s | %-14s | %-38s| \n", this.medicineID, this.medicineName, this.medicinePrice, this.manufactureDate,this.expiryDate,this.medicineDescription);
	}	
}