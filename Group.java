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

    public String getGroupName() {
        return groupName;
    }

    public Group findGroup(String name) {

        if (this.groupName.equalsIgnoreCase(name)) {
            return this;
        }

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

    public boolean removePerson(String name) {

        for (int i = 0; i < members.size(); i++) {

            Unit u = members.get(i);

            if (u instanceof Person) {
                if (((Person) u).getName().equalsIgnoreCase(name)) {
                    members.remove(i);
                    return true;
                }
            }

            if (u instanceof Group) {
                boolean removed = ((Group) u).removePerson(name);
                if (removed) return true;
            }
        }

        return false;
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