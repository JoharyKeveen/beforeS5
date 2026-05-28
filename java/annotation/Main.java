package print;
import annot.*;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class Main 
{
    public static ArrayList<Class>get_Class(String path,String packages)throws Exception
    {
        ArrayList<Class> result=new ArrayList<Class>();
        File directory=new File(path);
        if(!directory.exists())
        {
            return result;
        }
        File[] files=directory.listFiles();
        for(File file : files)
        {
            if(file.isDirectory())
            {
                assert !file.getName().contains(".");
                result.addAll(get_Class(path, packages+"."+file.getName()));
            }
            else if(file.getName().endsWith(".class"))
            {
                result.add(Class.forName(packages+"."+file.getName().substring(0,file.getName().length()-6)));
            }
        }
        return result;
    }

    public static ArrayList<Class>get_Class(String path)throws Exception
    {
        ArrayList<Class> result=new ArrayList<Class>();
        File directory=new File(path);
        if(!directory.exists())
        {
            return result;
        }
        File[] files=directory.listFiles();
        for(File file : files)
        {
            if(file.isDirectory())
            {
                assert !file.getName().contains(".");
                result.addAll(get_Class(path, file.getName()));
            }
            else if(file.getName().endsWith(".class"))
            {
                result.add(Class.forName(file.getName().substring(0,file.getName().length()-6)));
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception{
        // => 0
        // One one=new One();
        // System.out.println("one : "+one.getClass().isAnnotationPresent(Number.class));
   
        // => 1 fa diso sujet
        // Two two=new Two();
        // System.out.println("two : ");
        // for(int i=0;i<two.getClass().getAnnotations().length;i++)
        // {
        //     System.out.println(two.getClass().getAnnotations()[i]);
        // }
        
        ArrayList<Class> list=get_Class("D:/projet/java/annotation/model/","model");

        for(int i=0;i<list.size();i++)
        {
            // => 1
            System.out.println("Annotation : Under10");
            if(list.get(i).isAnnotationPresent(Under10.class))
            {
                System.out.println(list.get(i).getName()+" : true");
            }
            else
            {
                System.out.println(list.get(i).getName()+" : false");
            }
            // => 2
            System.out.println("---Annotation : Fields");
            for(Field field : list.get(i).getDeclaredFields())
            {
                if(field.isAnnotationPresent(Fields.class))
                {
                    System.out.println(field.getName()+" : true");
                }
                else
                {
                    System.out.println(field.getName()+" : false");
                }
            }
            System.out.println("");
        }
    }
}