import java.time.LocalDate;
import java.util.ArrayList;

public class Pengembalian {
    private String nmrPengembalian;
    private Peminjaman noPinjam;
    private int totalDendaRusak;
    private LocalDate tglKembali;
    private int totalTelat;
    private int totalBayar;
    private Pustakawan idPustakawan;

    public Pengembalian() {
    }

    public Pengembalian(String nmrPengembalian, Peminjaman noPinjam, int totalDendaRusak, LocalDate tglKembali,
            int totalTelat, int totalBayar, Pustakawan idPustakawan) {
       this.nmrPengembalian = nmrPengembalian;
        this.noPinjam = noPinjam;
        this.totalDendaRusak = totalDendaRusak;
        this.tglKembali = tglKembali;
        this.totalTelat = totalTelat;
        this.totalBayar = totalBayar;
        this.idPustakawan = idPustakawan;
    }

    public void inputData(ArrayList<Peminjaman> listPinjam, ArrayList<Mahasiswa> mhsList,
            ArrayList<Dosen_staff> dosenList, ArrayList<Pustakawan> pustakawanList) {

        System.out.println("Daftar Peminjaman:");
        for (int i = 0; i < listPinjam.size(); i++) {
            System.out.println((i + 1) + ". " + listPinjam.get(i).getNoPinjam());
        }

        int choice = Main.getChoice(listPinjam.size());
        noPinjam = listPinjam.get(choice - 1);

        System.out.println("Daftar Pustakawan:");
        for (int i = 0; i < pustakawanList.size(); i++) {
            System.out.println((i + 1) + ". " + pustakawanList.get(i).getIdPustakawan() + " - "
                    + pustakawanList.get(i).getNama());
        }

        choice = Main.getChoice(pustakawanList.size());
        idPustakawan = pustakawanList.get(choice - 1);
    }

    // Getter dan setter untuk setiap atribut
    public String getNmrPengembalian() {
        return this.nmrPengembalian;
    }

    public void setNmrPengembalian(String nmrPengembalian) {
        this.nmrPengembalian = nmrPengembalian;
    }

    public Peminjaman getNoPinjam() {
        return this.noPinjam;
    }

    public void setNoPinjam(Peminjaman noPinjam) {
        this.noPinjam = noPinjam;
    }

    public Pustakawan getIdPustakawan() {
        return this.idPustakawan;
    }

    public void setIdPustakawan(Pustakawan idPustakawan) {
        this.idPustakawan = idPustakawan;
    }

    public LocalDate getTglKembali() {
        return this.tglKembali;
    }

    public void setTglKembali(LocalDate tglKembali) {
        this.tglKembali = tglKembali;
    }

    public int getTotalDendaRusak() {
        return this.totalDendaRusak;
    }

    public void setTotalDendaRusak(int totalDendaRusak) {
        this.totalDendaRusak = totalDendaRusak;
    }

    public int getTotalTelat() {
        return this.totalTelat;
    }

    public void setTotalTelat(int totalTelat) {
        this.totalTelat = totalTelat;
    }

    public int getTotalBayar() {
        return this.totalBayar;
    }

    public void setTotalBayar(int totalBayar) {
        this.totalBayar = totalBayar;
    }
}
