import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    Player player;
    Location location;
    Scanner scan=new Scanner(System.in);
    public void login(){
        String k_adi,parola;
        System.out.println("Kullanici Adi: ");
        k_adi=scan.nextLine();
        System.out.println("Parola: ");
        parola=scan.nextLine();
        if(k_adi.equals("semih123")&&parola.equals("admin123")){
            System.out.println("Oyuna Hosgeldiniz !");
            System.out.println("Oyuna başlamadan önce nickinizi giriniz : ");
        String playerName=scan.nextLine();
        player= new Player(playerName);
        player.selectCha();
        }
        else{
            System.out.println("Kullanıcı adınız veya sifrenizi yanlis girdiniz !");
         }
        start();

    }
    public void start(){
        
        while(true){
            System.out.println("");
        System.out.println("=====================================================================");
        System.out.println("");
        System.out.println("Eylem gerçekleştirmek için yer seçiniz.");
        System.out.println("1-Güvenli Ev ---> Size ait , can yenileyebildiğiniz güvenli bir mekan.");
        System.out.println("2-Mağara --->Karşınıza zombilerin çıkabileceği bir mekan.");
        System.out.println("3-Orman --->Karşınıza zombilerin çıkabileceği bir mekan.");
        System.out.println("4-Nehir --->Karşınıza zombilerin çıkabileceği bir mekan.");
        System.out.println("5-Mağaza --->Silah ve Zırh alabileceğiniz bir mekan.");
        int selLoc = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Seçiminiz: ");
                selLoc = scan.nextInt(); // Rakam dışında bir şey girilirse hata fırlatır
                if (selLoc < 1 || selLoc > 5) {
                    System.out.println("Lütfen 1-5 arası geçerli bir seçim yapınız!");
                } else {
                    validInput = true; // Geçerli bir seçim yapıldıysa döngüden çık
                }
            } catch (InputMismatchException e) {
                // Eğer kullanıcı rakam dışı bir şey girdiyse burası çalışır
                System.out.println("Geçersiz giriş! Lütfen 1-5 arası bir rakam giriniz.");
                scan.nextLine(); // Scanner'daki geçersiz girdiyi temizle
            }
        }
        switch(selLoc){
        case 1:
        location= new SafeHouse(player);
           break;
           case 2:
           location= new Cave(player);
           break;
           case 3:
           location= new Forest(player);
           break;
           case 4:
           location= new River(player);
           break;
           case 5:
           location=new ToolStore(player);
           break;
        default:
        location= new SafeHouse(player);
    }
    if(location.getClass().getName().equals("SafeHouse")){
        if(player.getInv().isFirewood() && player.getInv().isFood() && player.getInv().isWater()){
            System.out.println("Tebrikler Oyunu Kazandınız !!");
            break;
        }
    }
    if(!location.getLocation()){
        System.out.println("Oyun bitti.");
        break;
    }
        }
    }
    
}
