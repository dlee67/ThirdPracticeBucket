import numpy as np

class PythonPrac:

    def __init__(self, age):
        self.age = age
        self.cars = ["Ford", "Volvo", "BMW"]

    def input_name(self):
        myNameIs = input("What is your name?: ")
        print(myNameIs)

    def display_age(self):
        print("I am ", self.age, " years old.")

    def loop_through_an_array(self):
        for index in range(0,  len(self.cars)):
            print(self.cars[index])
            if self.cars[index] == "Ford":
                print("passing by...")

    def create_dict(self):
        grade_dict = {'Alan Anderson': 4.0,
                      'Betsy Baron': 2.8,
                      'Tom Swift': 3.5}
        ##This is how you iterate through dictionary.
        for key in grade_dict:
            print(key, '\t', grade_dict[key])

    def use_np_array(self):
        a = np.array([1, 2, 3])
        ##nditer is used to iterate through an array of numpy.
        for element in np.nditer(a):
            print("Iterating through: ", element)

def main():
    HowToStuff = PythonPrac(5)
    HowToStuff.input_name()
    HowToStuff.display_age()
    HowToStuff.loop_through_an_array()
    HowToStuff.create_dict()
    HowToStuff.use_np_array()

if __name__ == "__main__":
    main()
