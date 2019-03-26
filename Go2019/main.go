package main

//https://tutorialedge.net/golang/golang-mysql-tutorial/
//Almost complete copy pasta from the above.

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

  results, err := db.Query("SELECT name, age FROM person")
  if err != nil {
    panic(err.Error())
	}

  for results.Next(){
    var tag Tag

    err = results.Scan(&tag.name, &tag.age)
		if err != nil {
			panic(err.Error()) // proper error handling instead of panic in your app
		}

    fmt.Println(tag.name)
  }

  defer db.Close()
}
