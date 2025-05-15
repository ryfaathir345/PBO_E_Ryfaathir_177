import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class ManajemenStok {
    public static void main(String[] args) {
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi: ");
            int pilihan;
            try {
                pilihan = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid! Harap masukkan angka.");
                scanner.next();
                continue;
            }
            switch (pilihan) {
                case 1: // Tambah Barang Baru
                    System.out.print("Masukkan nama barang: ");
                    String nama = scanner.next();
                    System.out.print("Masukkan stok awal: ");
                    int stokAwal;
                    try {
                        stokAwal = scanner.nextInt();
                        daftarBarang.add(new Barang(nama, stokAwal));
                        System.out.println("Barang berhasil ditambahkan.");
                    } catch (InputMismatchException e) {
                        System.out.println("Input stok harus berupa angka!");
                        scanner.next(); // Clear invalid input
                    }
                    break;
                case 2: // Tampilkan Semua Barang
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Stok barang kosong.");
                    } else {
                        System.out.println("Daftar Barang:");
                        for (Barang barang : daftarBarang) {
                            System.out.println("Nama: " + barang.getNama() + ", Stok: " + barang.getStok());
                        }
                    }
                    break;
                case 3: // Kurangi Stok Barang
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Stok barang kosong.");
                        break;
                    }
                    System.out.println("Daftar Barang:");
                    for (int i = 0; i < daftarBarang.size(); i++) {
                        System.out.println(i + ". " + daftarBarang.get(i).getNama() + " (Stok: " + daftarBarang.get(i).getStok() + ")");
                    }
                    System.out.print("Masukkan nomor indeks barang yang stoknya akan dikurangi: ");
                    int indeks;
                    try {
                        indeks = scanner.nextInt();
                        if (indeks < 0 || indeks >= daftarBarang.size()) {
                            throw new IndexOutOfBoundsException("Indeks tidak valid.");
                        }
                        System.out.print("Masukkan jumlah stok yang akan diambil: ");
                        int jumlahDiambil = scanner.nextInt();
                        Barang barang = daftarBarang.get(indeks);
                        if (jumlahDiambil > barang.getStok()) {
                            throw new StokTidakCukupException("Stok untuk " + barang.getNama() + " hanya tersisa " + barang.getStok());
                        }
                        barang.setStok(barang.getStok() - jumlahDiambil);
                        System.out.println("Pengurangan stok berhasil.");
                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka.");
                        scanner.next(); // Clear invalid input
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                    } catch (StokTidakCukupException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 0: // Keluar
                    running = false;
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
            }
        }
        scanner.close();
    }
}