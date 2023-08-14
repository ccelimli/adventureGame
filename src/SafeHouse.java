public class SafeHouse extends NormalLoc {
    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }
    public SafeHouse() {
        super(null,"name");
    };

    @Override
    public boolean onLocation() {
        if (true) {
            System.out.println("Tebrikler " + this.getPlayer().getName() +  " Oyunu Kazandın !!!");
        } else {
            System.out.println("Güvenli evdesiniz. Sağlık Yenilendi");
            this.getPlayer().setHealth(this.getPlayer().getOriginalHealtPlayer());
            return true;
        }
        return true;
    }

    public boolean isWinGame() {
        String[] wonAwards = this.getPlayer().getInventory().getAward();
        boolean isWin = true;

        for (String award : wonAwards) {
            if (award == null) {
                isWin = false;
            }
        }
        return isWin;
    }
}
