"use strict";
console.log("My first TS code.");
//TS behaves very much like JS, but when it comes to functions, I can
//actually define the data type of my parameters.
function squareOf(n) {
    return n * n;
}
//I am really liking the pace of this.
console.log("Just called squareOf: " + squareOf(5));
//There is this type called "unknown."
let a = 30; // unknown
let b = a === 123; // boolean
//let c = a + 10              // Error TS2571: Object is of type 'unknown'.
if (typeof a === 'number') {
    let d = a + 10; // number
}
// Essentially, TS doesn't know what type a is, until you assign something to it.
// Objects are still very much a real thing in TypeScript.
var myName = {
    first: "Dong",
    last: "Lee"
};
//You can do some Java smelling-like stuff too.
class Student {
    constructor(name, GPA) {
        this.name = name;
        this.GPA = GPA;
        console.log("Student object was created.");
    }
}
var newStudent = new Student("Dong Lee", 3.5);
console.log(newStudent.name + " has GPA of: " + newStudent.GPA);
//It's not JavaScript.
function add(x, y) {
    return x + y;
}
//No, it's not. JS doesn't have a concept called return type.
console.log(add(1, 1));
//JS has some weird things you can do with function.
//These three concepts are called apply, call, and bind.
//I should really go search about this some other time.
//Remember, JS has dollar signs for formatting ...
//In JS/TS, you can do stuff like this.
function vooDooStuff(string) {
    if (string != null) {
        return string;
    }
    return 0;
}
console.log("voo doo magic with String: " + vooDooStuff("Maximum Spoop"));
console.log("voo doo magic with a number: " + vooDooStuff(0));
//# sourceMappingURL=index.js.map