public abstract class MembershipPlan implements Billable {

    private static final double VAT = 0.23;

    private String planCode;
    private String clientName;
    private int months;
    private double baseMonthlyFee;
    private boolean autoRenew;

    public MembershipPlan(String planCode, String clientName, int months, double baseMonthlyFee, boolean autoRenew) {
        this.planCode = planCode;
        this.clientName = clientName;
        this.months = months;
        this.baseMonthlyFee = baseMonthlyFee;
        this.autoRenew = autoRenew;
    }

    public String getPlanCode() {
        return planCode;
    }

    public String getClientName() {
        return clientName;
    }

    public int getMonths() {
        return months;
    }

    public double getBaseMonthlyFee() {
        return baseMonthlyFee;
    }

    public boolean isAutoRenew() {
        return autoRenew;
    }

    public abstract String getPlanType();

    @Override
    public abstract double calculateMonthlyNetPrice();

    @Override
    public double calculateMonthlyGrossPrice() {
        return calculateMonthlyNetPrice() * (1 + VAT);
    }

    public double calculateTotalNetPrice() {
        return calculateMonthlyNetPrice() * months;
    }

    public final void printSummary() {
        System.out.println("Plan: " + getPlanType() + " [" + planCode + "]");
        System.out.println("Client: " + clientName + ", months: " + months);
        System.out.println("Monthly net: " + calculateMonthlyNetPrice());
        System.out.println("Monthly gross: " + calculateMonthlyGrossPrice());
        System.out.println("Total contract net: " + calculateTotalNetPrice());
    }

    @Override
    public String toString() {
        return getPlanType() + "{code=" + planCode +
                ", client=" + clientName +
                ", months=" + months +
                ", baseMonthlyFee=" + baseMonthlyFee +
                ", autoRenew=" + autoRenew + "}";
    }

}


