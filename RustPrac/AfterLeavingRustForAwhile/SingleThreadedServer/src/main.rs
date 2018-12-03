use std::net::*;
use std::io::*;
use std::fs::File;

fn handle_connection(mut stream: TcpStream){
    let mut buffer = [0; 512];
    stream.read(&mut buffer);

    let get = b"GET / HTTP/1.1\r\n";

    // If the buffer starts with the above pattern, execute the if block
    if buffer.starts_with(get){
        let mut file = File::open("hello.html").unwrap();
        let mut contents = String::new();
        file.read_to_string(&mut contents);//.unwrap();

        let response = format!("HTTP/1.1 200 OK\r\n\r\n{}", contents);

        stream.write(response.as_bytes());//.unwrap();
        stream.flush();//.unwrap();
    } else {
        let status_line = "HTTP/1.1 404 NOT FOUND\r\n\r\n";
        let mut file = File::open("404.html").unwrap();
        let mut contents = String::new();

        file.read_to_string(&mut contents);//.unwrap();

        let response = format!("{}{}", status_line, contents);

        stream.write(response.as_bytes());//.unwrap();
        stream.flush();//.unwrap();
    }
}

fn main() {
    // bind() is a function in Result enum: https://doc.rust-lang.org/std/result/enum.Result.html#method.unwrap
    // unwrap() returns the content of Ok().
    let listener = TcpListener::bind("127.0.0.1:7878").unwrap();

    for stream in listener.incoming(){
        let stream = stream.unwrap();

        handle_connection(stream);
    }
}
