package com.praktikum.main;

import com.praktikum.data.Item;
import com.praktikum.users.*;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginSystem {
    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Item> reportedItems = new ArrayList<>();

    public static void prosesLogin() throws LoginFailedException {
        Scanner scanner = new Scanner(System.in);

        userList.add(new Admin("Admin177", "202410370110177", "Admin177", "Pass177"));
        userList.add(new Admin("Admin180", "202410370110180", "Admin180", "Pass180"));
        userList.add(new Mahasiswa("Azka", "202410370110222"));
        userList.add(new Mahasiswa("Julian", "202410370110175"));


        System.out.println("Selamat datang di Sistem Login");
        System.out.println("1. Login sebagai Admin");
        System.out.println("2. Login sebagai Mahasiswa");
        System.out.println("Ketik 'exit' untuk keluar dari program kapan saja.");
        System.out.print("Masukkan pilihan: ");
        String pilihan = scanner.nextLine();

        if (pilihan.equalsIgnoreCase("exit")) {
            System.out.println("Keluar dari program. Sampai jumpa!");
            System.exit(0);
        }

        User user = null;

        if (pilihan.equals("1")) {
            System.out.print("Masukkan username: ");
            String username = scanner.nextLine();
            System.out.print("Masukkan password: ");
            String password = scanner.nextLine();

            for (User u : userList) {
                if (u instanceof Admin a && a.login(username, password)) {
                    user = a;
                    break;
                }
            }

            if (user == null) throw new LoginFailedException("Login Admin gagal. Username atau password salah.");

        } else if (pilihan.equals("2")) {
            System.out.print("Masukkan nama: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan NIM: ");
            String nim = scanner.nextLine();

            if (!nama.matches("[a-zA-Z ]+")) {
                throw new LoginFailedException("Nama hanya boleh berisi huruf dan spasi.");
            }

            for (User u : userList) {
                if (u instanceof Mahasiswa m && m.login(nama, nim)) {
                    user = m;
                    break;
                }
            }

            if (user == null) throw new LoginFailedException("Login Mahasiswa gagal. Nama atau NIM salah.");

        } else {
            throw new LoginFailedException("Pilihan tidak valid. Harus 1 (Admin) atau 2 (Mahasiswa).");
        }


        if (user != null) {
            user.displayInfo();
            user.displayAppMenu();
        }

        scanner.close();
    }

    public static void main(String[] args) {
        boolean berhasilLogin = false;

        do {
            try {
                prosesLogin();
                berhasilLogin = true;
            } catch (LoginFailedException e) {
                System.out.println("❌ " + e.getMessage());
                System.out.println("Silakan coba lagi.\n");
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan sistem: " + e.getMessage());
                break; // keluar dari loop jika error sistem
            }
        } while (!berhasilLogin);
    }


}