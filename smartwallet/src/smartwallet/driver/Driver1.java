package smartwallet.driver;

import smartwallet.model.*;
import java.util.*;

public class Driver1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, Account> daftarAkun = new HashMap<>();
        
        while (true) {
            String baris = input.nextLine();
            
            if (baris.equals("---")) {
                break;
            }
            
            String[] bagian = baris.split("#");
            
            if (bagian[0].equals("create-account")) {
                String nama = bagian[1];
                String namaKerja = bagian[2];
                String tipeAkun = bagian[3];
                
                Account akun = new Account(nama, namaKerja, tipeAkun);
                daftarAkun.put(namaKerja, akun);
            }
        }
        
        for (Account akun : daftarAkun.values()) {
            System.out.println(akun.getNamaKerja() + "|" + akun.getNama() + "|" + 
                             akun.getTipeAkun() + "|" + akun.getSaldo());
        }
        
        input.close();
    }
}
