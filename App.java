import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class App{
    public static void main(String[] args){
        User user = new User("Budi","qwerty");
        Pelajaran mtk = new Pelajaran("Matematika",80);
        Pelajaran ipa = new Pelajaran("IPA",70);
        user.addPelajaran(mtk);
        user.addPelajaran(ipa);
        System.out.println("Highest -> " + user.getTertinggi().getNilai());
        System.out.println("Lowest -> " + user.getTerendah().getNilai());
        System.out.println("Average -> " + user.getRataRata());

        user.printPelajaran();
        
    }
}
