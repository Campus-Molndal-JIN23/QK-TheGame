import java.util.Scanner;

public class Shop {
    Player player;
    private int hpPrice;
    private int health;
    private int attackPrice;
    private int attack;
    private int defendPrice;
    private int toughness;

    public Shop(Player player) {
        this.player = player;
        this.hpPrice = 50;
        this.health = 50;
        this.attackPrice = 10;
        this.defendPrice = 10;
        this.toughness = 1;
        this.attack = 1;
    }
    public void enter() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("-----------------------------------");
            System.out.println("**What do you want to buy?**");
            System.out.println("You have " + player.getGuld() + " gold.");
            System.out.println("1. Health Amulet (50 Health) - 50 gold.");
            System.out.println("2. Attack Amulet (+1 Attack) - 10 gold.");
            System.out.println("3. Defend Amulet (+1 toughness) - 10 gold.");
            System.out.println("4. Exit shop.");
            System.out.println("<< Choice number >>");
            System.out.println("-----------------------------------");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    if (player.getHp() >= 200) {System.out.println("Your health is full ");break;}
                    if (player.getGuld() >= 50) {
                        player.takeGuld(hpPrice);
                        player.setHp(health);
                        System.out.println("You bought health power Amulet! Your Health is now " + player.getHp() + ".");
                    }
                     else if ((player.getHp() + 30) > 200 ) {
                        System.out.println("Your can't buy 50 health, because they will be over 200 " );
                                 }
                    else {System.out.println("You don't have enough gold to buy that!");}

                    break;
                case "2":
                    if (player.getGuld() >= 10) {
                        player.takeGuld(attackPrice);
                        player.setAttack(attack);
                        System.out.println("You bought the attack Amulet! Your attack is now " + player.getAttack() + ".");
                    } else {
                        System.out.println("You don't have enough gold to buy that!");
                    }
                    break;
                case "3":
                    if (player.getGuld() >= 10) {
                        player.takeGuld(defendPrice);
                        player.setDefense(toughness);
                        System.out.println("You bought the Defense Amulet! Your toughness is now " + player.getDefend() + ".");
                    } else {
                        System.out.println("You don't have enough gold to buy that!");
                    }
                    break;
                case "4":
                    System.out.println("Good luck!");
                    System.out.println("''''''''''");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

}


