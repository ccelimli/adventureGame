public class Armor {
    private int id;
    private String itemName;
    private int block;
    private int price;

    public Armor(int id, String itemName, int block, int price) {
        this.id = id;
        this.itemName = itemName;
        this.block = block;
        this.price = price;
    }

    public static Armor[] armors(){
        Armor[] armorList= new Armor[3];
        armorList[0] = new Armor(1,"Hafif", 1, 15);
        armorList[1] = new Armor(2,"Orta", 3, 25);
        armorList[2] = new Armor(3,"Ağır", 5, 45);

        return armorList;
    }

    public static Armor getArmorObjectById(int id){
        for (Armor armor:Armor.armors()){
            if (armor.getId()==id){
                return armor;
            }
        }
        return null;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
