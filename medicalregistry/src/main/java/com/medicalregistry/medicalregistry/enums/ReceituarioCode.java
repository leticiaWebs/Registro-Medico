package com.medicalregistry.medicalregistry.enums;

public enum ReceituarioCode {
    simples (0),
    amarelo(1),
    azul(2),
    branco (3);

    private int value;

    ReceituarioCode(int value) {
        this.value = value;
    }

}

