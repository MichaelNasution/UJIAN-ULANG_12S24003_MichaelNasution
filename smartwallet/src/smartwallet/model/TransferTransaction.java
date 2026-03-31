package smartwallet.model;

public class TransferTransaction extends Transaction {
    private static final double PERSENTASE_BIAYA = 0.02;
    private String penerima;
    
    public TransferTransaction(String namaKerja, String penerima, double jumlah, String waktu, String deskripsi) {
        super(namaKerja, jumlah, waktu, deskripsi);
        this.penerima = penerima;
        hitungBiayaDanJumlahBersih();
    }
    
    @Override
    public void hitungBiayaDanJumlahBersih() {
        this.biaya = this.jumlah * PERSENTASE_BIAYA;
        this.jumlahBersih = this.jumlah - this.biaya;
    }
    
    @Override
    public String getTipeTransaksi() {
        return "transfer";
    }
    
    public String getPenerima() {
        return penerima;
    }
}
