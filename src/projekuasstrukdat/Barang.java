package projekuasstrukdat;

import java.util.Date;

public class Barang {
    private int idBarang;
    private String namaBarang;
    private Date tanggalMasuk;
    private int jumlahBarang;

    public Barang(int idBarang, String namaBarang, Date tanggalMasuk, int jumlahBarang){
        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
        this.tanggalMasuk = tanggalMasuk;
        this.jumlahBarang = jumlahBarang;
    }

    public int getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(int idBarang) {
        this.idBarang = idBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public Date getTanggalMasuk() {
        return tanggalMasuk;
    }

    public void setTanggalMasuk(Date tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }

    public int getJumlahBarang() {
        return jumlahBarang;
    }

    public void setJumlahBarang(int jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }
    
}
