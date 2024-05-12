task_list=[]

def create_task():
    task=input("Enter the TASK: ")
    task_list.append(task)                      # appending into the list
    print(f"Task '{task}' added to the list.")  # f is to put the variables into it 

def delete_task():
    display_task()
    try:
        taskToDelete=int(input("Choose the number of the task to delete: #"))  #getting input in number to delete a task

        if taskToDelete>=0 and taskToDelete <len(task_list):
            task_list.pop(taskToDelete)
            print(f"Task {taskToDelete} has been deleted.")
        else:
            print(f"Task #{taskToDelete} was not found.")
    except:
        print("Invalid input")


def display_task():
    if not task_list:
        print ("NO TASK IN THE TO-DO LIST")
    else:
        for i ,task in enumerate(task_list):  # enumerate is used to go through the list with the elements and index
            print(f"Task #{i}. {task}")

print("---TO-DO LIST APP---")
print("____________________")
while True:
    print("select one option from below:")
    print("______________________________")
    print("1. Create a TASK")
    print("2. Delete a TASK")
    print("3. Display TASKS")
    print("4. Quit")
    print("______________________________")
    choice=input("Enter your choice: ")
    if choice=="1":
        create_task()
    elif choice=="2":
        delete_task()        
    elif choice=="3":
        display_task()    
    elif choice=="4":
        print("Thank you! bye bye !!")
        break    
    else:
        print("---Invalid Input---")