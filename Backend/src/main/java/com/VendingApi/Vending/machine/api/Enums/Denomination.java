package com.VendingApi.Vending.machine.api.Enums;

public enum Denomination {
    FIVE_RAND(5),
    TEN_RAND(10),
    TWENTY_RAND(20),
    FIFTY_RAND(50),
    HUNDRED_RAND(100);

    private final int value;

    Denomination(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
