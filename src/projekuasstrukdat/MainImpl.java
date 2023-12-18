package projekuasstrukdat;

import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MainImpl {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory(100);

        boolean exit = false;
        while (!exit) {
            System.out.println("\nPilihan:");
            System.out.println("1. Barang Masuk");
            System.out.println("2. Barang Keluar");
            System.out.println("3. Tampilkan keseluruhan barang");
            System.out.println("x. Keluar");
            System.out.print("Pilihan: ");

            String choice = scanner.next();

            switch (choice) {
                case "1":
                    System.out.println("Masukkan id barang: ");
                    int id = scanner.nextInt();
                    System.out.println("Masukkan nama barang: ");
                    String nama = scanner.next();
                    System.out.println("Masukkan tanggal masuk: ");//(dd-mm-yyyy)
                    String tanggalString = scanner.next();
                    Date tanggal = null;
                    try {
                        tanggal = new SimpleDateFormat("dd-MM-yyyy").parse(tanggalString);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Masukkan jumlah barang: ");
                    int jumlah = scanner.nextInt();

                    Barang barangBaru = new Barang(id, nama, tanggal, jumlah);
                    inventory.insertBarang(barangBaru);
                    System.out.println("Barang berhasil dimasukkan ke dalam inventori.");
                    break;
                case "2":
                    System.out.println("Masukkan ID barang yang akan dikeluarkan: ");
                    int idBarangKeluar = scanner.nextInt();
                    System.out.println("Masukkan jumlah barang yang ingin dikeluarkan: ");
                    int jumlahKeluar = scanner.nextInt();

                    Barang barangKeluar = inventory.removeBarang(idBarangKeluar, jumlahKeluar);
                    if (barangKeluar != null) {
                        System.out.println("Barang keluar dari inventori: " + barangKeluar.getNamaBarang());
                    }
                    break;
                case "3":
                    Barang[] sortedBarang = inventory.getAllSortedBarang();

                    for (Barang barang : sortedBarang) {
                        System.out.println("ID: " + barang.getIdBarang()
                                + ", Nama: " + barang.getNamaBarang()
                                + ", Tanggal Masuk: " + barang.getTanggalMasuk()
                                + ", Jumlah: " + barang.getJumlahBarang());
                    }
                    break;
                case "x":
                    exit = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih menu yang benar.");
            }
        }
    }

}
