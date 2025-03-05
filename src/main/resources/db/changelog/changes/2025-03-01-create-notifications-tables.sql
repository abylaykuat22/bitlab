--liquibase aldik: 1
CREATE TABLE IF NOT EXISTS NOTIFICATIONS (
    notification_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    type VARCHAR(100) NOT NULL,
    message TEXT NOT NULL,
    is_read BOOLEAN DEFAULT FALSE,
    created_at date,
    updated_at date,
    );

