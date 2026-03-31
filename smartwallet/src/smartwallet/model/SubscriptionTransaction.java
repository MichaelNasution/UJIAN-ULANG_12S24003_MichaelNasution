package smartwallet.model;

public class SubscriptionTransaction extends Transaction {
    
    public SubscriptionTransaction(String namaKerja, double jumlah, String waktu, String deskripsi) {
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
        return "subscribe";
    }
}
