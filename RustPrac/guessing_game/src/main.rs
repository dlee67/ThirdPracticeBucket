extern crate rand;

use std::io;
use std::cmp::Ordering;
use rand::Rng;

/*
    Okay, let's try to throughly undestand what the heck is going on with this code.
*/
fn main() {
    println!("Guess the number!");

    let secret_number = rand::thread_rng().gen_range(1, 101);
    println!("The secret number is: {}", secret_number);

    loop{
        println!("Please input your guess.");
        let mut guess = String::new(); // If we don't put mut next to a guess, then guess becomes immutable.
        // Rust will take in the inputs as they are; meaning, the new line will also be part of the guess var.
        io::stdin().read_line(&mut guess).expect("Failed to read line");

        // Despite the fact that I've already declared the guess to be assigned with something,
        // but Rust allows shadow, which allows me to re-use the variable.
        let guess: u32 = guess.trim().parse(){
            Ok(num) => num,
            Err(_) => continue,
        }

        // {} you see here is something similar to using printf from Java and C.
        // In the world of Rust, {} is something called placeholder.
        println!("You guessed: {}", guess);

        match guess.cmp(&secret_number){
            Ordering::Less => println!("Too small!"),
            Ordering::Greater => println!("Too big!"),
            Ordering::Equal => {
                println!("FIIIIIIIGHTIIIIIIIIIIIIIIIIING GOOOOOOOOOOOLD!");
                break;
            }
        }
    }
}
