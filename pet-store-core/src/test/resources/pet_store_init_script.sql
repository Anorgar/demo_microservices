
DROP TABLE if EXISTS pet_type;
DROP TABLE if EXISTS pet;

CREATE TABLE pet_type (
  id smallint(6) NOT NULL,
  type varchar(255),
  PRIMARY KEY (id)
);


CREATE TABLE pet (
  id smallint(6) NOT NULL,
  type_id smallint(6),
  number smallint(6),
  price decimal(5,2),
  name varchar(255),
  PRIMARY KEY (id)
);
