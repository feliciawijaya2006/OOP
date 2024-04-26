public class Dosen_staff {
    private String NIK;
    private String nama;
    private Fakultas fakultas;
    private Prodi prodi;
    private String alamat;
    private String noHp;
    private boolean pDenda;
    private int totalDenda;

    public Dosen_staff() {
    }

    public Dosen_staff(String NIK, String nama, Fakultas fakultas, Prodi prodi,String alamat, String noHp, boolean pDenda, int totalDenda) {
        this.NIK = NIK;
        this.nama = nama;
        this.fakultas = fakultas;
        this.prodi = prodi;
        this.alamat = alamat;
        this.noHp = noHp;
        this.pDenda = pDenda;
        this.totalDenda = totalDenda;

    }

    public void inputData() {
        NIK = Main.getInput("Masukkan NIK: ", false);
        nama = Main.getInput("Masukkan Nama: ", false);
        fakultas = getFakultas1();
        prodi = getProdi1();
        alamat = Main.getInput("Masukkan Alamat: ", false);
        noHp = Main.getInput("Masukkan No HP: ", true);

    }
    // Getter dan setter untuk setiap atribut
    public String getNIK() {
        return NIK;
    }

    public void setNIK(String NIK) {
        this.NIK = NIK;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Fakultas getFakultas() {
        return this.fakultas;
    }

    Prodi getProdi1() {
        System.out.println("Pilih Prodi: ");
        for (Prodi prodi : Prodi.values()) {
            System.out.println((prodi.ordinal() + 1) + ". " + prodi);
        }
        int choice = Main.getChoice(Prodi.values().length);
        return Prodi.values()[choice - 1];
    }


    Fakultas getFakultas1() {
        System.out.println("Pilih Fakultas: ");
        for (Fakultas fakultas : Fakultas.values()) {
            System.out.println((fakultas.ordinal() + 1) + ". " + fakultas);
        }
        int choice = Main.getChoice(Fakultas.values().length);
        return Fakultas.values()[choice - 1];
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }
}

enum Prodi {
    MAN,
    VCD,
    IMT
}

enum Fakultas {
    IMT,
    VCD,
    MAN,
    STAFF
}