package smartwallet.driver;

import smartwallet.model.*;
import java.util.*;

public class Driver2 {
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
            }
        }
        
        for (Account akun : daftarAkun.values()) {
            System.out.println(akun.getNamaKerja() + "|" + akun.getNama() + "|" + 
                             akun.getTipeAkun() + "|" + akun.getSaldo());
        }
        
        input.close();
    }
}
