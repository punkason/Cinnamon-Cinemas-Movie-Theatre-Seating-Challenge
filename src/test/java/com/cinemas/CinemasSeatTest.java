package com.cinemas;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CinemasSeatTest {
        //2D arrays seat numbers [3][5]
        private Cinema cinema;
        private static final int MAX_SEAT = 15;

        @Before
        public void setup(){

        }
        @Test
        public void oneCustomer(){
                //Arrange
                cinema = new Cinema(1);
                //ticket = new Ticket(1);

                //Act
                cinema.buyTicket();

                //Assert
                int noOfSeat = MAX_SEAT - cinema.getRemainingSeat();
                //assertTrue(1 <= noOfSeat && 3 >= noOfSeat);
        }


        /*Test Case 1
        1 customer buy ticket
        output should be within 1 to 3

        Test Case 2
        Remaining Seat = 2
        the random number should be 1 or 2 but not 3

        Test Case 3
        Remaining Seat = 1
        the random number should be 1 but not 2 or 3

        Test Case 4
        Remaining Seat = 0
        END Program

        Test Case 5
        Test if left to right, front to back
         */

}
