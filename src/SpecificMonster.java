
public class SpecificMonster extends Monster {
    public SpecificMonster(String name,int level /*,int hp, int attack, int defend, int exp, int hp,int level*/) {
        super(name/*, attack, defend, exp, hp,level*/);
        this.setHp(300);
    }
    public void monsterAttack(Player player) {
        int damage = (int) (Math.random() * 10 * 10) + 1;
        player.takeDamage(damage);
        System.out.println(getName() + " attacks " + player.getName() + " for " + damage + " damage.");
    }
}
