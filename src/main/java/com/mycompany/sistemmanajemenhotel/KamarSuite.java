package com.mycompany.sistemmanajemenhotel;

public class KamarSuite extends Kamar implements DapatDipesan, DapatDinilai {
    private boolean adaJacuzzi;

    public KamarSuite(String nomorKamar, double hargaPerMalam, boolean adaJacuzzi) {
        super(nomorKamar, hargaPerMalam);
        this.adaJacuzzi = adaJacuzzi;
    }

    public boolean isAdaJacuzzi() {
        return this.adaJacuzzi;
    }

    public void setAdaJacuzzi(boolean adaJacuzzi) {
        this.adaJacuzzi = adaJacuzzi;
    }

    @Override
    public void tampilkanInfo() {
        System.out.print("[SUITE]   ");
        super.tampilkanInfo();
        System.out.printf(" | Jacuzzi: %s%n", (this.adaJacuzzi ? "Ada" : "Tidak"));
    }

    @Override
    public void layananKamar() {
        System.out.println("-> Layanan Suite: Layanan kamar 24 jam, pembersihan privat & akses Jacuzzi.");
    }

    @Override
    public void hitungDendaKeterlambatan() {
        System.out.println("-> Denda Keterlambatan Check-out: Rp 150.000 / jam.");
    }

    @Override
    public void prosesPemesanan() {
        System.out.println("-> PROSES PESAN: Kamar Suite dipesan dengan jaminan Deposit VIP.");
    }

    @Override
    public void beriRating(int bintang) {
        System.out.println("-> RATING: Tamu memberikan nilai " + bintang + " / 5 bintang untuk Kamar Suite.");
    }
}