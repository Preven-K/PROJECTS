import random

point=0
match=0
bot_choices=["stone","paper","scissor"]
in_yn=input("Do you want to Play a Game? (yes/no) ").lower()
if in_yn not in ('yes' or 'y'):
    print("Ok bye see you later ")
    quit()
else:
    print("Lets Play Stone Paper Scissor Game")
name=input("Enter your name: ")

while match<3:
    user=input("Hi "+name+"! choose any one from (stone,paper,scissor) :").lower()
    if user not in bot_choices:
        print("Invalid choice! kindly select from the options given.")
        continue
    else:
        bot_index=random.randint(0,2);
        bot_input=bot_choices[bot_index]
        if (user==bot_input):
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
if point>=2:
    print("************************************************")
    print("Congratularions! "+name+" you Won the Match :) ")
    print("************************************************")
else:
    print("************************************************")
    print("You Lost Better luck next time ;) ")
    print("************************************************")