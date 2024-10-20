

public abstract class BattleLoc extends Location{
    protected Obstacle obstacle;
    protected String award;
    BattleLoc(Player player,String name,Obstacle obstacle,String award){
        super(player);
        this.name=name;
        this.obstacle=obstacle;
        this.award=award;
    }
    public boolean getLocation(){
        int obsCount = obstacle.count();
        System.out.println("Şu an buradasınız: "+" "+this.getName());
        System.out.println("Dikkatli ol!Burada "+ obsCount+ " tane "+ " "+obstacle.getName()+" yaşıyor.");
        System.out.println("<S>avaş veya <k>aç: ");
        String selCase=scan.nextLine();
        if(selCase.equalsIgnoreCase("S")){
            if(combat(obsCount)){
                System.out.println(this.getName()+" Bölgesindeki tüm canavarları temizlediniz.");
                if(this.award.equals("Yemek")&& player.getInv().isFood()==false){
                    System.out.println(this.award+" Kazandınız !");
                    player.getInv().setFood(true);
                }else if(this.award.equals("Su") && player.getInv().isWater()==false){
                  System.out.println(this.award +" Kazandınız !");
                  player.getInv().setWater(true);
                }
                else if(this.award.equals("Odun")&& player.getInv().isFirewood()==false){
                    System.out.println(this.award +" Kazandınız !");
                    player.getInv().setFirewood(true);
                }
                return true;
            }if(player.getHealthy()<=0){
                System.out.println("Öldünüz !");
                return false;
            }
            }
        
        return true;
    }
    public boolean combat(int obsCount){
        for(int i=0 ; i < obsCount ; i++){
            int defObsHealth = obstacle.getHealth();
            playerStats();
            enemyStats();
            while(player.getHealthy() > 0 && obstacle.getHealth() > 0){
                System.out.println("<V>ur veya <k>aç");
                String selCase = scan.nextLine();
                if(selCase.equalsIgnoreCase("V")){
                    System.out.println("Vuruş gerçekleştirildi !!");
                    obstacle.setHealth(obstacle.getHealth()-player.getTotalDamage());
                    afterHit();
                     if(obstacle.getHealth() >0 ){
                    System.out.println();
                    System.out.println("Canavar size vurdu !");
                    player.setHealthy(player.getHealthy()-(obstacle.getDamage()-player.getInv().getArmor()));
                    afterHit();
                    }
                }else {
                    break;
                }

            }
            if(obstacle.getHealth() <= 0 && player.getHealthy() > 0 ){
                System.out.println("Düşmanı yendiniz !");
                player.setMoney(player.getMoney()+obstacle.getAward());
                System.out.println("Güncel paranız :"+player.getMoney());
                obstacle.setHealth(defObsHealth);
            
            }else{
                return false;
            }
            System.out.println("-----S----------S--------S----");
        }
        return true;
    }
    public void playerStats(){
        System.out.println("Oyuncu değerleri\n-------------");
        System.out.println("Can : "+player.getHealthy());
        System.out.println("Hasar : "+ player.getTotalDamage());
        System.out.println("Para : "+player.getMoney());
        if(player.getInv().getDamage()>0){
            System.out.println("Silah : "+player.getInv().getwName());
            
        }
        if(player.getInv().getArmor()>0){
            System.out.println("Zırh : "+player.getInv().getaName());
        }

    }
    public void enemyStats(){
        System.out.println(obstacle.getName()+" Değerleri \n ---------------");
        System.out.println("Can : "+ obstacle.getHealth());
        System.out.println("Hasar : "+obstacle.getDamage());
        System.out.println("Ödül : "+obstacle.getAward());
    }
    public void afterHit(){
        System.out.println("Canınız: "+player.getHealthy());
                    System.out.println(obstacle.getName()+" Canı :"+ obstacle.getHealth());
    }
   
}
