public class Buku {
    private String idBuku;
    private String judul;
    private String idPengarang;
    private String idPenerbit;
    private String tahunTerbit;
    private String edisiBuku;
    private Cover jenisSampul;
    private String kodeKategori;
    private GenreChoice Genre;

    public Buku() {
    }

    public Buku(String idBuku, String judul, String idPengarang, String idPenerbit, String tahunTerbit, String edisiBuku, Cover jenisSampul, String kodeKategori){
        this.idBuku = idBuku;
        this.judul = judul;
        this.idPengarang = idPengarang;
        this.idPenerbit = idPenerbit;
        this.tahunTerbit = tahunTerbit;
        this.edisiBuku = edisiBuku;
        this.jenisSampul = jenisSampul;

    }

    public void inputData(String idbuku) {
        idBuku = idbuku;
        judul = Main.getInput("Masukkan Judul Buku: ", false);
        idPengarang = Main.getInput("Masukkan Pengarang: ", false);
        idPenerbit = Main.getInput("Masukkan Penerbit: ", false);
        tahunTerbit = Main.getInputDate("Masukkan tahun terbit: ");
        edisiBuku = Main.getInput("Masukkan Edisi Terbit:", false);
        jenisSampul = getCover1();
        Genre = getGenre1();
    }

    Cover getCover1() {
        System.out.println("Pilih Cover:");
        for (Cover cover : Cover.values()) {
            System.out.println((cover.ordinal() + 1) + ". " + cover);
        }
        int choice = Main.getChoice(Cover.values().length);
        return Cover.values()[choice - 1];
    }

    GenreChoice getGenre1() {
        System.out.println("Pilih Genre:");
        for (GenreChoice genre : GenreChoice.values()) {
            System.out.println((genre.ordinal() + 1) + ". " + genre);
        }
        int choice = Main.getChoice(GenreChoice.values().length);
        return GenreChoice.values()[choice - 1];
    }

    public GenreChoice getGenre() {
        return this.Genre;
    }

    public Cover getCover() {
        return this.jenisSampul;
    }

    public String getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(String idBuku) {
        this.idBuku = idBuku;
    }

    public String getJudulBuku() {
        return judul;
    }

    public void setJudulBuku(String judul) {
        this.judul = judul;
    }

    public String getIdPengarang() {
        return idPengarang;
    }

    public void setIdPengarang(String idPengarang) {
        this.idPengarang = idPengarang;
    }

    public String getIdPenerbit() {
        return idPenerbit;
    }

    public void setIdPenerbit(String idPenerbit) {
        this.idPenerbit = idPenerbit;
    }

    public String getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(String tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    public String getEdisiBuku() {
        return edisiBuku;
    }

    public void setEdisiBuku(String edisiBuku) {
        this.edisiBuku = edisiBuku;
    }

    public Cover getJenisSampul() {
        return jenisSampul;
    }

    public void setJenisSampul(Cover jenisSampul) {
        this.jenisSampul = jenisSampul;
    }

    public String getKodeKategori() {
        return kodeKategori;
    }

    public void setKodeKategori(String kodeKategori) {
        this.kodeKategori = kodeKategori;
    }

    enum Cover {
        Hardcover,
        Softcover
    }
    
    enum GenreChoice {
        Horor,
        Komedi,
        Romansa,
        Aksi,
        SciFi,
        Edukasi
    }

    public void inputData() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inputData'");
    }
}

