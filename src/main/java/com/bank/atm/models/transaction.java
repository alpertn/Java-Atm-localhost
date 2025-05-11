package com.bank.atm.models;

import java.time.LocalDateTime;

public class transaction {
    private Long id;
    private String gondereniban;
    private String gonderileniban;
    private double bakiye;
    private LocalDateTime transfervtarihi;

    public transaction() {}

    public transaction(Long id, String gondereniban, String gonderileniban, double bakiye) {
        this.id = id;
        this.gondereniban = gondereniban;
        this.gonderileniban = gonderileniban;
        this.bakiye = bakiye;
        this.transfervtarihi = LocalDateTime.now();
    }

    public Long cek_id() {
        return id;
    }

    public void belirle_id(Long id) {
        this.id = id;
    }

    public String cek_gondereniban() {
        return gondereniban;
    }

    public void belirle_gondereniban(String geleniban) {
        this.gondereniban = geleniban;
    }

    public String cek_gonderilen() {
        return gonderileniban;
    }

    public void belirle_gonderileniban(String gonderileniban) {
        this.gonderileniban = gonderileniban;
    }

    public double cek_bakiye() {
        return bakiye;
    }

    public void belirle_bakiye(double bakiye) {
        this.bakiye = bakiye;
    }

    public LocalDateTime cek_transvertarihi() {
        return transfervtarihi;
    }

    public void belirle_transfertarihi(LocalDateTime transfervtarihi) {
        this.transfervtarihi = transfervtarihi;
    }
}
