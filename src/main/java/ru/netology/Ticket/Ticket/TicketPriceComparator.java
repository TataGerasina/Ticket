package ru.netology.Ticket.Ticket;

import java.util.Comparator;

public class TicketPriceComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket o1, Ticket o2) {
        int price1 = o1.getPrice();
        int price2 = o2.getPrice();

        if (price1 < price2) {
            return -1;
        } else if (price1 > price2) {
            return +1;
        } else {
            return 0;
        }
    }
}