public class EnhanceFor {
    public static void main(String[] args) {
        // Enhanced for loop
        int[] numbers = {1, 2, 3, 4, 5}; //Mendeklarasikan dan menginisialisasikan jika ada sebuah array bernama variabel 'numbers' dengan panjang lima elemen, yaitu 1,2,3,4, dan 5.
        for (int number : numbers) { //Ini adalah loop for enhanced yang digunakan untuk mengiterasi melalui setiap elemen dalam array 'numbers'. Saat setiap iterasi, nilai dari elemen saat ini akan disimpan dalam variabel 'number'.
            System.out.println(number); //Mencetak/print setiap elemen dari array 'numbers'.
        }
    }
}
