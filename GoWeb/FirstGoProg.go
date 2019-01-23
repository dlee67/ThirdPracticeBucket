package main

import (
    "fmt"
    "net/http"
)

func handler(writer http.ResponseWriter, request *http.Request) {
    fmt.Fprintf(writer, "Hello World, %s!", request.URL.Path[1:])
}

func fiddler(writer http.ResponseWriter, request *http.Request) {
    fmt.Fprintf(writer, "%s played us like a damn fiddle!", request.URL.Path[1:])
}

func main() {
    http.HandleFunc("/", handler)
    http.HandleFunc("/fiddle", fiddler)
    http.ListenAndServe(":8080", nil)
}
