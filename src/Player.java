import java.util.Scanner;

public class Player {
    private Integer damage;
    private Integer health;
    private Integer money;
    private String name;
    private String charName;
    private Inventory inventory;
    private Scanner input = new Scanner(System.in);

    public Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public void selectChar() {
        GameChar[] gameChars = {new Samurai(), new Knight(), new Archer()};
        System.out.println("Karakterler");
        System.out.println("----------------------------------------------------------------------------------");
        for (GameChar gameChar : gameChars) {
            System.out.println("ID: " + gameChar.getId() +
                               "\t Karakter: " + gameChar.getName() +
                               "\t\t Hasar:" + gameChar.getDamage() +
                               "\t\t Sağlık:" + gameChar.getHealth() +
                               "\t\t Para:" + gameChar.getMoney());
        }

        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Lütfen bir karakter giriniz: ");
        Integer selectChar = input.nextInt();
        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }

        System.out.println("Karakter: " + this.getCharName() +
                           ", Hasar: " + this.getDamage() +
                           ", Sağlık: " + this.getHealth() +
                           ", Para: " + this.getMoney());
    }

    public void selectLoc(){
        Location location=null;
        System.out.println("Bölgeler");
        System.out.println("1 - Güvenli Ev");
        System.out.println("2 - Mağaza");
        System.out.println("Lütfen Bölge Seçiniz: ");
        Integer selectLoc=input.nextInt();
        switch (selectLoc){
            case 1:
                location= new SafeHouse(this);
                break;
        }
    }

    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }
}
