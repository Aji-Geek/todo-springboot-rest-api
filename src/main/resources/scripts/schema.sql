CREATE TABLE IF NOT EXISTS public.todo
(
    id character varying(36)  NOT NULL,
    title character varying(255)  NOT NULL,
    completed boolean NOT NULL,
    CONSTRAINT todo_pkey PRIMARY KEY (id)
)