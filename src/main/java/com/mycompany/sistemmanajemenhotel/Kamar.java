package com.mycompany.sistemmanajemenhotel;

public class Kamar {
    private String nomorKamar;
    private double hargaPerMalam;
    private boolean terisi;

    public static int totalKamarDibuat = 0;

    public Kamar(String nomorKamar, double hargaPerMalam) {
        this.nomorKamar = nomorKamar;
        setHargaPerMalam(hargaPerMalam);
        this.terisi = false;
        totalKamarDibuat++;
    }

    public String getNomorKamar() {
        return this.nomorKamar;
    }

    public void setNomorKamar(String nomorKamar) {
        this.nomorKamar = nomorKamar;
    }

    public double getHargaPerMalam() {
        return this.hargaPerMalam;
    }

    public void setHargaPerMalam(double hargaPerMalam) {
        if (hargaPerMalam > 0) {
            this.hargaPerMalam = hargaPerMalam;
        } else {
            System.out.println("[Peringatan] Harga kamar tidak valid! Diset ke default 100000.");
            this.hargaPerMalam = 100000;
        }
    }

    public boolean isTerisi() {
        return this.terisi;
    }

    public void setTerisi(boolean terisi) {
        this.terisi = terisi;
    }

    public void tampilkanInfo() {
        String status = this.terisi ? "Terisi" : "Kosong";
        System.out.printf("Nomor Kamar: %-6s | Harga/Malam: Rp%,-10.2f | Status: %s", 
                this.nomorKamar, this.hargaPerMalam, status);
    }

    public void layananKamar() {
        System.out.println("-> Layanan Kamar Standar: Pembersihan kamar harian.");
    }
}