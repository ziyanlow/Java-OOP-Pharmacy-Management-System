public class Card extends Payment {
    private String cardNumber;
    private String expiryDate;
    private String cvc;

    public Card() {
        super();
    }

    public Card(Staff staff, Order order, Member member, double discount, double totalAmount, String cardNumber, String expiryDate, String cvc) {
        super("Card", staff, order, member, discount, totalAmount);
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvc = cvc;
    }

    // Getter
    public String getcardNumber() { return this.cardNumber; }
    public String getExpiryDate() { return this.expiryDate; }
    public String getCvc() { return this.cvc; }

    // Setter
    public void setcardNumber(String cardNumber) { this.cardNumber = cardNumber; }
    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }
    public void setCvc(String cvc) { this.cvc = cvc; }
}