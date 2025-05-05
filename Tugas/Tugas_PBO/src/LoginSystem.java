import java.util.ArrayList;
import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Admin> daftarAdmin = new ArrayList<>();
        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
        daftarAdmin.add(new Admin("Ryfaathir", "202410370110177", "Admin177", "Pass177"));
        daftarAdmin.add(new Admin("Habibi", "202410370110180", "Admin180", "Pass180"));  // Admin kedua

        daftarMahasiswa.add(new Mahasiswa("Ryfaathir Rahman", "202410370110177"));
        daftarMahasiswa.add(new Mahasiswa("Habibi Dzakki", "202410370110180"));

        boolean ulang = true;

        while (ulang) {
            System.out.println("\n=== SISTEM LOGIN ===");
            System.out.println("1. Login sebagai Admin");
            System.out.println("2. Login sebagai Mahasiswa");
            System.out.print("Pilih menu (1/2): ");
            int pilihan = input.nextInt();
            input.nextLine(); // membersihkan buffer

            if (pilihan == 1) {
                String user, pass;
                do {
                    System.out.print("Masukkan Username: ");
                    user = input.nextLine().trim();
                    if (user.isEmpty()) {
                        System.out.println("Username tidak boleh kosong!");
                    }
                } while (user.isEmpty());

                do {
                    System.out.print("Masukkan Password: ");
                    pass = input.nextLine().trim();
                    if (pass.isEmpty()) {
                        System.out.println("Password tidak boleh kosong!");
                    }
                } while (pass.isEmpty());

                boolean loginSukses = false;
                for (Admin a : daftarAdmin) {
                    if (a.login(user, pass)) {
                        System.out.println("Yey, Login Admin Berhasil 😊");
                        a.displayInfo();
                        loginSukses = true;
                        break;
                    }
                }
                if (!loginSukses) {
                    System.out.println("Login Admin gagal! Username atau Password salah.");
                }

            } else if (pilihan == 2) {
                String nama, nim;
                do {
                    System.out.print("Masukkan Nama Mahasiswa: ");
                    nama = input.nextLine().trim();
                    if (nama.isEmpty()) {
                        System.out.println("Nama tidak boleh kosong!");
                    }
                } while (nama.isEmpty());

                do {
                    System.out.print("Masukkan NIM Mahasiswa: ");
                    nim = input.nextLine().trim();
                    if (nim.isEmpty()) {
                        System.out.println("NIM tidak boleh kosong!");
                    }
                } while (nim.isEmpty());

                boolean loginSukses = false;
                for (Mahasiswa a : daftarMahasiswa) {
                    if (a.login(nama, nim)) {
                        System.out.println("Yeay, Login Berhasil");
                        a.displayInfo();
                        loginSukses = true;
                        break;
                    }
                }
                if (!loginSukses) {
                    System.out.println("Login gagal! Mohon Masukan data dengan benar");
                }

                System.out.print("\nApakah Anda ingin login lagi? (y/n): ");
                String jawaban = input.nextLine().trim();
                if (!jawaban.equalsIgnoreCase("y")) {
                    ulang = false;
                    System.out.println("Program selesai. Terima kasih!");
                }
            }
            input.close();
        }
    }
}
