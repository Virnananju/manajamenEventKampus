import java.time.LocalDate;

public class Kehadiran {
    private String id;
    private Peserta peserta;
    private Event event;
    private boolean hadir;
    private LocalDate tanggal;

    public Kehadiran(String id, Peserta peserta, Event event, boolean hadir) {
        this.id = id;
        this.peserta = peserta;
        this.event = event;
        this.hadir = hadir;
        this.tanggal = LocalDate.now();
    }

    public Event getEvent() { return event; }
    public Peserta getPeserta() { return peserta; }
    public boolean isHadir() { return hadir; }

    public void lihatData() {
        System.out.println("[" + (hadir? "HADIR" : "TIDAK") + "] ID=" + id + ", Peserta=" + peserta.getNama() + ", Event=" + event.getNama() + ", Tanggal=" + tanggal);
    }
}
