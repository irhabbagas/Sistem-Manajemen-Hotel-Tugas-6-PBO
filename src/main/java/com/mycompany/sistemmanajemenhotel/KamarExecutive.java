package com.mycompany.sistemmanajemenhotel;

public class KamarExecutive extends Kamar {
    private String fasilitasBisnis;

    public KamarExecutive(String nomorKamar, double hargaPerMalam, String fasilitasBisnis) {
        super(nomorKamar, hargaPerMalam);
        this.fasilitasBisnis = fasilitasBisnis;
    }

    public String getFasilitasBisnis() {
        return this.fasilitasBisnis;
    }

    public void setFasilitasBisnis(String fasilitasBisnis) {
        this.fasilitasBisnis = fasilitasBisnis;
    }

    @Override
    public void tampilkanInfo() {
        System.out.print("[EXECUTIVE]");
        super.tampilkanInfo();
        System.out.printf(" | Fasilitas Bisnis: %s%n", this.fasilitasBisnis);
    }

    @Override
    public void layananKamar() {
        System.out.println("-> Layanan Executive: Akses Ruang Rapat, Antar-Jemput Bandara & Butler Pribadi.");
    }
}