
    create table bici (
        id_bici integer not null auto_increment,
        id_sospensioni integer not null,
        numero_marce integer,
        pieghevole bit,
        primary key (id_bici)
    ) engine=InnoDB;

    create table categoria (
        id integer not null,
        nome varchar(50) not null,
        tipo varchar(255) not null,
        primary key (id, tipo)
    ) engine=InnoDB;

    create table colore (
        id_colore integer not null auto_increment,
        nome varchar(50) not null,
        primary key (id_colore)
    ) engine=InnoDB;

    create table macchina (
        cc integer not null,
        id_macchina integer not null auto_increment,
        numero_porte integer not null,
        targa varchar(7) not null,
        primary key (id_macchina)
    ) engine=InnoDB;

    create table marca_modello (
        id_marca_modello integer not null auto_increment,
        marca varchar(50) not null,
        modello varchar(50) not null,
        primary key (id_marca_modello)
    ) engine=InnoDB;

    create table messaggi_sistema (
        code varchar(255) not null,
        language varchar(255) not null,
        messaggio varchar(255),
        primary key (code, language)
    ) engine=InnoDB;

    create table moto (
        cc integer not null,
        id_moto integer not null auto_increment,
        targa varchar(7) not null,
        primary key (id_moto)
    ) engine=InnoDB;

    create table sospensioni (
        id_sospensione integer not null auto_increment,
        nome varchar(50) not null,
        primary key (id_sospensione)
    ) engine=InnoDB;

    create table tipo_alimentazione (
        id integer not null,
        nome varchar(50) not null,
        tipo varchar(255) not null,
        primary key (id, tipo)
    ) engine=InnoDB;

    create table tipo_veicolo (
        id_tipo_veicolo integer not null auto_increment,
        nome varchar(50) not null,
        primary key (id_tipo_veicolo)
    ) engine=InnoDB;

    create table veicolo (
        id_alimentazione integer not null,
        id_bici integer,
        id_categoria integer not null,
        id_colore integer not null,
        id_macchina integer,
        id_marca_modello integer not null,
        id_moto integer,
        id_tipo_veicolo integer not null,
        id_veicolo integer not null auto_increment,
        numero_ruote integer not null,
        data_inserimento TIMESTAMP DEFAULT CURRENT_TIMESTAMP null,
        tipo_alimentazione varchar(255) not null,
        tipo_categoria varchar(255) not null,
        primary key (id_veicolo)
    ) engine=InnoDB;

    alter table marca_modello 
       add constraint UKe87pa4v9je0x31g8i519c0tv9 unique (marca, modello);

    alter table tipo_veicolo 
       add constraint UKecy1ybvkegd6gi9kuksu2ckqp unique (nome);

    alter table veicolo 
       add constraint UK5bymgy200kk69dmnfiysdf7lf unique (id_bici);

    alter table veicolo 
       add constraint UK13ks038o7h9c9x4qi5bchu0wj unique (id_macchina);

    alter table veicolo 
       add constraint UK89l9dmjnynoafgwaj6p2do24b unique (id_moto);

    alter table bici 
       add constraint FKhrj12333op8hw9bekfl1a2xj1 
       foreign key (id_sospensioni) 
       references sospensioni (id_sospensione);

    alter table veicolo 
       add constraint FK86sw4w41kfvddcal21jbtrsoo 
       foreign key (id_bici) 
       references bici (id_bici);

    alter table veicolo 
       add constraint FK4wh497u3hhj0l61oihgd7ycf4 
       foreign key (id_categoria, tipo_categoria) 
       references categoria (id, tipo);

    alter table veicolo 
       add constraint FK1c8wuj83gmqgnjcyerakq2vge 
       foreign key (id_colore) 
       references colore (id_colore);

    alter table veicolo 
       add constraint FKg0gifxaj166l67dfuaix6gx65 
       foreign key (id_macchina) 
       references macchina (id_macchina);

    alter table veicolo 
       add constraint FK1xmc0626slyxkikw3c62br7t6 
       foreign key (id_marca_modello) 
       references marca_modello (id_marca_modello);

    alter table veicolo 
       add constraint FK676kcray54mxm3vae0yb7bv4b 
       foreign key (id_moto) 
       references moto (id_moto);

    alter table veicolo 
       add constraint FKgafsag0f40h4jddtgqcoh42u7 
       foreign key (id_alimentazione, tipo_alimentazione) 
       references tipo_alimentazione (id, tipo);

    alter table veicolo 
       add constraint FK8anvnj7a7qu0jfikivb1qi4g 
       foreign key (id_tipo_veicolo) 
       references tipo_veicolo (id_tipo_veicolo);
