package smartwallet.model;

public class CashbackTransaction extends Transaction {
    
    public CashbackTransaction(String namaKerja, double jumlah, String waktu, String deskripsi) {
        super(namaKerja, jumlah, waktu, deskripsi);
        hitungBiayaDanJumlahBersih();
    }
    
    @Override
    public void hitungBiayaDanJumlahBersih() {
        this.biaya = 0.0;
        this.jumlahBersih = this.jumlah;
    }
    
    @Override
    public String getTipeTransaksi() {
        return "cashback";
    }
}
