package com.cinemas;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CinemasSeatTest {
        private static final int MAX_SEAT = 15;

        @Test
        public void checkNoSeatsAreFilledForEmptyCinema(){
                //Arrange
                Cinema cinema = new Cinema(0);

                //Act
                cinema.buyTicket();

                //Assert
                int expectedSeat = 0;
                String expectedZero = "   1  2  3  4  5 \nC [Y][Y][Y][Y][Y]\nB [Y][Y][Y][Y][Y]\nA [Y][Y][Y][Y][Y]\n";

                int actualSeat = MAX_SEAT - cinema.getAvailableSeat();
                String actualPrintout = cinema.printSeatingPlan();

                assertEquals(expectedZero, actualPrintout);
                assertEquals(expectedSeat, actualSeat);
        }

        @Test
        public void checkSeatsAreFilledForOneCustomer(){
                //Arrange
                Cinema cinema = new Cinema(1);

                //Act
                cinema.buyTicket();

                //Assert
                int expectedMinSeat = 1;
                int expectedMaxSeat = 3;
                String expectedOne = "   1  2  3  4  5 \nC [Y][Y][Y][Y][Y]\nB [Y][Y][Y][Y][Y]\nA [N][Y][Y][Y][Y]\n";
                String expectedTwo = "   1  2  3  4  5 \nC [Y][Y][Y][Y][Y]\nB [Y][Y][Y][Y][Y]\nA [N][N][Y][Y][Y]\n";
                String expectedThree = "   1  2  3  4  5 \nC [Y][Y][Y][Y][Y]\nB [Y][Y][Y][Y][Y]\nA [N][N][N][Y][Y]\n";

                int actualSeat = MAX_SEAT - cinema.getAvailableSeat();
                String actualPrintout = cinema.printSeatingPlan();

                assertTrue(expectedMinSeat <= actualSeat && expectedMaxSeat >= actualSeat);
                assertTrue(actualPrintout.equals(expectedOne) || actualPrintout.equals(expectedTwo) || actualPrintout.equals(expectedThree));
        }

        @Test
        public void checkSeatsAreFilledAcrossRowsAAndB(){
                //Arrange
                Cinema cinema = new Cinema(2);

                //Act
                cinema.buyTicket();

                //Assert
                int expectedMinSeat = 2;
                int expectedMaxSeat = 6;
                String expectedTwo = "   1  2  3  4  5 \nC [Y][Y][Y][Y][Y]\nB [Y][Y][Y][Y][Y]\nA [N][N][Y][Y][Y]\n";
                String expectedThree = "   1  2  3  4  5 \nC [Y][Y][Y][Y][Y]\nB [Y][Y][Y][Y][Y]\nA [N][N][N][Y][Y]\n";
                String expectedFour = "   1  2  3  4  5 \nC [Y][Y][Y][Y][Y]\nB [Y][Y][Y][Y][Y]\nA [N][N][N][N][Y]\n";
                String expectedFive = "   1  2  3  4  5 \nC [Y][Y][Y][Y][Y]\nB [Y][Y][Y][Y][Y]\nA [N][N][N][N][N]\n";
                String expectedSix = "   1  2  3  4  5 \nC [Y][Y][Y][Y][Y]\nB [N][Y][Y][Y][Y]\nA [N][N][N][N][N]\n";

                int actualSeat = MAX_SEAT - cinema.getAvailableSeat();
                String actualPrintout = cinema.printSeatingPlan();

                assertTrue(expectedMinSeat <= actualSeat && expectedMaxSeat >= actualSeat);
                assertTrue(actualPrintout.equals(expectedTwo) || actualPrintout.equals(expectedThree) || actualPrintout.equals(expectedFour)|| actualPrintout.equals(expectedFive)|| actualPrintout.equals(expectedSix));
        }

        @Test
        public void checkNoMoreSeatsAvailable(){
                //Arrange
                Cinema cinema = new Cinema(15);

                //Act
                cinema.buyTicket();

                //Assert
                int noOfSeat = MAX_SEAT - cinema.getAvailableSeat();
                int expected = 15;
                String expectedOutput = "All tickets have been sold.";
                assertEquals(expected, noOfSeat);
                assertEquals(expectedOutput, cinema.printSeatingPlan());
        }
}
