create table Cliente (
    cpf varchar2(11), /* PK */
    nome varchar2(128),
    endereco varchar2(128),
    cidade varchar2(64),
    cep varchar2(8), /* "99999999" */
    ddd varchar2(3), /* "999" */
    telefone varchar2(9), /* "999999999" */
    limiteCred Number(16, 2), /* 99999999999999.99 */
    limiteDisp Number(16, 2) /* 99999999999999.99 */
);

create table Pedido (
    numero varchar2(8), /* PK */
    dataEmissao varchar2(10),
    dataPagto varchar2(10),
    formaPagto varchar2(1),
    cliente varchar2(11), /* FK Cliente.cpf */
    vendedor varchar2(11) /* FK Vendedor.cpf */
);

create table Produto (
    codigo varchar2(8), /* PK */
    descricao varchar2(256),
    qtdeEstoque number(16, 6), /* 9999999999.999999 */
    unidadeMedida varchar2(2), /* "UN" | "LT" | "KG" */
    preco number(8, 2), /* 999999.99 */
    estoqueMinimo number(16, 6) /* 9999999999.999999 */
);

create table ItemPedido (
    pedido varchar2(8),  /* FK Pedido.numero  | composite */
    produto varchar2(8), /* FK Produto.codigo |     PK    */
    sequencia number(8, 0), /* 99999999 */
    qtdeVendida number(16, 6), /* 9999999999.999999 */
    quantidade number(16, 6) /* 9999999999.999999 */
);

create table Vendedor (
    cpf varchar2(11), /* PK */
    nome varchar2(128),
    endereco varchar2(128),
    cidade varchar2(64),
    cep varchar2(8),
    ddd varchar2(3),
    telefone varchar2(9),
    taxaComissao number(8, 7), /* 0.0000000 - 1.0000000 */
    salarioBase number(16, 2) /* 99999999999999.99 */
);
