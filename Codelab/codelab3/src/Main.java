import java.util.Random;

// Superclass KarakterGame
class KarakterGame {
    private String nama;
    private int kesehatan;

    public KarakterGame(String nama, int kesehatan) {
        this.nama = nama;
        this.kesehatan = kesehatan;
    }

    public String getNama() {
        return nama;
    }

    public int getKesehatan() {
        return kesehatan;
    }

    public void setKesehatan(int kesehatan) {
        this.kesehatan = Math.max(kesehatan, 0); // Kesehatan tidak boleh negatif
    }

    public void serang(KarakterGame target) {
        System.out.println(nama + " menyerang " + target.getNama() + "!");
    }

    public boolean isAlive() {
        return kesehatan > 0;
    }
}

// Subclass Pahlawan
class Pahlawan extends KarakterGame {
    private static final String[] SERANGAN = {"Pedang Cahaya", "Tebasan Petir"};
    private static final Random rand = new Random();

    public Pahlawan(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    @Override
    public void serang(KarakterGame target) {
        String jenisSerangan = SERANGAN[rand.nextInt(SERANGAN.length)];
        int damage = 20;

        // 20% kemungkinan serangan kritikal (+10 damage)
        if (rand.nextInt(100) < 20) {
            damage += 10;
            System.out.println("💥 Serangan KRITIKAL! +10 Damage! 💥");
        }

        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan " + jenisSerangan + "!");
        target.setKesehatan(target.getKesehatan() - damage);
        System.out.println(target.getNama() + " sekarang memiliki kesehatan " + target.getKesehatan());
    }
}

// Subclass Musuh
class Musuh extends KarakterGame {
    private static final String[] SERANGAN = {"Sihir Gelap", "Api Neraka"};
    private static final Random rand = new Random();

    public Musuh(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    @Override
    public void serang(KarakterGame target) {
        String jenisSerangan = SERANGAN[rand.nextInt(SERANGAN.length)];
        int damage = 15;

        // 30% kemungkinan efek racun (-5 HP tambahan)
        if (rand.nextInt(100) < 30) {
            damage += 5;
            System.out.println("☠️ Efek RACUN! -5 HP tambahan ☠️");
        }

        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan " + jenisSerangan + "!");
        target.setKesehatan(target.getKesehatan() - damage);
        System.out.println(target.getNama() + " sekarang memiliki kesehatan " + target.getKesehatan());
    }
}

// Kelas Main untuk eksekusi pertarungan
public class Main {
    public static void main(String[] args) {
        Pahlawan brimstone = new Pahlawan("Brimstone", 150);
        Musuh viper = new Musuh("Viper", 200);

        System.out.println("===== Status Awal =====");
        System.out.println(brimstone.getNama() + " memiliki kesehatan: " + brimstone.getKesehatan());
        System.out.println(viper.getNama() + " memiliki kesehatan: " + viper.getKesehatan());
        System.out.println("=======================");

        // Simulasi pertarungan sampai salah satu kalah
        while (brimstone.isAlive() && viper.isAlive()) {
            brimstone.serang(viper);
            if (viper.isAlive()) {
                viper.serang(brimstone);
            }
        }

        // Menentukan pemenang
        if (brimstone.isAlive()) {
            System.out.println("\n🎉 " + brimstone.getNama() + " MENANG! 🎉");
        } else {
            System.out.println("\n💀 " + viper.getNama() + " MENANG! 💀");
        }

        System.out.println("\nProcess finished with exit code 0");
    }
}
