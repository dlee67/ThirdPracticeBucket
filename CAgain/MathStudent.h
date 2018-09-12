#include <string>
#include <iostream>

using namespace std;

class MathStudent: public Student{
   public:
      string concentration;

   void expressAge(){
      cout << "I am " << age << " years old!.\n";
   }

   void expressGPA(){
      cout << "I have " << GPA << "\n";
   }

   void expressName(){
      cout << "My name is: " << name << "\n";
   }

   void expressConcentration(){
      cout << "My concentration for Math major is: " << concentration << "\n";
   }
};
