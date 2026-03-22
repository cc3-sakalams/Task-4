public class Main {

    public static void main(String[] args) {

        HardwareRepository repo = new HardwareRepository();

        for(Hardware h : repo.getAllHardware()) {
            System.out.println(h);
        }

    }

}