/* Tabla customer */

INSERT INTO customers (id,email, firstname, lastname, password) VALUES (1, 'vitty@hotmail.com', 'Vitty', 'Pena', '123');
INSERT INTO customers (id,email, firstname, lastname, password) VALUES (2, 'pedro@hotmail.com', 'Pedro', 'Dil', 'aaa');
INSERT INTO customers (id,email, firstname, lastname, password) VALUES (3, 'bilbo@hotmail.com', 'Bilbo', 'Bolson', '321');
INSERT INTO customers (id,email, firstname, lastname, password) VALUES (4, 'marta@hotmail.com', 'Marta', 'Rapia', 'eee');
INSERT INTO customers (id,email, firstname, lastname, password) VALUES (5, 'sergio@hotmail.com','Sergio', 'Alvarez', '111');
INSERT INTO customers (id,email, firstname, lastname, password) VALUES (6, 'rosa@hotmail.com', 'Rosa', 'Domingez', 'aea');

/* Tabla address */
INSERT INTO address (id, fk_customer, country, address, zipcode) VALUES(1, 6, 'EsPaña', 'san juan', '50015');
INSERT INTO address (id, fk_customer, country, address, zipcode) VALUES(2, 2, 'italia', 'almirante preso', '50011');
INSERT INTO address (id, fk_customer, country, address, zipcode) VALUES(3, 4, 'francia', 'av madrid', '50012');
INSERT INTO address (id, fk_customer, country, address, zipcode) VALUES(4, 3, 'EsPaña', 'carlos v', '50013');
INSERT INTO address (id, fk_customer, country, address, zipcode) VALUES(5, 1, 'alemania', 'actur', '50014');
INSERT INTO address (id, fk_customer, country, address, zipcode) VALUES(6, 5, 'EsPaña', 'las fuentes', '50010');


/* Tabla partida */
INSERT INTO partida (id, fk_customer,numero_muertes,enemigos_fantasma_derrotados, enemigos_esqueletos_derrotados, enemigos_bestia_derrotados, boss_final_derrotados, monedas_obtenidas, nivel_secreto) VALUES(1, 1, 151, 35, 171, 24,15,3, true);
INSERT INTO partida (id, fk_customer,numero_muertes,enemigos_fantasma_derrotados, enemigos_esqueletos_derrotados, enemigos_bestia_derrotados, boss_final_derrotados, monedas_obtenidas, nivel_secreto) VALUES(2, 2, 17, 24, 2,8, 0,2, false);
INSERT INTO partida (id, fk_customer,numero_muertes,enemigos_fantasma_derrotados, enemigos_esqueletos_derrotados, enemigos_bestia_derrotados, boss_final_derrotados, monedas_obtenidas, nivel_secreto)  VALUES(3, 3, 5, 1, 21,8,999,56, false);
INSERT INTO partida (id, fk_customer,numero_muertes,enemigos_fantasma_derrotados, enemigos_esqueletos_derrotados, enemigos_bestia_derrotados, boss_final_derrotados, monedas_obtenidas, nivel_secreto) VALUES(4, 4, 0, 7, 46,8,66,71, false);
INSERT INTO partida (id, fk_customer,numero_muertes,enemigos_fantasma_derrotados, enemigos_esqueletos_derrotados, enemigos_bestia_derrotados, boss_final_derrotados, monedas_obtenidas, nivel_secreto) VALUES(5, 5, 76, 666,8,100,1,56, false);
INSERT INTO partida (id, fk_customer,numero_muertes,enemigos_fantasma_derrotados, enemigos_esqueletos_derrotados, enemigos_bestia_derrotados, boss_final_derrotados, monedas_obtenidas, nivel_secreto) VALUES(6, 6, 1000, 5,8, 1,0,22, true);


/*Tabla character */
INSERT INTO character (id, nombre, frase ,descripcion, ruta_imagen) VALUES(1, 'Jhonathan', '¿La vida es corta?', 'Es de la familia de dracula', 'jhonathan.jpg');
INSERT INTO character (id, nombre, frase ,descripcion, ruta_imagen) VALUES(2, 'Ghost', '¿Has visto mi linterna?', 'Lleva una linterna y se cree de lo mejor, tss', 'ghost.png');
INSERT INTO character (id, nombre, frase ,descripcion, ruta_imagen) VALUES(3, 'Bestia', '¿¿garrra ggaarrr garrrrrarrr?', 'No se entera de nada', 'bestia.png');
INSERT INTO character (id, nombre, frase ,descripcion, ruta_imagen) VALUES(4, 'Esqueleto', '¿Cuanto llevo muerto?', 'En su dia fui una leyenda', 'bone.png');
INSERT INTO character (id, nombre, frase ,descripcion, ruta_imagen) VALUES(5, 'Sephirot', '¿Todo ardera?', 'Demonio antiguo', 'sephirot.jpg');