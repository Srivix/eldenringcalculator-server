INSERT INTO WEAPON_TYPE(id, name) VALUES (1, 'ESPADON');
INSERT INTO WEAPON_TYPE(id, name) VALUES (2, 'KATANA');
INSERT INTO WEAPON_TYPE(id, name) VALUES (3, 'TALISMAN');

INSERT INTO WEAPON(id, name, weapontype_id, dexreq) VALUES (1, 'Uchigatana', 2, 15);
INSERT INTO WEAPON(id, name, weapontype_id, dexreq, strengreq) VALUES (2, 'Espadon', 1, 10, 15);
INSERT INTO WEAPON(id, name, weapontype_id, strengreq) VALUES (3, 'Zweihander', 1, 25);
INSERT INTO WEAPON(id, name, weapontype_id, intreq) VALUES (4, 'Talisman lloyd', 3, 10);
INSERT INTO WEAPON(id, name, weapontype_id, dexreq, intreq) VALUES (5, 'Cruz', 3, 10, 20);

INSERT INTO BUILD(id, name, level, dexterity, strength, intelect, weapon1_id) VALUES (1, '', 25, 15, 0, 10, 1);