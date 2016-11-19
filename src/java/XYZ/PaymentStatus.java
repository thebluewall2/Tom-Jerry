package XYZ;

public enum PaymentStatus 
{
    DUE("DUE"), DECLINED("DECLINED"), APPROVED("APPROVED"), PENDING("PENDING");

    private final String name;

    private PaymentStatus(String s) {
        this.name = s;
    }

    @Override
    public String toString() {
        return this.name();
    }
}