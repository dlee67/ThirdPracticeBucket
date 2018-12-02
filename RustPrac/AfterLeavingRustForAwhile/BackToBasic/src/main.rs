use std::io;

fn main() {
    let x = String::from("I am the lullest");
    //The below shadows the x above, where x essentially gets dropped and re-initialized.
    let x = take_and_give_ownership(x);

    println!("{}, still is.", x);

    let mut y = String::from("Not so ");
    // I have to declare to the function that I am passing in a mutable reference in the arguement...
    mutate_reference(&mut y);

    println!("{}", y);
}

fn take_and_give_ownership(str: String) -> String{
    str
}

// and in the parameters.
fn mutate_reference(str: &mut String){
    str.push_str("funny.");
}
