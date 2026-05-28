package print;
import windows.*;
import connection.*;
import java.sql.*;
import java.util.*;
import object.*;

public class Main
{
    public static void main(String[] args)throws Exception
    {
        Frame show=new Frame(new Person());
        show.createIndex();
    }
}