import java.util.Scanner;
import java.util.InputMismatchException;
public class Player {
    private int damage,healthy,money,rHealthy;
    private String name,cName;
    private Inventory inv;
    Scanner scan =new Scanner(System.in);
     public Player(String name) {
        this.name = name;
        this.inv=new Inventory();
    }
    public void selectCha(){
        switch(chaMenu()){
            case 1:
            initPlayer("Samuray",5,21 ,15);
            break;
            case 2:
            initPlayer("Okçu",7,18 ,20);
            break;
            case 3:
            initPlayer("Şövalye",9,24 ,9);
            break;
            default:
            initPlayer("Samuray",5,21 ,15);
            break;
        }
        System.out.println("Karakteriniz "+getcName()+" basarılı bir sekilde oluşturuldu.");
    }
    public int chaMenu() {
        int chaID = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Lütfen bir karakter seçiniz: ");
            System.out.println("Tür 1->Samuray |Hasar: 5 |Sağlık: 21 |Para: 15");
            System.out.println("Tür 2->Okçu |Hasar: 7 |Sağlık: 18 |Para: 20");
            System.out.println("Tür 3->Şövalye |Hasar: 9 |Sağlık: 24 |Para: 9");
            System.out.print("Karakter Seçiminiz: ");

            try {
                chaID = scan.nextInt();
                if (chaID >= 1 && chaID <= 3) {
                    validInput = true; 
                } else {
                    System.out.println("Lütfen 1-3 arası geçerli bir karakter seçiniz!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Geçersiz giriş! Lütfen bir sayı giriniz.");
                scan.nextLine(); 
            }
        }

        return chaID;
    }
    public int getTotalDamage(){
        return this.getDamage()+this.inv.getDamage();
    }
    public void initPlayer(String cName , int dmg, int heal,int mny){
        setcName(cName);
        setDamage(dmg);
        setHealthy(heal);
        setMoney(mny);
        setrHealthy(heal);
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getHealthy() {
        return healthy;
    }
    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getcName() {
        return cName;
    }
    public void setcName(String cName) {
        this.cName = cName;
    }
    public Inventory getInv() {
        return inv;
    }
    public void setInv(Inventory inv) {
        this.inv = inv;
    }
    public int getrHealthy() {
        return rHealthy;
    }
    public void setrHealthy(int rHealthy) {
        this.rHealthy = rHealthy;
    }
}