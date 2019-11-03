package br.com.pizzaria.core.api.infrastructure.util;


public enum Operador {

    MENO_QUE(-1),
    IGUAL(0),
    MAIOR_QUE(1);

    private Integer value;

    private Operador(Integer value) {
        this.value = value;
    }


    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
