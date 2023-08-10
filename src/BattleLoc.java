import java.util.Random;

public class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        if (!isAreaClean()) {
            int obsNumber = this.randomObstacleNumber();
            System.out.println("Şu an buradasınız: " + this.getName());
            System.out.println("Dikkatli Ol! Burada " + obsNumber + " tane " + this.getObstacle().getName() + " yaşıyor");
            System.out.println("<S>avaş veya <K>aç");
            String selectCase = input.nextLine();
            selectCase = selectCase.toUpperCase();

            if (selectCase.equals("S") && combat(obsNumber)) {
                System.out.println(this.getName() + " tüm düşmanları yendiniz!");
                addAwardInventory();
                return true;
            }
            if (this.getPlayer().getHealth() <=0) {
                System.out.println("Öldünüz!");
                return false;
            }
        }
        return true;
    }

    public boolean isAreaClean() {
        String[] wonAwards = this.getPlayer().getInventory().getAward();
        boolean isClean = false;

        for (String award : wonAwards) {
            if (award == this.award) {
                System.out.println(this.getName() + " Bölgesi daha önce tamamen temizlendi");
                System.out.println("Tekrar giremezsiniz !");
                isClean = true;
            }
        }

        return isClean;
    }

    public void addAwardInventory() {
        String[] wonAwards = this.getPlayer().getInventory().getAward();

        for (int i = 0; i < wonAwards.length; i++) {
            if (wonAwards[i] == null) {
                wonAwards[i] = this.award;
                break;
            }
        }

        System.out.println(this.getName() + " bölgesinin " + this.award + " ödülünü kazandınız ");
        System.out.println("Kazanılan Bölge Ödülleri");
        System.out.println("*******************************************");
        for (String award : wonAwards) {
            if (award != null) {
                System.out.println(award);
            }
        }
        System.out.println("*******************************************");
    }

    public boolean combat(int obsNumber) {
        boolean isRandomFinish = false;
        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealt(this.getObstacle().getOriginalHealth());
            playerStats();
            obstacleStats(i);
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealt() > 0) {
                System.out.println("<V>ur veya <K>aç");
                String selectCombat = input.nextLine();
                selectCombat = selectCombat.toUpperCase();
                if (selectCombat.equals("V")) {
                    if (!isRandomFinish) {
                        if (randomHit() == 0) {
                            System.out.println("İlk vuruşu yaptınız !!!");
                            System.out.println("Vurdun!");
                            this.getObstacle().setHealt(this.getObstacle().getHealt() - this.getPlayer().getTotalDamage());
                            afterHit();
                        } else {
                            System.out.println("ilk vuruşu " + this.getObstacle().getName() + " yaptı !!!");
                            if (this.getObstacle().getHealt() > 0) {
                                System.out.println(this.getObstacle().getName() + " Size Vurdu");
                                int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                                if (obstacleDamage < 0) {
                                    obstacleDamage = 0;
                                }
                                this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                            }
                        }
                        isRandomFinish = true;
                    } else {
                        System.out.println("Vurdun!");
                        this.getObstacle().setHealt(this.getObstacle().getHealt() - this.getPlayer().getTotalDamage());
                        afterHit();

                        if (this.getObstacle().getHealt() > 0) {
                            System.out.println(this.getObstacle().getName() + " Size Vurdu");
                            int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                            if (obstacleDamage < 0) {
                                obstacleDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        }
                    }
                } else {
                    return false;
                }
            }
            if (this.getObstacle().getHealt() < this.getPlayer().getHealth()) {
                System.out.println("Düşmanı Yendin");
                System.out.println(this.getObstacle().getAward() + " para kazandın");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Güncel Bakiye: " + this.getPlayer().getMoney());
            } else {
                return false;
            }
        }
        return true;
    }

    public void afterHit() {
        System.out.println("Kalan Can: " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " Canı: " + this.getObstacle().getHealt());
    }

    public void playerStats() {
        System.out.println("Oyuncu Değerleri");
        System.out.println("--------------------------------");
        System.out.println("Sağlık: " + this.getPlayer().getHealth());
        System.out.println("Silah: " + this.getPlayer().getInventory().getWeapon().getWeaponName());
        System.out.println("Hasar: " + this.getPlayer().getTotalDamage());
        System.out.println("Zırh: " + this.getPlayer().getInventory().getArmor().getItemName());
        System.out.println("Bloklama: " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Para: " + this.getPlayer().getMoney());
    }

    public void obstacleStats(int i) {
        System.out.println(i + ". " + this.getObstacle().getName() + " Değerleri");
        System.out.println("-----------------------------------------");
        System.out.println("Sağlık: " + this.getObstacle().getHealt());
        System.out.println("Hasar: " + this.getObstacle().getDamage());
        System.out.println("Ödül: " + this.getObstacle().getAward());
    }

    public int randomObstacleNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public int randomHit() {
        Random random = new Random();
        return random.nextInt(2);
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
