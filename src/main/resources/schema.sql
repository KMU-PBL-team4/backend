CREATE TABLE ad
(
    id             INT AUTO_INCREMENT PRIMARY KEY,
    title          VARCHAR(50)                         NOT NULL,
    shortheading   VARCHAR(200)                        NOT NULL,
    category       VARCHAR(10)                         NOT NULL,
    start_exposure TIMESTAMP                           NOT NULL,
    end_exposure   TIMESTAMP                           NOT NULL,
    count          INT                                 NOT NULL,
    reg_date       TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    description    TEXT,
    content        TEXT COMMENT '영상/이미지 링크'

);
drop table if exists user;
create table user
(
    id     int auto_increment primary key,
    username varchar(20) not null,
    age    int         not null,
    gender varchar(10) not null
);
create table ad_tag
(
    id     int primary key,
    tag varchar(10) not null
);
INSERT INTO ad_tag (id, tag)
VALUES
    (1, '10대 이하'),
    (2, '20대'),
    (3, '30대'),
    (4, '40대'),
    (5, '50대'),
    (6, '60대'),
    (7, '70대 이상'),
    (10, '남성'),
    (11, '여성');
#     (1, '10대 이하', '2005-01-01', '2024-12-31'),
#     (2, '20대', '1995-01-01', '2004-12-31'),
#     (3, '30대', '1985-01-01', '1994-12-31'),
#     (4, '40대', '1975-01-01', '1984-12-31'),
#     (5, '50대', '1965-01-01', '1974-12-31'),
#     (6, '60대', '1955-01-01', '1964-12-31'),
#     (7, '70대 이상', '1900-01-01', '1954-12-31');





