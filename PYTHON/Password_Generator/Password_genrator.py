import random 
import string 
def generate_pwd(min,num_in=True,spl_in=True):   #defining a function
    letters=string.ascii_letters  #getting all alphabets from string
    numbers=string.digits         #getting all numbers from string
    special=string.punctuation    #getting all special characters from string

    combined=letters            #adding every letters in single variable
    if num_in:                  #adding every numbers if the user input is true 
        combined+=numbers
    if spl_in:                  #adding every special characters if the user input is true 
        combined+=special 

    pwd=""               #making password a empty string
    requirements=False   #making requirements false since the pwd is empty
    has_num=False        #making it false since there is no numbers present in it
    has_spl=False        #making it false since there is no special char present

    while ((not requirements) or (len(pwd) < min)) : #loops until the requirment is true or the length of password is greater than min (INPUT)
        random_ip=random.choice(combined)            #randomly selecting a character from combined variable
        pwd += random_ip                   # adding the randomly selected char to password
        if random_ip in numbers:           # if randomly selected one is a number then make the has_num as True 
            has_num=True                   # this refers that the password contains numbers
        elif random_ip in special:         # if randomly selected one is a special character then make the has_spl as True           
            has_spl=True                   # this refers that the password contains special character

        requirements=True                  # then make the requiremnt is true 
        if num_in:                         #if the user need numbers then requirment will have the bool value depending on has_num 
            requirements=has_num           #since has_num has the bool value with respect to pwd
        if spl_in:                         #if the user need special char then requirment will have the bool value depending on has_spl 
            requirements=(requirements and has_spl)     #since has_spl has the bool value with respect to pwd
    return pwd         #finally returning the password

min =int(input("Enter the minimum length of the password: "))                       #getting minimum length as input 
num_in =input("Can the password have numbers? (y/n): ").lower() == 'y'              #getting input if the password can contain numbers
spl_in =input("Can the password have special characters? (y/n): ").lower() == 'y'   #getting input if the password can contain spl char
pwd=generate_pwd(min,num_in,spl_in)                                                 #function call 
print("The Password Generated is : "+pwd)                                           #printing the password generated 