CREATE TABLE nytimes_config
(
    id         INT AUTO_INCREMENT,
    app_id     NVARCHAR(255)           NOT NULL,
    app_name   NVARCHAR(255)           NOT NULL,
    api_key    NVARCHAR(255)           NOT NULL,
    api_secret NVARCHAR(255)           NOT NULL,
    status     NVARCHAR(100)           NOT NULL,
    base_url   TEXT                    NOT NULL,
    created    TIMESTAMP default NOW() NOT NULL,
    updated    TIMESTAMP,
    CONSTRAINT nytimes_config_pk
        PRIMARY KEY (id)
);

CREATE UNIQUE INDEX nytimes_config_api_key_uindex
    ON nytimes_config (api_key);

CREATE UNIQUE INDEX nytimes_config_app_id_uindex
    ON nytimes_config (app_id);

