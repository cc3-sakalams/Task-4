package HardwareSystem;

public class Laptop extends Hardware {
    public Laptop(String id, String brand, int spec) { super(id, brand, spec); }

    @Override public String interpretSpec() { return getSpec() + "GB RAM"; }
    @Override public String getType()       { return "Laptop"; }
}
