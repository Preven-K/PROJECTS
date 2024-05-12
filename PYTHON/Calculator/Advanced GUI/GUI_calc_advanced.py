import tkinter
from tkinter import *
 
root=Tk()
root.title("Simple Calculator")     #providing title for the gui
root.geometry("570x600+100+200")    #dimensions of the gui window
root.resizable(False,False)         #making the window not resizable
root.configure(bg="#17161b")        #giving background colour

equation=""          #initialising the variable as empty string

def show(value):     #defining funct for showing the input
    global equation
    equation+=value    #adding the values sequentially at the end
    label_result.config(text=equation,font=("arial",30,"bold"), bd=1,fg="#fff")  #declaring the font,colour,text
def clear():         #defining clear function
    global equation  #making it global to access outside the function
    equation=""
    label_result.config(text=equation)
def calculate():           #defining calculate function
    global equation
    result=""
    if equation !="":
        try:
            result=eval(equation) #evaluating the given expression
        except:
            result="error"
            equation=""
    label_result.config(text=result) #printing the result in the output window

label_result=Label(root,width=25,height=2,text="",font=("arial",30),bd=1,fg="#fff",bg="#000000")  #creating  seperate window to have the display 
label_result.pack()
#creating buttons in the first row with size,font,colour,command function and position
Button(root,text="C",width=5,height=1,font=("arial",30,"bold"), bd=1,fg="#fff",bg="#FF0000",command=lambda:clear()).place(x=10,y=100)
Button(root,text="/",width=5,height=1,font=("arial",30,"bold"), bd=1,fg="#fff",bg="#0000CD",command=lambda:show("/")).place(x=150,y=100)
Button(root,text="*",width=5,height=1,font=("arial",30,"bold"), bd=1,fg="#fff",bg="#0000CD",command=lambda:show("*")).place(x=290,y=100)
Button(root,text="%",width=5,height=1,font=("arial",30,"bold"), bd=1,fg="#fff",bg="#0000CD",command=lambda:show("%")).place(x=430,y=100)
#creating buttons in the second row with size,font,colour,command function and position
Button(root,text="7",width=5,height=1,font=("arial",30,"bold"), bd=1,fg="#fff",bg="#0000CD",command=lambda:show("7")).place(x=10,y=200)
Button(root,text="8",width=5,height=1,font=("arial",30,"bold"), bd=1,fg="#fff",bg="#0000CD",command=lambda:show("8")).place(x=150,y=200)
Button(root,text="9",width=5,height=1,font=("arial",30,"bold"), bd=1,fg="#fff",bg="#0000CD",command=lambda:show("9")).place(x=290,y=200)
Button(root,text="+",width=5,height=1,font=("arial",30,"bold"), bd=1,fg="#fff",bg="#0000CD",command=lambda:show("+")).place(x=430,y=200)
#creating buttons in the third row with size,font,colour,command function and position
Button(root,text="4",width=5,height=1,font=("arial",30,"bold"), bd=1,fg="#fff",bg="#0000CD",command=lambda:show("4")).place(x=10,y=300)
Button(root,text="5",width=5,height=1,font=("arial",30,"bold"), bd=1,fg="#fff",bg="#0000CD",command=lambda:show("5")).place(x=150,y=300)
Button(root,text="6",width=5,height=1,font=("arial",30,"bold"), bd=1,fg="#fff",bg="#0000CD",command=lambda:show("6")).place(x=290,y=300)
Button(root,text="-",width=5,height=1,font=("arial",30,"bold"), bd=1,fg="#fff",bg="#0000CD",command=lambda:show("-")).place(x=430,y=300)
#creating buttons in the fourth row with size,font,colour,command function and position
Button(root,text="1",width=5,height=1,font=("arial",30,"bold"), bd=1,fg="#fff",bg="#0000CD",command=lambda:show("1")).place(x=10,y=400)
Button(root,text="2",width=5,height=1,font=("arial",30,"bold"), bd=1,fg="#fff",bg="#0000CD",command=lambda:show("2")).place(x=150,y=400)
Button(root,text="3",width=5,height=1,font=("arial",30,"bold"), bd=1,fg="#fff",bg="#0000CD",command=lambda:show("3")).place(x=290,y=400)
Button(root,text=".",width=5,height=1,font=("arial",30,"bold"), bd=1,fg="#fff",bg="#0000CD",command=lambda:show(".")).place(x=430,y=400)
#creating buttons in the fifth row with size,font,colour,command function and position
Button(root,text="0",width=11,height=1,font=("arial",30,"bold"), bd=1,fg="#fff",bg="#0000CD",command=lambda:show("0")).place(x=10,y=500)
Button(root,text="=",width=11,height=1,font=("arial",30,"bold"), bd=1,fg="#fff",bg="#FF8C00",command=lambda:calculate()).place(x=290,y=500)

root.mainloop()