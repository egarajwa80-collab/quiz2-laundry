package id.ac.polinema.quiz2;

import java.util.ArrayList;
import java.util.List;

/**
 * Tempat bebas untuk mencoba programmu. Kelas ini TIDAK dinilai.
 *
 * Ide percobaan (tulis sendiri setelah tiap tahap selesai):
 *  1. Buat satu Customer, lalu coba ubah namanya.
 *  2. Buat satu RegularLaundry dan satu ExpressLaundry, lalu tampilkan harga-nya.
 *  3. Masukkan keduanya ke OrderCalculator.totalPrice(...) lewat sebuah List.
 *  4. Buat LaundryDesk dengan new ConsoleReceiptPrinter(), tambahkan pesanan laundry, lalu panggil checkout(...).
 *
 * Jalankan lewat NetBeans (Run Project), VS Code (Run di atas main),
 * atau terminal: mvn -q compile exec:java
 */
public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer("C1", "Budi");
        LaundryOrder regular = new RegularLaundry("L1", customer, 5);
        LaundryOrder express = new ExpressLaundry("L2", customer, 5);

        System.out.println("Harga reguler: Rp " + regular.calculatePrice());
        System.out.println("Harga ekspres: Rp " + express.calculatePrice());

        List<LaundryOrder> orders = new ArrayList<>();
        orders.add(regular);
        orders.add(express);
        System.out.println("Total harga: Rp " + OrderCalculator.totalPrice(orders));
        System.out.println("Total biaya antar-jemput: Rp " + OrderCalculator.totalDelivery(orders));

        LaundryDesk desk = new LaundryDesk(new ConsoleReceiptPrinter());
        desk.add(regular);
        desk.add(express);
        desk.checkout("L1");
        desk.checkout("L2");
    }
}
