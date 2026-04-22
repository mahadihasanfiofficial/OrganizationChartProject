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

    // Add member (Person or Group)
    public void add(Unit u) {
        members.add(u);
    }

    // OPTIONAL (useful later)
    public String getGroupName() {
        return groupName;
    }

    // 🔥 IMPORTANT: Find group recursively
    public Group findGroup(String name) {

        // Check current group
        if (this.groupName.equalsIgnoreCase(name)) {
            return this;
        }

        // Search in children
        for (Unit u : members) {
            if (u instanceof Group) {
                Group result = ((Group) u).findGroup(name);
                if (result != null) {
                    return result;
                }
            }
        }

        return null;
    }

    // Print organization structure
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