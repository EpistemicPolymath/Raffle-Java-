import java.util.ArrayList; //The Array List
import java.util.List; //Java Collections List

public class Ticket{

    //Class Variables
    static String WINNINGTICKET;
    String ticketHolder;
    String ticketNumber;
    static int numberOfFirstPrizes;
    static int numberOfSecondPrizes;
    static int numberOfThirdPrizes;
    static List<Ticket> listOfTickets = new ArrayList<Ticket>();



    //Constructors

    //Constructor for winningTicketNumber
    public Ticket(String winningTicket){
        WINNINGTICKET = winningTicket;
    }

    //Empty constructor
    public Ticket(){

    }

    //Constructor for taking in List of Ticket Objects from Raffle
    public Ticket(List<Ticket> list){

        listOfTickets.addAll(list);

    }

    //Object instantiation constructor
    public Ticket(String name, String ticket){

        this.ticketHolder = name;
        this.ticketNumber = ticket;
    }

    public void setName(String name){

        ticketHolder = name;
    }

    public void setNumber(String ticket){

        ticketNumber = ticket;
    }

    public String getName(){

        return ticketHolder;
    }

    public String getNumber(){

        return ticketNumber;
    }

    //Used for Testing
    public void getList() {

        System.out.println(listOfTickets);
        System.out.println("The ArrayList has " + listOfTickets.size() + " objects stored in it.");
        System.out.println(listOfTickets.get(0).getName());
        System.out.println(listOfTickets.get(0).getNumber());

    }


    public void getFirstPlace() {

        for ( Ticket obj : listOfTickets ) {

            if (obj.getNumber().equals(WINNINGTICKET)){
                String name = obj.getName();
                numberOfFirstPrizes++;

                System.out.println("Congratulations " + name + " you've won first prize!");

            }


        }
        if (numberOfFirstPrizes > 0){

            System.out.println("There were " + numberOfFirstPrizes + " First Prize Winners");

        }else {

            System.out.println("There were no First Prize Winners");

        }
    }

    public void getSecondPlace() {

        for ( Ticket obj : listOfTickets ) {

            StringBuilder builder = new StringBuilder(WINNINGTICKET);
            String reverse = builder.reverse().toString();
            if (obj.getNumber().equals(reverse)){
                String name = obj.getName();
                numberOfSecondPrizes++;


                System.out.println("Congratulations " + name + " you've won second prize!");

            }

        }
        if (numberOfSecondPrizes > 0){

            System.out.println("There were " + numberOfSecondPrizes + " Second Prize Winners");

        }else {

            System.out.println("There were no Second Prize Winners");

        }
    }

    public void getThirdPlace() {
        for ( Ticket obj : listOfTickets ) {
            if (((obj.getNumber().substring(0, 3).equals(WINNINGTICKET.substring(0, 3))) || (obj.getNumber().substring(1, 4).equals(WINNINGTICKET.substring(1,4)) ||
                    (obj.getNumber().substring(2, 5).equals(WINNINGTICKET.substring(2, 5)) || (obj.getNumber().substring(3).equals(WINNINGTICKET.substring(3))))))){
                String name = obj.getName();
                numberOfThirdPrizes++;


                System.out.println("Congratulations " + name + " you've won third prize!");

            }

        }

        if (numberOfThirdPrizes > 0){

            System.out.println("There were " + numberOfThirdPrizes + " Third Prize Winners");

        }else {

            System.out.println("There were no Thrid Prize Winners");

        }

    }


}