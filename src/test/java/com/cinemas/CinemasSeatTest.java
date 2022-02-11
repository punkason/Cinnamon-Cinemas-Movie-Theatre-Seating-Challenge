package com.cinemas;
import org.junit.Before;
import org.junit.Ignore;
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
        public void printEmptyCinema(){
                //Arrange
                cinema = new Cinema(0);

                //Act
                cinema.buyTicket();

                //Assert
                String expectedZero = "   1  2  3  4  5 \n";
                expectedZero += "C [Y][Y][Y][Y][Y]\n";
                expectedZero += "B [Y][Y][Y][Y][Y]\n";
                expectedZero += "A [Y][Y][Y][Y][Y]\n";

                String result = cinema.printSeatingPlan();
                assertEquals(expectedZero, result);
        }

        @Test
        public void oneCustomer(){
                //Arrange
                cinema = new Cinema(1);

                //Act
                cinema.buyTicket();

                //Assert
                int noOfSeat = MAX_SEAT - cinema.getRemainingSeat();
                //System.out.println(noOfSeat);
                assertTrue(1 <= noOfSeat && 3 >= noOfSeat);
        }

        @Test
        public void printOneCustomer(){
                //Arrange
                cinema = new Cinema(1);

                //Act
                cinema.buyTicket();

                //Assert
                String expectedOne = "   1  2  3  4  5 \n";
                expectedOne += "C [Y][Y][Y][Y][Y]\n";
                expectedOne += "B [Y][Y][Y][Y][Y]\n";
                expectedOne += "A [N][Y][Y][Y][Y]\n";

                String expectedTwo = "   1  2  3  4  5 \n";
                expectedTwo += "C [Y][Y][Y][Y][Y]\n";
                expectedTwo += "B [Y][Y][Y][Y][Y]\n";
                expectedTwo += "A [N][N][Y][Y][Y]\n";

                String expectedThree = "   1  2  3  4  5 \n";
                expectedThree += "C [Y][Y][Y][Y][Y]\n";
                expectedThree += "B [Y][Y][Y][Y][Y]\n";
                expectedThree += "A [N][N][N][Y][Y]\n";

                String result = cinema.printSeatingPlan();
                assertTrue(result.equals(expectedOne) || result.equals(expectedTwo) || result.equals(expectedThree));
        }

        @Test
        public void twoCustomers(){
                //Arrange
                cinema = new Cinema(2);

                //Act
                cinema.buyTicket();

                //Assert
                int noOfSeat = MAX_SEAT - cinema.getRemainingSeat();
                //System.out.println(noOfSeat);
                assertTrue(2 <= noOfSeat && 6 >= noOfSeat);
        }
        @Test
        public void printTwoCustomers(){
                //Arrange
                cinema = new Cinema(2);

                //Act
                cinema.buyTicket();

                //Assert
                String expectedTwo = "   1  2  3  4  5 \n";
                expectedTwo += "C [Y][Y][Y][Y][Y]\n";
                expectedTwo += "B [Y][Y][Y][Y][Y]\n";
                expectedTwo += "A [N][N][Y][Y][Y]\n";

                String expectedThree = "   1  2  3  4  5 \n";
                expectedThree += "C [Y][Y][Y][Y][Y]\n";
                expectedThree += "B [Y][Y][Y][Y][Y]\n";
                expectedThree += "A [N][N][N][Y][Y]\n";

                String expectedFour = "   1  2  3  4  5 \n";
                expectedFour += "C [Y][Y][Y][Y][Y]\n";
                expectedFour += "B [Y][Y][Y][Y][Y]\n";
                expectedFour += "A [N][N][N][N][Y]\n";

                String expectedFive = "   1  2  3  4  5 \n";
                expectedFive += "C [Y][Y][Y][Y][Y]\n";
                expectedFive += "B [Y][Y][Y][Y][Y]\n";
                expectedFive += "A [N][N][N][N][N]\n";

                String expectedSix = "   1  2  3  4  5 \n";
                expectedSix += "C [Y][Y][Y][Y][Y]\n";
                expectedSix += "B [N][Y][Y][Y][Y]\n";
                expectedSix += "A [N][N][N][N][N]\n";

                String result = cinema.printSeatingPlan();
                assertTrue(result.equals(expectedTwo) || result.equals(expectedThree) || result.equals(expectedFour)|| result.equals(expectedFive)|| result.equals(expectedSix));
        }

        @Ignore
        @Test
        public void remainingTwoSeats(){
                //Arrange
                cinema = new Cinema(1);

                //Act
                cinema.buyTicket();

                //Assert
                int noOfSeat = MAX_SEAT - cinema.getRemainingSeat();
                //System.out.println(noOfSeat);
                assertTrue(1 <= noOfSeat && 3 >= noOfSeat);
        }
        /*
        Test Case 2
        Remaining Seat = 2
        the random number should be 1 or 2 but not 3

        Test Case 3
        Remaining Seat = 1
        the random number should be 1 but not 2 or 3

        Test Case 4
        Remaining Seat = 0
        END Program

         */

}
