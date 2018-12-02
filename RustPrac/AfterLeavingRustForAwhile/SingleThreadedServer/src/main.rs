use std::net;
use std::io;

fn handle_connection(mut stream: TcpStream){
    let mut buffer = [0; 512];

    stream.read(&mut buffer).unwrap();

    println("Request: {}", String::from_utf8_lossy(&buffer[..]))
}

fn main() {
    // bind() returns Result, where Result invokes ok() or error() default.
    let listener = TcpListener::bind("127.0.0.1:7878").unwrap();
    for stream in listener.incoming(){
        let stream = stream.unwrap();

        println!("Connection established.");
    }
}
