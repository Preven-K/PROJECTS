import random

flag=True  #used for while loop 
point=0    #to calculate the points obtained by user
match=0    #to find the number of matches completed

bot_choices=["stone","paper","scissor"]                                #choices of the bot chosen using random int 
in_yn=input("Do you want to Play a Game? (yes/no) ").lower()           #getting input willingness to play from user 

if (in_yn) not in ('yes'):                 #comparing the willingness of player 
    print("Ok bye see you later ")
    quit()

else:
    print("Lets Play Stone Paper Scissor Game")     
name=input("Enter your name: ")                #Fetching name from user

while (flag==True)  :
    
    if (match==3):                 #calculating number of match in total in my case (best of 3)
            if point>=2:           #assigning values for winning and loosing by comparing the points (after 3 match only)
                print("************************************************")
                print("Congratularions! "+name+" you Won the Match :) ")
                print("************************************************")
            else:
                print("************************************************")
                print("You Lost "+name+ " Better luck next time ;) ")
                print("************************************************")

            ans=input("Do you want to play again? (yes/no): ").lower()     #after showing the results asking if player want to retry
            if ans != 'yes':
                print("Thank You for playing! Bye See you :)")
                flag==False
                break
            else:
                match=0            #if player wish to play again then reseting the match
                point=0
                continue
    else:
        user=input("Hi "+name+"! choose any one from (stone,paper,scissor) :").lower()   #user choice for this round

        if user not in bot_choices:       #if the user input choice not valid
            print("Invalid choice! kindly select from the options given.")
            continue
        else:
            bot_index=random.randint(0,2);       #randomly selecting a number for bot's choice
            bot_input=bot_choices[bot_index]
            if (user==bot_input):                  #if user and bot choice are same then its tie and similarly for the other logics
                print("_______________________________________________")
                print ("Your had chosen: "+user)
                print("Bot had chosen: "+bot_input)
                print("__Its a Tie__")
                print("completed matches: "+str(match)+"/3 " )
                print("_______________________________________________")
                point+=0
                match+=0
                continue
            elif ((user=="stone" and bot_input=="paper")or(user=="scissor" and bot_input=="stone")or(user=="paper" and bot_input=="scissor")):
                print("_______________________________________________")
                print ("Your had chosen: "+user)
                print("Bot had chosen: "+bot_input)
                print("__You Lose__")
                point+=0
                match+=1
                print("completed matches: "+str(match)+"/3 " )
                print("_______________________________________________")
                continue
            elif (user=="scissor" and bot_input=="paper")or(user=="stone" and bot_input=="scissor")or(user=="paper" and bot_input=="stone"):
                print("_______________________________________________")
                print ("Your had chosen: "+user)
                print("Bot had chosen: "+bot_input)
                print("__You WON__")
                point+=1
                match+=1
                print("completed matches: "+str(match)+"/3 " )
                print("_______________________________________________")
                continue
        

