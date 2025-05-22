package com.praktikum.users;

import com.praktikum.actions.AdminActions;
import com.praktikum.data.*;
import com.praktikum.main.LoginFailedException;
import com.praktikum.main.LoginSystem;

import java.util.*;

public class Admin extends User implements AdminActions {

    private String username;
    private String password;
    private String nama;
    private String nim;

    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.nim = nim;
    }

    @Override
    public boolean login(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    @Override
    public void displayInfo() {
        System.out.println("Login Admin berhasil!\nNama: " + getNama() + "\nNIM: " + getNim());
    }

    @Override
    public void displayAppMenu() throws LoginFailedException {
        Scanner scanner = new Scanner(System.in);
        String pilihan;

        do {
            System.out.println("\n=== Menu Admin ===");
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    manageItems();
                    break;
                case "2":
                    manageUsers();
                    break;
                case "0":
                    System.out.println("Logout...");
                    LoginSystem.prosesLogin();
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (!pilihan.equals("0"));
    }

    @Override
    public void manageItems() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== Menu Admin: Kelola Barang ===");
            System.out.println("1. Lihat Semua Laporan Barang");
            System.out.println("2. Tandai Barang Telah Diambil (Claimed)");
            System.out.println("0. Kembali");
            System.out.print("Masukkan pilihan: ");

            try {
                pilihan = Integer.parseInt(scanner.nextLine());

                switch (pilihan) {
                    case 1 -> ViewReported();
                    case 2 -> tandaiBarangClaimed();
                    case 0 -> System.out.println("🔙 Kembali ke menu utama...");
                    default -> System.out.println("❌ Pilihan tidak valid.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠ Input harus berupa angka.");
                pilihan = -1; // agar loop tetap berjalan
            }
        } while (pilihan != 0);
    }

    private void ViewReported() {
        System.out.println("\n📋 Daftar Semua Laporan Barang:");

        if (LoginSystem.reportedItems.isEmpty()) {
            System.out.println("⚠ Belum ada laporan barang.");
            return;
        }

        int no = 1;
        for (Item item : LoginSystem.reportedItems) {
            System.out.println("\nBarang #" + no++);
            System.out.println("Nama     : " + item.getItemName());
            System.out.println("Deskripsi: " + item.getDescription());
            System.out.println("Lokasi   : " + item.getLocation());
            System.out.println("Status   : " + item.getStatus());
        }
    }

    private void tandaiBarangClaimed() {
        ArrayList<Item> reportedOnly = new ArrayList<>();

        System.out.println("\n📌 Barang dengan Status 'Reported':");

        for (Item item : LoginSystem.reportedItems) {
            if (item.getStatus().equalsIgnoreCase("Reported")) {
                reportedOnly.add(item);
            }
        }

        if (reportedOnly.isEmpty()) {
            System.out.println("⚠ Tidak ada barang yang belum di-claim.");
            return;
        }

        // Tampilkan barang
        for (int i = 0; i < reportedOnly.size(); i++) {
            Item item = reportedOnly.get(i);
            System.out.println("\n[" + (i + 1) + "] " + item.getItemName());
            System.out.println("    Lokasi   : " + item.getLocation());
            System.out.println("    Deskripsi: " + item.getDescription());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nomor barang yang ingin ditandai sebagai 'Claimed': ");

        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;

            try {
                Item selectedItem = reportedOnly.get(index);
                selectedItem.setStatus("Claimed");
                System.out.println("✅ Barang '" + selectedItem.getItemName() + "' telah ditandai sebagai 'Claimed'.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("❌ Indeks tidak ditemukan dalam daftar!");
            }

        } catch (NumberFormatException e) {
            System.out.println("❌ Input harus berupa angka!");
        }
    }

    @Override
    public void manageUsers() {
        Scanner scanner = new Scanner(System.in);
        int pilihan = -1;

        do {
            System.out.println("\n=== Menu Admin: Kelola Mahasiswa ===");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("0. Kembali");
            System.out.print("Masukkan pilihan: ");

            try{
                pilihan = Integer.parseInt(scanner.nextLine());
                switch (pilihan) {
                    case 1 -> tambahMahasiswa(scanner);
                    case 2 -> hapusMahasiswa(scanner);
                    case 0 -> System.out.println("🔙 Kembali ke menu utama...");
                    default -> System.out.println("❌ Pilihan tidak valid.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠ Input harus berupa angka.");
            }

        } while (pilihan != 0);
    }

    private void tambahMahasiswa(Scanner scanner) {
        System.out.print("Masukkan nama mahasiswa: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan NIM mahasiswa: ");
        String nim = scanner.nextLine();

        if (!nama.matches("[a-zA-Z ]+")) {
            System.out.println("❌ Nama hanya boleh berisi huruf dan spasi.");
            return;
        }

        // Cek apakah NIM sudah digunakan
        for (User u : LoginSystem.userList) {
            if (u instanceof Mahasiswa m && m.getNim().equals(nim)) {
                System.out.println("⚠ Mahasiswa dengan NIM tersebut sudah terdaftar.");
                return;
            }
        }

        Mahasiswa mhs = new Mahasiswa(nama, nim);
        LoginSystem.userList.add(mhs);
        System.out.println("✅ Mahasiswa berhasil ditambahkan.");
    }

    private void hapusMahasiswa(Scanner scanner) {
        System.out.print("Masukkan NIM mahasiswa yang ingin dihapus: ");
        String nim = scanner.nextLine();

        Iterator<User> iterator = LoginSystem.userList.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user instanceof Mahasiswa m && m.getNim().equals(nim)) {
                iterator.remove();
                found = true;
                System.out.println("✅ Mahasiswa dengan NIM " + nim + " berhasil dihapus.");
                break;
            }
        }

        if (!found) {
            System.out.println("❌ Mahasiswa dengan NIM tersebut tidak ditemukan.");
        }
    }
}