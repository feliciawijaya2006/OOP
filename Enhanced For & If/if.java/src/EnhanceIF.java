public class EnhanceIF {
    public static void main(String[] args) {
        // Enhanced if statement
        int num = 10;
        String hasil = (num % 2 == 0) ? "even" : "odd"; //Menggunakan operator ternary '?' untuk membuat if statement lebih singkat dari yang biasanya. 'num % 2 == 0' digunakan untuk mengecek apakah 'num' habis dibagi 2 atau tidak, jika sisa pembagaian 'num' dengan adalah 0 atau dengan kata lain 'num' habis dibagi dengan 2, maka 'num' merupakan bilangan genap.
        System.out.println("The number is " + hasil); //Jika 'num' habis dibagi dengan 2, variabel hasil akan memprint string dengan "even" dimana ini menunjukkan bahwa 'num' merupakan bilangan genap. Jika tidak, variabel 'result' akan memprint string dengan "odd" dimana ini menunjukkan bahwa 'num' merupakan bilangan ganjil.
    }
}