import java.util.Scanner;

public class Panitia extends Pengguna {
    private String jabatan;

    public Panitia(String id, String nama, String username, String password, String jabatan) {
        super(id, nama, username, password);
        this.jabatan = jabatan;
    }

    public String getJabatan() { return jabatan; }

    @Override
    public void tambahData(Scanner scanner) {
        System.out.println("Tambah Panitia: ID=" + id + ", Nama=" + nama + ", Jabatan=" + jabatan);
    }

    @Override
    public void lihatData() {
        System.out.println("ID=" + id + ", Nama=" + nama + ", Jabatan=" + jabatan + ", Username=" + username);
    }
}
