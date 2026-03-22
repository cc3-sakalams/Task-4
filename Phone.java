public class Phone extends Hardware {

    public Phone(String id, String brand, int spec) {
        super(id, brand, spec, "Phone");
    }

    @Override
    public String getSpecDescription() {

        if(getSpecRaw() == 16) {
            return "16 Megapixels";
        }
        else if(getSpecRaw() == 48) {
            return "48 Megapixels";
        }
        else if(getSpecRaw() == 50) {
            return "50 Megapixels";
        }
        else {
            return getSpecRaw() + " Megapixels";
        }

    }
}