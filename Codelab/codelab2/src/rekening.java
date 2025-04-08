public class rekening {
    String nomorRekening,namaPemilik;
    double saldo;

    void tampilkanInfo(){
        System.out.println("");
        System.out.println("No Rekening : "+nomorRekening);
        System.out.println("Nama Pemilik : "+namaPemilik);
        System.out.println("Saldo : "+saldo);
        System.out.println("");
    }
    void setorUang(double jumlah){
        saldo = saldo + jumlah;
        System.out.println(namaPemilik+" Menyetor Rp."+jumlah+". Saldo Sekarang Rp."+saldo);
    }

    void tarikUang(double jumlah){
        if (jumlah < saldo){
            System.out.println(namaPemilik+" Menarik Rp."+jumlah+". (Berhasil Menarik)"+". Saldo Sekarang Rp."+(saldo-jumlah));
        }else {
            System.out.println(namaPemilik+" Menarik Rp."+jumlah+". (Gagal, Saldo Tidak Mencukupi)"+". Saldo Sekarang Rp."+saldo);
        }
    }
}
