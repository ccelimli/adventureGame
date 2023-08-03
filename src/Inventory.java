public class Inventory {
    private Boolean water;
    private Boolean food;
    private Boolean firewoord;
    private String weaponGame;
    private String armorName;
    private Integer weaponDamage;
    private Integer armorDefence;

    public Inventory() {
    }

    public Inventory(Boolean water, Boolean food, Boolean firewoord, String weaponGame, String armorName, Integer weaponDamage, Integer armorDefence) {
        this.water = water;
        this.food = food;
        this.firewoord = firewoord;
        this.weaponGame = weaponGame;
        this.armorName = armorName;
        this.weaponDamage = weaponDamage;
        this.armorDefence = armorDefence;
    }

    public Boolean getWater() {
        return water;
    }

    public void setWater(Boolean water) {
        this.water = water;
    }

    public Boolean getFood() {
        return food;
    }

    public void setFood(Boolean food) {
        this.food = food;
    }

    public Boolean getFirewoord() {
        return firewoord;
    }

    public void setFirewoord(Boolean firewoord) {
        this.firewoord = firewoord;
    }

    public String getWeaponGame() {
        return weaponGame;
    }

    public void setWeaponGame(String weaponGame) {
        this.weaponGame = weaponGame;
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public Integer getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(Integer weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public Integer getArmorDefence() {
        return armorDefence;
    }

    public void setArmorDefence(Integer armorDefence) {
        this.armorDefence = armorDefence;
    }
}
