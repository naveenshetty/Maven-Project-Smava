package de.smava.int_test.pages;

public enum PurposeOption {
    Wohnen(886), Umschuldung(8992946), AutoMotorrad(887), Gewerbe(40895887);

    private int value;

    PurposeOption(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}