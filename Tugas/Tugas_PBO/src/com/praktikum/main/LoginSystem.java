package com.praktikum.main;

import com.praktikum.users.*;
import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Sistem Login ===");
        System.out.print("Username: "); String userInput = sc.nextLine();
        System.out.print("Password: "); String passInput = sc.nextLine();

        User currentUser;
        if ("admin".equals(userInput) || "fathir5899".equals(userInput)) {
            // Asumsi dua akun admin: "admin" dengan pass "admin123", dan "fathir5899" dengan pass "admin1234"
            if ("admin".equals(userInput)) {
                currentUser = new Admin("admin", "admin123");
            } else {
                currentUser = new Admin("fathir5899", "admin1234");
            }
        } else {
            currentUser = new Mahasiswa(userInput, passInput);
        }

        if (currentUser.login(userInput, passInput)) {
            System.out.println("Login berhasil. Selamat datang, " + userInput + "!");
            currentUser.displayMenu();
        } else {
            System.out.println("Login gagal. Periksa username atau password.");
        }

        sc.close();
    }
}
