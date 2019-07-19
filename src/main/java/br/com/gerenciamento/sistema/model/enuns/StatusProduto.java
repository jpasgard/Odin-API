package br.com.gerenciamento.sistema.model.enuns;

/**
 * @Author Rafael Castro
 * Enum com os status das pessoas cadastradas no ODIN
 */
public enum StatusProduto {
    FORA(0, "Sem Estoque"),
    ESTOQUE(1, "Em Estoque");

    private Integer codigo;
    private String descricao;

    private StatusProduto(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static StatusProduto toEnum(Integer codigo)  {
        for (StatusProduto x : StatusProduto.values()) {
            if (codigo.equals(x.getCodigo()))
                return x;
        }
        return null;
    }
}