public class LiquidMedicine extends Medicine {
    private static int liquidMedicineCount = 0;

    public LiquidMedicine() {
        super();
    }

    public LiquidMedicine(String liquidMedicineName, double liquidMedicinePrice,String liquidMedicineManufactureDate,String liquidMedicineExpiryDate, String liquidMedicineDescription) {
        super(liquidMedicineName,liquidMedicinePrice,liquidMedicineManufactureDate,liquidMedicineExpiryDate, liquidMedicineDescription);
        liquidMedicineCount++;
    }

    public static int getLiquidMedicineCount() { return liquidMedicineCount; }

    public static void setLiquidMedicineCount(int liquidMedicineCount) { LiquidMedicine.liquidMedicineCount = liquidMedicineCount; }
}