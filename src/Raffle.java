/**
 *  Jenn Tillman
 *  3112-051 Design and Implementation of Object-Oriented Systems
 */

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Raffle {
    static List<Ticket> tickets = new ArrayList<Ticket>();

    public static void main (String[] args) {

        boolean isRightLength = false;
        String winningNumber;

        //Accepts user input as string and parses to an integer value
        do {
            winningNumber = JOptionPane.showInputDialog("Enter the winning 6-Digit ticket number");
            if (winningNumber == null || winningNumber.equals("")){
                JOptionPane.showMessageDialog(null,
                        "The winning ticket number must have a value!",
                        "Important!", JOptionPane.ERROR_MESSAGE);

                //If user selects cancel, check to see if they wish to quit
                int value;
                value = JOptionPane.showConfirmDialog(null,
                        "Do you want to quit?",
                        "Please Confirm", JOptionPane.YES_NO_OPTION);
                if(value == JOptionPane.YES_OPTION){

                    System.exit(0);
                }else {
                    continue;
                }

            }

            //Send winningTicket to Ticket Class
            new Ticket(winningNumber);


            //Checks if the length of the number is 6 digits, if not forces user to enter a value that is
                /*If winningNumber is Parsed to an int we need if (String.valueOf(winningTicketNumber).length() != 6)
                	if winningNumber is kept as a String we need if(winningNumber.length() != 6)
                */
            if (winningNumber.length() != 6) {
                isRightLength = false;
                JOptionPane.showMessageDialog(null,
                        "The winning ticket number must be 6 digits!",
                        "Important!", JOptionPane.ERROR_MESSAGE);
            } else {
                isRightLength = true;
            }
        }
        while(!isRightLength);


        //Boolean to check if there are still tickets to input
        boolean stillTickets = true;

        //While Loop potentially to keep asking for information from user
        while(stillTickets) {
            String userName = JOptionPane.showInputDialog("Enter your name");
            String userTicketNumber = JOptionPane.showInputDialog("Enter your ticket number");

            //Check if values are null, if they are let the user know this is not valid and continue loop
            if (userName == null || userName.equals("") || userTicketNumber == null || userTicketNumber.equals("")) {

                JOptionPane.showMessageDialog(null,
                        "Ticket Holder's Name and/or Ticket Holder's ticket number cannot be null",
                        "Important!", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            //Once there are valid values for userName and userTicketNumber Enter them into the Ticket Class
            //Can also parseInt here if necessary
            tickets.add(new Ticket(userName, userTicketNumber));


            //Check if there are more tickets that need to be entered in
            int result;
            result = JOptionPane.showConfirmDialog(null,
                    "Are there still tickets?",
                    "Please Confirm", JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION){
                stillTickets = true;

            }else if(result == JOptionPane.NO_OPTION) {

                stillTickets = false;

            }
        }

        //Sends ticket list to Ticket class
        new Ticket(tickets);

        Ticket x = new Ticket();
        //Code calls to do calculations on Tickets in the Ticket Class
        x.getFirstPlace();
        x.getSecondPlace();
        x.getThirdPlace();


    }

}