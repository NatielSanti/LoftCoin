package ru.natiel.loftcoin.data;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Coin {

    public abstract long id();

    public abstract String name();

    public abstract String symbol();

    public abstract double price();

    public abstract double change24h();

    public abstract int rank();

}
