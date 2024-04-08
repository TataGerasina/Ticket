package ru.netology.Ticket.Ticket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


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

        Ticket ticket1 = new Ticket("MSK", "SPB", 6_000, 8, 10);
        Ticket ticket2 = new Ticket("SPB", "MSK", 8_000, 10, 13);
        Ticket ticket3 = new Ticket("SPB", "LAS", 28_000, 14, 18);
        Ticket ticket4 = new Ticket("SPB", "AMS", 16_000, 5, 9);
        Ticket ticket5 = new Ticket("AMS", "SPB", 12_000, 7, 8);
        Ticket ticket6 = new Ticket("SPB", "MSK", 11_000, 17, 19);
        Ticket ticket7 = new Ticket("SPB", "MSK", 13_000, 15, 17);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.search("SPB", "MSK");
        Ticket[] expected = {ticket2, ticket6, ticket7};

        Assertions.assertArrayEquals(expected, actual);
    }

//    @Test
//    public void ShouldSortTicketWithTimeComporator() {
//        AviaSouls manager = new AviaSouls();
//
//        Ticket ticket1 = new Ticket("MSK", "SPB", 6_000, 8, 10);
//        Ticket ticket2 = new Ticket("SPB", "MSK", 10_000, 10, 13);
//        Ticket ticket3 = new Ticket("SPB", "LAS", 14_000, 14, 18);
//        Ticket ticket4 = new Ticket("SPB", "AMS", 11_000, 5, 9);
//        Ticket ticket5 = new Ticket("AMS", "SPB", 10_000, 7, 8);
//        Ticket ticket6 = new Ticket("SPB", "MSK", 8_000, 6, 10);
//
//        manager.add(ticket1);
//        manager.add(ticket2);
//        manager.add(ticket3);
//        manager.add(ticket4);
//        manager.add(ticket5);
//        manager.add(ticket6);
//
//        Comparator<Ticket> timeComparator = new TicketTimeComparator();
//
//        Ticket[] actual = manager.searchAndSortBy("SPB", "MSK", timeComparator);
//        Ticket[] expected = {ticket2, ticket6};
//
//        Assertions.assertArrayEquals(expected, actual);
    }
