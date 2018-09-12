/*
   "The preprocessor looks at your program before it is compiled (hence the term preprocessor)."
   - C Primer Plus, Sixth Ed
   Ben, you are wrong, lol.
*/
//These are called directives.
#include "Student.h" //Basically, include will look for a file called Student.h,
                     //and actually copy paste that entire thing.
#include "MathStudent.h"
#include "CSStudent.h"
#include "DoubleMajor.h"
//The below line is also allowed.
//#include "/home/bob/Desktop/WorkSpace/ThirdPracticeBucket/CAgain/Student.h"
//#include "SomeClass.h"
//When the subject of interest for include is wrapped with
//<>, the angled brackets, then I am telling the compiler to
//search for the file in standard compiler include paths.
#include <iostream>
//The TWO below is called macro.
#define TWO 2
//macro can even insert things like this.
#define returnVal(a) (a)

//You can do some neat things like below in C++.
#define LOL 1 // First define macro LOL.
#ifdef LOL  //If macro LOL is defined.
#   define LUL "LULULULULUL!!!" // Define LUL with the given string.
#   define FUNNY 1
#else
#   define LUL 1
#endif

#ifdef LOL //If LOL is defined.
#  if FUNNY == 1 //And FUNNY equals to 1.
#    define SAY "WE GOT FUNNY ONE HERE!!! LUL!" //Define SAY with the given String.
#  else
#    define SAY "HMPH... not so funny."
#  endif
#endif

//A great read regarding the pointer, a post made by JustKevin.
//https://stackoverflow.com/questions/24599815/why-pointers-are-faster-and-more-efficient

//void pointers are very versatile.

//... Convention like this still exists in 2018.
/*
   Namespaces provide a way of implementing information hidden.
   Some examples of namespaces in Java are classes and packages.
   Examples of namespaces in C++ are classes, namespaces, and struct.
*/
//However, this is a very straight foward decision (but, we'll rarely have a problem like this though...)
//https://stackoverflow.com/questions/1452721/why-is-using-namespace-std-considered-bad-practice
using namespace std;

// I can't believe I am back at this point.
int main(){
   cout << "Hello World!\n";

   Student me;
   me.age = 22;
   me.GPA = 3.55;
   me.name = "Dong Lee";

   me.expressAge();
   me.expressGPA();
   me.expressName();

   int someNumber =  returnVal(1);
   cout << someNumber << "\n";

   cout << LUL << "\n"; // That's nice.
   cout << SAY << "\n";

   //It's similar to Go; if you are initializing an object, there needs to be a pointer because
   //all objects are ultimately a chunk of memory.
   DoubleMajor* dbMj = new DoubleMajor();
   dbMj->expressAlphaGeekPride();
   delete dbMj;
}
