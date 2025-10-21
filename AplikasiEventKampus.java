import java.util.ArrayList;
import java.util.Scanner;

public class AplikasiEventKampus {
    private ArrayList<Event> daftarEvent = new ArrayList<>();
    private ArrayList<Panitia> daftarPanitia = new ArrayList<>();
    private ArrayList<Peserta> daftarPeserta = new ArrayList<>();
    private ArrayList<Kehadiran> daftarKehadiran = new ArrayList<>();
    private Admin adminAktif;

    public void inisialisasiData() {
        // admin default
        adminAktif = new Admin("A1", "Administrator", "admin", "pass");
        // contoh panitia
        daftarPanitia.add(new Panitia("P1", "Virna Nanju Fernanda", "virna", "virna123", "Ketua"));
        daftarPanitia.add(new Panitia("P2", "Nebula Amora", "nebula", "nebula123", "Sekretaris"));
        // contoh event
        daftarEvent.add(new Event("E1", "Seminar Teknologi", "20-10-2025", "Pleno", "Seminar teknologi modern", "P1"));
        daftarEvent.add(new Event("E2", "Workshop UI/UX", "25-11-2025", "RKA", "Workshop UI/UX", "P2"));
        // contoh peserta
        daftarPeserta.add(new Peserta("PS1", "Andi", "andi@gmail.com", "E1"));
        daftarPeserta.add(new Peserta("PS2", "Rina", "rina@gmail.com", "E2"));
    }

    public boolean loginAdmin(String username, String password) {
        if (adminAktif != null && adminAktif.login(username, password)) return true;
        return false;
    }

    // ---------- Event ----------
    public void kelolaEvent(Scanner sc) {
        System.out.println("Opsi Event: 1. Tambah Data  2. Lihat Data");
        int opsi = safeNextInt(sc);
        sc.nextLine();
        if (opsi == 1) {
            System.out.print("ID Event: "); String id = sc.nextLine();
            if (cariEvent(id) != null) { System.out.println("ID event sudah ada."); return; }
            System.out.print("Nama Event: "); String nama = sc.nextLine();
            System.out.print("Tanggal (dd-MM-yyyy): "); String tgl = sc.nextLine();
            System.out.print("Lokasi: "); String lokasi = sc.nextLine();
            System.out.print("Deskripsi: "); String desk = sc.nextLine();
            System.out.print("ID Panitia Penanggung Jawab (kosong boleh): "); String panitiaId = sc.nextLine();
            if (panitiaId.trim().isEmpty()) panitiaId = null;
            daftarEvent.add(new Event(id, nama, tgl, lokasi, desk, panitiaId));
            System.out.println("Event berhasil ditambahkan.");
        } else if (opsi == 2) {
            System.out.println("Daftar Event:");
            for (Event e : daftarEvent) e.lihatData();
        } else System.out.println("Opsi tidak valid.");
    }

    private Event cariEvent(String id) {
        for (Event e : daftarEvent) if (e.getId().equals(id)) return e;
        return null;
    }

    // ---------- Panitia ----------
    public void kelolaPanitia(Scanner sc) {
        System.out.println("Opsi Panitia: 1. Tambah Data  2. Lihat Data");
        int opsi = safeNextInt(sc);
        sc.nextLine();
        if (opsi == 1) {
            System.out.print("ID Panitia: "); String id = sc.nextLine();
            if (cariPanitia(id) != null) { System.out.println("ID panitia sudah ada."); return; }
            System.out.print("Nama Panitia: "); String nama = sc.nextLine();
            System.out.print("Username: "); String user = sc.nextLine();
            System.out.print("Password: "); String pass = sc.nextLine();
            System.out.print("Jabatan: "); String jab = sc.nextLine();
            Panitia p = new Panitia(id, nama, user, pass, jab);
            daftarPanitia.add(p);
            System.out.println("Panitia berhasil ditambahkan.");
        } else if (opsi == 2) {
            System.out.println("Daftar Panitia:");
            for (Panitia p : daftarPanitia) p.lihatData();
        } else System.out.println("Opsi tidak valid.");
    }

    private Panitia cariPanitia(String id) {
        for (Panitia p : daftarPanitia) if (p.getId().equals(id)) return p;
        return null;
    }

    // ---------- Peserta ----------
    public void kelolaPeserta(Scanner sc) {
        System.out.println("Opsi Peserta: 1. Tambah Data  2. Lihat Data");
        int opsi = safeNextInt(sc);
        sc.nextLine();
        if (opsi == 1) {
            System.out.print("ID Peserta: "); String id = sc.nextLine();
            if (cariPeserta(id) != null) { System.out.println("ID peserta sudah ada."); return; }
            System.out.print("Nama Peserta: "); String nama = sc.nextLine();
            System.out.print("Email: "); String email = sc.nextLine();
            System.out.print("ID Event: "); String idEvent = sc.nextLine();
            Event ev = cariEvent(idEvent);
            if (ev == null) { System.out.println("Event tidak ditemukan."); return; }
            Peserta ps = new Peserta(id, nama, email, idEvent);
            daftarPeserta.add(ps);
            System.out.println("Peserta berhasil ditambahkan.");
        } else if (opsi == 2) {
            System.out.println("Daftar Peserta:");
            for (Peserta ps : daftarPeserta) ps.lihatData();
        } else System.out.println("Opsi tidak valid.");
    }

    private Peserta cariPeserta(String id) {
        for (Peserta p : daftarPeserta) if (p.getId().equals(id)) return p;
        return null;
    }

    // ---------- Kehadiran ----------
    public void kelolaKehadiran(Scanner sc) {
        System.out.println("Catat Kehadiran - Masukkan ID Peserta:");
        System.out.print("ID Peserta: "); String idPeserta = sc.nextLine();
        Peserta ps = cariPeserta(idPeserta);
        if (ps == null) { System.out.println("Peserta tidak ditemukan."); return; }
        Event ev = cariEvent(ps.getEventId());
        if (ev == null) { System.out.println("Event peserta tidak ditemukan."); return; }
        System.out.print("Apakah hadir? (y/n): "); String jaw = sc.nextLine();
        boolean hadir = jaw.equalsIgnoreCase("y");
        String idK = "K" + (daftarKehadiran.size() + 1);
        Kehadiran k = new Kehadiran(idK, ps, ev, hadir);
        daftarKehadiran.add(k);
        System.out.println("Kehadiran dicatat.");
    }

    public void laporanKehadiran() {
        System.out.println("=== Laporan Kehadiran ===");
        for (Event e : daftarEvent) {
            long total = daftarPeserta.stream().filter(p -> e.getId().equals(p.getEventId())).count();
            long hadir = daftarKehadiran.stream().filter(k -> k.getEvent().getId().equals(e.getId()) && k.isHadir()).count();
            System.out.println(e.getNama() + " (ID=" + e.getId() + ") - Hadir: " + hadir + " / " + total);
        }
    }

    // ---------- Utility ----------
    private int safeNextInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            sc.nextLine();
            System.out.print("Masukkan angka: ");
        }
        return sc.nextInt();
    }
}
