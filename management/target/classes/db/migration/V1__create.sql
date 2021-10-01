CREATE TABLE user(
    user_id int NOT NULL AUTO_INCREMENT,
    user_name varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    is_active int default 0,
    is_delete int default 0,
    created_at timestamp,
    modified_at timestamp,
    PRIMARY KEY (user_id)
);
CREATE TABLE spareparts(
    spareparts_id int NOT NULL AUTO_INCREMENT,
    spareparts_name varchar(255) NOT NULL,
    fk_sparepartstype_id int,
    is_active int default 0,
    is_delete int default 0,
    created_at timestamp,
    modified_at timestamp,
    PRIMARY KEY (spareparts_id)
);

CREATE TABLE sparepartstype(
    sparepartstype_id int NOT NULL AUTO_INCREMENT,
    sparepartstype_name varchar(255) NOT NULL,
    is_active int default 0,
    is_delete int default 0,
    created_at timestamp,
    modified_at timestamp,
    PRIMARY KEY (sparepartstype_id)
);

CREATE TABLE orders(
    order_id int NOT NULL AUTO_INCREMENT,
    order_quantity int NOT NULL,
    order_destination varchar(255),
    is_active int default 0,
    is_delete int default 0,
    created_at timestamp,
    modified_at timestamp,
    fk_spareparts_id int,
    fk_user_id int,
    PRIMARY KEY (order_id)
);

CREATE TABLE role(
    id int AUTO_INCREMENT,
    role_name varchar(255),
    PRIMARY KEY (id)
);

CREATE TABLE userrole(
    id int AUTO_INCREMENT,
    role_id_fk int NOT NULL,
    user_id_fk int NOT NULL,
    PRIMARY KEY (id)
);


alter table orders
        add foreign key (fk_spareparts_id) references spareparts(spareparts_id),
        add foreign key (fk_user_id) references user(user_id);

alter table userrole
        add foreign key (role_id_fk) references role(id),
        add foreign key (user_id_fk) references user(user_id);

alter table spareparts
        add foreign key (fk_sparepartstype_id) references sparepartstype(sparepartstype_id);