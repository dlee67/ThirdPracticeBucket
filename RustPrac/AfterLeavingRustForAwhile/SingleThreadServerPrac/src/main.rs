use std::net::*;

fn main() {
    let listener = TcpListener::bind("127.0.0.1:7878");

    for stream in listener.incoming(){
        
    }
}
