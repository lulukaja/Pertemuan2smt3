/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pertemuan2;
import java.util.Scanner;
/**
 *
 * @author LULUK
 */
public class ATM_Prosedural {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double saldo = 0; // Saldo mulai 0, di sini saja, gampang!
        
        System.out.println("=== SELAMAT DATANG DI ATM ===");
        
        // Cek PIN — maksimal 3 kali
        int kesempatan = 0;
        boolean pinBenar = false;
        
        while (kesempatan < 3) {
            System.out.print("Masukkan PIN ATM kamu: ");
            int pin = input.nextInt();
            
            if (pin == 123456) {
                pinBenar = true;
                break;
            } else {
                kesempatan++;
                System.out.println("PIN salah! Sisa percobaan: " + (3 - kesempatan));
            }
        }
        
        if (!pinBenar) {
            System.out.println("Sudah 3 kali salah. Program berhenti.");
            return;
        }
        
        // Menu berulang
        boolean lanjut = true;
        while (lanjut) {
            System.out.println("\n===== MENU TRANSAKSI =====");
            System.out.println("1. CEK SALDO");
            System.out.println("2. TARIK TUNAI");
            System.out.println("3. SETOR TUNAI");
            System.out.println("4. KELUAR");
            System.out.println("==========================");
            System.out.print("Pilihan Anda: ");
            int pilih = input.nextInt();
            
            switch (pilih) {
                case 1:
                    // CEK SALDO
                    System.out.println("\nSaldo Anda saat ini: Rp " + saldo);
                    break;
                    
                case 2:
                    // TARIK TUNAI
                    System.out.println("\n--- TARIK TUNAI ---");
                    if (saldo == 0) {
                        System.out.println("Saldo kosong! Tidak bisa tarik tunai.");
                        break;
                    }
                    System.out.println("Hanya bisa kelipatan 50000 atau 100000");
                    System.out.print("Masukkan jumlah tarik: Rp ");
                    double tarik = input.nextDouble();
                    
                    if (tarik % 50000 != 0) {
                        System.out.println("SALAH! Harus kelipatan 50000 atau 100000.");
                    } else if (tarik > saldo) {
                        System.out.println("Saldo tidak mencukupi!");
                    } else if (tarik <= 0) {
                        System.out.println("Jumlah tidak boleh 0 atau negatif!");
                    } else {
                        saldo = saldo - tarik;
                        System.out.println("Berhasil ditarik!");
                        System.out.println("Sisa saldo: Rp " + saldo);
                    }
                    break;
                    
                case 3:
                    // SETOR TUNAI
                    System.out.println("\n--- SETOR TUNAI ---");
                    System.out.println("Hanya bisa kelipatan 50000 atau 100000");
                    System.out.print("Masukkan jumlah setor: Rp ");
                    double setor = input.nextDouble();
                    
                    if (setor % 50000 != 0) {
                        System.out.println("SALAH! Harus kelipatan 50000 atau 100000.");
                    } else if (setor <= 0) {
                        System.out.println("Jumlah tidak boleh 0 atau negatif!");
                    } else {
                        saldo = saldo + setor;
                        System.out.println("Berhasil disetor!");
                        System.out.println("Saldo sekarang: Rp " + saldo);
                    }
                    break;
                    
                case 4:
                    System.out.println("Terima kasih! Sampai jumpa.");
                    lanjut = false;
                    break;
                    
                default:
                    System.out.println("Pilihan tidak ada! Pilih 1 – 4.");
            }
            System.out.println("---------------------------");
        }
        input.close();
    }
}