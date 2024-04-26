import java.util.ArrayList;

public class Peminjaman {
    private String noPinjam;
    private Pustakawan idPustakawan;
    private String tglPinjam;

    public Peminjaman() {
    }

    public Peminjaman(String noPinjam, Pustakawan idPustakawan, String tglPinjam) {
        this.noPinjam = noPinjam;
        this.idPustakawan = idPustakawan;
        this.tglPinjam = tglPinjam;
    }

    public void inputData(ArrayList<Pustakawan> pustakawanList, ArrayList<Mahasiswa> mhsList,
            ArrayList<Dosen_staff> dosenList) {
        noPinjam = Main.getInput("Masukkan No Pinjam: ", false);
        tglPinjam = Main.TimeNow();
        System.out.println("Masukkan Tanggal Pinjam: " + tglPinjam);

        System.out.println("Daftar Pustakawan:");
        for (int i = 0; i < pustakawanList.size(); i++) {
            System.out.println((i + 1) + ". " + pustakawanList.get(i).getIdPustakawan() + " - "
                    + pustakawanList.get(i).getNama());
        }

        int choice = Main.getChoice(pustakawanList.size());
        idPustakawan = pustakawanList.get(choice - 1);
    }

    public String getNoPinjam() {
        return noPinjam;
    }

    public void setNoPinjam(String noPinjam) {
        this.noPinjam = noPinjam;
    }

    public Pustakawan getIdPustakawan() {
        return idPustakawan;
    }

    public void setIdPustakawan(Pustakawan idPustakawan) {
        this.idPustakawan = idPustakawan;
    }

    public String getTglPinjam() {
        return tglPinjam;
    }

    public void setTglPinjam(String tglPinjam) {
        this.tglPinjam = tglPinjam;
    }
}
