import java.util.ArrayList;

public class Detail_pengembalian {
    private Pengembalian nmrPengembalian;
    private int jumlah;
    private Buku idBuku;
    private CD idCd;

    public Detail_pengembalian() {
    }

    public Detail_pengembalian(Pengembalian nmrPengembalian, int jumlah, Buku idBuku, CD idCd) {
        this.nmrPengembalian = nmrPengembalian;
        this.jumlah = jumlah;
        this.idBuku = idBuku;
        this.idCd = idCd;
    }

    public void inputData(Pengembalian nmrPengembalian, Buku idBuku) {

        this.nmrPengembalian = nmrPengembalian;
        jumlah = Main.getInputInt("Masukkan jumlah pengembalian: ");
        this.idBuku = idBuku;

    }

    public void inputData(Pengembalian nmrPengembalian, CD idCd) {

        this.nmrPengembalian = nmrPengembalian;
        jumlah = Main.getInputInt("Masukkan jumlah pengembalian: ");
        this.idCd = idCd;
    }

    public void inputData(Pengembalian noPengembalian, ArrayList<Buku> bukuList, ArrayList<CD> listCD) {
        this.nmrPengembalian = noPengembalian;

        int choice;
        System.out.println("Pilih jenis koleksi yang ingin anda pinjam: ");
        Pilihan pilihan = getPilihan();
        if (pilihan == Pilihan.Buku) {
            System.out.println("Daftar Buku:");
            for (int i = 0; i < bukuList.size(); i++) {
                System.out.println((i + 1) + ". " + bukuList.get(i).getIdBuku() + " - "
                        + bukuList.get(i).getJudulBuku());
            }

            choice = Main.getChoice(bukuList.size());
            idBuku = bukuList.get(choice - 1);

        } else if (pilihan == Pilihan.CD) {
            System.out.println("Daftar CD:");
            for (int i = 0; i < listCD.size(); i++) {
                System.out.println((i + 1) + ". " + listCD.get(i).getIdCd() + " - "
                        + listCD.get(i).getIdCd());
            }

            choice = Main.getChoice(listCD.size());
            idCd = listCD.get(choice - 1);
        }
    }

    Pilihan getPilihan() {
        System.out.println("Pilih: ");
        for (Pilihan pilihan : Pilihan.values()) {
            System.out.println((pilihan.ordinal() + 1) + ". " + pilihan);
        }
        int choice = Main.getChoice(Pilihan.values().length);
        return Pilihan.values()[choice - 1];
    }

    public Pengembalian getNmrPengembalian() {
        return this.nmrPengembalian;
    }

    public void setNmrPengembalian(Pengembalian nmrPengembalian) {
        this.nmrPengembalian = nmrPengembalian;
    }

    public int getJumlah() {
        return this.jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public Buku getIdBuku() {
        return this.idBuku;
    }

    public void setIdBuku(Buku idBuku) {
        this.idBuku = idBuku;
    }

    public CD getIdCd() {
        return this.idCd;
    }

    public void setIdCd(CD idCd) {
        this.idCd = idCd;
    }

    

}