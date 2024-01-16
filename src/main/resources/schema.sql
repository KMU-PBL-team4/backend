CREATE TABLE ad (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    title VARCHAR(50) NOT NULL,
                    shortheading VARCHAR(200) NOT NULL,
                    start_exposure TIMESTAMP NOT NULL,
                    end_exposure TIMESTAMP NOT NULL,
                    count INT NOT NULL,
                    reg_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
                    description TEXT
);
