public class CD {
    private String idCd;
    private String judul;
    private GenreChoice Genre;
    private String kategoriCd;
    private String tahunPublikasi;
    private String idBuku;

    public CD() {
    }

    public CD(String idCd, String judul, GenreChoice kategori, String kategoriCd, String tahunPublikasi, String idBuku) {
        this.idCd = idCd;
        this.judul = judul;
        this.Genre = kategori;
        this.kategoriCd = kategoriCd;
        this.tahunPublikasi = tahunPublikasi;
        this.idBuku = idBuku;
    }

    public void inputData(String kodecd) {
        idCd = kodecd;
        judul = Main.getInput("Masukkan Judul CD:", false);
        Genre = getGenre1();
        kategoriCd = Main.getInput("Masukkan Kategori CD:", false);
        tahunPublikasi = Main.getInputDate("Masukkan Tahun Publikasi:");
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

    // Getter dan setter untuk setiap atribut
    public String getIdCd() {
        return idCd;
    }

    public void setIdCd(String idCd) {
        this.idCd = idCd;
    }

    public String getJudulCd() {
        return judul;
    }

    public void setJudulCd(String judul) {
        this.judul = judul;
    }

    public String getKategoriCd() {
        return kategoriCd;
    }

    public void setKategoriCd(String kategoriCd) {
        this.kategoriCd = kategoriCd;
    }

    public String getTahunPublikasi() {
        return tahunPublikasi;
    }

    public void setTahunPublikasi(String tahunPublikasi) {
        this.tahunPublikasi = tahunPublikasi;
    }

    public String getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(String idBuku) {
        this.idBuku = idBuku;
    }
}
enum GenreChoice {
    Horor,
    Komedi,
    Romansa,
    Aksi,
    SciFi,
    Edukasi
}