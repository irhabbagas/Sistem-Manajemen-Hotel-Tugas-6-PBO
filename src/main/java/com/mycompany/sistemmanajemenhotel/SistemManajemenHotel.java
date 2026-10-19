package com.mycompany.sistemmanajemenhotel;

import java.util.Scanner;

public class SistemManajemenHotel {

    public static void cariKamar(String nomorKamar, Kamar[] daftar, int jumlah) {
        System.out.println("\n=== Hasil Pencarian Nomor Kamar: " + nomorKamar + " ===");
        boolean ditemukan = false;
        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getNomorKamar().equalsIgnoreCase(nomorKamar)) {
                System.out.print("- ");
                daftar[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Kamar dengan nomor tersebut tidak ditemukan.");
        }
    }

    public static void cariKamar(double hargaMaksimal, Kamar[] daftar, int jumlah) {
        System.out.println("\n=== Hasil Pencarian Kamar dengan Harga <= Rp" + hargaMaksimal + " ===");
        boolean ditemukan = false;
        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getHargaPerMalam() <= hargaMaksimal) {
                System.out.print("- ");
                daftar[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Tidak ada kamar dengan harga di bawah nominal tersebut.");
        }
    }

    public static void simulasiLayanan(Kamar kamar) {
        kamar.layananKamar();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Kamar[] daftarKamar = new Kamar[10];
        int jumlahKamar = 0;
        boolean isRunning = true;

        daftarKamar[jumlahKamar++] = new KamarReguler("101", 350000, "Single Bed");
        daftarKamar[jumlahKamar++] = new KamarReguler("102", 500000, "Double Bed");
        daftarKamar[jumlahKamar++] = new KamarSuite("201", 1200000, true);
        daftarKamar[jumlahKamar++] = new KamarExecutive("301", 2500000, "Meja Rapat & Proyektor");

        System.out.println("=========================================");
        System.out.println("    SELAMAT DATANG DI HOTEL MANAGER      ");
        System.out.println("=========================================");

        while (isRunning) {
            System.out.println("\n--- MENU UTAMA ---");
            System.out.println("1. Tambah Kamar Baru");
            System.out.println("2. Tampilkan Seluruh Kamar & Eksekusi Interface");
            System.out.println("3. Cari Kamar (Fitur Overloading)");
            System.out.println("4. Keluar");
            System.out.print("Pilih Menu (1-4): ");

            if (!scanner.hasNextInt()) {
                break;
            }

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    if (jumlahKamar < daftarKamar.length) {
                        System.out.println("\n-- Pilih Jenis Kamar --");
                        System.out.println("1. Kamar Reguler");
                        System.out.println("2. Kamar Suite");
                        System.out.println("3. Kamar Executive");
                        System.out.print("Pilihan (1/2/3): ");
                        int jenis = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Masukkan Nomor Kamar : ");
                        String nomor = scanner.nextLine();
                        System.out.print("Masukkan Harga/Malam : ");
                        double harga = scanner.nextDouble();
                        scanner.nextLine();

                        if (jenis == 1) {
                            System.out.print("Masukkan Tipe Ranjang (Single/Double/King): ");
                            String ranjang = scanner.nextLine();
                            daftarKamar[jumlahKamar] = new KamarReguler(nomor, harga, ranjang);
                        } else if (jenis == 2) {
                            System.out.print("Memiliki Jacuzzi? (true/false): ");
                            boolean jacuzzi = scanner.nextBoolean();
                            scanner.nextLine();
                            daftarKamar[jumlahKamar] = new KamarSuite(nomor, harga, jacuzzi);
                        } else if (jenis == 3) {
                            System.out.print("Masukkan Fasilitas Bisnis: ");
                            String fasilitas = scanner.nextLine();
                            daftarKamar[jumlahKamar] = new KamarExecutive(nomor, harga, fasilitas);
                        }

                        jumlahKamar++;
                        System.out.println("Sukses! Data kamar berhasil ditambahkan.");
                    } else {
                        System.out.println("Kapasitas penyimpanan kamar sudah penuh!");
                    }
                    break;

                case 2:
                    System.out.println("\n--- Daftar Seluruh Kamar & Aksi Interface ---");
                    if (jumlahKamar == 0) {
                        System.out.println("Belum ada data kamar.");
                    } else {
                        for (int i = 0; i < jumlahKamar; i++) {
                            System.out.printf("%d. ", (i + 1));
                            daftarKamar[i].tampilkanInfo();
                            simulasiLayanan(daftarKamar[i]);
                            daftarKamar[i].hitungDendaKeterlambatan();

                            if (daftarKamar[i] instanceof DapatDipesan) {
                                DapatDipesan itemPesan = (DapatDipesan) daftarKamar[i];
                                itemPesan.prosesPemesanan();
                            }

                            if (daftarKamar[i] instanceof DapatDinilai) {
                                DapatDinilai itemNilai = (DapatDinilai) daftarKamar[i];
                                itemNilai.beriRating(5);
                            }

                            System.out.println();
                        }
                        System.out.println("* Total Objek Kamar Terdaftar: " + Kamar.totalKamarDibuat);
                    }
                    System.out.print("Tekan Enter untuk melanjutkan...");
                    scanner.nextLine();
                    break;

                case 3:
                    System.out.println("\n-- Cari Kamar Berdasarkan --");
                    System.out.println("1. Nomor Kamar (Teks)");
                    System.out.println("2. Batas Harga Maksimal (Angka)");
                    System.out.print("Pilihan (1/2): ");
                    int kriteria = scanner.nextInt();
                    scanner.nextLine();

                    if (kriteria == 1) {
                        System.out.print("Masukkan Nomor Kamar: ");
                        String nomor = scanner.nextLine();
                        cariKamar(nomor, daftarKamar, jumlahKamar);
                    } else if (kriteria == 2) {
                        System.out.print("Masukkan Batas Harga Maksimal: ");
                        double hg = scanner.nextDouble();
                        scanner.nextLine();
                        cariKamar(hg, daftarKamar, jumlahKamar);
                    } else {
                        System.out.println("Pilihan pencarian tidak valid.");
                    }
                    System.out.print("Tekan Enter untuk melanjutkan...");
                    scanner.nextLine();
                    break;

                case 4:
                    isRunning = false;
                    System.out.println("\nTerima kasih telah menggunakan Sistem Manajemen Hotel!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid! Silahkan pilih angka 1-4.");
                    break;
            }
        }
        scanner.close();
    }
}