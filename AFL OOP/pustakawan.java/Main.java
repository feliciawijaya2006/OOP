import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    private static Map<String, String> credentials = new HashMap<>();
    static {
        // Simpan kredensial untuk masing-masing tipe pengguna
        credentials.put("dosen", "dosen123");
        credentials.put("mahasiswa", "mahasiswa123");
        credentials.put("pustakawan", "pustakawan123");
    }
    private static ArrayList<Mahasiswa> usermhs = new ArrayList<>();
    private static ArrayList<Dosen_staff> userdosen = new ArrayList<>();
    private static ArrayList<Pustakawan> listpustakawan = new ArrayList<>();
    private static ArrayList<CD> listcd = new ArrayList<>();
    private static ArrayList<Buku> daftarBuku = new ArrayList<>();
    private static ArrayList<Detail_pembayaran> detailpembayaran = new ArrayList<>();
    private static ArrayList<Detail_peminjaman> detailpeminjaman = new ArrayList<>();
    private static ArrayList<Detail_pengembalian> fakultas = new ArrayList<>();
    private static ArrayList<Peminjaman> peminjaman = new ArrayList<>();
    private static ArrayList<Pengembalian> pengembalian = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static String TimeNow() {
        LocalDate tanggalPinjam = LocalDate.now();
        return String.valueOf(tanggalPinjam);
    }


    public static void main(String[] args) {
        login();

        // Jika login berhasil, lanjutkan dengan menampilkan menu
        if (isLoggedin()) {
            showMenu();
        } else {
            System.out.println("Login gagal. Program berakhir.");
        }

    }

    // Fungsi untuk login
    public static void login() {
        System.out.println("Selamat datang! Silakan login untuk melanjutkan.");
        System.out.println("Pilih jenis pengguna:");
        System.out.println("1. Dosen Staff");
        System.out.println("2. Mahasiswa");
        System.out.println("3. Pustakawan");
        System.out.print("Pilihan Anda: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Membuang newline character

        // Memeriksa pilihan pengguna dan mendapatkan username
        String userType = "";
        switch (choice) {
            case 1:
                userType = "dosen";
                break;
            case 2:
                userType = "mahasiswa";
                break;
            case 3:
                userType = "pustakawan";
                break;
            default:
                System.out.println("Pilihan tidak valid. Program berakhir.");
                System.exit(0);
        }

        // Meminta pengguna untuk login
        System.out.print("Username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Password: ");
        String inputPassword = scanner.nextLine();

        // Memeriksa apakah username dan password sesuai
        if (credentials.containsKey(userType) && inputPassword.equals(credentials.get(userType))) {
            System.out.println("Login berhasil!");
        } else {
            System.out.println("Username atau password salah. Silakan coba lagi.");
            login();
        }
    }

    // Fungsi untuk memeriksa apakah pengguna sudah login
    public static boolean isLoggedin() {
        System.out.print("Apakah Anda sudah login? (Y/N)");
        String input = scanner.nextLine();
        return input.equalsIgnoreCase("Y");
    }

    // Menampilkan menu
    public static void showMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Data Buku");
            System.out.println("2. Tampilkan Data Buku");
            System.out.println("3. Tambah Data CD");
            System.out.println("4. Tampilkan Data CD");
            System.out.println("3. Tambah Detail Pembayaran");
            System.out.println("4. Tampilkan Detail Pembayaran");
            System.out.println("5. Keluar");
            System.out.print("Pilihan Anda: ");
            int menuChoice = scanner.nextInt();
            scanner.nextLine(); // Membuang newline character

            switch (menuChoice) {
                case 1:
                    tambahBuku();
                    break;
                case 2:
                    tampilkanDataBuku(daftarBuku);
                    break;
                case 3:
                    tambahCD();
                    break;
                case 4:
                    tampilkanDataCD(listcd);
                    break;
                case 5:
                    tambahdetailpembayaran();
                    break;
                case 6:
                    tampilkandetailpembayaran(detailpembayaran);
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    

public static void tambahBuku() {
    System.out.print("Masukkan jumlah buku yang ingin ditambahkan:");
    int jumlahBuku = scanner.nextInt();
    scanner.nextLine(); // Membersihkan newline

    for (int i = 0; i < jumlahBuku; i++) {
         Buku buku = new Buku();
         System.out.println("Masukkan data untuk buku ke-" + (i + 1) + ":");
         buku.inputData(String.valueOf(i + 1)); // ID buku diisi dengan nomor urut
         daftarBuku.add(buku);
         System.out.print("Data buku berhasil ditambahkan!");
     }
}

// public static void tampilkanDataBuku() {
//     System.out.println("Daftar Buku:");
//     for (Buku buku : daftarBuku) {
//         System.out.print("ID Buku: " + buku.getIdBuku());
//         System.out.print("Judul Buku: " + buku.getJudulBuku());
//         System.out.print("Pengarang: " + buku.getIdPengarang());
//         System.out.print("Penerbit: " + buku.getIdPenerbit());
//         System.out.print("Tahun Terbit: " + buku.getTahunTerbit());
//         System.out.print("Edisi Buku: " + buku.getEdisiBuku());
//         System.out.print("Jenis Sampul: " + buku.getJenisSampul());
//         System.out.print("Kode Kategori: " + buku.getKodeKategori());
//         System.out.print("Genre: " + buku.getGenre());
//         System.out.print("--------------------------------------");
//     }
// }

// public static void tambahBuku(ArrayList<Buku> dataBuku) {
//     Buku buku = new Buku();
//     System.out.print("\nMasukkan data buku:");
//     buku.inputData();
//     dataBuku.add(buku);
//     System.out.print("Data buku berhasil ditambahkan!");
// }

public static void tampilkanDataBuku(ArrayList<Buku> dataBuku) {
    if (dataBuku.isEmpty()) {
        System.out.println("Belum ada data buku.");
    } else {
        System.out.println("\nData Buku:");
        for (Buku buku : dataBuku) {
            System.out.println("ID Buku: " + buku.getIdBuku());
                System.out.println("Judul Buku: " + buku.getJudulBuku());
                System.out.println("Pengarang: " + buku.getIdPengarang());
                System.out.println("Penerbit: " + buku.getIdPenerbit());
                System.out.println("Tahun Terbit: " + buku.getTahunTerbit());
                System.out.println("Edisi Buku: " + buku.getEdisiBuku());
                System.out.println("Jenis Sampul: " + buku.getJenisSampul());
                System.out.println("Kode Kategori: " + buku.getKodeKategori());
                System.out.println("Genre: " + buku.getGenre());
                System.out.println("--------------------------------------");
        }
    }
}

public static void tambahCD() {
    System.out.print("Masukkan jumlah CD yang ingin ditambahkan:");
    int jumlahCD = scanner.nextInt();
    scanner.nextLine(); // Membersihkan newline

    for (int i = 0; i < jumlahCD; i++) {
        CD cd = new CD();
        System.out.println("Masukkan data untuk buku ke-" + (i + 1) + ":");
        cd.inputData(String.valueOf(i + 1)); // ID buku diisi dengan nomor urut
        listcd.add(cd);
        System.out.print("Data buku berhasil ditambahkan!");
    }
}

public static void tampilkanDataCD(ArrayList<CD> listcd) {
    if (listcd.isEmpty()) {
        System.out.println("Belum ada data cd.");
    } else {
        System.out.println("\nData CD:");
        for (CD cd : listcd) {
                System.out.println("ID CD: " + cd.getIdCd());
                System.out.println("Judul CD: " + cd.getJudulCd());
                System.out.println("Genre: " + cd.getGenre1());
                System.out.println("Kategori CD: " + cd.getKategoriCd());
                System.out.println("Tahun Publikasi: " + cd.getTahunPublikasi());
                System.out.println("--------------------------------------");
        }
    }
}

// Menambahkan detail pembayaran
public static void tambahDetailPembayaran() {
    System.out.println("\nTambah Detail Pembayaran:");

    // Memasukkan data pembayaran
    Pengembalian nmrPengembalian = inputPengembalian();
    Buku idBuku = inputBuku();
    CD idCd = inputCD();
    int jumlah = getInputInt("Masukkan jumlah bayar: ");
    int jumlah_denda = getInputInt("Masukkan jumlah denda: ");
    JenisDenda jenisDenda = getJenisDenda();

    // Membuat objek detail pembayaran dan menambahkannya ke dalam list
    Detail_pembayaran detailPembayaran = new Detail_pembayaran(nmrPengembalian, jumlah, jumlah_denda, jenisDenda, idBuku, idCd);
    detailpembayaran.add(detailPembayaran);

    System.out.println("Detail pembayaran berhasil ditambahkan.");
}

// Menampilkan detail pembayaran
public static void tampilkanDetailPembayaran() {
    System.out.println("\nDetail Pembayaran:");
    if (detailpembayaran.isEmpty()) {
        System.out.println("Belum ada detail pembayaran.");
    } else {
        for (Detail_pembayaran detailPembayaran : detailpembayaran) {
            System.out.println("Nomor Pengembalian: " + detailPembayaran.getNmrPengembalian());
            System.out.println("Jumlah Bayar: " + detailPembayaran.getJumlah());
            System.out.println("Jumlah Denda: " + detailPembayaran.getJumlah_denda());
            System.out.println("Jenis Denda: " + detailPembayaran.getDenda());
            System.out.println("ID Buku: " + detailPembayaran.getIdBuku());
            System.out.println("ID CD: " + detailPembayaran.getIdCd());
            System.out.println("-------------------------");
        }
    }
}

// Memasukkan data pengembalian
public static Pengembalian inputPengembalian() {
    // Mengambil input nomor pengembalian
    System.out.print("Masukkan Nomor Pengembalian: ");
    String nomorPengembalian = scanner.nextLine();
    return new Pengembalian(nomorPengembalian);
}

// Memasukkan data buku
public static Buku inputBuku() {
    // Mengambil input ID buku
    System.out.print("Masukkan ID Buku: ");
    String idBuku = scanner.nextLine();
    return new Buku(idBuku);
}

// Memasukkan data CD
public static CD inputCD() {
    // Mengambil input ID CD
    System.out.print("Masukkan ID CD: ");
    String idCd = scanner.nextLine();
    return new CD(idCd);
}

// Memilih jenis denda
public static JenisDenda getJenisDenda() {
    System.out.println("\nPilih Jenis Denda:");
    for (JenisDenda denda : JenisDenda.values()) {
        System.out.println((denda.ordinal() + 1) + ". " + denda);
    }
    int choice = getInputInt("Pilihan: ");
    return JenisDenda.values()[choice - 1];
}

    //  public static String getInput(String message, boolean notelp) {
    //      Scanner scanner = new Scanner(System.in);
    //      try {
           
    //          System.out.print(message);
    //          String input = scanner.nextLine().trim();

    //          if (notelp != true) {
    //              if (input.matches("\\d+")) {
    //                  throw new IllegalArgumentException("Input tidak boleh hanya berisi angka.");
    //             }
    //         } else {
    //             if (!Pattern.matches("[\\p{Alnum}]+", input)) {
    //                 System.out.println("Input mengandung simbol. Harap masukkan bilangan bulat.");
    //                 return getInput(message, notelp);
    //             }

    //             if (Pattern.matches(".*[a-zA-Z].*", input)) {
    //                 System.out.println("Input mengandung huruf alfabet. Harap masukkan bilangan bulat.");
    //                 return getInput(message, notelp);
    //             }
    //         }

    //         if (input.isEmpty()) {
    //             System.out.println("Input tidak boleh kosong. Silakan coba lagi.");
    //             return getInput(message, notelp);
    //         }
    //         scanner.close();
    //         return input;
    //     } catch (IllegalArgumentException ex) {
    //         System.out.println("Terjadi kesalahan: " + ex.getMessage());
    //         return getInput(message, notelp);
    //     } catch (Exception ex) {
    //         System.out.println("Terjadi kesalahan: " + ex.getMessage());
    //         return getInput(message, notelp);
    //     }
     
    // }

    public static String getInput(String message, boolean allowEmpty) {
        try {
            System.out.print(message);
    
            if (!scanner.hasNextLine()) {
                throw new NoSuchElementException("Tidak ada input yang tersedia.");
            }
    
            String input = scanner.nextLine().trim();
    
            if (!allowEmpty && input.isEmpty()) {
                throw new IllegalArgumentException("Input tidak boleh kosong.");
            }
    
            return input;
        } catch (NoSuchElementException | IllegalArgumentException ex) {
            System.out.println("Terjadi kesalahan: " + ex.getMessage());
            return getInput(message, allowEmpty);
        }
    }


    
                // if (notelp) {
                //     if (!Pattern.matches("[\\p{Alnum}]+", input)) {
                //         System.out.println("Input mengandung simbol. Harap masukkan bilangan bulat.");
                //         continue;
                //     }
    
                //     if (Pattern.matches(".*[a-zA-Z].*", input)) {
                //         System.out.println("Input mengandung huruf alfabet. Harap masukkan bilangan bulat.");
                //         continue;
                //     }
                // } else {
                //     if (!Pattern.matches("\\d+", input)) {
                //         System.out.println("Input tidak boleh hanya berisi angka.");
                //         continue;
                //     }
                // }

    

    public static String getInputDate(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message + " (Format: yyyy-MM-dd): ");
        String input = scanner.nextLine().trim();
    
        if (!isValidDateFormat(input)) {
            System.out.println("Format tanggal tidak valid. Silakan masukkan kembali.");
            return getInputDate(message);
        }
    
        return input;
    }
    
    private static boolean isValidDateFormat(String input) {
        try {
            LocalDate.parse(input);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
    
    public static int getInputInt(String message) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print(message);
            String inputStr = scanner.nextLine().trim(); // Menghapus spasi di awal dan akhir input
            if (inputStr.isEmpty()) {
                System.out.println("Input tidak boleh kosong. Silakan coba lagi.");
                return getInputInt(message);
            }

            if (inputStr.contains(".") || inputStr.contains(",")) {
                System.out.println("Input tidak valid. Harap masukkan bilangan bulat.");
                return getInputInt(message);
            }

            Integer input = Integer.parseInt(inputStr);

            if (input < 0) {
                System.out.println("Input tidak boleh kurang dari atau sama dengan 0. Silakan coba lagi.");
                return getInputInt(message);
            }
            return input;
        } catch (NumberFormatException ex) {
            System.out.println("Input tidak valid. Harap masukkan bilangan bulat.");
            return getInputInt(message);
        } catch (Exception ex) {
            System.out.println("Terjadi kesalahan: " + ex.getMessage());
            return getInputInt(message);
        }
    }
    

     public static float getInputFloat(String message) {
         Scanner scanner = new Scanner(System.in);
         try {
             System.out.print(message);
             String inputStr = scanner.nextLine().trim();
             if (inputStr.isEmpty()) {
                System.out.println("Input tidak boleh kosong. Silakan coba lagi.");
                 return getInputFloat(message);
             }

          if (inputStr.contains(",")) {
                 System.out.println("Simbol untuk bilangan desimal adalah '.', bukan ','");
                 return getInputFloat(message);
             }

             Float input = Float.parseFloat(inputStr);

             if (input <= 0) {
                 System.out.println("Input tidak boleh kurang dari atau sama dengan 0. Silakan coba lagi.");
                 return getInputFloat(message);
             }
            scanner.close();
            return input;
         } catch (Exception ex) {
             System.out.println("Terjadi kesalahan: " + ex.getMessage());
             return getInputFloat(message);
         }
     }

      public static int getChoice(int max) {
         while (true) {
            try {
                int choice = Main.getInputInt("Pilihan: ");
                 if (choice < 1 || choice > max) {
                     throw new NumberFormatException();
                 }
                 return choice;
             } catch (NumberFormatException e) {
                 System.out.println("Pilihan tidak valid.");
            }
         }
     }



}



        
