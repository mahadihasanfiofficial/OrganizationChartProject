import java.util.Scanner;

public class MainApp {

    // Global organization
    static Group company;

    // Method to create hardcoded organization
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

            choice = sc.nextLine();

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
                    String groupName = sc.nextLine();

                    Group target = company.findGroup(groupName);

                    if (target == null) {
                        System.out.println("Group not found!");
                        break;
                    }

                    System.out.print("Enter person name: ");
                    String personName = sc.nextLine();

                    target.add(new Person(personName, target.level + 1));

                    System.out.println("Person added successfully!");

                    company.print();
                    break;

                case "3":
                    System.out.println("Remove person not implemented yet.");
                    break;

                case "q":
                    break;

                default:
                    System.out.println("Error: Invalid choice!");
            }

            System.out.println();

        } while (!choice.equalsIgnoreCase("q"));
    }
}