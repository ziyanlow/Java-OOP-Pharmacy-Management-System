import java.util.Scanner;

public class Item {
    public Item[] itemList = new Item[10000];
    private Medicine orderMedicine;
    private Equipment orderEquipment;
    private int medicineQuantity;
    private int equipmentQuantity;
    private double medicineSubtotal;
    private double equipmentSubtotal;
    private double subtotal = 0;
    private int orderItemCount = 0;
    private int totalOrderItem = 0;
    Scanner input = new Scanner(System.in);

    public Item() {
        this.orderMedicine = null;
        this.orderEquipment = null;
        this.medicineQuantity = 0;
        this.equipmentQuantity = 0;
        this.medicineSubtotal = 0.0;
        this.equipmentSubtotal = 0.0;
    }

    public Item(Medicine orderMedicine, int medicineQuantity) {
        this.orderMedicine = orderMedicine;
        this.medicineQuantity = medicineQuantity;
        this.medicineSubtotal = this.orderMedicine.getMedicinePrice() * this.medicineQuantity;
    }

    /*public Item(Equipment orderEquipment, int equipmentQuantity) {
        this.orderEquipment = orderEquipment;
        this.equipmentQuantity = equipmentQuantity;
        this.equipmentSubtotal = this.orderEquipment.getEquipmentPrice() * this.equipmentQuantity;////////////////////////////<------------------
    }*/

	public Item(Equipment orderEquipment, int equipmentQuantity) {
	    this.orderEquipment = orderEquipment;
	    this.equipmentQuantity = equipmentQuantity;
	    // Calculate the subtotal using the promotion price
	    // Replace 20.0 with the actual discount percentage
	    //->pass discountPercentage to  
	    double promotionPrice = orderEquipment.calculatePromotionPrice(20.0); 
	    this.equipmentSubtotal = promotionPrice * this.equipmentQuantity;
	}

    // Getter
    public Medicine getOrderMedicine() { return this.orderMedicine; }
    public Equipment getOrderEquipment() { return this.orderEquipment; }
    public int getMedicineQuantity() { return this.medicineQuantity; }
    public int getEquipmentQuantity() { return this.equipmentQuantity; }
    public double getMedicineSubtotal() { return this.medicineSubtotal; }
    public double getEquipmentSubtotal() { return this.equipmentSubtotal; }
    public double getSubtotal() { return this.subtotal; }
    public int getOrderItemCount() { return this.orderItemCount; }
    public int getTotalOrderItem() { return this.totalOrderItem; }

    // Setter
    public void setOrderMedicine(Medicine orderMedicine) { this.orderMedicine = orderMedicine; }
    public void setOrderEquipment(Equipment orderEquipment) { this.orderEquipment = orderEquipment; }
    public void setMedicineQuantity(int medicineQuantity) { this.medicineQuantity = medicineQuantity; }
    public void setEquipmentQuantity(int equipmentQuantity) { this.equipmentQuantity = equipmentQuantity; }
    public void setMedicineSubtotal(double medicineSubtotal) { this.medicineSubtotal = medicineSubtotal; }
    public void setEquipmentSubtotal(double equipmentSubtotal) { this.equipmentSubtotal = equipmentSubtotal; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }
    public void setOrderItemCount(int orderItemCount) { this.orderItemCount = orderItemCount; }
    public void setTotalOrderItem(int totalOrderItem) { this.totalOrderItem = totalOrderItem; }

	//Method
	//display item in order summary
    public void displayItem() {
    	//see format
        System.out.printf("|%-6s |%-30s |%-6s |%-9s |%-40s     | \n", "ID", "Item Name", "Price", "Quantity", "Subtotal (RM) ");
        System.out.println("|-------|-------------------------------|-------|----------|---------------------------------------------|");
        	for (int i = 0; i < totalOrderItem; i++) {
            System.out.print(itemList[i].toString());
        }
        System.out.println("==========================================================================================================");
        System.out.println("Total Item: " + orderItemCount);
        System.out.printf("Subtotal: RM%.2f \n", subtotal);
        System.out.println();
    }
	
