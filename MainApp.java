import java.util.Scanner;

public class MainApp {

    static Group company;

    public static void createOrganization() {

        company = new Group("Company", "Scrooge McDuck", 0);

        Group sales = new Group("Sales", "Donald Duck", 1);
        Group tech = new Group("Tech", "Gyro Gearloose", 1);

        sales.add(new Person("Huey Duck", 2));
        sales.add(new Person("Dewey Duck", 2));

        tech.add(new Person("Launchpad McQuack", 2));

        company.add(sales);
        company.add(tech);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String choice;

        do {
            System.out.println("Organization management system");
            System.out.println("------------------------------");
            System.out.println();
            System.out.println("1. Create and print hard coded organization");
            System.out.println("2. Print organization, add person to it and finally print it");
            System.out.println("3. Print organization, remove person from it and finally print it");
            System.out.println("Q. Quit the application");
            System.out.println();
            System.out.print("Your choice: ");

            choice = sc.nextLine().trim();

            switch (choice.toLowerCase()) {

                case "1":
                    createOrganization();
                    company.print();
                    break;

                case "2":

                    if (company == null) {
                        System.out.println("Create organization first (option 1)");
                        break;
                    }

                    company.print();

                    System.out.print("Enter group name: ");
                    String groupName = sc.nextLine().trim();

                    if (groupName.isEmpty()) {
                        System.out.println("Group name cannot be empty!");
                        break;
                    }

                    Group target = company.findGroup(groupName);

                    if (target == null) {
                        System.out.println("Group not found!");
                        break;
                    }

                    System.out.print("Enter person name: ");
                    String personName = sc.nextLine().trim();

                    if (personName.isEmpty()) {
                        System.out.println("Person name cannot be empty!");
                        break;
                    }

                    target.add(new Person(personName, target.level + 1));

                    System.out.println("Person added successfully!");
                    company.print();
                    break;

                case "3":

                    if (company == null) {
                        System.out.println("Create organization first (option 1)");
                        break;
                    }

                    company.print();

                    System.out.print("Enter person name to remove: ");
                    String nameToRemove = sc.nextLine().trim();

                    if (nameToRemove.isEmpty()) {
                        System.out.println("Name cannot be empty!");
                        break;
                    }

                    boolean removed = company.removePerson(nameToRemove);

                    if (removed) {
                        System.out.println("Person removed successfully!");
                    } else {
                        System.out.println("Person not found!");
                    }

                    company.print();
                    break;

                case "q":
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Error: Invalid choice!");
            }

            System.out.println();

        } while (!choice.equalsIgnoreCase("q"));

        sc.close();
    }
}