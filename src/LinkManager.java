/*
 * LinkManager.java
 *
*/
import java.lang.*;
import java.util.*;
import java.io.*;
import javax.swing.*;

public class LinkManager { 
    
    LinkNode head = null;
    LinkNode temp = null;
    LinkNode next = null;
    LinkNode current = null;
    LinkNode prev = null;
    //LinkNode temp ;
    LinkedApplet_Niedzielski myApplet;
    
    /** Creates a new instance of LinkManager */
    public LinkManager(LinkedApplet_Niedzielski a) {
        myApplet = a;
    }

    LinkManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public boolean initialize(String fileName){
        try {
            BufferedReader inStream                       // Create and 
                = new BufferedReader (new FileReader(fileName)); // Open the stream
            String name = "";
            String title = "";
            int sal = 0;
            int years = 0;
            String line = inStream.readLine();            // Read one line

            while (line != null) {                        // While more text
                
               name = line;

               line = inStream.readLine();               // Read next line
	       title = line;

               line = inStream.readLine();               // Read next line
               sal = Integer.parseInt(line);

               line = inStream.readLine();               // Read next line
               years = Integer.parseInt(line);
               
               LinkNode tempNode = new LinkNode(name, title, sal, years); 
               insert (tempNode);
               
               line = inStream.readLine();            // Read one line
        }
            inStream.close();   // Close the stream
            return true;
        }
    
        catch (java.io.FileNotFoundException e) {
            myApplet.displayText("IOERROR: File NOT Found: " + fileName + "\n");
            return false; // invalid operation
            //e.printStackTrace();
        } 
        catch (java.io.IOException e) {
            myApplet.displayText("IOERROR: " + e.getMessage() + "\n");
            return false; // invalid operation
            //e.printStackTrace();
        }
    }
    
    public boolean isEmpty()  
    {
        return head == null;
    }
    
    public void insert(LinkNode newNode) { 
    if (isEmpty()) 
        head = newNode;                   // Insert at head of list
    else {
        current = head;   // Start traversal at head
        while (current.getNext() != null) // While not at the last node
            current = current.getNext();  //   go to the next node
        current.setNext( newNode );     // Do the insertion
    }      
} // insert()

    public String print() { 
    
    if (isEmpty()) 
        return "List is empty";
    
    String listContents = "";
    current = head;          // Start traversal at head
    
    while (current != null) {                     // While not at end of list
        listContents = listContents + current.getInfo() + "\n"; //   append node's data to string
        current = current.getNext();              //   go to the next node
    }       
    return listContents;
    
} // print()
    
    
    public void sortTitleSalary(){
        LinkNode tempTS = null;
        current = head;
        
        while(current != null){ // visit all nodes in current list
           if (tempTS == null) // new list is empty
           {
               tempTS = current;
               current = current.getNext();
               tempTS.setNext(null);
               head = tempTS;
           }//end if the list is empty
           else if ((current.getJob().compareTo(head.getJob())< 0)) // add to front of list
           {
               temp = current.getNext(); // save rest of list
               head = current;
               head.setNext(tempTS);
               tempTS=head;
               current = temp;
           }//end else to add to front
           else if ((current.getJob().compareTo(head.getJob())==0)&&current.getSalary()<head.getSalary()) // add to front of list
           {
               temp = current.getNext(); // save rest of list
               head = current;
               head.setNext(tempTS);
               tempTS=head;
               current = temp;
           }//end else to add to front
           else // add to middle or end
           {
               temp = current.getNext(); // hold rest of list
               prev = head;
               next = prev.getNext();
               while ((next != null) && (current.getJob().compareTo(next.getJob()) >0))
               { 
                   prev = next;
                   next = next.getNext();
               }//end while 
               if (next == null)  // add to end of the list
               {
                   prev.setNext(current);
                   current.setNext(null);
                   current = temp;
               }//end if add to end
               else // add to middle
               {
                   current.setNext(next);
                   prev.setNext(current);
                   current = temp;
               }//end else add to middle
           } // end else add to middle or end
         }//end while current!=null
        current=null;
        temp = null;
        prev=null;
    }//end sortYear
    
