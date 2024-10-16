# This program is design by Gregory Doubt for Week 3 Discussion
# this Python Program will determine the generation you are born in

txt_1 = "HELLO EVERYONE"
x = txt_1.center(80, "_")
print(x)
print("Program Designed By Gregory Doubt for CMIS 102 7381\n")
print("Nov 6 2022\n")

print('This program will guess the generation you were born in')

print('Enter the Year You Were Born\t\n')

year = eval(input("Year:\t\n"))


if year < 1950:
    print('You are too old, LOL. Cannot name the generation')
elif year <= 1965:
    print('You are a Baby Boomer')
elif year <= 1985:
    print ('You are from Generation X')
# Modifications - Adam Langbert
# Added Zillennial generation :) (1993-1998)
elif year <= 1992:
    print ('You are from Millennial Generation')
elif year <= 1998:
    print ('You are a Zillennial')
elif year <= 2001:
    print('You are from Gen Z')
