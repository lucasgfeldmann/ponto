CREATE TABLE record (
    id BIGSERIAL PRIMARY KEY,
    start_at TIMESTAMP NOT NULL,
    end_at TIMESTAMP NULL,
    owner_id BIGINT NOT NULL REFERENCES users(id)
);