class Silver extends Member {
    private static int silverCount = 0;
    
    public Silver() {
    	super();
    }

    public Silver(String name, String icNumber, String gender, String phoneNum, String email, Address address) {
        super(name, icNumber, gender, phoneNum, email, address, "Silver", 0.1, 200.0);
        silverCount++;
    }

    public static int getSilverCount() {
        return silverCount;
    }

    public static void setSilverCount(int silverCount) {
        Silver.silverCount = silverCount;
    }
}