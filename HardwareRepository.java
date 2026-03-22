package hardware;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HardwareRepository {

    private final List<Hardware> inventory = new ArrayList<>();

    public HardwareRepository() {
        inventory.add(new Laptop("1",  "Dell XPS 13",    16));
        inventory.add(new Phone ("2",  "Samsung S24",    50));
        inventory.add(new Laptop("3",  "MacBook Pro",    32));
        inventory.add(new Phone ("4",  "iPhone 15",      48));
        inventory.add(new Laptop("5",  "ASUS Zenbook",   16));
        inventory.add(new Phone ("6",  "Google Pixel 8", 50));
        inventory.add(new Laptop("7",  "Lenovo Legion",  32));
        inventory.add(new Phone ("8",  "Huawei P60",     48));
        inventory.add(new Laptop("9",  "HP Spectre",     16));
        inventory.add(new Phone ("10", "Sony Xperia",    16));
    }

    public List<Hardware> getAllHardware() {
        return new ArrayList<>(inventory);
    }

    public int countByTypeAndSpec(String type, int spec) {
        return (int) inventory.stream()
                .filter(h -> h.getType().equalsIgnoreCase(type)
                          && h.getSpec() == spec)
                .count();
    }

    public void addFromInput(Scanner sc) {
        System.out.print("ID    : "); 
        String id    = sc.nextLine().trim();
        
        System.out.print("Brand : "); 
        String brand = sc.nextLine().trim();
        
        int spec = readPositiveInt(sc);
        String type = readType(sc);

        Hardware item = switch (type) {
            case "Laptop" -> new Laptop(id, brand, spec);
            case "Phone"  -> new Phone (id, brand, spec);
            default       -> null;
        };

        if (item != null) {
            inventory.add(item);
            System.out.println("✔ Added: " + item);
        } else {
            System.out.println("✘ Invalid type — item not added.");
        }
    }

    private int readPositiveInt(Scanner sc) {
        while (true) {
            System.out.print("Spec  : ");
            try {
                int v = Integer.parseInt(sc.nextLine().trim());
                if (v > 0) return v;
                System.out.println("  → Must be a positive number.");
            } catch (NumberFormatException e) {
                System.out.println("  → Invalid number format.");
            }
        }
    }

    private String readType(Scanner sc) {
        while (true) {
            System.out.print("Type (Laptop / Phone): ");
            String input = sc.nextLine().trim();
            if (input.equalsIgnoreCase("Laptop")) return "Laptop";
            if (input.equalsIgnoreCase("Phone"))  return "Phone";
            System.out.println("  → Please enter 'Laptop' or 'Phone'.");
        }
    }
}