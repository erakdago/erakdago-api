-- 001_create_tables.sql

CREATE EXTENSION IF NOT EXISTS pgcrypto;

-- ============ Users hierarchy (User -> Admin / Professional / Traveler) ============

CREATE TABLE users (
    id                UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    first_name        TEXT,
    last_name         TEXT,
    username          TEXT NOT NULL,
    phone_number      TEXT,
    email             TEXT NOT NULL,
    password          TEXT NOT NULL,
    pfp               TEXT,
    about             TEXT,
    registration_date TIMESTAMP,
    status            TEXT,
    CONSTRAINT uq_users_username UNIQUE (username),
    CONSTRAINT uq_users_email    UNIQUE (email)
);

CREATE TABLE admins (
    id           UUID PRIMARY KEY REFERENCES users (id) ON DELETE CASCADE,
    access_level TEXT,
    permissions  TEXT[]
);

CREATE TABLE professionals (
    id                  UUID PRIMARY KEY REFERENCES users (id) ON DELETE CASCADE,
    company_name        TEXT,
    business_type       TEXT,
    description         TEXT,
    business_address    TEXT,
    verification_status TEXT,
    license_number      TEXT,
    business_location   TEXT
);

CREATE TABLE travelers (
    id           UUID PRIMARY KEY REFERENCES users (id) ON DELETE CASCADE,
    preferences  TEXT,
    localisation TEXT
);

-- ============ Regions & Towns ============

CREATE TABLE regions (
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name        TEXT NOT NULL,
    description TEXT,
    climate     TEXT,
    image       TEXT
);

CREATE TABLE towns (
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name        TEXT NOT NULL,
    description TEXT,
    images      TEXT[],
    region_id   UUID REFERENCES regions (id) ON DELETE SET NULL
);

-- ============ Services hierarchy (Service -> Hotel / Restoration / Transportation) ============

CREATE TABLE services (
    id                  UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name                TEXT NOT NULL,
    description         TEXT,
    location            TEXT,
    image               TEXT,
    contact_information TEXT,
    availability        BOOLEAN,
    status              TEXT,
    town_id             UUID REFERENCES towns (id) ON DELETE SET NULL,
    max_price           INTEGER,
    min_price           INTEGER
);

CREATE TABLE hotels (
    id              UUID PRIMARY KEY REFERENCES services (id) ON DELETE CASCADE,
    number_of_rooms INTEGER NOT NULL DEFAULT 0,
    room_type       TEXT,
    star_rating     INTEGER,
    amenities       TEXT
);

CREATE TABLE restorations (
    id            UUID PRIMARY KEY REFERENCES services (id) ON DELETE CASCADE,
    cuisine_type  TEXT,
    opening_hours TIME,
    closing_hours TIME,
    menu          TEXT
);

CREATE TABLE transportations (
    id                  UUID PRIMARY KEY REFERENCES services (id) ON DELETE CASCADE,
    transport_type      TEXT,
    departure_location  TEXT,
    arrival_location    TEXT,
    capacity            INTEGER,
    departure_time      TIMESTAMP,
    arrival_time        TIMESTAMP
);

-- ============ Activities & Species ============

CREATE TABLE activities (
    id               UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name             TEXT NOT NULL,
    description      TEXT,
    duration_seconds BIGINT,
    type             TEXT,
    difficulty       TEXT CHECK (difficulty IN ('EASY', 'MEDIUM', 'DIFFICULT')),
    capacity         INTEGER,
    price            INTEGER,
    availability     BOOLEAN,
    image            TEXT
);

CREATE TABLE species (
    id                 UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    local_name         TEXT,
    scientific_name    TEXT,
    description        TEXT,
    habitat            TEXT,
    conservation_status TEXT CHECK (conservation_status IN ('CR', 'EN', 'VU', 'NT', 'LC', 'DD', 'NE')),
    images             TEXT[],
    is_endemic         BOOLEAN,
    species_type       TEXT CHECK (species_type IN ('FAUNA', 'FLORA')),
    town_id            UUID REFERENCES towns (id) ON DELETE CASCADE
);

