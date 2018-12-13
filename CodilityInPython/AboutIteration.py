def solution(N):

    N = "{0:b}".format(N)

    #split() returns a list; without any argument, it just converts the String into list.
    #N = N.split()
    #but in one String...
    #print("N's type is: ", type(N), " and its contents are: ", N)

    #The below converts the entire String character by character.
    N = list(N)

    currentLongestGap = 0
    zeroCounter = 0

    for char in N:
        if char == "1":
            N.pop(0)
            for zero in N:
                if zero == "1":
                    if zeroCounter > currentLongestGap:
                        currentLongestGap = zeroCounter
                    zeroCounter = 0
                    break
                zeroCounter += 1
        else:
            N.pop(0)
    return currentLongestGap

print("Sum of binary gap: ", solution(1162))
