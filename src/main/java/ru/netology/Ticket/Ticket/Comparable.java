package ru.netology.Ticket.Ticket;

public interface Comparable<Ticket> {
    int compareTo(Ticket o);

    int add(Ticket o);

    int search(Ticket o);
}