CREATE TABLE town_activity (
    town_id     UUID NOT NULL REFERENCES towns (id)     ON DELETE CASCADE,
    activity_id UUID NOT NULL REFERENCES activities (id) ON DELETE CASCADE,
    PRIMARY KEY (town_id, activity_id)
);

CREATE TABLE activity_species (
    activity_id UUID NOT NULL REFERENCES activities (id) ON DELETE CASCADE,
    species_id  UUID NOT NULL REFERENCES species (id)    ON DELETE CASCADE,
    PRIMARY KEY (activity_id, species_id)
);

CREATE TABLE professional_activity (
    professional_id UUID NOT NULL REFERENCES professionals (id) ON DELETE CASCADE,
    activity_id     UUID NOT NULL REFERENCES activities (id)    ON DELETE CASCADE,
    PRIMARY KEY (professional_id, activity_id)
);

-- ============ Gamification: Badges -> Achievements -> Challenges ============

CREATE TABLE badges (
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name        TEXT NOT NULL,
    description TEXT,
    created_at  TIMESTAMP,
    icon        TEXT
);

CREATE TABLE achievements (
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name        TEXT NOT NULL,
    description TEXT,
    criteria    TEXT,
    created_at  TIMESTAMP,
    badge_id    UUID REFERENCES badges (id) ON DELETE CASCADE
);

CREATE TABLE challenges (
    id             UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name           TEXT NOT NULL,
    description    TEXT,
    start_date     TIMESTAMP,
    end_date       TIMESTAMP,
    difficulty     DOUBLE PRECISION,
    progress       DOUBLE PRECISION,
    status         BOOLEAN,
    achievement_id UUID REFERENCES achievements (id) ON DELETE CASCADE,
    region_id      UUID REFERENCES regions (id)       ON DELETE CASCADE
);

-- ============ Cultural heritage ============

CREATE TABLE cultural_elements (
    id                    UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name                  TEXT NOT NULL,
    description           TEXT,
    type                  TEXT,
    historical_period     TEXT,
    cultural_significance TEXT,
    image                 TEXT,
    images                TEXT[],
    town_id               UUID REFERENCES towns (id) ON DELETE CASCADE
);

-- ============ Trips, Diaries, Destinations ============

CREATE TABLE trips (
    id           UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name         TEXT NOT NULL,
    description  TEXT,
    start_date   TIMESTAMP,
    end_date     TIMESTAMP,
    status       BOOLEAN,
    created_at   TIMESTAMP,
    traveler_id  UUID REFERENCES travelers (id) ON DELETE CASCADE
);

CREATE TABLE destinations (
    id                 UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name               TEXT NOT NULL,
    description        TEXT,
    image              TEXT,
    best_time_to_visit TIME,
    trip_id            UUID NOT NULL UNIQUE REFERENCES trips (id) ON DELETE CASCADE
);

CREATE TABLE diaries (
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    title       TEXT NOT NULL,
    description TEXT,
    created_at  TIMESTAMP,
    updated_at  TIMESTAMP,
    trip_id     UUID REFERENCES trips (id) ON DELETE CASCADE
);

CREATE TABLE pages (
    id         UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    sort_order TEXT,
    title      TEXT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    diary_id   UUID REFERENCES diaries (id) ON DELETE CASCADE
);

CREATE TABLE steps (
    id             UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    sort_order     TEXT,
    departure_date DATE,
    arrival_date   DATE,
    departure_time TIMESTAMP,
    arrival_time   TIMESTAMP,
    notes          TEXT,
    duration       INTEGER,
    trip_id        UUID REFERENCES trips (id) ON DELETE CASCADE
);

-- ============ Chat ============

CREATE TABLE chats (
    id         UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    trip_id    UUID NOT NULL UNIQUE REFERENCES trips (id) ON DELETE CASCADE
);

CREATE TABLE messages (
    id        UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    content   TEXT,
    send_at   TIMESTAMP,
    type      TEXT,
    status    TEXT,
    chat_id   UUID REFERENCES chats (id)    ON DELETE CASCADE,
    user_id   UUID REFERENCES travelers (id) ON DELETE CASCADE
);

-- ============ Gastronomy ============

CREATE TABLE ingredients (
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name        TEXT NOT NULL,
    description TEXT
);

