CREATE TABLE users
(
    id             SERIAL PRIMARY KEY NOT NULL,
    email          VARCHAR            NOT NULL,
    password       VARCHAR            NOT NULL,
    code_word      VARCHAR            NOT NULL,
    full_name      VARCHAR            NOT NULL,
    birthdate      DATE               NOT NULL,
    gender         VARCHAR            NOT NULL,
    status_avatar  VARCHAR            NOT NULL,
    status_friends VARCHAR            NOT NULL,
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP(0),
    updated_at     TIMESTAMP DEFAULT NULL
);

CREATE TABLE roles
(
    id         SERIAL PRIMARY KEY NOT NULL,
    name       VARCHAR            NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP(0),
    updated_at TIMESTAMP DEFAULT NULL
);

CREATE TABLE users_roles
(
    user_id  INT NOT NULL REFERENCES users (id),
    roles_id INT NOT NULL REFERENCES roles (id)
);

CREATE TABLE news
(
    id           SERIAL PRIMARY KEY NOT NULL,
    description  TEXT               NOT NULL,
    user_id      INT       DEFAULT 0,
    picture_id   INT       DEFAULT 0,
    amount_likes INT                NOT NULL,
    CONSTRAINT fk_news_user
        FOREIGN KEY (user_id)
            REFERENCES users (id),
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP(0),
    updated_at   TIMESTAMP DEFAULT NULL
);

CREATE TABLE pictures
(
    id           SERIAL PRIMARY KEY NOT NULL,
    picture      VARCHAR            NOT NULL,
    role_picture VARCHAR            NOT NULL,
    amount_likes INT                NOT NULL,
    user_id      INT       DEFAULT 0,
    CONSTRAINT fk_pictures_user
        FOREIGN KEY (user_id)
            REFERENCES users (id),
    news_id      INT       DEFAULT 0,
    CONSTRAINT fk_pictures_news
        FOREIGN KEY (news_id)
            REFERENCES news (id),
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP(0),
    updated_at   TIMESTAMP DEFAULT NULL
);


CREATE TABLE likes
(
    id         SERIAL PRIMARY KEY NOT NULL,
    user_id    INT       DEFAULT 0,
    CONSTRAINT fk_likes_user
        FOREIGN KEY (user_id)
            REFERENCES users (id),
    picture_id INT       DEFAULT 0,
    CONSTRAINT fk_likes_picture
        FOREIGN KEY (picture_id)
            REFERENCES pictures (id),
    news_id    INT       DEFAULT 0,
    CONSTRAINT fk_likes_news
        FOREIGN KEY (news_id)
            REFERENCES news (id),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP(0)
);

CREATE TABLE comments
(
    id         SERIAL PRIMARY KEY NOT NULL,
    comment    TEXT               NOT NULL,
    user_id    INT       DEFAULT 0,
    CONSTRAINT fk_comments_user
        FOREIGN KEY (user_id)
            REFERENCES users (id),
    news_id    INT       DEFAULT 0,
    CONSTRAINT fk_comments_news
        FOREIGN KEY (news_id)
            REFERENCES news (id),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP(0),
    updated_at TIMESTAMP DEFAULT NULL
);

CREATE TABLE friends
(
    id                SERIAL PRIMARY KEY NOT NULL,
    status            VARCHAR            NOT NULL,
    user_sender_id    INT                NOT NULL,
    user_recipient_id INT                NOT NULL,
    created_at        TIMESTAMP DEFAULT CURRENT_TIMESTAMP(0),
    updated_at        TIMESTAMP DEFAULT NULL
);

CREATE TABLE friends_users
(
    friends_id INT NOT NULL REFERENCES friends (id),
    users_id   INT NOT NULL REFERENCES users (id)
);








