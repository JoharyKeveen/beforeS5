import java.util.Vector;

public class Main
{
    public static void main(String[] args) {
        String test="1,9->10";
        String[] splits=test.replaceAll("//s", "").split(",");
        Vector<String> list=new Vector<String>();
        for(int x=0;x<splits.length;x++)
        {
            list.add(splits[x]);
        }
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).contains("->"))
            {
                String[] temp=list.get(i).split("->");
                int first=Integer.valueOf(temp[0]);
                int between=Integer.valueOf(temp[1])-Integer.valueOf(temp[0]);
                list.remove(i);
                for(int j=i;j<=i+between;j++)
                {
                    list.insertElementAt(Integer.toString(first), j);
                    first+=1;
                }
            }
        }
        System.out.println("La taille du resultat est "+list.size());
        for(int k=0;k<list.size();k++)
        {
            System.out.println(list.get(k));
        }
    }
}