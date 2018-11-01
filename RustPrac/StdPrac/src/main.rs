use std::vec::Vec;

fn main() {
    let mut vec: Vec<i32> = Vec::new();
    vec.push(1);
    vec.push(2);
    // At the moment, it seems like Rust only has iterators for lists data structures?
    for x in &vec{
        println!("iterating over: {}", x);
    }
    // Wonder if this works?
    for index in vec.len(){
// The below code is brain farty, I am guessing the below line kinda nails the coffin that everything is dereferenced by default.
        println!("In the second for loop, iterating over: {}", vec[index]);
    }

    println!("The vector at the moment: {}", vec);
}
