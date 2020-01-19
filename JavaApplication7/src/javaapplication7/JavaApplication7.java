/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Mahe
 */
class Dummy implements Serializable
{   
    private int _a , _b;
    Dummy(int _a , int _b)
    {
        this._a = _a;
        this._b = _b;
    }
    
    public int geta()
    {
        return this._a;
    }
    
    public int getb()
    {
        return this._b;
    }
    
    
}
public class JavaApplication7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        System.out.println("Hello WOrld");
        Dummy d = new Dummy(1,2);
        Dummy d2 = new Dummy(3,4);
        Dummy d3 = new Dummy(5,6);
        Dummy d4 = new Dummy(7,8);
        
        ArrayList<Dummy> arr = new ArrayList<Dummy>();
        arr.add(d);
        arr.add(d2);
        arr.add(d3);
        arr.add(d4);
        
        FileOutputStream f = new FileOutputStream("Ser");
        ObjectOutputStream out = new ObjectOutputStream(f); 
        
        out.writeObject(arr);
        
        //SEND DATA CODE
        
        FileInputStream f2 = new FileInputStream("Ser");
        ObjectInputStream in = new ObjectInputStream(f2);
        
        ArrayList<Dummy> arr2 = null;
        
        arr2 = (ArrayList<Dummy>) in.readObject();
        
      for(int i = 0 ; i < arr2.size() ; i++)
      {
        System.out.println(arr2.get(i).geta());
        System.out.println(arr2.get(i).getb());
        System.out.println("---------------------");
      }
        
    }
    
    
}
