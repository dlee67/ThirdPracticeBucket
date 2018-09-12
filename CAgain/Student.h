#include <string>
#include <iostream>

using namespace std;

class Student{
   public:
      int age;
      int GPA;
      string name;

   void expressAge(){
      cout << "I am " << age << " years old!.\n";
   }

   void expressGPA(){
      cout << "I have " << GPA << "\n";
   }

   void expressName(){
      cout << "My name is: " << name << "\n";
   }
};
