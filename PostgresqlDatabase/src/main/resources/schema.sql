DROP TABLE IF EXISTS "books";
DROP TABLE IF EXISTS "authors";

-- Create sequence for authors table
CREATE SEQUENCE IF NOT EXISTS authors_id_seq;

-- Create authors table
CREATE TABLE "authors" (
    "id" bigint DEFAULT nextval('authors_id_seq') NOT NULL,
    "name" text NOT NULL,  -- Assuming name is required
    "age" integer,
    CONSTRAINT "authors_pkey" PRIMARY KEY ("id")
);

-- Create books table with foreign key constraint
CREATE TABLE "books" (
    "isbn" text NOT NULL,
    "title" text NOT NULL,  -- Assuming title is required
    "author_id" bigint NOT NULL,  -- Assuming author_id is required
    CONSTRAINT "books_pkey" PRIMARY KEY ("isbn"),
    CONSTRAINT "fk_author" FOREIGN KEY (author_id)
        REFERENCES authors(id) ON DELETE CASCADE  -- Optional: delete books when the author is deleted
);
