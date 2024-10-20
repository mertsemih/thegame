public class SafeHouse extends NormalLocation{

    SafeHouse(Player player) {
        super(player, "Güvenli ev");
        
    }
    public boolean getLocation(){
        player.setHealthy(player.getrHealthy());
        System.out.println("Şu an Güvenli Evdesiniz.Canınız yenilendi.");
        System.out.println("Anlık canınız: "+player.getHealthy());
        return true;
    }
}
