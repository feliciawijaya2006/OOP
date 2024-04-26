public class Detail_pembayaran {
    private Pengembalian nmrPengembalian;
    private int jumlah;
    private int jumlah_denda;
    private JenisDenda Denda;
    private Buku IDBuku;
    private CD IDCD;

    public Detail_pembayaran() {
    }

    public Detail_pembayaran(Pengembalian nmrPengembalian, int jumlah, int jumlah_denda, JenisDenda Denda, Buku IDBuku, CD IDCD) {
        this.nmrPengembalian = nmrPengembalian;
        this.jumlah = jumlah;
        this.jumlah_denda = jumlah_denda;
        this.Denda = Denda;
        this.IDBuku = IDBuku;
        this.IDCD = IDCD;
    }

    public void inputData(Pengembalian nmrPengembalian, Buku IDBuku, CD IDCD) {
        this.nmrPengembalian = nmrPengembalian;
        jumlah = Main.getInputInt("Masukkan jumlah bayar: ");
        Denda = getJenisDenda1();
        this.IDBuku = IDBuku;
        this.IDCD = IDCD;
    }

    JenisDenda getJenisDenda1() {
        System.out.println("Rusak/Tidak ? : ");
        for (JenisDenda Denda : Denda.values()) {
            System.out.println((Denda.ordinal() + 1) + ". " + Denda);
        }
        int choice = Main.getChoice(Denda.values().length);
        return Denda.values()[choice - 1];
    }


}
enum JenisDenda {
    Rusak,
    Hilang,
    Terlambat
}

