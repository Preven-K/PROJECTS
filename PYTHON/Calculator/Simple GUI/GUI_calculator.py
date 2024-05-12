from tkinter import *

root=Tk()
input =Entry (root,width =60)
input.grid(row=0,column=0,columnspan=4,padx=15,pady=15)

addg=False
subg=False
mulg=False
divg=False

def click(num):
    current=input.get()
    input.delete(0,END)
    input.insert(0,str(current)+str(num))
    return
def add():
    current=input.get()
    global firstnum
    global addg
    addg=True
    input.delete(0,END)
    firstnum=int(current)
    return
def sub():
    current=input.get()
    global firstnum
    global subg
    subg=True
    input.delete(0,END)
    firstnum=int(current)
    return
def mul():
    current=input.get()
    global firstnum
    global mulg
    mulg=True
    input.delete(0,END)
    firstnum=int(current)
    return
def div():
    current=input.get()
    global firstnum
    global divg
    divg=True
    input.delete(0,END)
    firstnum=int(current)
    return
def clr():
    input.delete(0,END)
    return
def equal():
    current=input.get()
    secondnum=int(current)
    global addg
    global subg
    global mulg
    global divg

    if(addg==True):
        input.delete(0,END)
        input.insert(0,str(firstnum+secondnum))
        addg=False
    if(subg==True):
        input.delete(0,END)
        input.insert(0,str(firstnum-secondnum))
        subg=False
    if(mulg==True):
        input.delete(0,END)
        input.insert(0,str(firstnum*secondnum))
        mulg=False
    if(divg==True):
        input.delete(0,END)        
        input.insert(0,str(firstnum/secondnum))
        divg=False
    return

button_1=Button(root,text="1",padx=50,pady=25,command=lambda: click(1))
button_2=Button(root,text="2",padx=50,pady=25,command=lambda: click(2))
button_3=Button(root,text="3",padx=50,pady=25,command=lambda: click(3))
button_4=Button(root,text="4",padx=50,pady=25,command=lambda: click(4))
button_5=Button(root,text="5",padx=50,pady=25,command=lambda: click(5))
button_6=Button(root,text="6",padx=50,pady=25,command=lambda: click(6))
button_7=Button(root,text="7",padx=50,pady=25,command=lambda: click(7))
button_8=Button(root,text="8",padx=50,pady=25,command=lambda: click(8))
button_9=Button(root,text="9",padx=50,pady=25,command=lambda: click(9))
button_0=Button(root,text="0",padx=50,pady=25,command=lambda: click(0))
button_add=Button(root,text="+",padx=50,pady=25,command=add)
button_sub=Button(root,text="-",padx=50,pady=25,command=sub)
button_mul=Button(root,text="*",padx=50,pady=25,command=mul)
button_div=Button(root,text="/",padx=50,pady=25,command=div)
button_clr=Button(root,text="AC",padx=50,pady=25,command=clr)
button_eq=Button(root,text="=",padx=50,pady=25,command=equal)

button_7.grid(row=1,column=0)
button_8.grid(row=1,column=1)
button_9.grid(row=1,column=2)
button_4.grid(row=2,column=0)
button_5.grid(row=2,column=1)
button_6.grid(row=2,column=2)
button_1.grid(row=3,column=0)
button_2.grid(row=3,column=1)
button_3.grid(row=3,column=2)

button_clr.grid(row=4,column=0)
button_0.grid(row=4,column=1)
button_eq.grid(row=4,column=3)
button_add.grid(row=1,column=3)
button_sub.grid(row=2,column=3)
button_mul.grid(row=3,column=3)
button_div.grid(row=4,column=2)

root.mainloop()