use mydb;

SELECT * FROM vendedor;
SELECT * FROM produto;

INSERT INTO `mydb`.`vendedor` (`idvendedor`, `usuario_nome`) VALUES ('1', 'Matheus');

INSERT INTO `mydb`.`PRODUTO` (`idProduto`, `nome`, `preco`, `estoque`, `cod. fabricante`, `vendedor_idvendedor`, `cliente_idcliente`) VALUES ('1', 'camisa', '60', '2', '321', '1', '1');
INSERT INTO `mydb`.`PRODUTO` (`idProduto`, `nome`, `preco`, `estoque`, `cod. fabricante`, `vendedor_idvendedor`, `cliente_idcliente`) VALUES ('2', 'calça', '50', '5', '123', '1', '1');