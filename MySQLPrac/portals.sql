use portals;

drop table techsites;
drop table academicsites;
drop table foodsites;

CREATE TABLE techsites (
    techsites_id_number INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
    URL TEXT NOT NULL,
    description TEXT NOT NULL,
    PRIMARY KEY (techsites_id_number)
);

INSERT INTO techsites
    (URL, description)
VALUES
    ("http://g2pc1.bu.edu/~qzpeng/manual/MySQL%20Commands.htm",
    "\"Handy MySQL Commands.\"");

INSERT INTO techsites
    (URL, description)
VALUES
    ("https://learning.oreilly.com/home/",
    "They've changed their name from Safari to O'Reily Learning.");

INSERT INTO techsites
    (URL, description)
VALUES
    ("https://news.ycombinator.com/",
    "Who doesn't know this website by now?");

INSERT INTO techsites
    (URL, description)
VALUES
    ("https://angular-university.io/",
    "To learn Angular.");

INSERT INTO techsites
    (URL, description)
VALUES
    ("https://developer.nvidia.com/hpc",
    "To learn CUDA.");

INSERT INTO techsites
    (URL, description)
VALUES
    ("https://aws.amazon.com/hpc/",
    "AWS has their own cloud service for HPC.");

INSERT INTO techsites
    (URL, description)
VALUES
    ("https://www.ethdenver.com/",
    "Currently, the biggest hackathon in Colorado right now.");

INSERT INTO techsites
    (URL, description)
VALUES
    ("https://github.com/ladyleet/tech-community-slacks",
    "List of Slack channels related to techs.");

INSERT INTO techsites
    (URL, description)
VALUES
    ("https://dinosaurjs.org/",
    "JS conference in Colorado.");

INSERT INTO techsites
    (URL, description)
VALUES
    ("https://angulardenver.com/",
    "Angular conference in Colorado.");

INSERT INTO techsites
    (URL, description)
VALUES
    ("https://callforcode.org/",
    "IBM's global scale programming challenge.");

INSERT INTO techsites
    (URL, description)
VALUES
    ("https://www.youtube.com/watch?v=1RiFIYwuwHM",
    "Hands on best, practical machine learning book.");

CREATE TABLE academicsites (
    academic_id_number INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
    URL TEXT NOT NULL,
    description TEXT NOT NULL,
    PRIMARY KEY (academic_id_number)
);

INSERT INTO academicsites
    (URL, description)
VALUES
    ("http://web.mit.edu/alexmv/6.037/",
    "One and only.");

INSERT INTO academicsites
    (URL, description)
VALUES
    ("https://cs.mines.edu/graduate-program/",
    "Graduate programs at Mines.");

CREATE TABLE foodsites (
    food_id_number INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
    URL TEXT NOT NULL,
    description TEXT NOT NULL,
    PRIMARY KEY (food_id_number)
);
