package sql;
import java.util.*;
import java.io.*;
public class Relation
{
    String name;
    Vector<String> colonne;
    Vector<String> donne;
    public Relation()
    {
        this.colonne=new Vector<String>();
        this.donne=new Vector<String>();
    }

    public void create_tab(String name,String colonnes)throws Exception
    {
        File e = new File(name+".txt");
        if(e.exists())
        {
            throw new Exception("Cette table existe deja");
        }
        FileWriter file=new FileWriter(e,true);
        String[] wr=colonnes.split(",");
        for(int i=0;i<wr.length;i++)
        {
            file.write(wr[i]+"    ");
        }
        file.write("\n");
        file.close();
    }

    public boolean testExistancePourDivision(String test,String[][] tab)
    {
        for(int i=0;i<tab.length;i++)
        {
            for(int j=0;j<tab[0].length;j++)
            {
                if(tab[i][j].toLowerCase().equals(test.toLowerCase()))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public Vector<Integer> lineDivision(String[][] tab1,String[][] tab2,int icolumn)throws Exception
    {
        Vector<Integer> result=new Vector<Integer>();
        for(int i=0;i<tab1.length;i++)
        {
            for(int j=0;j<tab1[0].length;j++)
            {
                    if(j==icolumn)
                    {
                        if(testExistancePourDivision(tab1[i][j],tab2)==true)
                        {
                            result.add(i);
                        }
                    }
            }
        }
        return result;
    }

    public int idCol(String a,String b)throws Exception
    {
        int nb=-2;
        String[] result=a.split("    ");
        String[] ty=b.split("    ");
        for(int i=0;i<result.length;i++)
        {
            for(int j=0;j<ty.length;j++)
            {
                if(result[i].toLowerCase().equals(ty[j].toLowerCase()))
                {
                    nb=i;
                }
            }
        }
        if(nb<0)
        {
            throw new Exception("Division impossible: aucune similarite de colonne");
        }
        return nb;
    }

    public void produitCarthesien(String fileName1,String fileName2)throws Exception
    {
        File file1 = new File(fileName1+".txt");
        File file2 = new File(fileName2+".txt");
        String line1="";
        String line2="";
        Vector<String> tab1=new Vector<String>();
        Vector<String> tab2=new Vector<String>();
        BufferedReader br1 = new BufferedReader(new FileReader(file1));
        BufferedReader br2 = new BufferedReader(new FileReader(file2));
        while((line1=br1.readLine())!=null)
        {
            tab1.add(line1);
        }
        while((line2=br2.readLine())!=null)
        {
            tab2.add(line2);
        }
        Vector<String> result=new Vector<String>();
        result.add(tab1.get(0)+tab2.get(0));
        for(int i=1;i<tab1.size();i++)
        {
            for(int j=1;j<tab2.size();j++)
            {
                result.add(tab1.get(i)+tab2.get(j));
            }
        }
        for(int k=0;k<result.size();k++)
        {
            System.out.println(result.get(k));
        }
        // vectorStoFile("ProduitCarthesien_"+fileName1+"_"+fileName2,result);
    }

    public Vector<String> doublColumn(String[][] tab,int icolumn,int[] line)
    {
        Vector<String> res=new Vector<String>();
        int test=0;
        for(int i=1;i<tab.length;i++)
        {
            for(int l=0;l<line.length;l++)
            {
                if(i==line[l])
                {
                    for(int j=0;j<tab[i].length;j++)
                    {
                            if(j!=icolumn&&checkDoublon(res,tab[i][j])==false)
                            {
                                if(test==0)
                                {
                                    res.add(tab[0][j]);
                                    test++;
                                }
                                res.add(tab[i][j]);
                            }
                    }
                }
            }
        }
        return res;
    }

    public void division(String file1,String file2)throws Exception
    {
        File e1=new File(file1+".txt");
        File e2=new File(file2+".txt");
        String line1="";
        String line2="";
        Vector<String> tab1=new Vector<String>();
        Vector<String> tab2=new Vector<String>();
        BufferedReader br1 = new BufferedReader(new FileReader(e1));
        BufferedReader br2 = new BufferedReader(new FileReader(e2));
        while((line1=br1.readLine())!=null)
        {
            tab1.add(line1);
        }
        while((line2=br2.readLine())!=null)
        {
            tab2.add(line2);
        }
        int columnNB=idCol(tab1.get(0),tab2.get(0));
        String[][] tab_1=new String[tab1.size()][tab1.get(0).split("    ").length];
        String[][] tab_2=new String[tab2.size()][tab2.get(0).split("    ").length];
        for(int i=0;i<tab1.size();i++)
        {
            tab_1[i]=tab1.get(i).split("    ");
        }
        for(int j=0;j<tab2.size();j++)
        {
            tab_2[j]=tab2.get(j).split("    ");
        }
        int[] idDiv=vectorToI(lineDivision(tab_1,tab_2,columnNB));
        Vector<String> temp_res=doublColumn(tab_1,columnNB,idDiv);
        int temp=0;
        System.out.println(temp_res.get(0));
        for(int m=0;m<temp_res.size();m++)
        {
            temp=0;
            for(int k=0;k<tab_1.length;k++)
            {
                for(int iline=0;iline<idDiv.length;iline++)
                {
                    if(k==idDiv[iline])
                    {
                        for(int l=0;l<tab_1[k].length;l++)
                        {
                                if(l!=columnNB)
                                {
                                    if(temp_res.get(m).toLowerCase().equals(tab_1[k][l].toLowerCase()))
                                    temp++;
                                }
                        }
                    }
                }
            }
            if(temp==tab_2.length-1)
            {
                System.out.println(temp_res.get(m));
            }
        }
    }

    public void insert(String name,String values)throws Exception
    {
        File e = new File(name+".txt");
        FileWriter file=new FileWriter(e,true);
        BufferedReader br = new BufferedReader(new FileReader(e));
        String line=br.readLine();
        String[] compare=line.split("    ");
        String[] res=values.split(",");
        if(res.length>compare.length)
        {
            throw new Exception("Trop de parametre a inserer");
        }
        else if(res.length<compare.length)
        {
            throw new Exception("Manque de parametre a inserer");
        }
        for(int i=0;i<res.length;i++)
        {
            file.write(res[i]+"    ");
        }
        file.write("\n");
        file.close();
    }

    public void desc(String name)throws Exception
    {
        File file = new File(name+".txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
            System.out.println(br.readLine());
            br.close();
    }

    public Vector<String> selectAll(String name)throws Exception
    {
        Vector<String> result=new Vector<String>();
        File file = new File(name+".txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine())!=null)
            {
                result.add(line);
            }
            br.close();
        return result;
    }

    public static String[] vectorToS(Vector<String> str)
    {
        String[] ret = new String[str.size()];
        for(int i=0; i<ret.length;i++){
            ret[i] = str.get(i);
        }
        return ret;
    }

    public static int[] vectorToI(Vector<Integer> integ)
    {
        int[] ret = new int[integ.size()];
        for(int i=0; i<ret.length;i++){
            ret[i] = integ.get(i);
        }
        return ret;
    }

    public Vector<Integer> getLine( String fileName , String toBeSearched, String column ) throws Exception
    {
        Vector<Integer> result = new Vector<Integer>();
        Vector<String> base = selectAll(fileName) ;
        int iDel=seachIndicesColomn(fileName,column);
        for(int i = 0 ; i < base.size() ; i++)
        {
            String[] temp = base.get(i).toUpperCase().split("    ") ;
            for(int j = 0 ; j < temp.length ; j++)
            {
                if(j==iDel)
                {
                    if( temp[j].equals(toBeSearched.toUpperCase()) )
                    {
                        result.add(i) ;
                    }
                }
            }
        }
        return result;
    }

    public void delete(String fileName, String delete,String colonnes)throws Exception
    {
        BufferedReader flex=new BufferedReader(new InputStreamReader(new FileInputStream(fileName+".txt")));
        StringBuffer vaovao=new StringBuffer();
        String line;
        int[] line_number=vectorToI(getLine(fileName,delete,colonnes));
        if(line_number[0]==0)
        {
            return;
        }
        int count=0;
        int itab=0;
        while((line=flex.readLine())!=null)
        {
            if(count!=line_number[itab])
            {
                vaovao.append(line+"\n");
            }
            else
            {
                if(itab<line_number.length-1)
                {
                    itab++;
                }
            }
            count++;
        }
        flex.close();
        BufferedWriter hafa=new BufferedWriter(new FileWriter(fileName+".txt"));
        hafa.write(vaovao.toString());
        hafa.close();
    }

    public void deleteTab(String name)throws Exception
    {
        File file = new File(name+".txt");
        if(file.exists())
        {
            file.delete();
        }
        else
        {
            throw new Exception("Ce tableau n'existe pas");
        }
    }

    public int[] seachIndicesColomns(String name,String colum) throws Exception
    {
        String[] temp;
        String[] column=colum.split(",");
        int[] result = new int[column.length];
        File file = new File(name+".txt");
        int index=0;
        BufferedReader br = new BufferedReader(new FileReader(file));
            String line=br.readLine();
            temp=line.split("    ");
            for (int i = 0; i < temp.length; i++) 
            {
                for(int j=0;j<column.length;j++)
                {
                    if(temp[i].equals(column[j].toUpperCase()))
                    {
                        result[index]=i;
                        index++;
                    }
                }
            }
            if(result[result.length-1]==0)
            new Exception("check your column name");
            br.close();
        return result;
    }

    public int seachIndicesColomn(String name,String column) throws Exception
    {
        String[] temp;
        int result=-1;
        File file = new File(name+".txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
            String line=br.readLine();
            temp=line.split("    ");
            for (int i = 0; i < temp.length; i++) 
            {
                if(temp[i].equals(column.toUpperCase()))
                {
                    result=i;
                }
            }
            if(result<0)
            {
                new Exception("check your column name");
            }
            br.close();
        return result;
    }

    public void update(String fileName, String alterColumn,String alter,String conditionColumn,String condition)throws Exception
    {
        BufferedReader flex=new BufferedReader(new InputStreamReader(new FileInputStream(fileName+".txt")));
        StringBuffer vaovao=new StringBuffer();
        String line;
        int[] line_number=vectorToI(getLine(fileName,condition,conditionColumn));
        if(line_number[0]==0)
        {
            return;
        }
        int count=0;
        int itab=0;
        String[] alt=alter.split(",");
        String[] altColumn=alterColumn.split(",");
        if(alt.length!=altColumn.length)
        {
            new Exception("Il y a une erreur au niveau de la mise a jour");
            return;
        }
        int[] indexAlterColumn=seachIndicesColomns(fileName,alterColumn);
        while((line=flex.readLine())!=null)
        {
            if(count!=line_number[itab])
            {
                vaovao.append(line+"\n");
            }
            else
            {
                String[] tempLine=line.split("    ");
                for(int i=0;i<indexAlterColumn.length;i++)
                {
                    tempLine[indexAlterColumn[i]]=alt[i];
                }
                String tempRes="";
                for(int j=0;j<tempLine.length;j++)
                {
                    tempRes=tempRes+tempLine[j]+"    ";
                }
                vaovao.append(tempRes+"\n");
                if(itab<line_number.length-1)
                {
                    itab++;
                }
            }
            count++;
        }
        flex.close();
        BufferedWriter hafa=new BufferedWriter(new FileWriter(fileName+".txt"));
        hafa.write(vaovao.toString());
        hafa.close();
    }

    public boolean compareAttribute(String fileName1,String fileName2)throws Exception
    {
        File file1 = new File(fileName1+".txt");
        File file2 = new File(fileName2+".txt");
        String line1="";
        String line2="";
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            line1=br1.readLine();
            br1.close();
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            line2=br2.readLine();
            br2.close();
        if(line1.equals(line2))
        {
            return true;
        }
        return false;
    }

    public boolean checkDoublon(Vector<String> tab,String arg)
    {
        for(int i=0;i<tab.size();i++)
        {
            if(tab.get(i).toLowerCase().equals(arg.toLowerCase()))
            {
                return true;
            }
        }
        return false;
    }

    public void vectorStoFile(String fileName,Vector<String> tab)throws Exception
    {
        BufferedWriter result=new BufferedWriter(new FileWriter(fileName+".txt"));
        StringBuffer news=new StringBuffer();
        for(int i=0;i<tab.size();i++)
        {
            news.append(tab.get(i)+"\n");
        }
        result.write(news.toString());
        result.close();
    }

    public void union(String fileName1,String fileName2)throws Exception
    {
        //  union tab1 tab2
        if(compareAttribute(fileName1,fileName2)==false)
        {
            return;
        }  
        File file1 = new File(fileName1+".txt");
        File file2 = new File(fileName2+".txt");
        String line1="";
        String line2="";
        Vector<String> tab1=new Vector<String>();
        Vector<String> tab2=new Vector<String>();
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            while((line1=br1.readLine())!=null)
            {
                tab1.add(line1);
            }
            while((line2=br2.readLine())!=null)
            {
                tab2.add(line2);
            }
            String[] rtab1=vectorToS(tab1);
            String[] rtab2=vectorToS(tab2);
            Vector<String> result=new Vector<String>();
            for(int i=0;i<rtab1.length;i++)
            {
                result.add(rtab1[i]);
            }
            for(int j=0;j<rtab2.length;j++)
            {
                if(checkDoublon(result,rtab2[j])==false)
                {
                    result.add(rtab2[j]);
                }
            }
            for(int x=0;x<result.size();x++)
            {
                System.out.println(result.get(x));
            }
            // vectorStoFile("UNION_"+fileName1+"_"+fileName2,result);
            br1.close();
            br2.close();     
    }

    public void difference(String fileName1,String fileName2)throws Exception
    {
        if(compareAttribute(fileName1,fileName2)==false)
        {
            return;
        } 
        File file1 = new File(fileName1+".txt");
        File file2 = new File(fileName2+".txt");
        String line1="";
        String line2="";
        Vector<String> tab1=new Vector<String>();
        Vector<String> tab2=new Vector<String>();
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            while((line1=br1.readLine())!=null)
            {
                tab1.add(line1);
            }
            while((line2=br2.readLine())!=null)
            {
                tab2.add(line2);
            }
            Vector<String> result=new Vector<String>();
            result.add(tab1.get(0));
            for(int i=1;i<tab1.size();i++)
            {
                if(checkDoublon(tab2,tab1.get(i))==false)
                {
                    result.add(tab1.get(i));
                }
            }
            for(int j=0;j<result.size();j++)
            {
                System.out.println(result.get(j));
            }
            // vectorStoFile("DIFFERENCE_"+fileName1+"_"+fileName2,result);
    }

    public void intersection(String fileName1,String fileName2)throws Exception
    {
        if(compareAttribute(fileName1,fileName2)==false)
        {
            return;
        } 
        File file1 = new File(fileName1+".txt");
        File file2 = new File(fileName2+".txt");
        String line1="";
        String line2="";
        Vector<String> tab1=new Vector<String>();
        Vector<String> tab2=new Vector<String>();
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            while((line1=br1.readLine())!=null)
            {
                tab1.add(line1);
            }
            while((line2=br2.readLine())!=null)
            {
                tab2.add(line2);
            }
            Vector<String> result=new Vector<String>();
            result.add(tab1.get(0));
            for(int i=1;i<tab1.size();i++)
            {
                if(checkDoublon(tab2,tab1.get(i))==true)
                {
                    result.add(tab1.get(i));
                }
            }
            for(int j=0;j<result.size();j++)
            {
                System.out.println(result.get(j));
            }
            // vectorStoFile("INTERSECTION_"+fileName1+"_"+fileName2,result);
    }

    public Vector<String> columnSelected(String fileName,int numColumn)throws Exception
    {
        File file = new File(fileName+".txt");
        Vector<String> result=new Vector<String>();
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line="";
            while((line=br.readLine())!=null)
            {
                String[] temp=line.split("    ");
                result.add(temp[numColumn]);
            }
        return result;
    }

    public Vector<String> juncture(String fileName,String column)throws Exception
    {
        String[] tabName=fileName.toLowerCase().split(",");
        String[] condition=column.split("=");
        File file1 = new File(tabName[0]+".txt");
        File file2 = new File(tabName[1]+".txt");
        String line1="";
        String line2="";
        Vector<String> tab1=new Vector<String>();
        Vector<String> tab2=new Vector<String>();
        Vector<String> result=new Vector<String>();
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            while((line1=br1.readLine())!=null)
            {
                tab1.add(line1);
            }
            while((line2=br2.readLine())!=null)
            {
                tab2.add(line2);
            }
            result.add(tab1.get(0)+tab2.get(0));
            int itab1=seachIndicesColomn(tabName[0],condition[0]);
            int itab2=seachIndicesColomn(tabName[1],condition[1]);
            Vector<String> temp1=columnSelected(tabName[0],itab1);
            Vector<String> temp2=columnSelected(tabName[1],itab2);
            for(int i=1;i<temp1.size();i++)
            {
                for(int j=1;j<temp2.size();j++)
                {
                    if(temp1.get(i).toLowerCase().equals(temp2.get(j).toLowerCase()))
                    {
                        temp2.set(j,"    ");
                        result.add(tab1.get(i)+tab2.get(j));
                    }
                }
            }
            // for(int j=0;j<result.size();j++)
            // {
            //     System.out.println(result.get(j));
            // }
            // vectorStoFile("JUNCTURE"+tabName[0]+"_"+tabName[1],result);
        return result;
    }

    public void checkParenthese(String ty)throws Exception
    {
        String[] res=ty.split("");
        int misokatra=0;
        int mihidy=0;
        for(int i=0;i<res.length;i++)
        {
            if(res[i].equals("("))
            {
                misokatra++;
            }
            else if(res[i].equals(")"))
            {
                mihidy++;
            }
        }
        if(mihidy!=misokatra)
        {
            throw new Exception("verifier votre syntaxe");
        }
    }

    public void sql(String request)throws Exception
    {
        checkParenthese(request);
        String[] rq=request.toUpperCase().split(" ");
            if(rq[0].equals("CREATE"))
            {
                create_tab(rq[1].toLowerCase(),rq[3]);
            }
            else if(rq[0].equals("INSERT"))
            {
                insert(rq[1].toLowerCase(),rq[3].toLowerCase());
            }
            else if(rq[0].equals("DESC"))
            {
                desc(rq[1].toLowerCase());
            }
            else if(rq[0].equals("SELECT"))
            {
                if(rq[1].equals("*"))
                {
                    Vector<String> temp=selectAll(rq[2].toLowerCase());
                    String[] print=vectorToS(temp);
                    if(rq.length==3)
                    {
                        for(int i=0;i<print.length;i++)
                        {
                            System.out.println(print[i]);
                        }
                    }
                    else if(rq[3].equals("WHERE")&&rq.length==5)
                    {
                        String[] equa=rq[4].split("=");
                        int[] iprint=vectorToI(getLine(rq[2].toLowerCase(),equa[1].toLowerCase(),equa[0]));
                        System.out.println(print[0]);
                        for(int i=0;i<iprint.length;i++)
                        {
                            System.out.println(print[iprint[i]]);
                        }
                    }
                        //  select nom tab join tab2 id=id2
                    else if(rq[3].equals("JOIN")&&rq.length==6)
                    {
                        String tab=rq[2].toLowerCase()+","+rq[4].toLowerCase();
                        temp=juncture(tab,rq[5].toLowerCase());
                        print=vectorToS(temp);
                        for(int i=0;i<print.length;i++)
                        {
                            System.out.println(print[i]);
                        }
                    }
                }
                else
                {
                    String[] all=vectorToS(selectAll(rq[2].toLowerCase()));
                    String[] temp=all[0].split("    ");
                    int[] itab=seachIndicesColomns(rq[2].toLowerCase(),rq[1]);
                    if(rq.length==3)
                    {
                        for(int i=0;i<all.length;i++)
                        {
                            for(int j=0;j<temp.length;j++)
                            {
                                temp=all[i].split("    ");
                                for(int k=0;k<itab.length;k++)
                                {
                                    if(j==itab[k])
                                    {
                                        System.out.print(temp[j]+"    ");
                                    }
                                }
                            }
                            System.out.println(" ");
                        }
                    }
                    else if(rq[3].equals("WHERE")&&rq.length==5)
                    {
                        String[] equa=rq[4].split("=");
                        int[] iprint=vectorToI(getLine(rq[2].toLowerCase(),equa[1].toLowerCase(),equa[0]));
                        for(int j=0;j<temp.length;j++)
                        {
                            temp=all[0].split("    ");
                            for(int k=0;k<itab.length;k++)
                            {
                                if(j==itab[k])
                                {
                                    System.out.print(temp[j]+"    ");
                                }
                            }
                        }
                        System.out.println(" ");
                        for(int i=0;i<iprint.length;i++)
                        {
                            for(int j=0;j<temp.length;j++)
                            {
                                temp=all[iprint[i]].split("    ");
                                for(int k=0;k<itab.length;k++)
                                {
                                    if(j==itab[k])
                                    {
                                        System.out.print(temp[j]+"    ");
                                    }
                                }
                            }
                            System.out.println(" ");
                        }
                    }
                    // select nom chien join chat id=id2
                    else if(rq[3].equals("JOIN")&&rq.length==6)
                    {
                        String tab=rq[2].toLowerCase()+","+rq[4].toLowerCase();
                        all=vectorToS(juncture(tab,rq[5].toLowerCase()));
                        temp=all[0].split("    ");
                        itab=seachIndicesColomns(rq[2].toLowerCase(),rq[1]);
                        for(int i=0;i<all.length;i++)
                        {
                            for(int j=0;j<temp.length;j++)
                            {
                                temp=all[i].split("    ");
                                for(int k=0;k<itab.length;k++)
                                {
                                    if(j==itab[k])
                                    {
                                        System.out.print(temp[j]+"    ");
                                    }
                                }
                            }
                            System.out.println(" ");
                        }
                    }
                }
            }
            else if(rq[0].equals("DELETE"))
            {
                if(rq[1].equals("TAB")==false)
                {
                    String[] del=rq[2].split("=");
                    delete(rq[1].toLowerCase(),del[1],del[0]);
                }
                else
                {
                    deleteTab(rq[2].toLowerCase());
                }
            }
            else if(rq[0].equals("UPDATE"))
            {
                //  update chien nom,age wolf,9 where race=doberman
                //  0         1     2        3    4        5
                String[] condition=rq[5].split("=");
                update(rq[1].toLowerCase(),rq[2],rq[3].toLowerCase(),condition[0],condition[1]);
            }
            else if(rq[0].equals("UNION"))
            {
                //  union tab1 tab2
                union(rq[1].toLowerCase(),rq[2].toLowerCase());
            }
            else if(rq[0].equals("DIFFERENCE"))
            {
                difference(rq[1].toLowerCase(),rq[2].toLowerCase());
            }
            else if(rq[0].equals("INTERSECTION"))
            {
                intersection(rq[1].toLowerCase(),rq[2].toLowerCase());
            }
            else if(rq[0].equals("DIVISION"))
            {
                division(rq[1].toLowerCase(),rq[2].toLowerCase());
            }
            else if(rq[0].equals("PRODUIT"))
            {
                produitCarthesien(rq[1].toLowerCase(),rq[2].toLowerCase());
            }
            else
            {
                throw new Exception("verifier la syntaxe");
            }
            for(int i=0;i<colonne.size();i++)
            {
                System.out.println(colonne.get(i));
            }
            for(int j=0;j<donne.size();j++)
            {
                System.out.println(donne.get(j));
            }
    }
}