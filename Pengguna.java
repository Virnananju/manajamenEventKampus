import java.util.Scanner;

public abstract class Pengguna {
    protected String id;
    protected String nama;
    protected String username;
    protected String password;

    public Pengguna(String id, String nama, String username, String password) {
        this.id = id;
        this.nama = nama;
        this.username = username;
        this.password = password;
    }

    public String getId() { return id; }
    public String getNama() { return nama; }
    public String getUsername() { return username; }

    public abstract void tambahData(Scanner scanner);
    public abstract void lihatData();
}