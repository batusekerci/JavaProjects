import java.util.Scanner;

public class Bus{
    private String plate;
    private int seatCount;
    Seat[] seats;

    Bus(String plate, int seatCount){
        this.plate = plate;
        this.seatCount = seatCount;
        seats = new Seat[42];
        for(int i=0 ; i<42 ; i++){
            seats[i] = new Seat(i+1, true, new Passenger());
        }
    }
    public void bookSeat(Passenger p, int seatID){
        if (seats[seatID-1].getStatus() == false){
            System.out.println("The seat has already reserved!");
        }else{
            seats[seatID-1]= new Seat(seatID, false,p);

        }

    }
    public void printAllPassengers(){

        for (int i=0 ; i < seatCount ; i++ ){
            if (seats[i].getStatus() == false){
                System.out.println("Seat: "+ i + " Status: Reserved");
                seats[i].getPassenger().display();

            }

        }
    }
    public void printAllAvailableSeatIDs(){
        for (int i=0 ; i < seatCount ; i++){
            if (seats[i].getStatus() == true){
                System.out.println(i);
            }
        }
    }
    public void search(String name, String surname){
        for(int i=0; i<seatCount; i++){
            if(seats[i].getP().getName().equals(name) && seats[i].getP().getSurname().equals(surname)) {
                seats[i].getP().display();
                break;
            }
        }

    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getPlate() {
        return plate;
    }

    public Seat[] getSeats() {
        return seats;

    }

    public void setSeats(Seat[] seats) {
        this.seats = seats;
    }
}