-- script usado para banco mockado em postgresql
CREATE TYPE privilege_type AS ENUM ('CLIENT', 'USER', 'ADMIN');

DROP TABLE IF EXISTS cliente;

CREATE table cliente (
	nome TEXT,
	idade INT,
	email VARCHAR(50),
	faixa_salarial DOUBLE PRECISION,
	privilege privilege_type,
	senha VARCHAR(50),
	primary key(email)
);

CREATE TYPE tipo_conta AS ENUM ('PRATA','OURO','PLATINA','DIAMANTE');

DROP TABLE IF EXISTS conta;

CREATE TABLE conta (
    id SERIAL PRIMARY KEY, 
    limite DOUBLE PRECISION, 
    cliente_id TEXT,         
    tipo tipo_conta       
);

ALTER TABLE conta
ADD CONSTRAINT fk_cliente
FOREIGN KEY (cliente_id)
REFERENCES cliente(email); 

INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(889.2, 56, 'abernier@example.com', 'Mariam Reichert PhD', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(2084.11, 58, 'alexandria.gutmann@example.org', 'Kyra Gutmann', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(395.25, 61, 'amani.wuckert@example.net', 'Mrs. Ashlynn Treutel', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(407.48, 66, 'ankunding.cheyanne@example.net', 'Cassie Breitenberg', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(522577.31, 97, 'asimonis@example.net', 'Herman Skiles', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(584.0, 80, 'bell.botsford@example.org', 'Ashly Sawayn I', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(689550.84, 44, 'bernier.junius@example.org', 'Abigail Hagenes', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(297487.77, 62, 'berry.heaney@example.net', 'Denis Schroeder', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(7556151.11, 34, 'bkris@example.org', 'Yessenia Rau II', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(617.38, 30, 'brice52@example.com', 'Magali Feil', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(18359059.13, 58, 'bridie93@example.net', 'Melany Mann', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(403492464.41, 80, 'brown.aliya@example.org', 'Emily Bradtke I', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(31118.75, 31, 'buckridge.tiana@example.com', 'Miss Rossie Kohler II', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(1590.43, 78, 'carlie15@example.org', 'Dr. Reba Grady III', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(190891.39, 89, 'celestino10@example.org', 'Dr. Brycen Kirlin', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(77999571.99, 28, 'celine.cummerata@example.org', 'Ova Hauck', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(104.41, 49, 'cordie.eichmann@example.com', 'Miss Cortney Doyle', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(305397.43, 92, 'cronin.theo@example.org', 'Kristofer Sipes MD', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(977.83, 57, 'dejon41@example.net', 'Benny Denesik Jr.', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(85384934.62, 37, 'dejuan67@example.com', 'Lea Miller', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(443450.12, 47, 'demetrius.fisher@example.net', 'Bryana Hermann', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(14897.49, 21, 'denesik.ruben@example.com', 'Donnell Lind MD', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(36583.92, 58, 'derek.paucek@example.org', 'Ken Auer II', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(34276761.76, 92, 'destini.marks@example.org', 'Leonel Adams', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(695233169.5, 79, 'dkilback@example.org', 'Dr. Laverna Barrows DDS', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(2140.55, 83, 'dkoepp@example.com', 'Regan Walter PhD', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(13564.87, 32, 'dsanford@example.org', 'Tom Hirthe', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(146.82, 87, 'ernser.sarah@example.org', 'Stanford Davis', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(413.61, 24, 'farrell.noemy@example.org', 'Stacy Kilback', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(130.73, 53, 'freddie94@example.org', 'Mr. Eldred Nikolaus MD', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(163801089.81, 51, 'freichel@example.net', 'Mr. Zack Wisozk', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(606.36, 68, 'freynolds@example.com', 'Dusty Kunde', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(634.82, 62, 'garrison.larson@example.com', 'Maxie O\`Reilly III', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(352.12, 23, 'gdonnelly@example.org', 'Mr. Moshe Mraz', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(29984721.28, 27, 'geo.dach@example.org', 'Prof. Barbara Dach', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(151.69, 82, 'gleason.daphney@example.com', 'Jenifer Muller', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(62463470.79, 96, 'gulgowski.kali@example.com', 'Dr. Frederic Little', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(188671.16, 75, 'halvorson.ivy@example.net', 'Bert Cummings', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(1467.07, 45, 'harrison.bradtke@example.com', 'Ardith Wilkinson', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(7792.28, 35, 'heaney.meggie@example.org', 'Twila Stark', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(189193721.73, 88, 'hilario79@example.org', 'Thelma Cormier', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(1250.65, 22, 'homenick.sydney@example.com', 'Prof. Van Auer', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(26.86, 28, 'howe.elian@example.net', 'Prof. Palma Spinka', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(808.06, 49, 'ignatius.kuhlman@example.org', 'Norene Ortiz', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(29.88, 49, 'jacobi.megane@example.com', 'Wava Buckridge', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(4683692.41, 75, 'jody41@example.com', 'Prof. Cameron Keeling', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(701.35, 77, 'julian81@example.com', 'Zack Stiedemann', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(809.64, 66, 'kaley41@example.org', 'Haven Mann', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(204014467.33, 80, 'kariane.marvin@example.org', 'Francisco Swaniawski', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(199.97, 73, 'karianne.wolff@example.org', 'Prof. Lavonne King', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(405.51, 47, 'klocko.kareem@example.net', 'Keith Hoeger', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(1155.96, 99, 'kunde.kraig@example.org', 'Mrs. Avis Gerhold', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(32062756.73, 78, 'kunze.aniya@example.com', 'Dr. Clair Bayer', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(964.64, 60, 'magdalen99@example.org', 'Elyssa Gerhold', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(984.76, 19, 'maiya.boehm@example.org', 'Anastasia Kemmer', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(3305.84, 58, 'marilyne.mcglynn@example.net', 'Maegan Hackett', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(325997037.21, 58, 'marlene.beahan@example.net', 'Eladio Weber', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(10847.18, 29, 'maurine88@example.org', 'Damien Bauch', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(3997102.27, 41, 'medhurst.tiffany@example.net', 'Dr. Gabe Paucek', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(275805079.07, 93, 'mgleason@example.net', 'Mr. Mustafa Altenwerth', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(135858.96, 23, 'milford.corkery@example.net', 'Madie Bechtelar', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(8217.66, 27, 'milton.white@example.org', 'Gladys Goodwin', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(28407202.05, 29, 'molly.feil@example.org', 'Moshe Spencer', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(30658330.39, 62, 'mstehr@example.net', 'Ms. Sandrine Nienow', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(800.14, 34, 'ncorkery@example.org', 'Joanie Purdy', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(41300639, 74, 'nwehner@example.org', 'Miss Lila Jacobs Sr.', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(792.82, 21, 'octavia.white@example.com', 'Sydnee Koelpin', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(78729.77, 33, 'oswald.parisian@example.net', 'Ibrahim Kiehn MD', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(1802878.73, 61, 'pfeffer.louisa@example.com', 'Adrianna Hilpert', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(839.61, 20, 'pink.schoen@example.com', 'Agustin Champlin', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(33041.46, 64, 'qdonnelly@example.net', 'Elijah Carter', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(3830.46, 20, 'qfahey@example.com', 'Rhiannon Kirlin PhD', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(354.53, 98, 'qrau@example.com', 'Keeley Lindgren', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(23164.7, 31, 'quinton.koelpin@example.org', 'Prof. Margarita Conn V', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(3198.02, 43, 'rcorwin@example.org', 'Tyree Luettgen', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(14555593.68, 50, 'reilly.emmie@example.net', 'Emmanuelle Waelchi', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(1151.21, 98, 'rex.frami@example.org', 'Josh Abbott', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(686.48, 37, 'roberto09@example.org', 'Mrs. Kaylah Wyman DVM', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(902.09, 76, 'rose71@example.net', 'Skyla Raynor', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(887.3, 34, 'rossie25@example.org', 'Mr. Baron Hodkiewicz DDS', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(6059.99, 31, 'rrunolfsdottir@example.org', 'Broderick Lueilwitz', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(983.83, 65, 'salvador.corwin@example.net', 'Dayna Gleichner', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(1405.43, 73, 'sophie.grimes@example.org', 'Prof. Carli Will', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(479.21, 34, 'stehr.lane@example.com', 'Prof. Al Oberbrunner Sr.', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(7607114.09, 93, 'swaniawski.sophia@example.com', 'Francesco Ankunding', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(440195394.59, 64, 'sylvester59@example.com', 'Arden Gorczany', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(455.82, 64, 'tbernier@example.com', 'Lesley Lueilwitz', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(745.03, 29, 'trycia.fay@example.org', 'Carrie Hagenes I', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(788.06, 62, 'ublanda@example.net', 'Lauren Torphy', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(1027.07, 100, 'uturner@example.com', 'Georgianna Hoppe', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(364854.36, 42, 'vcremin@example.org', 'Dr. Vivien Miller', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(845.41, 85, 'vlittle@example.com', 'Verner Walker', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(2110.2, 27, 'ward.makenna@example.org', 'Noemi Tremblay', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(67165450.91, 32, 'wbruen@example.net', 'Dr. Erin Dooley', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(586.71, 38, 'winnifred69@example.org', 'Dr. Madison Schultz', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(20627.86, 73, 'xhomenick@example.com', 'Dr. Gladyce Klocko', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(11129.81, 26, 'xschoen@example.org', 'Modesta Kiehn', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(33943.39, 61, 'yundt.eda@example.net', 'Madonna Russel MD', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(41.63, 61, 'zkub@example.org', 'Michel Borer', 'CLIENT', NULL);
INSERT INTO public.cliente
(faixa_salarial, idade, email, nome, privilege, senha)
VALUES(57016018.85, 96, 'zmuller@example.org', 'Mr. Major O\`Connell IV', 'CLIENT', NULL);



-- povoar conta 

INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(2, 500.0, 'alexandria.gutmann@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(3, 500.0, 'amani.wuckert@example.net', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(4, 500.0, 'ankunding.cheyanne@example.net', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(5, 5000.0, 'asimonis@example.net', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(6, 500.0, 'bell.botsford@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(7, 5000.0, 'bernier.junius@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(8, 5000.0, 'berry.heaney@example.net', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(9, 5000.0, 'bkris@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(10, 500.0, 'brice52@example.com', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(11, 5000.0, 'bridie93@example.net', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(12, 5000.0, 'brown.aliya@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(13, 5000.0, 'buckridge.tiana@example.com', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(14, 500.0, 'carlie15@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(15, 5000.0, 'celestino10@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(16, 5000.0, 'celine.cummerata@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(17, 500.0, 'cordie.eichmann@example.com', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(18, 5000.0, 'cronin.theo@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(19, 500.0, 'dejon41@example.net', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(20, 5000.0, 'dejuan67@example.com', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(21, 5000.0, 'demetrius.fisher@example.net', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(22, 5000.0, 'denesik.ruben@example.com', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(23, 5000.0, 'derek.paucek@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(24, 5000.0, 'destini.marks@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(25, 5000.0, 'dkilback@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(26, 500.0, 'dkoepp@example.com', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(27, 5000.0, 'dsanford@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(28, 500.0, 'ernser.sarah@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(29, 500.0, 'farrell.noemy@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(30, 500.0, 'freddie94@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(31, 5000.0, 'freichel@example.net', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(32, 500.0, 'freynolds@example.com', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(33, 500.0, 'garrison.larson@example.com', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(34, 500.0, 'gdonnelly@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(35, 5000.0, 'geo.dach@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(36, 500.0, 'gleason.daphney@example.com', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(37, 5000.0, 'gulgowski.kali@example.com', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(38, 5000.0, 'halvorson.ivy@example.net', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(39, 500.0, 'harrison.bradtke@example.com', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(40, 2500.0, 'heaney.meggie@example.org', 'PLATINA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(41, 5000.0, 'hilario79@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(42, 500.0, 'homenick.sydney@example.com', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(43, 500.0, 'howe.elian@example.net', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(44, 500.0, 'ignatius.kuhlman@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(45, 500.0, 'jacobi.megane@example.com', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(46, 5000.0, 'jody41@example.com', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(47, 500.0, 'julian81@example.com', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(48, 500.0, 'kaley41@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(49, 5000.0, 'kariane.marvin@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(50, 500.0, 'karianne.wolff@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(51, 500.0, 'klocko.kareem@example.net', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(52, 500.0, 'kunde.kraig@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(53, 5000.0, 'kunze.aniya@example.com', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(54, 500.0, 'magdalen99@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(55, 500.0, 'maiya.boehm@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(56, 1000.0, 'marilyne.mcglynn@example.net', 'OURO');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(57, 5000.0, 'marlene.beahan@example.net', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(58, 5000.0, 'maurine88@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(59, 5000.0, 'medhurst.tiffany@example.net', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(60, 5000.0, 'mgleason@example.net', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(61, 5000.0, 'milford.corkery@example.net', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(62, 2500.0, 'milton.white@example.org', 'PLATINA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(63, 5000.0, 'molly.feil@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(64, 5000.0, 'mstehr@example.net', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(65, 500.0, 'ncorkery@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(66, 5000.0, 'nwehner@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(67, 500.0, 'octavia.white@example.com', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(68, 5000.0, 'oswald.parisian@example.net', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(69, 5000.0, 'pfeffer.louisa@example.com', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(70, 500.0, 'pink.schoen@example.com', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(71, 5000.0, 'qdonnelly@example.net', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(72, 1000.0, 'qfahey@example.com', 'OURO');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(73, 500.0, 'qrau@example.com', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(74, 5000.0, 'quinton.koelpin@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(75, 1000.0, 'rcorwin@example.org', 'OURO');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(76, 5000.0, 'reilly.emmie@example.net', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(77, 500.0, 'rex.frami@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(78, 500.0, 'roberto09@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(79, 500.0, 'rose71@example.net', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(80, 500.0, 'rossie25@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(81, 2500.0, 'rrunolfsdottir@example.org', 'PLATINA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(82, 500.0, 'salvador.corwin@example.net', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(83, 500.0, 'sophie.grimes@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(84, 500.0, 'stehr.lane@example.com', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(85, 5000.0, 'swaniawski.sophia@example.com', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(86, 5000.0, 'sylvester59@example.com', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(87, 500.0, 'tbernier@example.com', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(88, 500.0, 'trycia.fay@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(89, 500.0, 'ublanda@example.net', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(90, 500.0, 'uturner@example.com', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(91, 5000.0, 'vcremin@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(92, 500.0, 'vlittle@example.com', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(93, 500.0, 'ward.makenna@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(94, 5000.0, 'wbruen@example.net', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(95, 500.0, 'winnifred69@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(96, 5000.0, 'xhomenick@example.com', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(97, 5000.0, 'xschoen@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(98, 5000.0, 'yundt.eda@example.net', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(99, 500.0, 'zkub@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(100, 5000.0, 'zmuller@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(101, 500.0, 'abernier@example.com', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(102, 500.0, 'alexandria.gutmann@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(103, 500.0, 'amani.wuckert@example.net', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(104, 500.0, 'ankunding.cheyanne@example.net', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(105, 5000.0, 'asimonis@example.net', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(106, 500.0, 'bell.botsford@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(107, 5000.0, 'bernier.junius@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(108, 5000.0, 'berry.heaney@example.net', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(109, 5000.0, 'bkris@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(110, 500.0, 'brice52@example.com', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(111, 5000.0, 'bridie93@example.net', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(112, 5000.0, 'brown.aliya@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(113, 5000.0, 'buckridge.tiana@example.com', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(114, 500.0, 'carlie15@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(115, 5000.0, 'celestino10@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(116, 5000.0, 'celine.cummerata@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(117, 500.0, 'cordie.eichmann@example.com', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(118, 5000.0, 'cronin.theo@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(119, 500.0, 'dejon41@example.net', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(120, 5000.0, 'dejuan67@example.com', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(121, 5000.0, 'demetrius.fisher@example.net', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(122, 5000.0, 'denesik.ruben@example.com', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(123, 5000.0, 'derek.paucek@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(124, 5000.0, 'destini.marks@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(125, 5000.0, 'dkilback@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(126, 500.0, 'dkoepp@example.com', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(127, 5000.0, 'dsanford@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(128, 500.0, 'ernser.sarah@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(129, 500.0, 'farrell.noemy@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(130, 500.0, 'freddie94@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(131, 5000.0, 'freichel@example.net', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(132, 500.0, 'freynolds@example.com', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(133, 500.0, 'garrison.larson@example.com', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(134, 500.0, 'gdonnelly@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(135, 5000.0, 'geo.dach@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(136, 500.0, 'gleason.daphney@example.com', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(137, 5000.0, 'gulgowski.kali@example.com', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(138, 5000.0, 'halvorson.ivy@example.net', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(139, 500.0, 'harrison.bradtke@example.com', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(140, 2500.0, 'heaney.meggie@example.org', 'PLATINA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(141, 5000.0, 'hilario79@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(142, 500.0, 'homenick.sydney@example.com', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(143, 500.0, 'howe.elian@example.net', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(144, 500.0, 'ignatius.kuhlman@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(145, 500.0, 'jacobi.megane@example.com', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(146, 5000.0, 'jody41@example.com', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(147, 500.0, 'julian81@example.com', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(148, 500.0, 'kaley41@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(149, 5000.0, 'kariane.marvin@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(150, 500.0, 'karianne.wolff@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(151, 500.0, 'klocko.kareem@example.net', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(152, 500.0, 'kunde.kraig@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(153, 5000.0, 'kunze.aniya@example.com', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(154, 500.0, 'magdalen99@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(155, 500.0, 'maiya.boehm@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(156, 1000.0, 'marilyne.mcglynn@example.net', 'OURO');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(157, 5000.0, 'marlene.beahan@example.net', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(158, 5000.0, 'maurine88@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(159, 5000.0, 'medhurst.tiffany@example.net', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(160, 5000.0, 'mgleason@example.net', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(161, 5000.0, 'milford.corkery@example.net', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(162, 2500.0, 'milton.white@example.org', 'PLATINA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(163, 5000.0, 'molly.feil@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(164, 5000.0, 'mstehr@example.net', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(165, 500.0, 'ncorkery@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(166, 5000.0, 'nwehner@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(167, 500.0, 'octavia.white@example.com', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(168, 5000.0, 'oswald.parisian@example.net', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(169, 5000.0, 'pfeffer.louisa@example.com', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(170, 500.0, 'pink.schoen@example.com', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(171, 5000.0, 'qdonnelly@example.net', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(172, 1000.0, 'qfahey@example.com', 'OURO');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(173, 500.0, 'qrau@example.com', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(174, 5000.0, 'quinton.koelpin@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(175, 1000.0, 'rcorwin@example.org', 'OURO');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(176, 5000.0, 'reilly.emmie@example.net', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(177, 500.0, 'rex.frami@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(178, 500.0, 'roberto09@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(179, 500.0, 'rose71@example.net', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(180, 500.0, 'rossie25@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(181, 2500.0, 'rrunolfsdottir@example.org', 'PLATINA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(182, 500.0, 'salvador.corwin@example.net', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(183, 500.0, 'sophie.grimes@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(184, 500.0, 'stehr.lane@example.com', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(185, 5000.0, 'swaniawski.sophia@example.com', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(186, 5000.0, 'sylvester59@example.com', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(187, 500.0, 'tbernier@example.com', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(188, 500.0, 'trycia.fay@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(189, 500.0, 'ublanda@example.net', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(190, 500.0, 'uturner@example.com', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(191, 5000.0, 'vcremin@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(193, 500.0, 'ward.makenna@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(194, 5000.0, 'wbruen@example.net', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(195, 500.0, 'winnifred69@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(196, 5000.0, 'xhomenick@example.com', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(197, 5000.0, 'xschoen@example.org', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(198, 5000.0, 'yundt.eda@example.net', 'DIAMANTE');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(199, 500.0, 'zkub@example.org', 'PRATA');
INSERT INTO public.conta
(id, limite, cliente_id, tipo)
VALUES(200, 5000.0, 'zmuller@example.org', 'DIAMANTE');