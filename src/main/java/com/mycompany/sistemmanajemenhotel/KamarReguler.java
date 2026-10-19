package com.mycompany.sistemmanajemenhotel;

public class KamarReguler extends Kamar implements DapatDipesan {
    private String tipeRanjang;

    public KamarReguler(String nomorKamar, double hargaPerMalam, String tipeRanjang) {
        super(nomorKamar, hargaPerMalam);
        this.tipeRanjang = tipeRanjang;
    }

    public String getTipeRanjang() {
        return this.tipeRanjang;
    }

    public void setTipeRanjang(String tipeRanjang) {
        this.tipeRanjang = tipeRanjang;
    }

    @Override
    public void tampilkanInfo() {
        System.out.print("[REGULER] ");
        super.tampilkanInfo();
        System.out.printf(" | Ranjang: %s%n", this.tipeRanjang);
    }

    @Override
    public void layananKamar() {
        System.out.println("-> Layanan Reguler: Pembersihan kamar & penggantian handuk harian.");
    }

    @Override
    public void hitungDendaKeterlambatan() {
        System.out.println("-> Denda Keterlambatan Check-out: Rp 50.000 / jam.");
    }

    @Override
    public void prosesPemesanan() {
        System.out.println("-> PROSES PESAN: Kamar Reguler berhasil dipesan via Resepsionis/Aplikasi.");
    }
}