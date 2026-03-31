package smartwallet.model;

public abstract class Transaction {
    protected static int penghitungId = 0;
    
    protected int id;
    protected String namaKerja;
    protected double jumlah;
    protected double biaya;
    protected double jumlahBersih;
    protected String waktu;
    protected String deskripsi;
    
    public Transaction(String namaKerja, double jumlah, String waktu, String deskripsi) {
        this.id = ++penghitungId;
        this.namaKerja = namaKerja;
        this.jumlah = jumlah;
        this.waktu = waktu;
        this.deskripsi = deskripsi;
    }
    
    public abstract void hitungBiayaDanJumlahBersih();
    
    public int getId() {
        return id;
    }
    
    public String getNamaKerja() {
        return namaKerja;
    }
    
    public double getJumlah() {
        return jumlah;
    }
    
    public double getBiaya() {
        return biaya;
    }
    
    public double getJumlahBersih() {
        return jumlahBersih;
    }
    
    public String getWaktu() {
        return waktu;
    }
    
    public String getDeskripsi() {
        return deskripsi;
    }
    
    public abstract String getTipeTransaksi();
}
