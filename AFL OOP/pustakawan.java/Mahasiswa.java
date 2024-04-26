public class Mahasiswa {
    private String NIM;
    private String nama;
    private Fakultas fakultas;
    private String alamat;
    private String noHp;

    public Mahasiswa() {
    }

    public Mahasiswa(String NIM, String nama, Fakultas fakultas, String alamat, String noHp) {
        this.NIM = NIM;
        this.nama = nama;
        this.fakultas = fakultas;
        this.alamat = alamat;
        this.noHp = noHp;
    }

    public void displayDetails() {
        System.out.println("===== Detail Mahasiswa =====");
        System.out.println("NIM: " + NIM);
        System.out.println("Nama: " + nama);
        System.out.println("Fakultas: " + fakultas);
        System.out.println("Alamat: " + alamat);
        System.out.println("No Hp: " + noHp);
    }

    public void inputData() {
        NIM = Main.getInput("Masukkan NIM: ", false);
        nama = Main.getInput("Masukkan Nama: ", false);
        fakultas = getFakultas1();
        alamat = Main.getInput("Masukkan Alamat: ", false);
        noHp = Main.getInput("Masukkan No HP: ", true);
    }

    Fakultas getFakultas1() {
        System.out.println("Pilih Fakultas:");
        for (Fakultas fakultas : Fakultas.values()) {
            System.out.println((fakultas.ordinal() + 1) + ". " + fakultas);
        }
        int choice = Main.getChoice(Fakultas.values().length);
        return Fakultas.values()[choice - 1];
    }

    // Getter dan setter untuk setiap atribut
    public String getNIM() {
        return NIM;
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Fakultas getFakultas() {
        return fakultas;
    }

    public void setFakultas(Fakultas fakultas) {
        this.fakultas = fakultas;
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

enum Fakultas {
    IMT,
    VCD,
    MAN
}