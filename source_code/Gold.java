class Gold extends Member {
    private static int goldCount = 0;
    
    public Gold() {
    	super();
    }

    public Gold(String name, String icNumber, String gender, String phoneNum, String email, Address address) {
        super(name, icNumber, gender, phoneNum, email, address, "Gold", 0.2, 100.0);
        goldCount++;
    }

    public static int getGoldCount() {
        return goldCount;
    }

    public static void setGoldCount(int goldCount) {
        Gold.goldCount = goldCount;
    }
}
