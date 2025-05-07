package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;

import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions {

    public Mahasiswa(String username, String password) {
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
            System.out.println("1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Log Out");
            System.out.println("Masukan Pilihan : ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan){
                case 1 : reportItem();
                    break;
                case 2 : viewReportedItems();
                    break;
                case 0 :
                    System.out.println("Log Out......");
                    break;
                default:
                    System.out.println("Pilihan Tidak Valid");
            }
        }while(pilihan != 0);
    }

    @Override
    public void reportItem() {
        Scanner inputan = new Scanner(System.in);
        System.out.println("Masukan Nama Barang : ");
        String barang = inputan.nextLine();
        System.out.println("Masukan Deksripsi Barang : ");
        String dekripsi = inputan.nextLine();
        System.out.println("Lokasi Terakhir/Ditemukan : ");
        String lokasi = inputan.nextLine();
        System.out.println("Laporan diterima: " + barang + " - " + dekripsi + " di " + lokasi);
    }

    @Override
    public void viewReportedItems() {
        System.out.println(">> Fitur Lihat Laporan Belum Tersedia <<");
    }
}