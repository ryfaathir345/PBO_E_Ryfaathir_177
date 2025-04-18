public class Admin extends User {
    private String username ;
    private String password ;

    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    public boolean login(String inputUsername, String inputPassword) {
        return username.equals(inputUsername) && password.equals(inputPassword);
    }

    public void displayInfo() {
        System.out.println("==== Informasi Admin ====");
        System.out.println("Nama: "+getNama());
        System.out.println("Nim: "+getNim());
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }
}
