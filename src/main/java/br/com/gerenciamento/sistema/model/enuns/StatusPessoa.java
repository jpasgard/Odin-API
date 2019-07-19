package br.com.gerenciamento.sistema.model.enuns;

/**
 * @Author Rafael Castro
 * Enum com os status das pessoas cadastradas no ODIN
 */
public enum StatusPessoa {
    INATIVO(0, "Invativo"),
    ATIVO(1, "Ativo");

    private Integer codigo;
    private String descricao;

    private StatusPessoa(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static StatusPessoa toEnum(Integer codigo)  {
        for (StatusPessoa x : StatusPessoa.values()) {
            if (codigo.equals(x.getCodigo()))
                return x;
        }
        return null;
    }
}