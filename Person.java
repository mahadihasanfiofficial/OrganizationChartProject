public class Person extends Unit {

    private String name;

    public Person(String name, int level) {
        super(level);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void print() {
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println(name);
    }
}