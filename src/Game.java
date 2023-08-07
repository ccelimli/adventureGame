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
            System.out.println("2 - Mağaza --> Silah veya Zırh alabilirsiniz.");
            System.out.println("0 - Çıkış Yap --> Oyunu Sonlandır!");
            System.out.println("Lütfen Bölge Seçiniz: ");
            int selectLoc = input.nextInt();
            location = switch (selectLoc) {
                case 0 ->location=null;
                case 1 -> new SafeHouse(player);
                case 2 -> new ToolStore(player);
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
