import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;

class App{
    static List<User> users = new ArrayList<User>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static boolean login = false;
    public static void main(String[] args){
        Menu();
    }

    public static void Menu(){
        System.out.println("==================================");
        System.out.print("\n\t1. Login\n\t2.Register\n\t3.Exit\n\nInput -> ");
        try{
            String input = br.readLine();
            switch(input){
                case "1":
                    Login();
                    break;
                case "2":
                    Register();
                    break;
                case "3":
                    System.exit(0);
                    break;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void Login(){
        System.out.println("------------LOGIN--------------");
        try{
        System.out.print("\nMasukan username -> ");
        String uname = br.readLine();
        System.out.print("\nMasukan password -> ");
        String passwd = br.readLine();
        boolean found = false;
        for(int i = 0; i < users.size(); i++){
            if(uname.equals(users.get(i).getUsername())){
                if(passwd.equals(users.get(i).getPassword())){
                    found = true;
                    login = true;
                    MainMenu(users.get(i));
                    break;
                }else{
                    System.out.println("Password Salah!\n");
                    Menu();
                }
            }
        }

        if(!found){
            System.out.println("Username tidak ditemukan!\n");
            Menu();
        }

        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public static void Register(){
        try{
        System.out.print("\nMasukkan username -> ");
        String uname = br.readLine();
        System.out.print("\nMasukkan password -> ");
        String passwd = br.readLine();

        User newUser = new User(uname,passwd);
        users.add(newUser);
        System.out.println("User registered successfully!");
        Login();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void MainMenu(User user){
        while(login){
        try{
        System.out.println("++++++++++++++++++++++++++++++++++++");
        System.out.println("\n\t1. Masukkan data pelajaran\n\t2. Lihat Nilai Tertinggi\n\t3. Lihat Nilai Terendah\n\t4.Lihat Rata-Rata\n\t5. Lihat Seluruh Mata Pelajaran\n\t6. Logout");
        System.out.print("Pilihan Anda -> ");
        String pilihan = br.readLine();
        switch(pilihan){
            case "1":
                TambahPelajaran(user);
                break;
            case "2":
                System.out.println("\tNama Mapel -> " + user.getTertinggi().getMapel() + "\n\t Nilai -> " + user.getTertinggi().getNilai() + "\n\n");
                break;
            case "3":
                System.out.println("\tNama Mapel -> " + user.getTerendah().getMapel() + "\n\t Nilai -> " + user.getTerendah().getNilai() + "\n\n");
                break;
            case "4":
                System.out.println("\tRata-Rata -> " + user.getRataRata());
                break;
            case "5":
                System.out.println("\n\n");
                user.printPelajaran();
                break;
            case "6":
                login = false;
                Menu();
                break;
        }
        System.out.print("Press enter to continue");
        br.readLine();
        }catch(IOException e){
            e.printStackTrace();
        }
        }
    }

    public static void TambahPelajaran(User user){
        try{
        System.out.println("\nMasukkan nama mapel -> ");
        String mapel = br.readLine();
        System.out.println("\nMasukkan nilai mapel -> ");
        int nilai = Integer.parseInt(br.readLine());
        Pelajaran mapelBaru = new Pelajaran(mapel,nilai);
        user.addPelajaran(mapelBaru);
        }catch(IOException e){
            e.printStackTrace();
        }

    }

}
