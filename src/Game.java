import java.util.Scanner;

public class Game {
  private Scanner input=new Scanner(System.in);

  public void start(){
      System.out.println("Hoşgeldiniz");
      System.out.println("Bir isim gir: ");
      String playerName=input.nextLine();
      Player player = new Player(playerName);
      System.out.println(player.getName()+" Hoşgeldin");
      System.out.println(" Burada yaşanacak olanların hepsi gerçek!");
      System.out.println("Lütfen bir karakter seçiniz: ");
      player.selectChar();
  }
}
