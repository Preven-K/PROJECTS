a_in=int(input("Enter the first number:"))
b_in=int(input("Enter the Second number:"))

choice=int(input('''List of Operations:
1.ADDITION
2.SUBRACTION
3.MULTIPLICATION 
4.DIVISION
Enter the number of Operation which you want to perform: '''))
match choice :
    case 1:
        print("______________________________")
        print("Performing ADDITION OPERATION")
        print("______________________________")
        print("................")
        print (str(a_in)+ " + "+str(b_in)+ " = "+str(a_in+b_in))
        print("................")
    case 2:
        print("______________________________")
        print("Performing SUBRACTION OPERATION")
        print("______________________________")
        print("................")
        print (str(a_in)+ " - "+str(b_in)+ " = "+str(a_in-b_in))
        print("................")
    case 3:
        print("______________________________")
        print("Performing MULTIPLICATION OPERATION")
        print("______________________________")
        print("................")
        print (str(a_in)+ " * "+str(b_in)+ " = "+str(a_in*b_in))
        print("................")

    case 4:
        print("______________________________")
        print("Performing DIVISION OPERATION")
        print("______________________________")
        print("................")
        print (str(a_in)+ " / "+str(b_in)+ " = "+str(a_in/b_in))
        print("................")
