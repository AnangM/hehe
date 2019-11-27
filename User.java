import java.util.List;
import java.util.ArrayList;

class User{
    String username;
    String password;
    List<Pelajaran> pelajaran = new ArrayList<Pelajaran>();

    public User(String uname,String passwd){
        this.username = uname;
        this.password = passwd;
    }

    public void addPelajaran(Pelajaran pel){
        if(pelajaran.size() <= 7){
            pelajaran.add(pel);
        }else{
            System.out.println("Error: Daftar pelajaran sudah penuh");
        }
    }

    public Pelajaran getTertinggi(){
        Pelajaran highest = pelajaran.get(0);
        for(int i = 0; i < pelajaran.size(); i++){
            if(highest.getNilai() < pelajaran.get(i).getNilai()){
                highest = pelajaran.get(i);
            }
        }

        return highest;
    }

    public Pelajaran getTerendah(){
        Pelajaran lowest = pelajaran.get(0);
        for(int i = 0; i < pelajaran.size(); i++){
            if(lowest.getNilai() > pelajaran.get(i).getNilai()){
                lowest = pelajaran.get(i);
            }
        }

        return lowest;
    }

    public Double getRataRata(){
        int total = 0;
        for(int i = 0; i < pelajaran.size(); i++){
            total += pelajaran.get(i).getNilai();
        }

        Double rataRata = (Double.valueOf(total) /pelajaran.size());

        return rataRata;
    }

    public void printPelajaran(){
        for(int i = 0; i < pelajaran.size(); i++){
            System.out.println("Pelajaran " + pelajaran.get(i).getMapel() + ", Nilai " + pelajaran.get(i).getNilai());
        }
    }
}