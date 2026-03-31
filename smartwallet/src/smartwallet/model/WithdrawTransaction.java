package smartwallet.model;

public class WithdrawTransaction extends Transaction {
    private static final double PERSENTASE_BIAYA = 0.05;
    
    public WithdrawTransaction(String namaKerja, double jumlah, String waktu, String deskripsi) {
        super(namaKerja, jumlah, waktu, deskripsi);
        hitungBiayaDanJumlahBersih();
    }
    
    @Override
    public void hitungBiayaDanJumlahBersih() {
        this.biaya = this.jumlah * PERSENTASE_BIAYA;
        this.jumlahBersih = this.jumlah - this.biaya;
    }
    
    @Override
    public String getTipeTransaksi() {
        return "withdraw";
    }
}