CREATE TABLE dishes (
    id             UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name           TEXT NOT NULL,
    description    TEXT,
    origin         TEXT,
    history        TEXT,
    image          TEXT,
    town_id        UUID REFERENCES towns (id)       ON DELETE CASCADE,
    restoration_id UUID REFERENCES restorations (id) ON DELETE CASCADE
);

CREATE TABLE dish_ingredient (
    dish_id       UUID NOT NULL REFERENCES dishes (id)      ON DELETE CASCADE,
    ingredient_id UUID NOT NULL REFERENCES ingredients (id) ON DELETE CASCADE,
    PRIMARY KEY (dish_id, ingredient_id)
);

-- ============ Events ============

CREATE TABLE events (
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name        TEXT NOT NULL,
    description TEXT,
    image       TEXT,
    start_date  TIMESTAMP,
    end_date    TIMESTAMP,
    status      BOOLEAN,
    location    TEXT,
    town_id     UUID REFERENCES towns (id) ON DELETE CASCADE
);

CREATE TABLE event_activity (
    event_id    UUID NOT NULL REFERENCES events (id)    ON DELETE CASCADE,
    activity_id UUID NOT NULL REFERENCES activities (id) ON DELETE CASCADE,
    PRIMARY KEY (event_id, activity_id)
);

-- ============ Reviews ============

CREATE TABLE reviews (
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    author_id   UUID REFERENCES travelers (id) ON DELETE CASCADE,
    rating      NUMERIC(2, 1) CHECK (rating BETWEEN 0 AND 5),
    comment     TEXT,
    created_at  TIMESTAMP,
    status      TEXT,
    updated_at  TIMESTAMP,
    event_id    UUID REFERENCES events (id)    ON DELETE CASCADE,
    activity_id UUID REFERENCES activities (id) ON DELETE CASCADE,
    town_id     UUID REFERENCES towns (id)     ON DELETE CASCADE,
    service_id  UUID REFERENCES services (id)  ON DELETE CASCADE,
    CONSTRAINT chk_review_single_target CHECK (num_nonnulls(event_id, activity_id, town_id, service_id) = 1)
);

-- ============ Social: Posts, Comments, Likes, Follows ============

CREATE TABLE posts (
    id         UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    content    TEXT NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    image      TEXT,
    author_id  UUID REFERENCES travelers (id) ON DELETE CASCADE
);

CREATE TABLE comments (
    id         UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    content    TEXT NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    author_id  UUID REFERENCES travelers (id) ON DELETE CASCADE,
    post_id    UUID REFERENCES posts (id)     ON DELETE CASCADE
);

CREATE TABLE likes (
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    created_at  TIMESTAMP,
    post_id     UUID REFERENCES posts (id)     ON DELETE CASCADE,
    traveler_id UUID REFERENCES travelers (id) ON DELETE CASCADE,
    CONSTRAINT uq_likes_post_traveler UNIQUE (post_id, traveler_id)
);

CREATE TABLE follows (
    id           UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    created_at   TIMESTAMP,
    follower_id  UUID REFERENCES travelers (id) ON DELETE CASCADE,
    following_id UUID REFERENCES travelers (id) ON DELETE CASCADE,
    CONSTRAINT chk_follow_self CHECK (follower_id <> following_id)
);

-- ============ Traveler activity ============

CREATE TABLE favorites (
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    created_at  TIMESTAMP,
    status      TEXT CHECK (status IN ('SAVED', 'PLANNED', 'VISITED')),
    town_id     UUID REFERENCES towns (id)     ON DELETE CASCADE,
    traveler_id UUID REFERENCES travelers (id) ON DELETE CASCADE,
    CONSTRAINT uq_favorites_town_traveler UNIQUE (town_id, traveler_id)
);

CREATE TABLE check_ins (
    id           UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    checked_in_at TIMESTAMP,
    latitude     DOUBLE PRECISION,
    longitude    DOUBLE PRECISION,
    xp_earned    INTEGER,
    town_id      UUID REFERENCES towns (id)     ON DELETE CASCADE,
    traveler_id  UUID REFERENCES travelers (id) ON DELETE CASCADE
);

