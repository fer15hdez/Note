-----Install----
sudo apt install postgresql postgresql-contrib
sudo -i -u postgres ("Change to user postgres")
sudo -u postgres createuser --interactive ("Create a new user")
psql ("To interact with posgri console ")

SET USER admin WITH PASSWORD 'Admin123'; ("From console psql")
ALTER USER admin WITH PASSWORD 'Admin123'; ("From console psql")