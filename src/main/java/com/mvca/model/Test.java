package com.mvca.model;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        Fld fld=new Fld(11,"22",33);
        System.out.println(fld);
        FileOutputStream fout=null;
        ObjectOutputStream out=null;
        String fname=null;
        try {
            //fout=new FileOutputStream(System.getProperty("user.dir")+"/fld.out");
            fname=System.getProperty("user.dir")+"/fld.out";
            System.out.println(fname);
             out= new ObjectOutputStream(new FileOutputStream(fname));
             out.writeObject(fld);
            System.out.println("Serialized data is saved in" + fname);
        }catch (Exception e){

            System.err.println(e.getMessage());
        }finally {
            if (out!=null){
                out.close();
            }

        }

        try{
            FileInputStream fin=new FileInputStream(fname);
            ObjectInputStream in=new ObjectInputStream(fin);
            Fld fld2=(Fld)in.readObject();
            System.out.println(fld2);
            in.close();
            fin.close();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

    }
}