	//add item in the order
    public void addItem(Medicine medicineList, Equipment equipmentList) {
        int medicineBevID = 0;
        int quantity = 0;
        char confirmation = 'N';

        medicineList.displayMedicine();//display medicine list
        equipmentList.displayEquipment();//display equipment list

        System.out.println("==============");
        System.out.println("   Add Order   ");
        System.out.println("==============");

        do {
            do {
                try {
                    System.out.print("Enter the Medicine/Equipment ID: ");
                    medicineBevID = input.nextInt();
                    input.nextLine();
                    break;
                }catch (Exception error) {
                    System.out.println("*Invalid Medicine/Equipment ID! It should be an integer.");
                    input.nextLine();
                }
            } while (true);

            do {
                try {
                    System.out.print("Enter the Quantity: ");
                    quantity = input.nextInt();
                    input.nextLine();

                    if (quantity <= 0) {
                        System.out.println("*Invalid Quantity! It should be higher than 0.");
                    }else {
                        break;
                    }
                }catch (Exception error) {
                    System.out.println("*Invalid Quantity! It should be an integer.");
                    input.nextLine();
                }
            } while (true);

            if (medicineList.searchMedicine(medicineBevID) != null) {//check medicineID validation
                orderMedicine = medicineList.searchMedicine(medicineBevID);
                itemList[totalOrderItem] = new Item(orderMedicine, quantity);
                orderItemCount++;
                totalOrderItem++;
                // Calculation of subtotal
                subtotal += orderMedicine.getMedicinePrice() * quantity;
                System.out.printf("%dx %s(s) is added successfully! \n", quantity, orderMedicine.getMedicineName());
            }else if (equipmentList.searchEquipment(medicineBevID) != null) {//check equipmentID validation
			    orderEquipment = equipmentList.searchEquipment(medicineBevID);
			    itemList[totalOrderItem] = new Item(orderEquipment, quantity);
			    orderItemCount++;
			    totalOrderItem++;
				// Calculation of subtotal
			    // Get the promotionPrice using the calculatePromotionPrice method
			    double promotionPrice = orderEquipment.calculatePromotionPrice(20.0); // 20.0 is the discount percentage
			    subtotal += promotionPrice * quantity;			
			    System.out.printf("%dx %s(s) is added successfully! \n", quantity, orderEquipment.getEquipmentName());
			}else {
                System.out.println("*This Medicine/Equipment ID is not existed.");
            }

            do {
                do {
                    try {
                        System.out.print("Add more item (Y/N): ");
                        confirmation = input.nextLine().charAt(0);
                        if (Character.toUpperCase(confirmation) != 'Y' && Character.toUpperCase(confirmation) != 'N') {
                            System.out.println("*Invalid! It should be 'Y' or 'N'.");
                        }
                        System.out.println();
                        break;
                    }catch (StringIndexOutOfBoundsException error) {
                        System.out.println("*Invalid! It should be 'Y' or 'N'.");
                        System.out.println();
                    }
                } while (true);
            } while (Character.toUpperCase(confirmation) != 'Y' && Character.toUpperCase(confirmation) != 'N');
        } while (Character.toUpperCase(confirmation) == 'Y');
    }

	//delete item in the order
    public void deleteItem() {
        int medicineBevID = 0;
        int found = 0;
        int deleteIndex = 0;
        char confirmation = 'N';

        System.out.println("=================");
        System.out.println("   Delete Item   ");
        System.out.println("=================");

        do {
            do {
                try {
                    System.out.print("Enter the Medicine/Equipment ID: ");
                    medicineBevID = input.nextInt();
                    input.nextLine();
                    break;
                }catch (Exception error) {
                    System.out.println("*Invalid Medicine/Equipment ID! It should be an integer.");
                    input.nextLine();
                }
            } while (true);

            for (int i = 0; i < totalOrderItem; i++) {
                if (itemList[i].orderMedicine != null) {//loop and check item from orderMedicine
                    if (medicineBevID == itemList[i].orderMedicine.getMedicineID()) {//check ID entered from orderMedicine list
                        found++;
                        deleteIndex = i;
                        break;
                    }
                }else if (itemList[i].orderEquipment != null) {//loop and check item from orderEquipment
                    if (medicineBevID == itemList[i].orderEquipment.getEquipmentID()) {//check ID entered from orderEquipment list
                        found++;
                        deleteIndex = i;
                        break;
                    }
                }
            }
            if (found == 0) {
                System.out.println("*This Medicine/Equipment ID is not existed in the Order. Please try again!");
            }
        } while (found == 0);

        do {
            do {
                try {
                    System.out.print("Are you sure to delete Item " + medicineBevID + " from the Order (Y/N): ");
                    confirmation = input.nextLine().charAt(0);
                    if (Character.toUpperCase(confirmation) == 'Y') {
                    	//New calculation of subtotal for medicine and equipment
                        subtotal -= (itemList[deleteIndex].medicineSubtotal + itemList[deleteIndex].equipmentSubtotal);
                        itemList[deleteIndex] = new Item();
                        orderItemCount--;
                        System.out.printf("The Item (%s) is deleted successfully! \n", medicineBevID);
                    }else if (Character.toUpperCase(confirmation) != 'Y' && Character.toUpperCase(confirmation) != 'N') {
                        System.out.println("*Invalid! It should be 'Y' or 'N'.");
                    }
                    break;
                }catch (StringIndexOutOfBoundsException error) {
                    System.out.println("*Invalid! It should be 'Y' or 'N'.");
                }
            } while (true);
        } while (Character.toUpperCase(confirmation) != 'Y' && Character.toUpperCase(confirmation) != 'N');
        System.out.println();
    }

    @Override
    public String toString() {
        if (this.orderMedicine != null) {
        	return String.format("|%-6d |%-30s |%-6.2f |%-9d |%-43.2f  | \n", this.orderMedicine.getMedicineID(), this.orderMedicine.getMedicineName(), this.orderMedicine.getMedicinePrice(), this.medicineQuantity, this.medicineSubtotal);
        }else if (this.orderEquipment != null) {
        	//promoPrice
		    double promotionPrice = this.orderEquipment.calculatePromotionPrice(20.0); // Replace 20.0 with the actual discount percentage
		    return String.format("|%-6d |%-30s |%-6.2f |%-9d |%-43.2f  | \n", 
	        this.orderEquipment.getEquipmentID(), this.orderEquipment.getEquipmentName(), promotionPrice,
            this.equipmentQuantity, this.equipmentSubtotal);
		}
		//Handle the case where orderEquipment is null
        return "";
    }
}
