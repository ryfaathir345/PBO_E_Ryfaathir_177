import java.util.Scanner;
import java.time.LocalDate;

public class codelab {
    public static void main(String[] args) throws Exception {
        Scanner obj = new Scanner(System.in);
        String nama;
        char kelamin;
        int tahun;
        String kelamin_panjang = null;

        System.out.println("Masukan Nama Anda : ");
        nama = obj.nextLine();
        System.out.println("Masukan Jenis Kelamin Anda : ");
        kelamin = obj.next().charAt(0);
        System.out.println("Masukan Tahun Lahir Anda : ");
        tahun = obj.nextInt();

        int tahunSaatIni = LocalDate.now().getYear();
        int umur = tahunSaatIni - tahun;

        if (kelamin == 'L' || kelamin == 'l') {
            kelamin_panjang = "Laki Laki";
        } else if (kelamin == 'p' || kelamin == 'P') {
            kelamin_panjang = "Perempuan";
        }

        System.out.println("\nData Diri:");
        System.out.println("Nama Anda : "+nama);
        System.out.println("Jenis Kelamin : "+kelamin_panjang);
        System.out.println("Umur anda : "+umur);
    }
}