    public void sortYears(){
        LinkNode tempYears = null;
        current = head;
        while(current != null){ // visit all nodes in current list
        
           if (tempYears == null) // new list is empty
           {
               tempYears = current;
               current = current.getNext();
               tempYears.setNext(null);
               head = tempYears;
           }
           else if (current.getYears() < head.getYears()) // add to front of list
           {
               temp = current.getNext(); // save rest of list
               head = current;
               head.setNext(tempYears);
               tempYears=head;
               current = temp;
           }
           else // add to middle or end
           {
               temp = current.getNext(); // hold rest of list
               prev = head;
               next = prev.getNext();
               while ((next != null) && (current.getYears() >next.getYears()))
               { 
                   prev = next;
                   next = next.getNext();
               }
               if (next == null)  // add to end of the list
               {
                   prev.setNext(current);
                   current.setNext(null);
                   current = temp;
               }
               else // add to middle
               {
                   current.setNext(next);
                   prev.setNext(current);
                   current = temp;
               }
           } // end else
           
        }//end while
        current=null;
        temp = null;
        prev=null;
    }//end sortYear
    
    public void sortName(){
        LinkNode tempName = null;
        current = head;
        
        while(current != null){ // visit all nodes in current list
        
           if (tempName == null) // new list is empty
           {
               tempName = current;
               current = current.getNext();
               tempName.setNext(null);
               head = tempName;
           }
           else if (current.getName().compareTo(head.getName()) < 0) // add to front of list
           {
               temp = current.getNext(); // save rest of list
               head = current;
               head.setNext(tempName);
               tempName=head;
               current = temp;
           }
           else // add to middle or end
           {
               temp = current.getNext(); // hold rest of list
               prev = head;
               next = prev.getNext();
               while ((next != null) && (current.getName().compareTo(next.getName()) >0 ))
               { 
                   prev = next;
                   next = next.getNext();
               }
               if (next == null)  // add to end of the list
               {
                   prev.setNext(current);
                   current.setNext(null);
                   current = temp;
               }
               else // add to middle
               {
                   current.setNext(next);
                   prev.setNext(current);
                   current = temp;
               }
           } // end else
           
        }//end while
        current=null;
        temp = null;
        prev=null;
    }//end sortName
    
    public void removeItem(){
        String eName = JOptionPane.showInputDialog(null,"Enter the employee's name");
        String eTitle = JOptionPane.showInputDialog(null,"Enter the employee's job title");
        String empSal = JOptionPane.showInputDialog(null,"Enter the employee's salary");
        String empYears = JOptionPane.showInputDialog(null,"Enter the number of years of employment");
        if(eName == null || eTitle==null||empSal==null||empYears==null){
            System.exit(0);
        }//check for cancel button and null values
        int eYears = Integer.parseInt(empYears);
        int eSal = Integer.parseInt(empSal);
        
        LinkNode node1=null,node2=null;
        current = head;
        boolean remove=false, dupe=false;
        
        while((current!=null)&&(remove==false)){
            if((current.getName().equals(eName))&&(current.getJob().equals(eTitle))&&(current.getSalary()==eSal)&&(current.getYears()==eYears)){//if item matches the head
                dupe=true;
                head = current.getNext();
                current = head;
                JOptionPane.showMessageDialog(null,"Record Terminated!","Success",JOptionPane.INFORMATION_MESSAGE);
                remove=true;
            }//end if matches head
            else if((current.getNext().getName().equals(eName))&&(current.getNext().getJob().equals(eTitle))&&(current.getNext().getSalary()==eSal)&&(current.getNext().getYears()==eYears)){//if match isnt the first node
                dupe=true;
                node1 = current.getNext();
                 node2 = node1.getNext();
                 current.setNext(node2);
                JOptionPane.showMessageDialog(null,"Record Terminated","Success",JOptionPane.INFORMATION_MESSAGE);
                remove=true;
            }//end if match and not head
            
            else{
                current=current.getNext();
            }//end else not match
        }//end while current!=null
        if(!remove||!dupe)
            JOptionPane.showMessageDialog(null,"No Match!","Please Try Again",JOptionPane.INFORMATION_MESSAGE);
        
    }//end removeItem
    
    public void addItem(){
        String eName = JOptionPane.showInputDialog(null,"Enter the employee's name");
        String eTitle = JOptionPane.showInputDialog(null,"Enter the employee's job title");
        String empSal = JOptionPane.showInputDialog(null,"Enter the employee's salary");
        String empYears = JOptionPane.showInputDialog(null,"Enter the number of years of employment");
        if(eName == null || eTitle==null||empSal==null||empYears==null){
            System.exit(0);
        }//check for cancel button and null values
        int eSal = Integer.parseInt(empSal);
        int eYears = Integer.parseInt(empYears);
        LinkNode newNode = new LinkNode(eName, eTitle, eSal, eYears); 
        insert(newNode);
        JOptionPane.showMessageDialog(null,"New Record Succesfully Added!","Success",JOptionPane.INFORMATION_MESSAGE);
    }//end add item

}//end LinkManager
