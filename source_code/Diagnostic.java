public class Diagnostic extends Equipment {
    private static int diagnosticCount = 0;

    public Diagnostic() {
        super();
    }

     public Diagnostic(String diagnosticName, double diagnosticPrice, String diagnosticPromotionStartDate, String diagnosticPromotionExpiryDate, String diagnosticDescription) {
        super(diagnosticName, diagnosticPrice, diagnosticPromotionStartDate, diagnosticPromotionExpiryDate, diagnosticDescription);
        diagnosticCount++;
    }

    public static int getDiagnosticCount() { return diagnosticCount; }

    public static void setDiagnosticCount(int diagnosticCount) { Diagnostic.diagnosticCount = diagnosticCount; }
}