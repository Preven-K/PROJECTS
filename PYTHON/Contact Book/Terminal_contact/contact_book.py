print ("________________________")
print("*****  CONTACT BOOK   *****")
print ("________________________")

contact={}   #creating an empty dictionary

def display():   #defining the display function
    print("Name\t\tContact Number")
    for key in contact:                                     
        print("{}\t\t{}".format(key,contact.get(key)))      #printing both the key and value pair in dictionary(contact)
while True:
    choice=int(input(" 1.Add Contact \n 2.View Contact List \n 3.Search Contact \n 4.Update Contact \n 5.Delete Contact \n 6.Exit \n Enter your choice: "))
    match choice:
        case 1:
            print("----Adding new Contact----")
            name=str(input("Enter the contact name: "))
            phone=int(input("Enter the mobile number: "))
            contact[name]=phone             #adding key(name) and value(phone) to contact dictionary
        case 2:
            print("----List of Contacts----")
            if not contact:
                print("Contact Book is EMPTY")
            else:
                print ("____________________________")
                display()
                print ("____________________________")
        case 3:
            print("----Searching a Contact----")
            search=str(input("Enter the search Name: "))
            if search in contact:
                print(search,"'s contact number is: ",phone)
                print ("____________________________")
            else:
                print("Name not found in Contact Book :( ")
                print ("____________________________")
        case 4:
            print("----Updating a Contact----")
            edit=str(input("Enter name to be edited: "))
            if edit in contact:
                phone=int(input("Enter the updated Mobile number: "))
                contact[edit]=phone
                print("Sucessfully Updated")
                print ("__________________________")
                display()
                print ("__________________________")
            else:
                print("Name not found in Contact Book :( ")
        case 5:
            print("----Delete a Contact----")
            delete=str(input("Enter name to be edited: "))
            if delete in contact:
                confirm=input("Are you sure you want to delete? (y/n) : ").lower()
                if confirm=='y':
                    contact.pop(delete)
                    print("Sucessfully deleted")
                    print ("________________________")
                    display()
                    print ("________________________")
            else:
                print("Name not found in Contact Book :( ")
        case 6:
            print("----Exiting the Contact Book...")
            print("Thank You :) ")
            break