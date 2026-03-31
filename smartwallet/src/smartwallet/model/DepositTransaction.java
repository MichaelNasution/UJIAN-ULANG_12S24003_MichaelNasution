package smartwallet.model;

public class DepositTransaction extends Transaction {
    
    public DepositTransaction(String namaKerja, double jumlah, String waktu, String deskripsi) {
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
        return "deposit";
    }
}
