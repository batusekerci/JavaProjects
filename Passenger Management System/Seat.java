public class Seat{
    private int SeatID;
    private boolean status;
    private Passenger p;
    Seat(int SeatID, boolean status, Passenger p){
        this.status = status;
        this.SeatID = SeatID;

    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setSeatID(int seatID) {
        SeatID = seatID;
    }

    public int getSeatID() {
        return SeatID;
    }

    public Passenger getP() {
        return p;
    }

    public void setP(Passenger p) {
        this.p = p;
    }
}

