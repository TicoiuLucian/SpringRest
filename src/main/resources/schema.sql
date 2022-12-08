CREATE TABLE IF NOT EXISTS Owner
(
    Pk_Owner_Id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS Car
(
    Pk_Car_Id INT PRIMARY KEY AUTO_INCREMENT,
    manufacturer VARCHAR(100),
    model VARCHAR(100),
    car_year VARCHAR(100),
    Fk_Owner_Id INT,
    FOREIGN KEY(Fk_Owner_Id) REFERENCES Owner(Pk_Owner_Id)
);




