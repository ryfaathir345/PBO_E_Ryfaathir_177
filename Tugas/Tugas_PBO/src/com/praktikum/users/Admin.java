package com.praktikum.users;

import com.praktikum.actions.AdminActions;
import java.util.Scanner;

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
    public void displayAppMenu() {
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
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (!pilihan.equals("0"));
    }

    @Override
    public void manageItems() {
        System.out.println(">> Fitur Kelola Barang Belum Tersedia <<");
    }

    @Override
    public void manageUsers() {
        System.out.println(">> Fitur Kelola Mahasiswa Belum Tersedia <<");
    }
}