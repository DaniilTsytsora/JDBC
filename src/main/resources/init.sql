CREATE TABLE user (
                      id      INT AUTO_INCREMENT  PRIMARY KEY,
                      surname TEXT    NOT NULL,
                      phone   TEXT,
                      addres  TEXT,
                      created timestamp DEFAULT now()
)