package com;

public class Surname {
    private String surname;
    private String frequency;
    private String rank;

    public Surname(String surname, String frequency, String rank) {
        this.surname = surname;
        this.frequency = frequency;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Surname: " + surname.toUpperCase() + " frequency: " + frequency + "% rank: " + rank;
    }


//    @Override
//    public String toString() {
//        return "Surname{" +
//                "surname='" + surname + '\'' +
//                ", frequency='" + frequency + '\'' +
//                ", rank='" + rank + '\'' +
//                '}';
//    }
}
