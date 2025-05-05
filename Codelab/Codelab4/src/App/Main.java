package App;

import Perpustakaan.*;

public class Main {
    public static void main(String[] args) {
        Buku buku1 = new NonFiksi("Gus Dur", "Mughammad Rifai", " filsafat, dan sosial-politik");
        Buku buku2 = new Fiksi("Laskar Pelangi", "Andrea Hirata", "drama inspiratif.");

        buku1.displayInfo();
        buku2.displayInfo();

        Anggota anggota1 = new Anggota("Ryfaathir Rahman", "E177");
        Anggota anggota2 = new Anggota("Azka Hafiyan Kahfi Ahshoni", "E222");

        anggota1.display();
        anggota2.display();

        anggota1.pinjamBuku("Gus Dur");
        anggota2.pinjamBuku("Laskar Pelangi", 7);

        anggota1.kembalikanBuku("Gus Dur");
        anggota2.kembalikanBuku("Laskar Pelangi");
    }
}
