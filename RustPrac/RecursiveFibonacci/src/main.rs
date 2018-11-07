use std::collections::HashMap;

const FIB_ZERO: u64 = 1;
const FIB_ONE: u64 = 1;

fn fib(n: u64) -> u64 {
    if n == 0 {
        FIB_ZERO
    } else if n == 1 {
        FIB_ONE
    } else {
        fib(n - 1) + fib(n - 2)
    }
}

// Ampersend means reference.
fn fib_dyn(n: u64, map: &mut HashMap<u64, u64>) -> u64{
    // Match is a switch on steroid.
    match n {
        0 | 1 => 1,
        n => {
            if map.contains_key(&n){
                *map.get(&n).unwrap()
            } else {
                let val = fib_dyn(n-1, map) + fib_dyn(n-2, map);
                map.insert(n, val);
                // We could write return val;... but...
                val
            }
        }
    }
}

fn main() {
    let mut map = HashMap::new();
    for i in 1..41 {
        println!("{}:{}", i, fib_dyn(i, &mut map));
    }
}
