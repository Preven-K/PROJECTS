print("_______________________________________________________________________________________")
print("\t\t\t---PIG Game---")
print("Welcome to PIG game")
print("Rules :")
print("1. The game is played by two or more players. Each player takes turns rolling a die.")
print("2. The score will be based on sum value of each die rolled")
print("3. The player who rolls a 1 loses his/her turn and the score is reset to 0")
print("4. The player Player can either roll the die or pass the turn with current score")
print("5 .The player who reaches 50 first wins the game")
print("_______________________________________________________________________________________")
import random

def roll():
    return random.randint(1,6)

max_score=50
player_list=[]

while True:
    try: 
        player = int(input("How many players want to play (2-4) : "))
    except ValueError: 
        print("Invalid input. Please enter a number") 
        continue
    if player >=2 and player <=4:       
        for i in range(player):
            name=input(f"Enter the Name of Player {i+1} : ")
            player_list.append(name)
        break
    else:
        print("Invalid input. Please enter a valid number between 2-4")
        continue

player_score=[0 for _ in range(len(player_list))]

while max(player_score)<=max_score:

    for i in range(len(player_list)):
        cur_score = 0
        print("_______________________________________________________")
        print(f">>> Player {player_list[i]} turn <<< ")
        while True:            
            print(f"Current Score : {cur_score}")
            print("1. Roll the die\n2. Pass the turn")            
            try:
                choice = int(input("Enter your choice : "))
                if choice == 1:
                    die = roll()
                    print(f"---You rolled {die}---")
                    if die == 1:
                        cur_score=0
                        print(">>> You lose your turn and score is reset to 0 <<<")
                        break
                    else:
                        cur_score +=  die
                        print(f">>> Your current score is {cur_score} <<<")
                elif choice == 2:
                    print(f">>> {player_list[i]} passed the turn <<<")
                    break
                else:
                    print("---Invalid choice. Please enter a valid choice---")
                    continue
            except ValueError : 
                print("Invalid input. Please enter a valid choice")
                continue
        player_score[i] += cur_score
        print(f">>> Player '{player_list[i]}' Total Scored: {player_score[i]} <<<")
        print("_______________________________________________________")


print(" \t RESULTZ:")
for player in range(len(player_list)):
    print(f">>> Player '{player_list[player]}' Total Scored: {player_score[player]} <<<")

win = max(player_score)
win_index=player_score.index(win)
print("*********************************************************")
print(f" Player '{player_list[win_index].upper()}' WON the match with score : {player_score[win_index]} ")
print("*********************************************************")