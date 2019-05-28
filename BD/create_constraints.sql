alter table Cliente
    add constraint pk_client primary key (cpf);

alter table Vendedor
    add constraint pk_vendedor primary key (cpf);

alter table Produto
    add constraint pk_produto primary key (codigo);

alter table Pedido
    add constraint pk_pedido primary key (numero)
    add constraint fk_cliente foreign key (cliente) references Cliente
    add constraint fk_vendedor foreign key (vendedor) references Vendedor;

alter table ItemPedido
    add constraint pk_itemPedido primary key (pedido, produto)
    add constraint fk_pedido foreign key (pedido) references Pedido
    add constraint fk_produto foreign key (produto) references Produto;
