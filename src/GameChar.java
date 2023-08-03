public abstract class GameChar {
    private Integer id;
    private String name;
    private Integer damage;
    private Integer health;
    private Integer money;

    public GameChar(Integer id,String name,Integer damage, Integer health, Integer money) {
        this.id=id;
        this.name=name;
        this.damage = damage;
        this.health = health;
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
