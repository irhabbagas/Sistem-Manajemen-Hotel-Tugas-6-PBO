package com.mycompany.sistemmanajemenhotel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemManajemenHotel {

    public static void cariKamar(String nomorKamar, ArrayList<Kamar> daftar) throws KamarTidakDitemukanException {
        System.out.println("\nMencari Kamar dengan Nomor: " + nomorKamar);
        boolean ditemukan = false;
        for (int i = 0; i < daftar.size(); i++) {
            if (daftar.get(i).getNomorKamar().equalsIgnoreCase(nomorKamar)) {
                daftar.get(i).tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            throw new KamarTidakDitemukanException("Gagal: Kamar dengan nomor '" + nomorKamar + "' tidak terdaftar di sistem.");
        }
    }

    public static void simulasiLayanan(Kamar kamar) {
        kamar.layananKamar();
    }

  3  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Kamar> daftarKamar = new ArrayList<>();
        HashMap<String, String> dataTamu = new HashMap<>();
        boolean isRunning = true;

        try {
            daftarKamar.add(new KamarReguler("101", 350000, "Single Bed"));
            daftarKamar.add(new KamarReguler("102", 500000, "Double Bed"));
            daftarKamar.add(new KamarSuite("201", 1200000, true));
            daftarKamar.add(new KamarExecutive("301", 2500000, "Meja Rapat & Proyektor"));

            dataTamu.put("187101001", "Budi Santoso");
            dataTamu.put("187101002", "Siti Aminah");
        } catch (Exception e) {
            System.out.println("Gagal menginisialisasi data awal: " + e.getMessage());
        }

        System.out.println("=========================================");
        System.out.println("    SELAMAT DATANG DI HOTEL MANAGER      ");
        System.out.println("=========================================");

        while (isRunning) {
            System.out.println("\n--- MENU UTAMA ---");
            System.out.println("1. Tambah Kamar Baru (ArrayList)");
            System.out.println("2. Tampilkan Seluruh Kamar");
            System.out.println("3. Cari Kamar (Demo Custom Exception)");
            System.out.println("4. Manajemen Tamu (Demo HashMap)");
            System.out.println("5. Keluar");
            System.out.print("Pilih Menu (1-5): ");

            try {
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
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
                            daftarKamar.add(new KamarReguler(nomor, harga, ranjang));
                        } else if (jenis == 2) {
                            System.out.print("Memiliki Jacuzzi? (true/false): ");
                            boolean jacuzzi = scanner.nextBoolean();
                            scanner.nextLine();
                            daftarKamar.add(new KamarSuite(nomor, harga, jacuzzi));
                        } else if (jenis == 3) {
                            System.out.print("Masukkan Fasilitas Bisnis: ");
                            String fasilitas = scanner.nextLine();
                            daftarKamar.add(new KamarExecutive(nomor, harga, fasilitas));
                        } else {
                            System.out.println("Jenis kamar tidak valid!");
                            break;
                        }

                        System.out.println("Sukses! Kamar berhasil ditambahkan. (Total Kamar: " + daftarKamar.size() + ")");
                        break;

                    case 2:
                        System.out.println("\n--- Daftar Seluruh Kamar (ArrayList) ---");
                        if (daftarKamar.isEmpty()) {
                            System.out.println("Belum ada data kamar.");
                        } else {
                            for (int i = 0; i < daftarKamar.size(); i++) {
                                System.out.printf("%d. ", (i + 1));
                                daftarKamar.get(i).tampilkanInfo();
                                simulasiLayanan(daftarKamar.get(i));
                                daftarKamar.get(i).hitungDendaKeterlambatan();

                                if (daftarKamar.get(i) instanceof DapatDipesan) {
                                    DapatDipesan itemPesan = (DapatDipesan) daftarKamar.get(i);
                                    itemPesan.prosesPemesanan();
                                }

                                if (daftarKamar.get(i) instanceof DapatDinilai) {
                                    DapatDinilai itemNilai = (DapatDinilai) daftarKamar.get(i);
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
                        System.out.println("\n-- Fitur Cari Kamar --");
                        System.out.print("Masukkan Nomor Kamar: ");
                        String kataKunci = scanner.nextLine();

                        try {
                            cariKamar(kataKunci, daftarKamar);
                        } catch (KamarTidakDitemukanException e) {
                            System.out.println("Peringatan: " + e.getMessage());
                        } finally {
                            System.out.println("-> Sesi pencarian selesai dieksekusi.");
                        }

                        System.out.print("Tekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                        break;

                    case 4:
                        System.out.println("\n-- Kelola Tamu Hotel (HashMap) --");
                        System.out.println("1. Tambah Tamu Baru");
                        System.out.println("2. Cari Tamu via NIK");
                        System.out.println("3. Tampilkan Semua Tamu");
                        System.out.print("Pilih: ");
                        int menuTamu = scanner.nextInt();
                        scanner.nextLine();

                        if (menuTamu == 1) {
                            System.out.print("Masukkan NIK (Key): ");
                            String nik = scanner.nextLine();
                            System.out.print("Masukkan Nama Lengkap (Value): ");
                            String nama = scanner.nextLine();

                            dataTamu.put(nik, nama);
                            System.out.println("Berhasil menambahkan data tamu!");
                        } else if (menuTamu == 2) {
                            System.out.print("Masukkan NIK yang dicari: ");
                            String searchNik = scanner.nextLine();

                            if (dataTamu.containsKey(searchNik)) {
                                System.out.println("Ditemukan! Nama Tamu: " + dataTamu.get(searchNik));
                            } else {
                                System.out.println("Tamu dengan NIK tersebut tidak terdaftar.");
                            }
                        } else if (menuTamu == 3) {
                            System.out.println("Total Tamu Terdaftar: " + dataTamu.size());
                            for (String keyNik : dataTamu.keySet()) {
                                System.out.println("- NIK: " + keyNik + " | Nama: " + dataTamu.get(keyNik));
                            }
                        } else {
                            System.out.println("Pilihan menu tamu tidak valid!");
                        }

                        System.out.print("Tekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                        break;

                    case 5:
                        isRunning = false;
                        System.out.println("\nTerima kasih telah menggunakan Sistem Manajemen Hotel!");
                        break;

                    default:
                        System.out.println("Pilihan tidak valid! Silahkan pilih angka 1-5.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\n[FATAL ERROR] Input tidak valid! Anda harus memasukkan angka.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("\n[ERROR SISTEM] Terjadi kegagalan: " + e.getMessage());
            }
        }
        scanner.close();
    }
}