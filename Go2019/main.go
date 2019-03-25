package main

import(
  "fmt"
)

type language struct{
  name string
  purpose string
}

func why(s string, s2 string){
  fmt.Println(s, s2)
}

func sayLanguage(n string, p string) language{
  return language{name: n, purpose: p}
}

func main(){
  f := func(message string){
    fmt.Println(message)
  }
  f("This is pretty neat.")
}
