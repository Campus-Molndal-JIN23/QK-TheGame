public class Player {

    private String name;
    private int level;
    private int exp;
    private int hp;
    private int guld;
    private int defend;
    private int attack;

    public Player(String name, int guld) {
        this.name = name;
        this.level = 1;
        this.exp = 0;
        this.hp = 100;
        this.guld = guld;
        this.attack = 3;
        this.defend = 2;
    }

    public String getName() {
        return name;
    }
    public int getAttack() {
        return attack;
    }

    public int getLevel() {
        return level;
    }

    public int getExp() {
        return exp;
    }

    public int getHp() {
        return hp;
    }
    public int getGuld() {
        return guld;
    }
    public int getDefend(){
        return defend;
    }
    public void setDefense(int defense) {
        this.defend += defense;
    }

    public void takeGuld(int guld) {
        this.guld -= guld;
    }
    public void setHp(int hp) {
        this.hp += hp;
    }
    public void setAttack(int attack){
        this.attack += attack ;
    }
    public void setEarnGold(int earnGold){
        this.guld +=  earnGold * level;
    }

    public void attack(Monster monster) {
        int monsterAttack = getAttack();
        int damage = (int) (Math.random() * monsterAttack * 5) + 1;
        monster.takeDamage(damage);
        System.out.println(name + " attacks " + monster.getName() + " for " + damage + " damage.");
    }

    public void defend(Monster monster) {
        int monsterDefend = getDefend() - 1;
        int newDefense = (int) (Math.random() * monsterDefend * 5);
        monster.setHp(newDefense);
        System.out.println(monster.getName() + " defentded itself by (" + newDefense + ") .");
    }

    public void takeDamage(int damage) {
        this.hp -= damage;
        if (hp <= 0) {
            System.out.println("You have been defeated by the monster. Game over.");

        }
    }

    public void gainExp(int exp) {
        this.exp += exp;
        System.out.println("You gained " + exp + " experience points!");
        if (this.exp >= 10 && level < 10) {
            levelUp();
        } else if (level == 10) {
            System.out.println("You have reached level 10 and are now ready to face the SpecificMonster! Good luck!");
            System.exit(0);
        }
    }
    public void levelUp() {
        this.level++;
        if (level >= 5 ) this.hp += 20;
        System.out.println("Congratulations, you have leveled up to level " + level + "!");
    }
    @Override
    public String toString() {
        return  "-------------------"+
                "\n* Player: " + getName() +
                "\n* Health: " + getHp() +
                "\n* Level: " + getLevel() +
                "\n* Exp: " + getExp() +
                "\n* Gold: " + getGuld() +
                "\n* Attack: " + getAttack() +
                "\n* Defend: " + getDefend() +
                "\n-------------------";
    }
}
