import java.util.Scanner;

public class Player {
    private Integer damage;
    private Integer health;
    private Integer money;
    private String name;
    private int originalHealtPlayer;
    private String charName;
    private Inventory inventory;
    private Scanner input = new Scanner(System.in);

    public Player() {
    }

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void printInfo() {
        System.out.println("Silah: " + this.getInventory().getWeapon().getWeaponName() +
                           ", Zırh: " + this.getInventory().getArmor().getItemName() +
                           ", Bloklama: " + this.getInventory().getArmor().getBlock() +
                           ", Hasar: " + this.getTotalDamage() +
                           ", Sağlık: " + this.getHealth() +
                           ", Para: " + this.getMoney());
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Integer getTotalDamage(){
        return damage+this.getInventory().getWeapon().getDamage();
    }

    public Integer getDamage() {
        return this.damage;
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

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public Weapon getWeapon(){
        return this.getInventory().getWeapon();
    }

    public int getOriginalHealtPlayer() {
        return originalHealtPlayer;
    }

    public void setOriginalHealtPlayer(int originalHealtPlayer) {
        this.originalHealtPlayer = originalHealtPlayer;
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
        int selectChar = input.nextInt();
        switch (selectChar) {
            case 1 -> initPlayer(new Samurai());
            case 2 -> initPlayer(new Archer());
            case 3 -> initPlayer(new Knight());
            default -> initPlayer(new Samurai());
        }
    }


    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOriginalHealtPlayer(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }
}
