#include <string>
#include <iostream>

using namespace std;

class DoubleMajor: public Student{
   public:
      string specialization;
      ~DoubleMajor(){
         cout << "Deleting the DoubleMajor object." << "\n";
      };

   void expressAge(){
      cout << "I am " << age << " years old!.\n";
   }

   void expressGPA(){
      cout << "I have " << GPA << "\n";
   }

   void expressName(){
      cout << "My name is: " << name << "\n";
   }

   void expressAlphaGeekPride(){
      cout << "I am 21 and I double major in Math and Computer Science!!" << "\n";
   }
};
