CREATE TABLE car
(
    id INT PRIMARY KEY,
    manufacturer VARCHAR(100),
    model VARCHAR(100),
    year VARCHAR(100)
);

CREATE TABLE owner
(
    id INT PRIMARY KEY,
    name VARCHAR(100),
    FOREIGN KEY (id) REFERENCES car(id)

);