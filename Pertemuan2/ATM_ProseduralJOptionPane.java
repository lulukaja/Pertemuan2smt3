/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pertemuan2;

import javax.swing.JOptionPane;

public class ATM_ProseduralJOptionPane {
    public static void main(String[] args) {
        double saldo = 0;

        JOptionPane.showMessageDialog(null, "=== SELAMAT DATANG DI ATM ===", "ATM System", JOptionPane.INFORMATION_MESSAGE);

        // Cek PIN — maksimal 3 kali
        int kesempatan = 0;
        boolean pinBenar = false;

        while (kesempatan < 3) {
            String inputPin = JOptionPane.showInputDialog(null, "Masukkan PIN ATM kamu:", "Input PIN", JOptionPane.QUESTION_MESSAGE);

            // Menangani tombol Cancel atau x pada dialog
            if (inputPin == null) {
                JOptionPane.showMessageDialog(null, "Transaksi dibatalkan.", "Keluar", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                int pin = Integer.parseInt(inputPin);

                if (pin == 123456) {
                    pinBenar = true;
                    break;
                } else {
                    kesempatan++;
                    JOptionPane.showMessageDialog(null, "PIN salah! Sisa percobaan: " + (3 - kesempatan), "Error PIN", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                kesempatan++;
                JOptionPane.showMessageDialog(null, "PIN harus berupa angka! Sisa percobaan: " + (3 - kesempatan), "Error Input", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (!pinBenar) {
            JOptionPane.showMessageDialog(null, "Sudah 3 kali salah. Program berhenti.", "Akses Ditolak", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Menu berulang
        boolean lanjut = true;
        while (lanjut) {
            String menu = "===== MENU TRANSAKSI =====\n"
                        + "1. CEK SALDO\n"
                        + "2. TARIK TUNAI\n"
                        + "3. SETOR TUNAI\n"
                        + "4. KELUAR\n"
                        + "==========================\n"
                        + "Pilihan Anda (1-4):";

            String inputPilih = JOptionPane.showInputDialog(null, menu, "Menu Utama", JOptionPane.QUESTION_MESSAGE);

            if (inputPilih == null) {
                break; // Jika tombol Cancel ditekan
            }

            try {
                int pilih = Integer.parseInt(inputPilih);

                switch (pilih) {
                    case 1:
                        // CEK SALDO
                        JOptionPane.showMessageDialog(null, "Saldo Anda saat ini: Rp " + saldo, "Cek Saldo", JOptionPane.INFORMATION_MESSAGE);
                        break;

                    case 2:
                        // TARIK TUNAI
                        if (saldo == 0) {
                            JOptionPane.showMessageDialog(null, "Saldo kosong! Tidak bisa tarik tunai.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                            break;
                        }

                        String inputTarik = JOptionPane.showInputDialog(null, "Hanya bisa kelipatan 50000 atau 100000\nMasukkan jumlah tarik (Rp):", "Tarik Tunai", JOptionPane.QUESTION_MESSAGE);
                        if (inputTarik == null) break;

                        double tarik = Double.parseDouble(inputTarik);

                        if (tarik % 50000 != 0) {
                            JOptionPane.showMessageDialog(null, "SALAH! Harus kelipatan 50000 atau 100000.", "Gagal Transaksi", JOptionPane.ERROR_MESSAGE);
                        } else if (tarik > saldo) {
                            JOptionPane.showMessageDialog(null, "Saldo tidak mencukupi!", "Gagal Transaksi", JOptionPane.ERROR_MESSAGE);
                        } else if (tarik <= 0) {
                            JOptionPane.showMessageDialog(null, "Jumlah tidak boleh 0 atau negatif!", "Gagal Transaksi", JOptionPane.ERROR_MESSAGE);
                        } else {
                            saldo -= tarik;
                            JOptionPane.showMessageDialog(null, "Berhasil ditarik!\nSisa saldo: Rp " + saldo, "Sukses", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;

                    case 3:
                        // SETOR TUNAI
                        String inputSetor = JOptionPane.showInputDialog(null, "Hanya bisa kelipatan 50000 atau 100000\nMasukkan jumlah setor (Rp):", "Setor Tunai", JOptionPane.QUESTION_MESSAGE);
                        if (inputSetor == null) break;

                        double setor = Double.parseDouble(inputSetor);

                        if (setor % 50000 != 0) {
                            JOptionPane.showMessageDialog(null, "SALAH! Harus kelipatan 50000 atau 100000.", "Gagal Transaksi", JOptionPane.ERROR_MESSAGE);
                        } else if (setor <= 0) {
                            JOptionPane.showMessageDialog(null, "Jumlah tidak boleh 0 atau negatif!", "Gagal Transaksi", JOptionPane.ERROR_MESSAGE);
                        } else {
                            saldo += setor;
                            JOptionPane.showMessageDialog(null, "Berhasil disetor!\nSaldo sekarang: Rp " + saldo, "Sukses", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;

                    case 4:
                        JOptionPane.showMessageDialog(null, "Terima kasih! Sampai jumpa.", "Keluar", JOptionPane.INFORMATION_MESSAGE);
                        lanjut = false;
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Pilihan tidak ada! Pilih 1 – 4.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Input harus berupa angka valid!", "Error Input", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
