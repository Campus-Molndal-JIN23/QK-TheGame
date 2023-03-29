
public class SpecificMonster extends Monster {
    public SpecificMonster(String name,int level) {
        super(name);
        this.setHp(300);
    }
    public void monsterAttack(Player player) {
        int damage = (int) (Math.random() * 10 * 10) + 1;
        player.takeDamage(damage);
        System.out.println(getName() + " attacks " + player.getName() + " for " + damage + " damage.");
    }
}
