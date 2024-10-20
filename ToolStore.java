
public class ToolStore extends NormalLocation {
    ToolStore(Player player){
        super(player,"Mağaza");
         }
    public boolean getLocation(){
     System.out.println("Para : "+player.getMoney());
     System.out.println("1.Silahlar");
     System.out.println("2.Zırhlar");
     System.out.println("3.Çıkış");
     System.out.println("Seçiminiz: ");
     int selTool = scan.nextInt();
     int selItemID;
     switch(selTool){
        case 1:
         selItemID = weaponMenu();
         buyWeapon(selItemID);
        break;
        case 2:
        selItemID = armorMenu();
        buyArmor(selItemID);
        break;
        default:
        break;
     }
       return true;
    }
public int armorMenu(){
  System.out.println("1.Hafif Zırh --> Para : 15 | Engelleme : 1");
  System.out.println("2.Orta Zırh --> Para : 25 | Engelleme : 3");
  System.out.println("3.Ağır Zırh --> Para : 40 | Engelleme : 5");
  System.out.println("4.Çıkış.");
  System.out.println("Zırh seçiniz : ");
  int selArmorID=scan.nextInt();
  return selArmorID;
}
public void buyArmor(int itemID){
 int price=0;
 int avoid=0;
 String aName=null;
 switch(itemID){
   case 1:
   aName="Hafif Zırh";
   price=15;
   avoid=1;
   break;
   case 2:
   aName="Orta Zırh";
   price=25;
   avoid=3;
   break;
   case 3:
   aName="Ağır zırh";
   price=40;
   avoid=5;
   break;
   case 4:
            System.out.println("Çıkış Yapılıyor.");
            break;
   default:
   System.out.println("Geçersiz İşlem !");
   break;
 }
 if(price > 0){
  if(player.getMoney() > price){
    player.getInv().setArmor(avoid);
    player.getInv().setaName(aName);
    player.setMoney(player.getMoney()-price);
    System.out.println(aName+" satın aldınız,Engellenen Hasar :"+ player.getInv().getArmor());
    System.out.println("Kalan Para: "+player.getMoney());
  }else {
      System.out.println("Para yetersiz !");
    }
  }
 }

 public int weaponMenu(){
    System.out.println("1.Tabanca --> Para : 25 | Hasar : 2");
    System.out.println("2.Kılıç --> Para : 35 | Hasar : 3");
    System.out.println("3.Tüfek --> Para : 45 | Hasar : 7");
    System.out.println("4.Çıkış.");
    System.out.println("Silah seçiniz : ");
    int selWeaponID=scan.nextInt();
    return selWeaponID;
}


public void buyWeapon(int itemID){
    int damage=0;
    int price=0;
    String wName=null;
     switch(itemID){
            case 1:
            damage=2;
            wName="Tabanca";
            price=25;
            break;
            case 2:
            damage=3;
            wName="Kılıç";
            price=35;
            break;
            case 3:
            damage=7;
            wName="Tüfek";
            price=45;
            break;
            case 4:
            System.out.println("Çıkış Yapılıyor.");
            break;
            default:
            System.out.println("Geçersiz İşlem !");
            break;
        }
        if(price > 0){
          if(player.getMoney()> price){
            player.getInv().setDamage(damage);
            player.getInv().setwName(wName);
            player.setMoney(player.getMoney()- price);
            System.out.println(wName+" satın aldınız,Önceki hasar : "+(player.getDamage() + ", Yeni hasar : "+player.getTotalDamage()));
          }else{
            System.out.println("Bakiye Yetersiz !");
          }
          
      }
   }
}