INSERT INTO Cliente
(cpf, nome, endereco, cidade, uf, cep, ddd, telefone, limiteCred, limiteDisp) VALUES
('31958771805', 'Pedro Bernardo de SOUSA', 'Rua Icaraí, 308', 'Sorocaba', 'SP', '18044270', '11', '974703060', 999.9, 999.9);

INSERT INTO Vendedor
(cpf, nome, endereco, cidade, uf, cep, ddd, telefone, taxaComissao, salarioBase) VALUES
('05226752474', 'Cecília Costa Cabral SOUSA', 'Rua Icaraí, 308', 'Sorocaba', 'SP', '18044270', '11', '963189090', 0.1, 2499.9);

INSERT INTO Produto
(codigo, descricao, qtdeEstoque, unidadeMedida, preco, estoqueMinimo) VALUES
('0', 'Acer Nitro 5', 10, 'UN', 1199.9, 2);
INSERT INTO Produto
(codigo, descricao, qtdeEstoque, unidadeMedida, preco, estoqueMinimo) VALUES
('1', 'Mouse Logitech M170', 10, 'UN', 71.45, 1);
INSERT INTO Produto
(codigo, descricao, qtdeEstoque, unidadeMedida, preco, estoqueMinimo) VALUES
('2', 'Balinha', 20, 'UN', 1, 0);
