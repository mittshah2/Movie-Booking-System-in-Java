package com.mitt;

import java.io.*;
import java.util.Arrays;

public class Seat1 implements Seat {
    int[][] seat;
    String fileName;
    public Seat1(String fileName) {
        seat=new int[10][10];
        for(int i=0;i<10;i++)
        {
            for(int j=0;j<10;j++)
            {
                seat[i][j]=0;
            }
        }
        this.fileName=fileName;
    }

    public void write()
    {
        try{
            File file = new File(fileName);
            file.createNewFile();
            Writer f1=new FileWriter(file);
           BufferedWriter b=new BufferedWriter(f1);
            for(int i=0;i<10;i++)
            {
                for(int j=0;j<10;j++)
                {
                    b.write(seat[i][j]);
                }
            }
            b.close();
            f1.close();

        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }

    }

    public void read()
    {
        try{
            File file=new File(fileName);
            file.createNewFile();
            FileInputStream fi=new FileInputStream(file);
            BufferedInputStream b=new BufferedInputStream(fi);

            for(int i=0;i<10;i++)
            {
                for(int j=0;j<10;j++)
                {
                    seat[i][j]=b.read();
                }

            }
            fi.close();
            b.close();
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }

    public void display()
    {
        for(int i=0;i<10;i++)
        {
            for(int j=0;j<10;j++)
            {
                if(seat[i][j]==0)
                {
                    int a=j+1;
                    System.out.print((char)(i+65)+""+a+"  ");
                }
              else if(seat[i][j]==1)
                    System.out.print("X  ");
            }
            System.out.println();
        }
    }
}
