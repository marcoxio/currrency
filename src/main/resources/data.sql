INSERT INTO tbl_currency(id, name, symbol, rank) VALUES(1L, 'Bitcoin', 'BTC', 1)
INSERT INTO tbl_currency(id, name, symbol, rank) VALUES(2L, 'Litecoin', 'LTK', 2)
INSERT INTO tbl_currency(id, name, symbol, rank) VALUES(3L, 'Ethereum', 'ETH', 3)


INSERT INTO tbl_quotes(id, name, symbol, price, last_update, currency_id) VALUES(1, 'Dolares Americanos', 'USD', 9500.4, sysdate(),1)
INSERT INTO tbl_quotes(id, name, symbol, price, last_update, currency_id) VALUES(2, 'Libra Esterlina', 'GBP', 7500.4, sysdate(),1)

