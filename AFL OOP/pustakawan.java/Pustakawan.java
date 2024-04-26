public class Pustakawan {
    private String idPustakawan;
    private String nama;
    private String hp;
    private String username;
    private String password;

    public Pustakawan() {

    }

    public Pustakawan(String idPustakawan, String nama, String hp, String username, String password) {
        this.idPustakawan = idPustakawan;
        this.nama = nama;
        this.hp = hp;
        this.username = username;
        this.password = password;
    }

    public void displayDetails() {
        System.out.println("===== Detail Pustakawan =====");
        System.out.println("NIM: " + idPustakawan);
        System.out.println("Nama: " + nama);
        System.out.println("No Hp: " + hp);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }

    public void inputData(String kodepustakawan) {
        idPustakawan = kodepustakawan;
        nama = Main.getInput("Masukkan Nama:", false);
        hp = Main.getInput("Masukkan No HP:", true);
        username = Main.getInput("Masukkan Username:", false);
        password = Main.getInput("Masukkan Password:", false);
    }

    // Getter dan setter untuk setiap atribut
    public String getIdPustakawan() {
        return idPustakawan;
    }

    public void setIdPustakawan(String idPustakawan) {
        this.idPustakawan = idPustakawan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

// Sisanya implementasinya serupa dengan yang di atas
