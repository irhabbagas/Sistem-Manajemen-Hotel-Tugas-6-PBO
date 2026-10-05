package com.mycompany.sistemmanajemenhotel;

public class KamarSuite extends Kamar {
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
}