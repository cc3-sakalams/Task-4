import java.util.ArrayList;
import java.util.List;

public class HardwareRepository {

    private List<Hardware> inventory;

    public HardwareRepository() {

        inventory = new ArrayList<>();

        // Hard-coded inventory
        inventory.add(new Laptop("L001", "Dell", 16));
        inventory.add(new Laptop("L002", "Asus", 32));
        inventory.add(new Phone("P001", "Samsung", 48));
        inventory.add(new Phone("P002", "Xiaomi", 50));

    }

    public List<Hardware> getAllHardware() {
        return inventory;
    }

}