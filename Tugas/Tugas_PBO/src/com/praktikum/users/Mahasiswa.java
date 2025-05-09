package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;
import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions {

    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public boolean login(String inputNama, String inputNim) {
        return getNama().equals(inputNama) && getNim().equals(inputNim);
    }

    @Override
    public void displayInfo() {
        System.out.println("Login Mahasiswa berhasil!\nNama: " + getNama() + "\nNIM: " + getNim());
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        String pilihan;

        do {
            System.out.println("\n=== Menu Mahasiswa ===");
            System.out.println("1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    reportItem();
                    break;
                case "2":
                    viewReportedItems();
                    break;
                case "0":
                    System.out.println("Logout...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (!pilihan.equals("0"));
    }

    @Override
    public void manageItems() {

    }

    @Override
    public void manageUsers() {

    }

    @Override
    public void reportItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nama Barang: ");
        String nama = scanner.nextLine();
        System.out.print("Deskripsi Barang: ");
        String deskripsi = scanner.nextLine();
        System.out.print("Lokasi Terakhir/Ditemukan: ");
        String lokasi = scanner.nextLine();

        System.out.println(">> Laporan berhasil dikirim. Terima kasih!");
    }

    @Override
    public void viewReportedItems() {
        System.out.println(">> Fitur Lihat Laporan Belum Tersedia <<");
    }

}