from tkinter import *
from PIL import ImageTk,Image
from tkinter import messagebox
import pymysql
from tkinter import ttk
import tkinter


# Add your own database name and password here to reflect in the code
mypass = "Mystry@001"
mydatabase="Library_Management"

con = pymysql.connect(host="localhost",user="root",password=mypass,database=mydatabase)
cur = con.cursor()

# Enter Table Names here
bookTable = "books"
y = 0.25



order=["asc","desc"]




def sort():
    global sortBtn,labelFrame,lb1,inf2,quitBtn,root,Canvas1,order
    root.withdraw()
    
    root = Tk()
    
    
    root.title("Library")
    root.minsize(width=400,height=600)
    root.geometry("600x500")

    Canvas1 = Canvas(root) 
    Canvas1.config(bg="#12a4d9")
    Canvas1.pack(expand=True,fill=BOTH)

    headingFrame1 = Frame(root,bg="#FFBB00",bd=5)
    headingFrame1.place(relx=0.25,rely=0.1,relwidth=0.5,relheight=0.13)
        
    headingLabel = Label(headingFrame1, text="Sort Books", bg='black', fg='white', font=('Courier',15))
    headingLabel.place(relx=0,rely=0, relwidth=1, relheight=1)
    
    labelFrame = Frame(root,bg='black')
    labelFrame.place(relx=0.1,rely=0.3,relwidth=0.8,relheight=0.6)
    
    o=inf2.get()
    
    Label(labelFrame, text="%-10s%-50s%-30s%-20s"%('BID','Title','Author','Status'),bg='black',fg='white').place(relx=0.07,rely=0.1)
    Label(labelFrame, text="----------------------------------------------------------------------------",bg='black',fg='white').place(relx=0.05,rely=0.2)
    
    qry="select * from books order by title " +o + " ; "
    cur.execute(qry)
    con.commit()
    y=0.25
    for i in cur:
        #Label(labelFrame, text="%-10s%-30s%-30s%-20s"%(i[0],i[1],i[2],i[3]),bg='black',fg='white').place(relx=0.07,rely=y)
        Label(labelFrame, text="%s"%(i[0]),bg='black',fg='white').place(relx=0.07,rely=y)
        Label(labelFrame, text="%s"%(i[1]),bg='black',fg='white').place(relx=0.15,rely=y)
        Label(labelFrame, text="%s"%(i[2]),bg='black',fg='white').place(relx=0.5,rely=y)
        Label(labelFrame, text="%s"%(i[3]),bg='black',fg='white').place(relx=0.7,rely=y)
        y += 0.1

    lbl=Label(labelFrame, text='ORDER BY TITLE',bg='black',fg='white')
    lbl.place(relx=0.2,rely=0.9, relwidth=0.2)

    inf2=ttk.Combobox(root,value=order)
    inf2.place(relx=0.5,rely=0.84, relwidth=0.2)
     
    sortBtn = Button(root,text="Sort",bg='#d1ccc0', fg='black',command=sort)
    sortBtn.place(relx=0.28,rely=0.9, relwidth=0.18,relheight=0.08)
    
    quitBtn = Button(root,text="Quit",bg='#aaa69d', fg='black', command=root.destroy)
    quitBtn.place(relx=0.53,rely=0.9, relwidth=0.18,relheight=0.08)

    root.mainloop()
       
       
def sortBook():

    global sortBtn,labelFrame,lb1,inf1,inf2,quitBtn,root,Canvas1,order

    root = Tk()
    root.title("Library")
    root.minsize(width=400,height=600)
    root.geometry("600x500")

    Canvas1 = Canvas(root) 
    Canvas1.config(bg="#12a4d9")
    Canvas1.pack(expand=True,fill=BOTH)

    headingFrame1 = Frame(root,bg="#FFBB00",bd=5)
    headingFrame1.place(relx=0.25,rely=0.1,relwidth=0.5,relheight=0.13)
        
    headingLabel = Label(headingFrame1, text="Sort Books", bg='black', fg='white', font=('Courier',15))
    headingLabel.place(relx=0,rely=0, relwidth=1, relheight=1)
    
    labelFrame = Frame(root,bg='black')
    labelFrame.place(relx=0.1,rely=0.3,relwidth=0.8,relheight=0.6)
    y = 0.25
    
    Label(labelFrame, text="%-10s%-50s%-30s%-20s"%('BID','Title','Author','Status'),bg='black',fg='white').place(relx=0.07,rely=0.1)
    Label(labelFrame, text="----------------------------------------------------------------------------",bg='black',fg='white').place(relx=0.05,rely=0.2)
    getBooks = "select * from "+bookTable

    try:
        cur.execute(getBooks)
        con.commit()
        for i in cur:
            #Label(labelFrame, text="%-10s%-30s%-30s%-20s"%(i[0],i[1],i[2],i[3]),bg='black',fg='white').place(relx=0.07,rely=y)
            
            Label(labelFrame, text="%s"%(i[0]),bg='black',fg='white').place(relx=0.07,rely=y)
            Label(labelFrame, text="%s"%(i[1]),bg='black',fg='white').place(relx=0.15,rely=y)
            Label(labelFrame, text="%s"%(i[2]),bg='black',fg='white').place(relx=0.5,rely=y)
            Label(labelFrame, text="%s"%(i[3]),bg='black',fg='white').place(relx=0.7,rely=y)
            y += 0.1
    except:
        messagebox.showinfo("Failed to fetch files from database")

    


    '''btn1 = Button(root,text="Sort Ascending",bg='black', fg='white',command=[root.destroy,sortAsc])
    btn1.place(relx=0.28,rely=0.9, relwidth=0.18,relheight=0.08)
        
    btn2 = Button(root,text="Sort Descending",bg='black', fg='white',command=sortDesc)
    btn2.place(relx=0.38,rely=0.9, relwidth=0.18,relheight=0.08)'''

    lbl=Label(labelFrame, text='ORDER BY TITLE',bg='black',fg='white')
    lbl.place(relx=0.2,rely=0.9, relwidth=0.2)

    inf2=ttk.Combobox(root,value=order)
    inf2.place(relx=0.5,rely=0.84, relwidth=0.2)
     
    sortBtn = Button(root,text="Sort",bg='#d1ccc0', fg='black',command=sort)
    sortBtn.place(relx=0.28,rely=0.9, relwidth=0.18,relheight=0.08)
    
    quitBtn = Button(root,text="Quit",bg='#aaa69d', fg='black', command=root.destroy)
    quitBtn.place(relx=0.53,rely=0.9, relwidth=0.18,relheight=0.08)

    root.mainloop()


    
