package com.mycompany.sistemmanajemenhotel;

public class KamarReguler extends Kamar {
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
}