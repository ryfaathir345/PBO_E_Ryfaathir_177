import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Admin admin = new Admin("Habibi", "202410370110180","Admin177", "Pass177");
        Mahasiswa mahasiswa = new Mahasiswa("Ryfaathir Rahman", "202410370110177");


        boolean ulang = true;

        while (ulang) {
            System.out.println("\n=== SISTEM LOGIN ===");
            System.out.println("1. Login sebagai Admin");
            System.out.println("2. Login sebagai Mahasiswa");
            System.out.print("Pilih menu (1/2): ");
            int pilihan = input.nextInt();
            input.nextLine(); // membersihkan buffer

            if (pilihan == 1) {
                System.out.print("Masukkan Username: ");
                String user = input.nextLine();
                System.out.print("Masukkan Password: ");
                String pass = input.nextLine();

                if (admin.login(user, pass)) {
                    System.out.println("Yey, Login Admin Berhasil😊");
                    admin.displayInfo();
                } else {
                    System.out.println("Login Admin gagal! Username atau Password salah.");
                }

            } else if (pilihan == 2) {
                System.out.print("Masukkan Nama Mahasiswa: ");
                String nama = input.nextLine();
                System.out.print("Masukkan NIM Mahasiswa: ");
                String nim = input.nextLine();

                if (mahasiswa.login(nama, nim)) {
                    System.out.println("Login Mahasiswa berhasil!");
                    mahasiswa.displayInfo();
                } else {
                    System.out.println("Login Mahasiswa gagal! Nama atau NIM salah.");
                }

            } else {
                System.out.println("Pilihan tidak valid.");
            }

            System.out.print("\nApakah Anda ingin login lagi? (y/n): ");
            String jawaban = input.nextLine();
            if (!jawaban.equalsIgnoreCase("y")) {
                ulang = false;
                System.out.println("Program selesai. Terima kasih!");
            }
        }
        input.close();
    }
}