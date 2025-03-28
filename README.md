<h2 align="center">Note App</h2>

> This is not recommended in Production.
> It was just a small project i made while being at an Intership.

Just a simple Note App, which uses Java (Spring-Boot), which is giving you the ability to create, edit and delete notes with date, auto assigned id's and the text... duh.

### Installation

1. Run the command `git clone https://github.com/calishu/Note-App.git` in the directory you want.
2. Go inside `src/main/resources` and edit `application.properties` to your database. (btw: for the `spring.datasource.url` use this layout `jdbc:mariadb://<ip>:<port>/<database>`
3. Now check your database and create the Table `noteapp` with those values: `id (INT, AUTO_INCREMENT)`, `date (INT)`, `text (TEXT)`
4. Now just run everything and your good to go
