package com.praktikum.users;

import com.praktikum.actions.AdminActions;

import java.util.Scanner;

public class Admin extends User implements AdminActions {

    public Admin(String username, String password) {
        super(username, password);
    }

    public boolean login(String inputUser, String inputPass) {
        return inputUser.equals(this.username) &&
                inputPass.equals(this.password);
    }

    @Override
    public void displayMenu() {
        Scanner input = new Scanner(System.in);
        int pilihan = 0;

        do{
            System.out.println("=== Menu Mahasiswa ===");
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
            System.out.println("0. Log Out");
            System.out.println("Masukan Pilihan : ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan){
                case 1 : manageItems();
                    break;
                case 2 : manageUsers();
                    break;
                case 0 : System.out.println("Log Out......");
                    break;
                    default: System.out.println("Pilihan Tidak Valid");
                }
            }while(pilihan != 0);
    }

    public void displayInfo() {
        System.out.println("==== Informasi com.praktikum.users.Admin ====");
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
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
