package lw01.prelab;

public class ColourPrint extends PrintJob {

    public ColourPrint(String id, int pages) {
        super(id, pages);
    }

    @Override
    public int calculateCharge() {

        int total = getPages();
        int harga = 0;

        if (total <= 10) {
            harga = total * 1500;
        } else {
            harga = (10 * 1500) + ((total - 10) * 1000);
        }

        return harga + 2000;
    }

    @Override
    public String label() {
        return "Colour";
    }

}
