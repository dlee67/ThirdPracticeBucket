use std::io::Write;
use std::str::FromStr;

fn main() {
    println!("Hello, world!");
    // Made a mistake writing : println!(returnNumPlusNum(2, 2));
    //println!("The returnNumPlusNum returned: {}", returnNumPlusNum(2, 2));
    //The below is how the things ought to be, Holochain testing, really, got nothing on this.
    //assertTwoNumsEquals(1, 1);
    //assertTwoNumsEquals(1, 2);
    doForLoop(10);
}

fn returnNumPlusNum(mut numOne: u32, mut numTwo: u32) -> u32 {
    // return numOne + numTwo // You can certainly have a return keyword in Rust,
    numOne + numTwo // But when the function is ending with an expression without a semi-colon,
                    // that becomes the return value.
}

fn assertTwoNumsEquals(numOne: u32, numTwo: u32) {
    assert_eq!(numOne, numTwo)
}

fn doForLoop(range: u32){
    for element in 0..range{
        println!("Iterating over: {}", element)
    }
}

// The test below can be executed separately from the other code base,
// by using cargo test.
#[test]
fn test_equals(){
    assert_eq!(1, 1);
    assert_ne!(1, 2);
}
