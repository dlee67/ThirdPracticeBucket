package main

//https://tutorialedge.net/golang/golang-mysql-tutorial/
//Almost complete copy pasta from the above.
//mysql -u root -p
//with "root" as the password.

import(
  "fmt"
  "database/sql"
  _ "github.com/go-sql-driver/mysql"
)

type Tag struct {
	name string
  age int
}

func main(){
  fmt.Println("Go MySQL Tutorial")

  db, err := sql.Open("mysql", "root:root@tcp(127.0.0.1:3306)/test")

  if err != nil {
      panic(err.Error())
  }

  fmt.Println("MySQL was successfully connected.")

  //READ
  resultsOne, errOne := db.Query("SELECT * FROM person;")
  if errOne != nil {
    panic(err.Error())
	}

  for resultsOne.Next(){
    var tag Tag

    err = resultsOne.Scan(&tag.name, &tag.age)
		if err != nil {
			panic(err.Error()) // proper error handling instead of panic in your app
		}

    fmt.Println(tag.name)
  }

  //CREATE
  db.Query("INSERT INTO person (name, age) VALUES ('Bob', 23);")

  //CREATE
  db.Query("INSERT INTO person (name, age) VALUES ('Sam', 23);")

  //READ
  resultsFour, errFour := db.Query("SELECT * FROM person;")
  if errFour != nil {
    panic(err.Error())
	}

  for resultsFour.Next(){
    var tag Tag

    err = resultsFour.Scan(&tag.name, &tag.age)
		if err != nil {
			panic(err.Error()) // proper error handling instead of panic in your app
		}

    fmt.Println(tag.name)
  }

  //DELETE
  db.Query("DELETE FROM person WHERE name='Bob';")

  //READ
  resultsSix, errSix := db.Query("SELECT * FROM person;")
  if errSix != nil {
    panic(err.Error())
	}

  for resultsSix.Next(){
    var tag Tag

    err = resultsSix.Scan(&tag.name, &tag.age)
		if err != nil {
			panic(err.Error()) // proper error handling instead of panic in your app
		}

    fmt.Println(tag.name)
  }

  //UPDATE
  db.Query("UPDATE person SET age=14 WHERE name='Sam';")

  //READ
  resultsEight, errEight := db.Query("SELECT * FROM person;")
  if errEight != nil {
    panic(err.Error())
	}

  for resultsEight.Next(){
    var tag Tag

    err = resultsEight.Scan(&tag.name, &tag.age)
		if err != nil {
			panic(err.Error()) // proper error handling instead of panic in your app
		}

    fmt.Println(tag.name)
  }

  defer db.Close()
}
