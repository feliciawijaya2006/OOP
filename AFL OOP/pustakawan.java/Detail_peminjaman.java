import java.time.LocalDate;
import java.util.ArrayList;

public class Detail_peminjaman {
    private Peminjaman noPinjam;
    private String idPustakawan;
    private String dueDate;
    private Buku IDBuku;
    private CD idCd;
    private String tglPinjam;

    public Detail_peminjaman() {
    }

    public Detail_peminjaman(Peminjaman noPinjam, String idPustakawan, String dueDate, Buku IDBuku, CD idCd, String tglPinjam) {
        this.noPinjam = noPinjam;
        this.idPustakawan = idPustakawan;
        this.dueDate = dueDate;
        this.IDBuku = IDBuku;
        this.idCd = idCd;
        this.tglPinjam = tglPinjam;
    }

    public void inputData(ArrayList<Peminjaman> listPinjam, ArrayList<Buku> bukuList,
            ArrayList<CD> listCD) {

        System.out.println("Daftar Peminjaman:");
        for (int i = 0; i < listPinjam.size(); i++) {
            System.out.println((i + 1) + ". " + listPinjam.get(i).getNoPinjam());
        }

        int choice = Main.getChoice(listPinjam.size());
        noPinjam = listPinjam.get(choice - 1);

        dueDate = String.valueOf(LocalDate.parse(noPinjam.getTglPinjam()).plusWeeks(2));
        System.out.println("Tanggal Harus Kembali: " + dueDate);

        Pilihan pilihan = getPilihan();
        if (pilihan == Pilihan.Buku) {
            System.out.println("Daftar Buku:");
            for (int i = 0; i < bukuList.size(); i++) {
                System.out.println((i + 1) + ". " + bukuList.get(i).getIdBuku() + " - "
                        + bukuList.get(i).getJudulBuku());
            }

            choice = Main.getChoice(bukuList.size());
            IDBuku = bukuList.get(choice - 1);
        } else if (pilihan == Pilihan.CD) {
            System.out.println("Daftar CD:");
            for (int i = 0; i < listCD.size(); i++) {
                System.out.println((i + 1) + ". " + listCD.get(i).getIdCd() + " - "
                        + listCD.get(i).getJudulCd());
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

    public Peminjaman getNoPinjam() {
        return noPinjam;
    }

    public void setNoPinjam(Peminjaman noPinjam) {
        this.noPinjam = noPinjam;
    }

    public String getIdPustakawan() {
        return idPustakawan;
    }

    public String getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setIdPustakawan(String idPustakawan) {
        this.idPustakawan = idPustakawan;
    }

    public Buku getIDBuku() {
        return this.IDBuku;
    }

    public void setIDBuku(Buku IDBuku) {
        this.IDBuku = IDBuku;
    }
    

    public String getTglPinjam() {
        return tglPinjam;
    }

    public void setTglPinjam(String tglPinjam) {
        this.tglPinjam = tglPinjam;
    }
    public CD getIdCd() {
        return this.idCd;
    }

    public void setIdCd(CD idCd) {
        this.idCd = idCd;
    }

}

enum Pilihan {
    Buku,
    CD
}

