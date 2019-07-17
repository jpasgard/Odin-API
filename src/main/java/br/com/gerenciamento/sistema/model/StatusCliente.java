package br.com.gerenciamento.sistema.model;

public enum StatusCliente {
    INATIVO(0, "Invativo"),
    ATIVO(1, "Ativo");

    private Integer codigo;
    private String descricao;

    private StatusCliente(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static StatusCliente toEnum(Integer codigo)  {
        for (StatusCliente x : StatusCliente.values()) {
            if (codigo.equals(x.getCodigo()))
                return x;
        }
        return null;
    }
}