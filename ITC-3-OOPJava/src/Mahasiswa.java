public class Mahasiswa extends Manusia implements Bernyanyi{
    private String nim;
    private double ipk;

    public Mahasiswa(String nama, String nim, double ipk) {
        super(nama);
        this.nim = nim;
        this.ipk = ipk;
    }

    void belajar(){
        System.out.println("sedang belajar");
    }

    void doTugas(){
        System.out.println("ngerjain tugas");
    }

    public String getNama() {
        return super.nama;
    }

    public void setNama(String nama) {
        super.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public double getIpk() {
        return ipk;
    }

    public void setIpk(double ipk) {
        this.ipk = ipk;
    }

    @Override
    public void Bernada() {
        System.out.println(super.nama + " sedang bernyanyi");
    }

    @Override
    public void Berjoget(String gerakan) {
        System.out.println(super.nama + " lagi joget " + gerakan);
    }
}
