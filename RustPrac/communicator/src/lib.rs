mod client; // This tells the Rust to look for another location for this module.

mod network;

//mod network{
//    fn connect(){
//
//    }
//
//    // In Rust, I can have a module inside a module, where they call a module like this "an inner module."
//    mod client {
//        fn connect(){
//
//        }
//    }
//}

// The below is legal, I can have a module outside the module in Rust.
// Remember practicing LinkedList in Java?
//mod client {
//    fn connect() {
//
//    }
//}

#[cfg(test)]
mod tests {
    #[test]
    fn it_works() {
        assert_eq!(2 + 2, 4);
    }
}
