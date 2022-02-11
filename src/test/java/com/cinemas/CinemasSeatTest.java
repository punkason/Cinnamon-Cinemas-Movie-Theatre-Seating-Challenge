package com.cinemas;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CinemasSeatTest {
        private static final int MAX_SEAT = 15;

        @Test
        public void noCustomer(){
                //Arrange
                Cinema cinema = new Cinema(0);

                //Act
                cinema.buyTicket();

                //Assert
                int expected = 0;
                String expectedZero = "   1  2  3  4  5 \nC [Y][Y][Y][Y][Y]\nB [Y][Y][Y][Y][Y]\nA [Y][Y][Y][Y][Y]\n";
                int noOfSeat = MAX_SEAT - cinema.getRemainingSeat();
                String result = cinema.printSeatingPlan();
                assertEquals(expectedZero, result);
                assertEquals(expected, noOfSeat);
        }

        @Test
        public void oneCustomer(){
                //Arrange
                Cinema cinema = new Cinema(1);

                //Act
                cinema.buyTicket();

                //Assert
                String expectedOne = "   1  2  3  4  5 \nC [Y][Y][Y][Y][Y]\nB [Y][Y][Y][Y][Y]\nA [N][Y][Y][Y][Y]\n";
                String expectedTwo = "   1  2  3  4  5 \nC [Y][Y][Y][Y][Y]\nB [Y][Y][Y][Y][Y]\nA [N][N][Y][Y][Y]\n";
                String expectedThree = "   1  2  3  4  5 \nC [Y][Y][Y][Y][Y]\nB [Y][Y][Y][Y][Y]\nA [N][N][N][Y][Y]\n";

                int noOfSeat = MAX_SEAT - cinema.getRemainingSeat();
                String result = cinema.printSeatingPlan();

                assertTrue(1 <= noOfSeat && 3 >= noOfSeat);
                assertTrue(result.equals(expectedOne) || result.equals(expectedTwo) || result.equals(expectedThree));
        }

        @Test
        public void twoCustomers(){
                //Arrange
                Cinema cinema = new Cinema(2);

                //Act
                cinema.buyTicket();

                //Assert
                String expectedTwo = "   1  2  3  4  5 \nC [Y][Y][Y][Y][Y]\nB [Y][Y][Y][Y][Y]\nA [N][N][Y][Y][Y]\n";
                String expectedThree = "   1  2  3  4  5 \nC [Y][Y][Y][Y][Y]\nB [Y][Y][Y][Y][Y]\nA [N][N][N][Y][Y]\n";
                String expectedFour = "   1  2  3  4  5 \nC [Y][Y][Y][Y][Y]\nB [Y][Y][Y][Y][Y]\nA [N][N][N][N][Y]\n";
                String expectedFive = "   1  2  3  4  5 \nC [Y][Y][Y][Y][Y]\nB [Y][Y][Y][Y][Y]\nA [N][N][N][N][N]\n";
                String expectedSix = "   1  2  3  4  5 \nC [Y][Y][Y][Y][Y]\nB [N][Y][Y][Y][Y]\nA [N][N][N][N][N]\n";
                int noOfSeat = MAX_SEAT - cinema.getRemainingSeat();
                String result = cinema.printSeatingPlan();

                assertTrue(2 <= noOfSeat && 6 >= noOfSeat);
                assertTrue(result.equals(expectedTwo) || result.equals(expectedThree) || result.equals(expectedFour)|| result.equals(expectedFive)|| result.equals(expectedSix));
        }

        @Test
        public void fullHouse(){
                //Arrange
                Cinema cinema = new Cinema(15);

                //Act
                cinema.buyTicket();

                //Assert
                int noOfSeat = MAX_SEAT - cinema.getRemainingSeat();
                int expected = 15;
                String expectedOutput = "All tickets have been sold.";
                assertEquals(expected, noOfSeat);
                assertEquals(expectedOutput, cinema.printSeatingPlan());
        }
}
