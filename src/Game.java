import java.util.Scanner;

public class Game {
     private static Scanner scanner = new Scanner(System.in);

    public static void play() {
        System.out.println("Write your name: ");
        String name = scanner.nextLine();
        Player p1 = new Player(name,50);
        Shop sh = new Shop(p1);
        System.out.println("Hello, " + p1.getName() + "!");
        System.out.println("Welcome to Crush Kill Destroy!");
        firstMenu(p1, sh);

    }

    private static void firstMenu(Player p1, Shop sh) {
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Main Menu:");
            System.out.println("1. Go adventuring");
            System.out.println("2. Show details about your character");
            System.out.println("3. Go shop");
            System.out.println("4. Exit game");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:easyMonster(scanner, p1, sh);
                       bossMonster(scanner, p1);
                    break;
                case 2:System.out.println(p1.toString());
                    break;
                case 3:
                    sh.enter();
                    break;
                case 4:godbye();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);
    }


    private static void easyMonster(Scanner scanner, Player p1, Shop sh) {
        int monstersDefeated = 0;
        while (p1.getLevel() < 10) {
            System.out.println("\nYou have defeated " + monstersDefeated + " monsters.");
            Monster monster = new Monster("Giant Wurm");

            System.out.println("-----------------------------------");
            System.out.println(" You have encountered a " + monster.getName() + "!");
            System.out.println("-----------------------------------");
            while (p1.getHp() > 0 && monster.getHp() > 0) {
                System.out.println("-----------------------------------");
                System.out.println(" Your health power: " + p1.getHp());
                System.out.println(" Monster health power: " + monster.getHp());
                System.out.println(" your Gold " + p1.getGuld());

                System.out.println("-----------------------------------");
                System.out.println("\nPress enter to attack the " + monster.getName() + "...");
                System.out.println("-----------------------------------");
                scanner.nextLine();
                p1.attack(monster);
                p1.defend(monster);
                monster.takeGold(p1);
                if (monster.getHp() <= 0) {break;}
                monster.attack(p1);
                monster.defend(p1);

            }
            if (p1.getHp() > 0) {
                int exp = monster.getExp();
                p1.gainExp(exp);
                System.out.println("You are level " + p1.getLevel() + ", and you have " + p1.getExp() + " exp and " + p1.getHp() + " hp");
                System.out.println("Monster are level " + monster.getLevel() + ", and  have " + monster.getExp() + " exp and " + monster.getHp() + " hp");
                monstersDefeated++;
                firstMenu(p1,sh);
            } else {
                System.out.println("Game over.");
                askToFinish();
            }
        }
    }

    private static void bossMonster(Scanner scanner, Player p1) {
        SpecificMonster boss = new SpecificMonster("SpecificMonster",10/*, 15, 10, 150, 300,10*/);
        System.out.println("\nYou have reached level 10 and are ready to face the " + boss.getName() + "!");
        while (p1.getHp() > 0 && boss.getHp() > 0) {
            System.out.println(" your health power " + p1.getHp());
            System.out.println(boss.getName() + " health power " + boss.getHp());
            System.out.println("\nPress enter to attack the " + boss.getName() + "...");
            scanner.nextLine();
            p1.attack(boss);
            if (boss.getHp() <= 0) {
                break;
            }
            boss.monsterAttack(p1);
        }
        if (p1.getHp() > 0) {
            System.out.println("\nCongratulations! You have defeated the " + boss.getName() + " and won the game!");
        } else {
            System.out.println("\nGame over.");
            askToFinish();
        }
    }
    private static void askToFinish() {
        System.out.println("Do you want to play again? Y or N");
        String svar = scanner.next();
        if (svar.equals("Y")) {
            play();
        } else {
            godbye();
            System.exit(0);
        }
    }

    private static void godbye() {
        System.out.println("goodbye ");
        System.exit(0);
    }

}