public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    @Override
   public boolean onLocation() {
        System.out.println("Güvenli evdesiniz. Sağlık Yenilendi");
        return true;
    }
}
