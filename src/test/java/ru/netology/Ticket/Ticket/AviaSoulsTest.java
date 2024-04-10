package ru.netology.Ticket.Ticket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Comparator;



class AviaSoulsTest {
    @Test
    public void ShouldSortOneTicketFromTo() {

        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("MSK", "SPB", 10_000, 8, 10);
        Ticket ticket2 = new Ticket("SPB", "MSK", 10_000, 10, 13);
        Ticket ticket3 = new Ticket("SPB", "LAS", 10_000, 14, 18);
        Ticket ticket4 = new Ticket("SPB", "AMS", 12_000, 5, 9);
        Ticket ticket5 = new Ticket("AMS", "SPB", 10_000, 7, 8);
        Ticket ticket6 = new Ticket("SPB", "MSK", 6_000, 17, 19);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);


        Ticket[] actual = manager.search("SPB", "LAS");
        Ticket[] expected = {ticket3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSortZeroTicket() {

        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("MSK", "SPB", 10_000, 8, 10);
        Ticket ticket2 = new Ticket("SPB", "MSK", 10_000, 10, 13);
        Ticket ticket3 = new Ticket("SPB", "LAS", 10_000, 14, 18);
        Ticket ticket4 = new Ticket("SPB", "AMS", 12_000, 5, 9);
        Ticket ticket5 = new Ticket("AMS", "SPB", 10_000, 7, 8);
        Ticket ticket6 = new Ticket("SPB", "MSK", 10_000, 17, 19);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);


        Ticket[] actual = manager.search("AMS", "MSK");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void ShouldSortFewTickets() {

        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("SPB", "MSK", 6_000, 8, 10);
        Ticket ticket2 = new Ticket("SPB", "MSK", 8_000, 10, 13);
        Ticket ticket3 = new Ticket("SPB", "LAS", 28_000, 14, 18);
        Ticket ticket4 = new Ticket("SPB", "AMS", 16_000, 5, 9);
        Ticket ticket5 = new Ticket("AMS", "SPB", 12_000, 7, 8);
        Ticket ticket6 = new Ticket("SPB", "MSK", 11_000, 17, 19);
        Ticket ticket7 = new Ticket("SPB", "MSK", 13_000, 15, 17);
        Ticket ticket8 = new Ticket("SPB", "MSK", 66_000, 16, 18);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("SPB", "MSK");
        Ticket[] expected = {ticket1, ticket2, ticket6, ticket7, ticket8};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSortTicketWithTimeComparator() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("MSK", "SPB", 6_000, 8, 10);
        Ticket ticket2 = new Ticket("SPB", "MSK", 10_000, 10, 13); //3
        Ticket ticket3 = new Ticket("SPB", "LAS", 14_000, 14, 18);
        Ticket ticket4 = new Ticket("SPB", "AMS", 11_000, 5, 9);
        Ticket ticket5 = new Ticket("AMS", "SPB", 10_000, 7, 8);
        Ticket ticket6 = new Ticket("SPB", "MSK", 8_000, 6, 10); //4
        Ticket ticket7 = new Ticket("SPB", "MSK", 13_000, 15, 17);//2
        Ticket ticket8 = new Ticket("SPB", "MSK", 66_000, 16, 17);//1

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);


        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("SPB", "MSK", comparator);
        Ticket[] expected = {ticket8, ticket7, ticket2,ticket6};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSortZeroTicketWithComparator() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("MSK", "SPB", 6_000, 8, 10);
        Ticket ticket2 = new Ticket("SPB", "MSK", 10_000, 10, 13);
        Ticket ticket3 = new Ticket("SPB", "LAS", 14_000, 14, 18);
        Ticket ticket4 = new Ticket("SPB", "AMS", 11_000, 5, 9);
        Ticket ticket5 = new Ticket("AMS", "SPB", 10_000, 7, 8);
        Ticket ticket6 = new Ticket("SPB", "MSK", 8_000, 6, 10);
        Ticket ticket7 = new Ticket("SPB", "MSK", 13_000, 15, 17);
        Ticket ticket8 = new Ticket("SPB", "MSK", 66_000, 16, 17);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);


        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("LAS", "MSK", comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSortOneTicketWithComparator() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1= new Ticket("SPB", "MSK", 8_000, 6, 10);
        Ticket ticket2 = new Ticket("SPB", "MSK", 10_000, 10, 13);
        Ticket ticket3 = new Ticket("SPB", "LAS", 14_000, 14, 18);
        Ticket ticket4 = new Ticket("SPB", "AMS", 11_000, 5, 9);
        Ticket ticket5 = new Ticket("AMS", "SPB", 10_000, 7, 8);
        Ticket ticket6 = new Ticket("MSK", "SPB", 6_000, 8, 10);
        Ticket ticket7 = new Ticket("SPB", "MSK", 13_000, 15, 17);
        Ticket ticket8 = new Ticket("SPB", "MSK", 66_000, 16, 17);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);


        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("MSK", "SPB", comparator);
        Ticket[] expected = {ticket6};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSortFewTicketWithPriceComparator() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("MSK", "SPB", 600, 8, 10);
        Ticket ticket2 = new Ticket("SPB", "MSK", 1500, 10, 13); //2
        Ticket ticket3 = new Ticket("SPB", "LAS", 140, 14, 18);
        Ticket ticket4 = new Ticket("SPB", "AMS", 900, 5, 9);
        Ticket ticket5 = new Ticket("AMS", "SPB", 800, 7, 8);
        Ticket ticket6 = new Ticket("SPB", "MSK", 900, 6, 10); //1 ВЕДЬ цена МЕНЬШЕ!
        Ticket ticket7 = new Ticket("SPB", "MSK", 13_000, 15, 17);//3
        Ticket ticket8 = new Ticket("SPB", "MSK", 66_000, 16, 17);//4


        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);



        Comparator<Ticket> comparator = new TicketPriceComparator();

        Ticket[] actual = manager.searchAndSortBy("SPB", "MSK", comparator);
        Ticket[] expected = {ticket6, ticket2, ticket7,ticket8};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void ShouldSortZeroTicketWithPriceComparator() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("MSK", "SPB", 600, 8, 10);
        Ticket ticket2 = new Ticket("SPB", "MSK", 1500, 10, 13);
        Ticket ticket3 = new Ticket("SPB", "LAS", 140, 14, 18);
        Ticket ticket4 = new Ticket("SPB", "AMS", 900, 5, 9);
        Ticket ticket5 = new Ticket("AMS", "SPB", 800, 7, 8);
        Ticket ticket6 = new Ticket("SPB", "MSK", 900, 6, 10);
        Ticket ticket7 = new Ticket("SPB", "MSK", 13_000, 15, 17);
        Ticket ticket8 = new Ticket("SPB", "MSK", 66_000, 16, 17);


        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);



        Comparator<Ticket> comparator = new TicketPriceComparator();

        Ticket[] actual = manager.searchAndSortBy("AMS", "MSK", comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSortOneTicketWithPriceComparator() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("MSK", "SPB", 600, 8, 10);
        Ticket ticket2 = new Ticket("SPB", "MSK", 1500, 10, 13);
        Ticket ticket3 = new Ticket("SPB", "LAS", 140, 14, 18);
        Ticket ticket4 = new Ticket("SPB", "AMS", 900, 5, 9);
        Ticket ticket5 = new Ticket("AMS", "SPB", 800, 7, 8);
        Ticket ticket6 = new Ticket("SPB", "MSK", 900, 6, 10);
        Ticket ticket7 = new Ticket("SPB", "MSK", 13_000, 15, 17);
        Ticket ticket8 = new Ticket("SPB", "MSK", 66_000, 16, 17);


        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);



        Comparator<Ticket> comparator = new TicketPriceComparator();

        Ticket[] actual = manager.searchAndSortBy("AMS", "SPB", comparator);
        Ticket[] expected = {ticket5};

        Assertions.assertArrayEquals(expected, actual);
    }
}
