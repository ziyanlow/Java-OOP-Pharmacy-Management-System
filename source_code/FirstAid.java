public class FirstAid extends Equipment {
    private static int firstAidCount = 0;

    public FirstAid() {
        super();
    }

     public FirstAid(String firstAidName, double firstAidPrice, String firstAidPromotionStartDate, String firstAidPromotionExpiryDate, String firstAidDescription) {
        super(firstAidName, firstAidPrice, firstAidPromotionStartDate, firstAidPromotionExpiryDate, firstAidDescription);
        firstAidCount++;
    }


    public static int getFirstAidCount() { return firstAidCount; }

    public static void setFirstAidCount(int firstAidCount) { FirstAid.firstAidCount = firstAidCount; }
}
