use std::mem;

pub struct List {
    head: Link,
}

enum Link {
    Empty,
    More(Box<Node>),
}

struct Node {
    elem: i32,
    next: Link,
}

//pub struct List {
//    head: Link,
//}
impl List {
    pub fn push(&mut self, elem: i32){
        let new_node = Node{
            elem: elem,
//Temporaryly replace self.head with Link::Empty because Rust's variables can never point to null.
            next: mem::replace(&mut self.head, Link::Empty)
        };

        self.head = Link::More(new_node);
    }

    pub fn pop(&mut self) -> Option<i32> {
        let result;
        match self.head{
            Link::Empty => {
                result = None;
            }
            Link::More(ref node) => {
                result = Some(node.elem);
                self.head = node.next;
            }
        }
        result
    }
}
