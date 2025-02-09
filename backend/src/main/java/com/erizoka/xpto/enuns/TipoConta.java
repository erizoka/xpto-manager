package com.erizoka.xpto.enuns;

public enum TipoConta {
    PRATA(500.0),
    OURO(1000.0),
    PLATINA(2500.0),
    DIAMANTE(5000.0);

    private final Double limite;

    TipoConta(Double limite) {
        this.limite = limite;
    }

    public Double getLimite() {
        return limite;
    }

    public static TipoConta obterTipoPorFaixaSalarial(Double faixaSalarial) {
        if (faixaSalarial <= 3000) {
            return PRATA;
        } else if (faixaSalarial <= 5000) {
            return OURO;
        } else if (faixaSalarial <= 10000) {
            return PLATINA;
        } else {
            return DIAMANTE;
        }
    }
}