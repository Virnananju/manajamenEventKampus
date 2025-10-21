public class Event {
    private String id;
    private String nama;
    private String tanggal; // format bebas, mis. dd-MM-yyyy
    private String lokasi;
    private String deskripsi;
    private String panitiaId; // id panitia penanggung jawab

    public Event(String id, String nama, String tanggal, String lokasi, String deskripsi, String panitiaId) {
        this.id = id;
        this.nama = nama;
        this.tanggal = tanggal;
        this.lokasi = lokasi;
        this.deskripsi = deskripsi;
        this.panitiaId = panitiaId;
    }

    public String getId() { return id; }
    public String getNama() { return nama; }
    public String getPanitiaId() { return panitiaId; }

    public void lihatData() {
        System.out.println("ID=" + id + ", Nama=" + nama + ", Tanggal=" + tanggal + ", Lokasi=" + lokasi + ", Panitia=" + (panitiaId==null? "-" : panitiaId));
        System.out.println("  Deskripsi: " + deskripsi);
    }
}
