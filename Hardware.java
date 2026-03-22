package HardwareSystem;

public abstract class Hardware {
    private final String id;
    private final String brand;
    private final int spec;

    public Hardware(String id, String brand, int spec) {
        this.id    = id;
        this.brand = brand;
        this.spec  = spec;
    }

    public String getId()    { return id; }
    public String getBrand() { return brand; }
    public int    getSpec()  { return spec; }

    public abstract String interpretSpec();
    public abstract String getType();

    @Override
    public String toString() {
        return String.format("%-3s  %-16s  %-10s  %-4d  %s",
                id, brand, getType(), spec, interpretSpec());
    }
}
