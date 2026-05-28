package object;
import connection.*;
import java.util.*;

public class RebondO extends BddClass
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

    public RebondO()
    {}
    public RebondO(String idplayer,String idmatche,String action,int nb)
    {
        setIdplayer(idplayer);
        setIdmatche(idmatche);
        setAction(action);
        setNb(nb);
    }
    public RebondO(String idplayer,String idmatche,String action)
    {
        setIdplayer(idplayer);
        setIdmatche(idmatche);
        setAction(action);
    }

    public Vector<RebondO> get_Tab(Vector<Object> o)
	{
		Vector<RebondO> result=new Vector<RebondO>();
		for(int i=0;i<o.size();i++)
		{
			result.add((RebondO)o.get(i));
		}
		return result;
	}
}
