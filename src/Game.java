import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Hoşgeldiniz");
        System.out.println("Bir isim gir: ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println(player.getName() + " Hoşgeldin");
        System.out.println(" Burada yaşanacak olanların hepsi gerçek!");
        System.out.println("Lütfen bir karakter seçiniz: ");
        player.selectChar();

        Location location = null;
        while (true) {
            player.printInfo();
            System.out.println("Bölgeler");
            System.out.println("1 - Güvenli Ev --> Düşman Yok");
            System.out.println("2 - Eşya Dükkanı --> Silah veya Zırh alabilirsiniz.");
            System.out.println("3 - Mağara --> (Ödül <Yemek>) Mağaraya Gir. Dikkatli ol! Zombi Çıkabilir.");
            System.out.println("4 - Orman -->(Ödül <Odun>) Ormana Gir. Dikkatli ol! Vampir Çıkabilir.");
            System.out.println("5 - Nehir -->(Ödül <Su>) Nehre Gir. Dikkatli ol! Ayı Çıkabilir.");
            System.out.println("6 - Maden -->(Ödül <Para, Zırh yada Silah>) Madene Gir. Dikkatli ol! Yılan Çıkabilir.");
            System.out.println("0 - Çıkış Yap --> Oyunu Sonlandır!");
            System.out.println("Lütfen Bölge Seçiniz: ");
            int selectLoc = input.nextInt();
            location = switch (selectLoc) {
                case 0 ->location=null;
                case 1 -> location=new SafeHouse(player);
                case 2 -> location=new ToolStore(player);
                case 3 ->location=new Cave(player);
                case 4 ->location=new Forest(player);
                case 5 ->location=new River(player);
                case 6 ->location=new Coal(player);
                default -> new SafeHouse(player);
            };
            if (location==null){
                System.out.println("Oyun Bitti");
                break;
            }
            System.out.println(location.getName());
            if (!location.onLocation()) {
                System.out.println("Game Over");
                break;
            }

        }
    }
}
