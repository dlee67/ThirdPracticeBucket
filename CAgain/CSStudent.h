#include <string>
#include <iostream>

using namespace std;

class CSStudent: public Student{
   public:
      string specialization;

   void expressAge(){
      cout << "I am " << age << " years old!.\n";
   }

   void expressGPA(){
      cout << "I have " << GPA << "\n";
   }

   void expressName(){
      cout << "My name is: " << name << "\n";
   }

   void expressSpecialization(){
      cout << "My specialization for Math major is: " << specialization << "\n";
   }
};
