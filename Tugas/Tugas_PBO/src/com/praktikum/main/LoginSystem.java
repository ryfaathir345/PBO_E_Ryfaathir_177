package com.praktikum.main;

import com.praktikum.users.*;
import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Admin admin = new Admin("Admin180", "202410370110177", "Admin177", "Password177");
        Mahasiswa mahasiswa = new Mahasiswa("Ryfaathir", "202410370110177");

        System.out.println("Selamat datang di Sistem Login");
        System.out.println("1. Login sebagai Admin");
        System.out.println("2. Login sebagai Mahasiswa");
        System.out.print("Masukkan pilihan: ");
        String pilihan = scanner.nextLine();

        User user = null;

        if (pilihan.equals("1")) {
            System.out.print("Masukkan username: ");
            String username = scanner.nextLine();
            System.out.print("Masukkan password: ");
            String password = scanner.nextLine();

            if (admin.login(username, password)) {
                user = admin;
            } else {
                System.out.println("Login Admin gagal!");
            }
        } else if (pilihan.equals("2")) {
            System.out.print("Masukkan nama: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan NIM: ");
            String nim = scanner.nextLine();

            if (mahasiswa.login(nama, nim)) {
                user = mahasiswa;
            } else {
                System.out.println("Login Mahasiswa gagal!");
            }
        } else {
            System.out.println("Pilihan tidak valid!");
        }

        if (user != null) {
            user.displayInfo();
            user.displayAppMenu();
        }

        scanner.close();
    }
}