package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;
import com.praktikum.data.Item;
import com.praktikum.main.*;

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
    public void displayAppMenu() throws LoginFailedException {
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
                    LoginSystem.prosesLogin();
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

        System.out.println("\n📌 Lapor Barang Hilang");
        System.out.print("Nama Barang: ");
        String itemName = scanner.nextLine();
        System.out.print("Deskripsi: ");
        String description = scanner.nextLine();
        System.out.print("Lokasi Kehilangan: ");
        String location = scanner.nextLine();

        Item item = new Item(itemName, "Reported", location, description);
        LoginSystem.reportedItems.add(item);

        System.out.println("✅ Barang berhasil dilaporkan!");
    }


    @Override
    public void viewReportedItems() {
        System.out.println("\n📋 Daftar Barang yang Dilaporkan:");

        if (LoginSystem.reportedItems.isEmpty()) {
            System.out.println("⚠ Belum ada laporan barang.");
        } else {
            int no = 1;
            for (Item item : LoginSystem.reportedItems) {
                if (item.getStatus().equalsIgnoreCase("Reported")) {
                    System.out.println("\nBarang #" + no++);
                    System.out.println("Nama     : " + item.getItemName());
                    System.out.println("Deskripsi: " + item.getDescription());
                    System.out.println("Lokasi   : " + item.getLocation());
                    System.out.println("Status   : " + item.getStatus());
                }
            }
        }
    }


}