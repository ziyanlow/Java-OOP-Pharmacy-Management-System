import java.util.Scanner;
import java.util.Date;

public class Report {
    private Receipt receiptDetails;
    private Date reportGenerateDateTime;
    Scanner input = new Scanner(System.in);

    public Report() {
        this.receiptDetails = null;
        this.reportGenerateDateTime = null;
    }

    public Report(Receipt receiptDetails) {
        this.receiptDetails = receiptDetails;
    }

    // Getter
    public Receipt getReceiptDetails() { return this.receiptDetails; }
    public Date getReportGenerateDateTime() { return this.reportGenerateDateTime; }

    // Setter
    public void setReceiptDetails(Receipt receiptDetails) { this.receiptDetails = receiptDetails; }
    public void setReportGenerateDateTime(Date reportGenerateDateTime) { this.reportGenerateDateTime = reportGenerateDateTime; }

	//Method
    public void adminMenuReport() {
        int choice = 0;

        do {
            System.out.println("|=========================|");
            System.out.println("|   Report Menu (Admin)   |");
            System.out.println("|=========================|");
            System.out.println("|1. Generate Sales Report |");
            System.out.println("|2. Generate Shift Report |");
            System.out.println("|0. Quit                  |");
            System.out.println("|=========================|");

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
                reportGenerateDateTime = new Date();
                displaySalesReport();
            }else if (choice == 2) {
                reportGenerateDateTime = new Date();
                displayShiftReport();
            }else if (choice == 0) {
                break;
            }else {
                System.out.println("*Invalid Choice! Please try again!");
                System.out.println();
            }
        } while (true);
    }

    public void displaySalesReport() {
        double totalSales = 0;
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.printf("%-47s%s\n", "", "Medplus Pharmacy");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.printf("%-35s%s\n", "", "88, Jalan Flower, Lorong Lembah Permai,");
        System.out.printf("%-35s%s\n", "", "11500 Tanjung Bungah, Pulau Pinang");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.printf("%43s%s\n", "", "DAILY SALES REPORT");
        System.out.printf("%32s%s%s\n", "", "DATE GENERATED: ", reportGenerateDateTime);
        System.out.println("==========================================================================================================");
        System.out.printf("|%-11s |%-11s |%-20s |%-20s |%28s(RM)  | \n", "Receipt ID", "Order ID", "Staff", "Member", "Total");
        System.out.println("|------------|------------|---------------------|---------------------|----------------------------------|");
        for (int i = 0; i < Receipt.getReceiptCount(); i++) {
            totalSales += receiptDetails.receiptList[i].getReceiptPayment().getTotalAmount();
            if (receiptDetails.receiptList[i].getReceiptPayment().getMember() != null) {
                System.out.printf("|%-11s |%-11s |%-20s |%-20s |%32.2f  | \n", receiptDetails.receiptList[i].getReceiptID(), receiptDetails.receiptList[i].getReceiptPayment().getOrder().getOrderID(), receiptDetails.receiptList[i].getReceiptPayment().getStaff().getName(), receiptDetails.receiptList[i].getReceiptPayment().getMember().getName(), receiptDetails.receiptList[i].getReceiptPayment().getTotalAmount());
            }else {
                System.out.printf("|%-11s |%-11s |%-20s |%-20s |%32.2f  | \n", receiptDetails.receiptList[i].getReceiptID(), receiptDetails.receiptList[i].getReceiptPayment().getOrder().getOrderID(), receiptDetails.receiptList[i].getReceiptPayment().getStaff().getName(), "Not Applicable", receiptDetails.receiptList[i].getReceiptPayment().getTotalAmount());
            }
        }
        System.out.println("==========================================================================================================");
        System.out.printf("%98s%.2f\n", "Grand Total Sales: RM", totalSales);
        System.out.printf("%98s%.2f\n", "Average Sales Per Order: RM", totalSales / Receipt.getReceiptCount());
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println();
    }

    

    public void displayShiftReport() {
        int cashTimeUsed = 0;
        double cashTotalAmount = 0;
        int cardTimeUsed = 0;
        double cardTotalAmount = 0;
        int ewalletTimeUsed = 0;
        double ewalletTotalAmount = 0;

        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.printf("%-47s%s\n", "", "Medplus Pharmacy");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.printf("%-35s%s\n", "", "88, Jalan Flower, Lorong Lembah Permai,");
        System.out.printf("%-35s%s\n", "", "11500 Tanjung Bungah, Pulau Pinang");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.printf("%44s%s\n", "", "DAILY SHIFT REPORT");
        System.out.printf("%32s%s%s\n", "", "DATE GENERATED: ", reportGenerateDateTime);
        System.out.println("==========================================================================================================");
        System.out.printf("|%-30s |%-20s |%48s  | \n", "Payment Method", "Time Used", "Total Amount(RM)");
        System.out.println("|-------------------------------|---------------------|--------------------------------------------------|");
        for (int i = 0; i < Receipt.getReceiptCount(); i++) {
            if (receiptDetails.receiptList[i].getReceiptPayment().getPaymentMethod().equals("Cash")) {
                cashTimeUsed++;
                cashTotalAmount += receiptDetails.receiptList[i].getReceiptPayment().getTotalAmount();
            }else if (receiptDetails.receiptList[i].getReceiptPayment().getPaymentMethod().equals("Card")) {
                cardTimeUsed++;
                cardTotalAmount += receiptDetails.receiptList[i].getReceiptPayment().getTotalAmount();
            }else if (receiptDetails.receiptList[i].getReceiptPayment().getPaymentMethod().equals("Ewallet")) {
                ewalletTimeUsed++;
                ewalletTotalAmount += receiptDetails.receiptList[i].getReceiptPayment().getTotalAmount();
            }
        }
        System.out.printf("|%-30s |%-20d |%48.2f  | \n", "Cash", cashTimeUsed, cashTotalAmount);
        System.out.printf("|%-30s |%-20d |%48.2f  | \n", "Credit/Debit Card", cardTimeUsed, cardTotalAmount);
        System.out.printf("|%-30s |%-20d |%48.2f  | \n", "Touch 'n Go eWallet", ewalletTimeUsed, ewalletTotalAmount);
        System.out.println("==========================================================================================================");
        System.out.println();
    }
}
