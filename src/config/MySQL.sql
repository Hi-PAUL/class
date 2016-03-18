CREATE TABLE
    t_user
    (
        id bigint NOT NULL AUTO_INCREMENT,
        password VARCHAR(50),
        username VARCHAR(50),
        address VARCHAR(50),
        phone VARCHAR(50),
        email VARCHAR(20),
        PRIMARY KEY (id)
    );