CREATE TABLE reservations (
    id               UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    created_at       TIMESTAMP,
    reservation_date TIMESTAMP,
    start_time       TIMESTAMP,
    end_time         TIMESTAMP,
    number_of_people INTEGER,
    status           TEXT,
    total_price      NUMERIC(12, 2),
    notes            TEXT,
    traveler_id      UUID REFERENCES travelers (id) ON DELETE CASCADE,
    service_id       UUID REFERENCES services (id)  ON DELETE CASCADE,
    activity_id      UUID REFERENCES activities (id) ON DELETE CASCADE
);

-- ============ Trip planning ============

CREATE TABLE trip_invitations (
    id                 UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    created_at         TIMESTAMP,
    invitation_status  TEXT CHECK (invitation_status IN ('PENDING', 'ACCEPTED', 'DECLINED')),
    responded_at       TIMESTAMP,
    trip_id            UUID REFERENCES trips (id)     ON DELETE CASCADE,
    traveler_id        UUID REFERENCES travelers (id) ON DELETE CASCADE
);

CREATE TABLE trip_proposals (
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    created_at  TIMESTAMP,
    title       TEXT NOT NULL,
    description TEXT,
    trip_id     UUID REFERENCES trips (id) ON DELETE CASCADE
);

CREATE TABLE trip_proposal_step (
    trip_proposal_id UUID NOT NULL REFERENCES trip_proposals (id) ON DELETE CASCADE,
    steps_id         UUID NOT NULL REFERENCES steps (id)          ON DELETE CASCADE,
    PRIMARY KEY (trip_proposal_id, steps_id)
);

CREATE TABLE votes (
    id               UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    created_at       TIMESTAMP,
    trip_proposal_id UUID REFERENCES trip_proposals (id) ON DELETE CASCADE,
    traveler_id      UUID REFERENCES travelers (id)       ON DELETE CASCADE,
    CONSTRAINT uq_votes_proposal_traveler UNIQUE (trip_proposal_id, traveler_id)
);

-- ============ Standalone resources ============

CREATE TABLE transports (
    id                 UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name               TEXT,
    type               TEXT,
    description        TEXT,
    departure_location TEXT,
    arrival_location   TEXT,
    departure_time     TIMESTAMP,
    arrival_time       TIMESTAMP,
    cost               DOUBLE PRECISION,
    duration           TEXT
);

CREATE TABLE media (
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    title       TEXT,
    type        TEXT CHECK (type IN ('IMAGE', 'VIDEO', 'AUDIO')),
    url         TEXT,
    description TEXT,
    created_at  DATE,
    content     TEXT
);

-- ============ Indexes (FK lookup hot-paths only) ============

CREATE INDEX idx_towns_region         ON towns (region_id);
CREATE INDEX idx_services_town        ON services (town_id);
CREATE INDEX idx_species_town         ON species (town_id);
CREATE INDEX idx_cultural_element_town ON cultural_elements (town_id);
CREATE INDEX idx_dish_town            ON dishes (town_id);
CREATE INDEX idx_events_town          ON events (town_id);
CREATE INDEX idx_challenges_region    ON challenges (region_id);
CREATE INDEX idx_reviews_author       ON reviews (author_id);
CREATE INDEX idx_posts_author         ON posts (author_id);
CREATE INDEX idx_comments_post        ON comments (post_id);
CREATE INDEX idx_likes_post           ON likes (post_id);
CREATE INDEX idx_favorites_traveler   ON favorites (traveler_id);
CREATE INDEX idx_check_ins_traveler   ON check_ins (traveler_id);
CREATE INDEX idx_reservations_traveler ON reservations (traveler_id);
CREATE INDEX idx_trips_traveler       ON trips (traveler_id);
CREATE INDEX idx_messages_chat        ON messages (chat_id);
CREATE INDEX idx_steps_trip           ON steps (trip_id);
CREATE INDEX idx_trip_invitations_trip    ON trip_invitations (trip_id);
CREATE INDEX idx_trip_invitations_traveler ON trip_invitations (traveler_id);
CREATE INDEX idx_trip_proposals_trip  ON trip_proposals (trip_id);
CREATE INDEX idx_votes_proposal       ON votes (trip_proposal_id);
CREATE INDEX idx_votes_traveler       ON votes (traveler_id);