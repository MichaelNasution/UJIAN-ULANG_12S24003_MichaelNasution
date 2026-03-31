package smartwallet.driver;

import smartwallet.model.*;
import java.util.*;

public class Driver4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, Account> daftarAkun = new HashMap<>();
        
        while (true) {
            String baris = input.nextLine();
            
            if (baris.equals("---")) {
                break;
            }
            
            String[] bagian = baris.split("#");
            String tipe = bagian[0];
            
            if (tipe.equals("create-account")) {
                String nama = bagian[1];
                String namaKerja = bagian[2];
                String tipeAkun = bagian[3];
                
                Account akun = new Account(nama, namaKerja, tipeAkun);
                daftarAkun.put(namaKerja, akun);
                
            } else if (tipe.equals("deposit")) {
                String namaKerja = bagian[1];
                double jumlah = Double.parseDouble(bagian[2]);
                String waktu = bagian[3];
                String deskripsi = bagian[4];
                
                Account akun = daftarAkun.get(namaKerja);
                DepositTransaction transaksi = new DepositTransaction(namaKerja, jumlah, waktu, deskripsi);
                akun.tambahTransaksi(transaksi);
                akun.tambahSaldo(transaksi.getJumlahBersih());
                
            } else if (tipe.equals("withdraw")) {
                String namaKerja = bagian[1];
                double jumlah = Double.parseDouble(bagian[2]);
                String waktu = bagian[3];
                String deskripsi = bagian[4];
                
                Account akun = daftarAkun.get(namaKerja);
                WithdrawTransaction transaksi = new WithdrawTransaction(namaKerja, jumlah, waktu, deskripsi);
                
                if (akun.getSaldo() >= transaksi.getJumlahBersih()) {
                    akun.tambahTransaksi(transaksi);
                    akun.kurangiSaldo(transaksi.getJumlahBersih());
                }
                
            } else if (tipe.equals("transfer")) {
                String pengirim = bagian[1];
                String penerima = bagian[2];
                double jumlah = Double.parseDouble(bagian[3]);
                String waktu = bagian[4];
                String deskripsi = bagian[5];
                
                Account akunPengirim = daftarAkun.get(pengirim);
                Account akunPenerima = daftarAkun.get(penerima);
                
                TransferTransaction transaksiTransfer = new TransferTransaction(pengirim, penerima, jumlah, waktu, deskripsi);
                
                if (akunPengirim.getSaldo() >= transaksiTransfer.getJumlahBersih()) {
                    akunPengirim.tambahTransaksi(transaksiTransfer);
                    akunPengirim.kurangiSaldo(transaksiTransfer.getJumlahBersih());
                    akunPenerima.tambahSaldo(jumlah);
                    
                    if (akunPengirim.getTipeAkun().equals("PREMIUM")) {
                        double jumlahCashback = jumlah * 0.02;
                        CashbackTransaction transaksiCashback = new CashbackTransaction(pengirim, jumlahCashback, waktu, "Cashback transfer");
                        akunPengirim.tambahTransaksi(transaksiCashback);
                        akunPengirim.tambahSaldo(jumlahCashback);
                    }
                }
                
            } else if (tipe.equals("subscribe")) {
                String namaKerja = bagian[1];
                double jumlahBiaya = Double.parseDouble(bagian[2]);
                String waktu = bagian[3];
                String deskripsi = bagian[4];
                
                Account akun = daftarAkun.get(namaKerja);
                SubscriptionTransaction transaksi = new SubscriptionTransaction(namaKerja, jumlahBiaya, waktu, deskripsi);
                
                try {
                    if (akun.getSaldo() >= transaksi.getJumlahBersih()) {
                        akun.tambahTransaksi(transaksi);
                        akun.kurangiSaldo(transaksi.getJumlahBersih());
                    } else {
                        throw new InsufficientBalanceException("Saldo tidak cukup untuk subscription");
                    }
                } catch (InsufficientBalanceException e) {
                    // agar program tidak berhenti, kalo saldo tdk cukup
                    
                }
            }
        }
        
        for (Account akun : daftarAkun.values()) {
            System.out.println(akun.getNamaKerja() + "|" + akun.getNama() + "|" + 
                             akun.getTipeAkun() + "|" + akun.getSaldo());
        }
        
        input.close();
    }
}
