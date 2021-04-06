import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {
        Bus bus = new Bus("06 HUBM 06", 42);
        String name, surname, gender,countrycode, code, type, number;
        int seatID;
        while (true) {
            System.out.println(" Menu");
            System.out.println("1 Book a seat\n" +
                    "2 Display all passengers with their seat numbers\n" +
                    "3 Display all available seatIDs\n" +
                    "4 Search\n" +
                    "5 Exit\n" +
                    "Enter your choose:");
            Scanner scan = new Scanner(System.in);
            int choose = scan.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("Enter seat id:");
                    seatID = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter name:");
                    name = scan.nextLine();
                    System.out.println("Enter surname:");
                    surname = scan.nextLine();
                    System.out.println("Enter gender:");
                    gender = scan.nextLine();
                    System.out.println("Enter country code:");
                    countrycode = scan.nextLine();
                    System.out.println("Enter code:");
                    code = scan.nextLine();
                    System.out.println("Enter number:");
                    number = scan.nextLine();

                    System.out.println("Enter type:");
                    type = scan.nextLine();
                    Phone phone = new Phone(countrycode, code ,number ,type);
                    Passenger p = new Passenger(name, surname,  gender, phone);
                    bus.bookSeat(p,seatID);
                    break;
                case 2:
                    bus.printAllPassengers();
                    break;
                case 3:
                    bus.printAllAvailableSeatIDs();
                    break;
                case 4:
                    System.out.println("Enter name:");
                    name = scan.nextLine();
                    System.out.println("Enter surname:");
                    surname = scan.nextLine();
                    bus.search(name, surname);

                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choose);
            }
        }
    }
}