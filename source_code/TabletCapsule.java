public class TabletCapsule extends Medicine {
    private static int tabletCapsuleCount = 0;

    public TabletCapsule() {
        super();
    }

    public TabletCapsule(String tabletCapsuleName, double tabletCapsulePrice,String tabletCapsuleManufactureDate, String tabletCapsuleExpiryDate, String tabletCapsuleDescription) {
        super(tabletCapsuleName, tabletCapsulePrice,tabletCapsuleManufactureDate,tabletCapsuleExpiryDate, tabletCapsuleDescription);
        tabletCapsuleCount++;
    }

    public static int getTabletCapsuleCount() { return tabletCapsuleCount; }

    public static void setTabletCapsuleCount(int tabletCapsuleCount) { TabletCapsule.tabletCapsuleCount = tabletCapsuleCount; }
}