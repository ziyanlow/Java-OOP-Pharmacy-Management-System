public class Promotion {
    public static double applyPromotion(double originalPrice, double discountPercentage) {
        double discountAmount = originalPrice * (discountPercentage / 100);
        double discountedPrice = originalPrice - discountAmount;
        return discountedPrice;
    }
}
