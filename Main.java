package hardware;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        HardwareRepository repo = new HardwareRepository();
        List<Hardware> hardware = repo.getAllHardware();

        // ── Hardware Masterlist ──────────────────────────────
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║          HARDWARE MASTERLIST                 ║");
        System.out.println("╚══════════════════════════════════════════════╝");
        System.out.printf("%-3s  %-16s  %-4s  %s%n", "ID", "Brand", "Spec", "Interpretation");
        System.out.println("─".repeat(48));

        for (Hardware h : hardware) {
            System.out.println(h);
        }

        // ── Polymorphic Audit (instanceof + single loop) ─────
        int laptops16GB = 0;
        int laptops32GB = 0;
        int phones50MP  = 0;

        for (Hardware h : hardware) {
            if (h instanceof Laptop && h.getSpec() == 16) laptops16GB++;
            if (h instanceof Laptop && h.getSpec() == 32) laptops32GB++;
            if (h instanceof Phone  && h.getSpec() == 50) phones50MP++;
        }

        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║        LAPTOP AND PHONE INVENTORY            ║");
        System.out.println("╚══════════════════════════════════════════════╝");
        System.out.println("Total 16GB Laptops : " + laptops16GB);
        System.out.println("Total 32GB Laptops : " + laptops32GB);
        System.out.println("Total 50MP Phones  : " + phones50MP);
    }
}
```

---

### Expected Output
```
╔══════════════════════════════════════════════╗
║          HARDWARE MASTERLIST                 ║
╚══════════════════════════════════════════════╝
ID   Brand             Spec  Interpretation
────────────────────────────────────────────────
1    Dell XPS 13       16    16GB RAM
2    Samsung S24       50    50 Megapixels
3    MacBook Pro       32    32GB RAM
4    iPhone 15         48    48 Megapixels
5    ASUS Zenbook      16    16GB RAM
6    Google Pixel 8    50    50 Megapixels
7    Lenovo Legion     32    32GB RAM
8    Huawei P60        48    48 Megapixels
9    HP Spectre        16    16GB RAM
10   Sony Xperia       16    16 Megapixels

╔══════════════════════════════════════════════╗
║        LAPTOP AND PHONE INVENTORY            ║
╚══════════════════════════════════════════════╝
Total 16GB Laptops : 3
Total 32GB Laptops : 2
Total 50MP Phones  : 2