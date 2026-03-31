package smartwallet.model;

import java.util.*;

public class Account {
    private String nama;
    private String namaKerja;
    private double saldo;
    private String tipeAkun;
    private List<Transaction> daftarTransaksi;
    
    public Account(String nama, String namaKerja, String tipeAkun) {
        this.nama = nama;
        this.namaKerja = namaKerja;
        this.saldo = 0.0;
        this.tipeAkun = tipeAkun;
        this.daftarTransaksi = new ArrayList<>();
    }
    
    public void tambahTransaksi(Transaction transaksi) {
        daftarTransaksi.add(transaksi);
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void tambahSaldo(double jumlah) {
        this.saldo += jumlah;
    }
    
    public void kurangiSaldo(double jumlah) {
        this.saldo -= jumlah;
    }
    
    public String getNama() {
        return nama;
    }
    
    public String getNamaKerja() {
        return namaKerja;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public String getTipeAkun() {
        return tipeAkun;
    }
    
    public List<Transaction> getDaftarTransaksi() {
        return daftarTransaksi;
    }
}
