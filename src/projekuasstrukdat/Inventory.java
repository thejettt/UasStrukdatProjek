package projekuasstrukdat;

import java.util.Arrays;

public class Inventory {

    private Barang[] inventory;
    private int size;
    private int maxSize;

    public Inventory(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        inventory = new Barang[this.maxSize + 1];
    }

    public Inventory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private void swap(int fpos, int spos) {
        Barang tmp = inventory[fpos];
        inventory[fpos] = inventory[spos];
        inventory[spos] = tmp;
    }

    public void insertBarang(Barang barang) {
        if (size >= maxSize) {
            System.out.println("Inventory sudah penuh");
            return;
        }
        size++;
        int current = size;
        inventory[current] = barang;

        while (current > 1 && inventory[current].getJumlahBarang() > inventory[parent(current)].getJumlahBarang()) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public Barang removeBarang(int idBarang, int jumlahKeluar) {
        if (size == 0) {
            System.out.println("Inventory kosong");
            return null;
        }

        for (int i = 1; i <= size; i++) {
            if (inventory[i] != null && inventory[i].getIdBarang() == idBarang) {
                if (inventory[i].getJumlahBarang() >= jumlahKeluar) {
                    inventory[i].setJumlahBarang(inventory[i].getJumlahBarang() - jumlahKeluar);
                    Barang barangKeluar = inventory[i];
                    maxHeapify(i);
                    return barangKeluar;
                } else {
                    System.out.println("Jumlah barang tidak mencukupi untuk pengeluaran.");
                    return null;
                }
            }
        }
        System.out.println("Barang dengan ID tersebut tidak ditemukan.");
        return null;
    }

    public Barang[] getAllSortedBarang() {
        if (size == 0) {
            System.out.println("Inventori kosong");
            return new Barang[0]; // Mengembalikan array kosong jika inventori kosong
        }

        Barang[] sortedInventory = Arrays.copyOfRange(inventory, 1, size + 1);
        bubbleSortByID(sortedInventory); // Panggil metode bubble sort

        return sortedInventory;
    }
    private void bubbleSortByID(Barang[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j].getIdBarang() > arr[j + 1].getIdBarang()) {
                // Tukar elemen jika ID Barang lebih besar
                Barang temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

    private void maxHeapify(int pos) {
        int left = leftChild(pos);
        int right = rightChild(pos);
        int largest = pos;

        if (left <= size && inventory[left].getJumlahBarang() > inventory[largest].getJumlahBarang()) {
            largest = left;
        }

        if (right <= size && inventory[right].getJumlahBarang() > inventory[largest].getJumlahBarang()) {
            largest = right;
        }

        if (largest != pos) {
            swap(pos, largest);
            maxHeapify(largest);
        }
    }

    private void heapify(Barang[] arr, int n, int i) {
        int largest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < n && arr[left] != null && arr[left].getJumlahBarang() > arr[largest].getJumlahBarang()) {
            largest = left;
        }

        if (right < n && arr[right] != null && arr[right].getJumlahBarang() > arr[largest].getJumlahBarang()) {
            largest = right;
        }

        if (largest != i) {
            Barang temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    private void minHeapSort(Barang[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(0, i);
            heapify(arr, i, 0);
        }
    }

    public Barang kurangiJumlahBarang(int parseInt, int jumlahBarangKeluar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Barang removeBarang(int parseInt, int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
