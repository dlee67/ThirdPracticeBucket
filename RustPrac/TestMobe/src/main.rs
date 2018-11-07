#![feature(core_intrinsics)]

use std::vec;
use std::ptr::null;
use std::string;
use std::intrinsics::type_name;

fn main() {
    let s = vec!["udon".to_string(), "ramen".to_string(), "soba".to_string()];
    let t = s;
    let u = s;
// The Cargo will tell me that s has been moved.
    test_type(s);
}

fn test_type<T>(_: T) {
    println!("{:?}", unsafe { type_name::<T>() });
}
