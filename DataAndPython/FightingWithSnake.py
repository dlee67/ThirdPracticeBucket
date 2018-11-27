import numpy as np
import pandas as pd

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
        a = np.array([1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
        ##nditer is used to iterate through an array of numpy.
        for element in np.nditer(a):
            print("Iterating through: ", element)
        print("Should be 3: ", a[2])
        print(a[0:3])

    def use_panda(self):
        someArray = np.array(range(0, 10))
        s = pd.Series(someArray)
        print(s)
        secondPanda = pd.Series([1, 2, 3], index=['a', 'b', 'c'])
        print(secondPanda['a'])

    def panda_dataframe(self):
        data = {"lol": ["lul", "lel", "heh"],
                "gut": ["good", "gud", "awesome"],
                "LOGH": ["Yang", "Julian", "Rein"]}
        frame = pd.DataFrame(data)
        print(frame, "\n")
        ## Strangely enough, data frame in panda is ["column"]["row"],
        ## not ["row"]["column"]
        print(frame["LOGH"][0])

def main():
    howToStuff = PythonPrac(5)
    howToStuff.input_name()
    howToStuff.display_age()
    howToStuff.loop_through_an_array()
    howToStuff.create_dict()
    howToStuff.use_np_array()
    howToStuff.use_panda()
    howToStuff.panda_dataframe()

if __name__ == "__main__":
    main()
