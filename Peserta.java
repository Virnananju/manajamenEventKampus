public class Peserta extends Pengguna {
    private String email;
    private String eventId; // event yang diikuti

    // Peserta tidak perlu username/password, tapi kita gunakan pengisian kosong agar turunan Pengguna terpenuhi
    public Peserta(String id, String nama, String email, String eventId) {
        super(id, nama, "", "");
        this.email = email;
        this.eventId = eventId;
    }

    public String getEmail() { return email; }
    public String getEventId() { return eventId; }

    @Override
    public void tambahData(java.util.Scanner scanner) {
        System.out.println("Tambah Peserta: ID=" + id + ", Nama=" + nama + ", Email=" + email + ", EventID=" + eventId);
    }

    @Override
    public void lihatData() {
        System.out.println("ID=" + id + ", Nama=" + nama + ", Email=" + email + ", EventID=" + eventId);
    }
}
