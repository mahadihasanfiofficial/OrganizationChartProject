import java.util.ArrayList;

public class Group extends Unit {

    private String groupName;
    private String bossName;
    private ArrayList<Unit> members;

    public Group(String groupName, String bossName, int level) {
        super(level);
        this.groupName = groupName;
        this.bossName = bossName;
        members = new ArrayList<>();
    }

    public void add(Unit u) {
        members.add(u);
    }

    public void print() {
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }

        System.out.println(groupName + " (Boss: " + bossName + ")");

        for (Unit u : members) {
            u.print();
        }
    }
}