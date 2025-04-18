public class Mahasiswa extends User{
    private String nama;
    private String nim;

    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    public boolean login(String inputNama, String inputNIM) {
        return getNama().equalsIgnoreCase(inputNama) && getNim().equals(inputNIM);
    }

    public void displayInfo() {
        System.out.println("==== Informasi Mahasiswa ====");
        System.out.println("Nama: " + getNama());
        System.out.println("NIM: " + getNim());
    }
}