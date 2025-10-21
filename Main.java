import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AplikasiEventKampus app = new AplikasiEventKampus();
        app.inisialisasiData();

        boolean login = false;
        while (!login) {
            System.out.println("=== LOGIN ADMIN ===");
            System.out.print("Username: "); String u = sc.nextLine();
            System.out.print("Password: "); String p = sc.nextLine();
            if (app.loginAdmin(u, p)) {
                login = true;
                System.out.println("Login berhasil!\n");
            } else {
                System.out.println("Login gagal. Coba lagi.\n");
            }
        }

        boolean running = true;
        while (running) {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Kelola Event");
            System.out.println("2. Kelola Panitia");
            System.out.println("3. Kelola Peserta");
            System.out.println("4. Catat Kehadiran Peserta");
            System.out.println("5. Lihat Laporan Kehadiran");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            String raw = sc.nextLine();
            int pilihan;
            try { pilihan = Integer.parseInt(raw); } catch (Exception e) { pilihan = -1; }

            switch (pilihan) {
                case 1 -> app.kelolaEvent(sc);
                case 2 -> app.kelolaPanitia(sc);
                case 3 -> app.kelolaPeserta(sc);
                case 4 -> app.kelolaKehadiran(sc);
                case 5 -> app.laporanKehadiran();
                case 6 -> running = false;
                default -> System.out.println("Pilihan tidak valid.");
            }
        }

        System.out.println("Terima kasih. Aplikasi selesai.");
        sc.close();
    }
}
