package object;
import connection.*;
import java.util.*;

public class Player extends BddClass
{
    String idplayer;
    String idteam;
    String name;

    public String getIdteam()
    {
        return this.idteam;
    }
    public void setIdteam(String idteam)
    {
        this.idteam=idteam;
    }
    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public String getIdplayer()
    {
        return this.idplayer;
    }
    public void setIdplayer(String idplayer)
    {
        this.idplayer=idplayer;
    }

    public Player()
    {}
	public Player(String idteam,String name)throws Exception
	{
		super.setPrefix("PLR");
		super.setSeqName("seq_player");
		setIdplayer(super.construirePK(get_sequence()));
        setIdteam(idteam);
		setName(name);
	}

	public Vector<Player> get_Tab(Vector<Object> o)
	{
		Vector<Player> result=new Vector<Player>();
		for(int i=0;i<o.size();i++)
		{
			result.add((Player)o.get(i));
		}
		return result;
	}
}