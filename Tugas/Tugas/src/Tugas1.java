import java.util.Scanner;

public class Tugas1 {

    public static void tipe(){
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan Pilihan Anda: ");
    }

    public static void main(String[] args) {
        Scanner inputan = new Scanner(System.in);
        int pilihan, nim_terakhir = 177;
        String username, password, nim, nama;
        String validnama = "Ryfaathir Rahman";
        String validnim = "202410370110177";
        String validusername = "Admin" + nim_terakhir;
        String validpassword = "Password" + nim_terakhir;

        System.out.println("Program Login Sederhana");

        // Validasi pilihan menggunakan do-while
        do {
            tipe();
            while (!inputan.hasNextInt()) { // Jika input bukan angka
                System.out.println("Pilihan Tidak Valid! Masukkan angka 1 atau 2.");
                inputan.next(); // Bersihkan input yang salah
                tipe();
            }
            pilihan = inputan.nextInt();
            inputan.nextLine(); // Membersihkan buffer agar nextLine() berfungsi dengan benar

            if (pilihan < 1 || pilihan > 2) {
                System.out.println("Pilihan Tidak Valid! Silakan coba lagi.");
            }

        } while (pilihan < 1 || pilihan > 2);

        if (pilihan == 1) {
            System.out.print("Masukkan Username: ");
            username = inputan.nextLine();
            System.out.print("Masukkan Password: ");
            password = inputan.nextLine();

            // Perbaikan cara membandingkan string
            if (username.equals(validusername) && password.equals(validpassword)) {
                System.out.println("Yeyyy, Login Admin Berhasil, Selamat Bersenang-senang!");
            } else {
                System.out.println("Halah, Login Admin Gagal.");
            }
        } else if (pilihan == 2) {
            System.out.print("Masukkan Nama: ");
            nama = inputan.nextLine();
            System.out.print("Masukkan NIM: ");
            nim = inputan.nextLine();

            if (nama.equals(validnama) && nim.equals(validnim)) {
                System.out.println("Yeyyy, Login Berhasil, Selamat Bersenang-senang!");
            } else {
                System.out.println("Yahaha hayyuk.");
            }
        }
        inputan.close(); // Menutup Scanner untuk menghindari memory leak
    }
}
