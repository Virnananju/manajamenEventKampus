import java.util.Scanner;

public class Admin extends Pengguna {

    public Admin(String id, String nama, String username, String password) {
        super(id, nama, username, password);
    }

    public boolean login(String user, String pass) {
        return this.username.equals(user) && this.password.equals(pass);
    }

    @Override
    public void tambahData(Scanner scanner) {
        System.out.println("Admin: ID=" + id + ", Nama=" + nama + ", Username=" + username);
    }

    @Override
    public void lihatData() {
        System.out.println("Admin: ID=" + id + ", Nama=" + nama + ", Username=" + username);
    }
}
