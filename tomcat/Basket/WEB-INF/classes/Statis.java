package object;
import connection.*;
import java.util.*;

public class Statis extends BddClass
{    
    String idplayer;
    String idmatche;
    String action;
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    int nb;

	public String getIdplayer() {
        return idplayer;
    }

    public void setIdplayer(String idplayer) {
        this.idplayer = idplayer;
    }

    public String getIdmatche() {
        return idmatche;
    }

    public void setIdmatche(String idmatche) {
        this.idmatche = idmatche;
    }


    public int getNb() {
        return nb;
    }

    public void setNb(int nb) {
        this.nb = nb;
    }

    public Statis()
    {}
    public Statis(String idplayer,String idmatche,String action,int nb)
    {
        setIdplayer(idplayer);
        setIdmatche(idmatche);
        setAction(action);
        setNb(nb);
    }
    public Statis(String idplayer,String idmatche,String action)
    {
        setIdplayer(idplayer);
        setIdmatche(idmatche);
        setAction(action);
    }

    public Vector<Statis> get_Tab(Vector<Object> o)
	{
		Vector<Statis> result=new Vector<Statis>();
		for(int i=0;i<o.size();i++)
		{
			result.add((Statis)o.get(i));
		}
		return result;
	}
}
