public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        boolean showMenu = true;
        while (true) {
            System.out.println("-----------Mağazaya Hoşgeldiniz-----------");
            System.out.println("1-Silahlar");
            System.out.println("2-Zırhlar");
            System.out.println("3-Çıkış Yap");
            System.out.println("Seçim: ");
            Integer selectCase = Location.input.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.println("Geçersiz Değer");
                selectCase = input.nextInt();
            }
            switch (selectCase) {
                case 1 -> {
                    System.out.println("--------------- SİLAHLAR ---------------");
                    printWeapon();
                }
                case 2 -> printArmor();
                case 3 -> {
                    System.out.println("Bir daha bekleriz!");
                    showMenu = false;
                    break;
                }
            }
            return true;
        }
    }

    public void printWeapon() {
        System.out.println("--------- Silahlar ---------");
        System.out.println();
        for (Weapon weapon : Weapon.weapons()) {
            System.out.println(weapon.getId() + "-" +
                               weapon.getWeaponName() + " <Para : " +
                               weapon.getPrice() + ", Hasar: " +
                               weapon.getDamage());
        }
        System.out.println("0 - Çıkış Yap");
        buyWeapon();
    }

    public void buyWeapon() {
        System.out.println("Bir Silah Seç: ");
        int selectWeaponId = input.nextInt();
        while (selectWeaponId < 0 || selectWeaponId > Weapon.weapons().length) {
            System.out.println("Geçersiz Değer!");
            selectWeaponId = input.nextInt();
        }
        if (selectWeaponId != 0) {
            Weapon selectedWeapon = Weapon.getWeaponObjectById(selectWeaponId);

            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Bakiye Yetersiz!");
                } else {
                    //Satın Alma
                    System.out.println(selectedWeapon.getWeaponName() + " satın aldınız!");
                    Integer balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan Bakiye: " + this.getPlayer().getMoney());
                    System.out.println("Silah: " + this.getPlayer().getInventory().getWeapon().getWeaponName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Silah: " + this.getPlayer().getInventory().getWeapon().getWeaponName());
                }
            }
        }

    }

    public void printArmor() {
        System.out.println("-------- Zırhlar --------");
        for (Armor armor : Armor.armors()) {
            System.out.println(armor.getId() +
                               " - " + armor.getItemName() +
                               "<Zırh: " + armor.getBlock() +
                               " , Fiyat>" + armor.getPrice());
        }
        System.out.println("0- Çıkış Yap");
        buyArmor();
    }

    public void buyArmor() {
        System.out.println("Bir Zırh Seçiniz: ");
        int selectArmorId = input.nextInt();
        while (selectArmorId < 0 || selectArmorId > Armor.armors().length) {
            System.out.println("Geçersiz Değer!");
            selectArmorId = input.nextInt();
        }

        if (selectArmorId != 0) {
            Armor selectedArmor = Armor.getArmorObjectById(selectArmorId);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yetersiz Bakiye!");
                } else {
                    System.out.println(selectedArmor.getItemName() + " zırhını satın aldın");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmor.getPrice());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Zırh: " + this.getPlayer().getInventory().getArmor().getItemName());
                    System.out.println("Kalan Bakiye: " + this.getPlayer().getMoney());
                }
            }
        }
    }
}
