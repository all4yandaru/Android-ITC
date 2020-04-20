public class Main {

    public static void main(String[] args) {
        /*
        Mahasiswa daru = new Mahasiswa("Daru gtg", "123180999", 4.5);

        daru.nama = "Daru";
        daru.nim = "123180054";
        daru.ipk = 4.2;

        System.out.println("Nama = " + daru.nama);
        System.out.println("NIM = " + daru.nim);
        System.out.println("IPK = " + daru.ipk);
        */

        System.out.println("\n==========================================");

        Manusia manusia = new Manusia("Allyandaru");
        Mahasiswa darulagi = new Mahasiswa("Daru", "123180054", 4.1);
        darulagi.noKTP = "xxxxxx2507000002";
        System.out.println("Nama = " + darulagi.getNama());
        System.out.println("No KTP = " + darulagi.noKTP);
        System.out.println("NIM = " + darulagi.getNim());
        System.out.println("IPK = " + darulagi.getIpk());
        darulagi.doTugas();
        darulagi.belajar();
        darulagi.Bernada();
        darulagi.Berjoget("Jamet");

        System.out.println("==========================================");


    }
}
