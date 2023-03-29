
public class Monster {
    private String name;
    private int attack;
    private int level;
    private int defense;
    private int exp;
    private  int hp;
    private int gold;

    public Monster(String name) {
        this.name = name;
        this.attack = 3;
        this.defense = 2;
        this.exp = 10;
        this.hp = 100;
        this.level = 1;
        this.gold = 2;
    }
    public void setHp(int hp) {
        this.hp += hp;
    }
    public String getName() {
        return name;
    }
    public int getExp() {
        return exp;
    }
    public int getHp() {
        return hp;
    }
    public int getAttack() {
        return attack;
    }
    public int getLevel() {
        return level;
    }

    public void attack(Player player) {
        int playerAttack = player.getAttack() - 1;
        int damage = (int) (Math.random() * playerAttack * 5) + 1;
        player.takeDamage(damage);
        System.out.println(name + " attacks " + player.getName() + " for " + damage + " damage.");
    }
    public void defend(Player player) {
        int playerDefend = player.getDefend();
        int newDefense = (int) (Math.random() * playerDefend * 5);
        player.setHp(newDefense);
        System.out.println(player.getName() + " defended your self by (" + newDefense + ").");
    }
    public void takeDamage(int damage) {
        this.hp -= damage;
        if (hp <= 0) {
            System.out.println("You have defeated the " + name + "!");
        }
    }
    public void takeGold (Player player) {
        player.setEarnGold(gold);
    }
    public void levelUp() {
        this.level ++;
        this.exp += 30;
    }
    public int getDefense(){
        return defense;
    }
    public void setDefense(int defense) {
        this.defense += defense;
    }
}
