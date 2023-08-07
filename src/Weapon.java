public class Weapon {
    private String weaponName;
    private Integer id;
    private Integer damage;
    private Integer price;

    public Weapon(String weaponName, Integer id, Integer damage, Integer price) {
        this.weaponName = weaponName;
        this.id = id;
        this.damage = damage;
        this.price = price;
    }

    public static Weapon[] weapons(){
        Weapon[] weaponList= new Weapon[3];
        weaponList[0]= new Weapon("Tabanca", 1,2,5);
        weaponList[1]= new Weapon("Kılıç", 2,3,35);
        weaponList[2]= new Weapon("Tüfek", 3,7,45);

        return weaponList;
    }

    public static Weapon getWeaponObjectById(int id){
        for (Weapon weapon:Weapon.weapons()){
            if (weapon.getId()==id){
                return weapon;
            }
        }
        return null;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
