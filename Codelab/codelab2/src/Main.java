import java.util.Date;
public class Main {
    public static void main(String[] args) {
        hewan hewan1 = new hewan();
        hewan hewan2 = new hewan();

        hewan1.Nama = "Kucing";
        hewan1.Jenis = "Mamalia";
        hewan1.Suara = "Nyann~~";

        hewan2.Nama = "Anjing";
        hewan2.Jenis = "Mamalia";
        hewan2.Suara = "Rawrrrr";

        hewan1.tampilkanInfo();
        hewan2.tampilkanInfo();

        rekening rekening1 = new rekening();

        rekening1.namaPemilik = "Diana";
        rekening1.nomorRekening = "202410370110177";
        rekening1.saldo = 500000;

        rekening1.tampilkanInfo();

        rekening1.setorUang(50000);
        rekening1.tarikUang(1000000);

        rekening1.tampilkanInfo();

    }
}