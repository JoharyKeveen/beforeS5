package object;
import connection.*;
import java.util.*;

public class Team extends BddClass
{
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

    public Team()
    {}
    public Team(String idTeam,String name)
    {
        setIdteam(idTeam);
        setName(name);
    }
	public Team(String name)throws Exception
	{
		super.setPrefix("TEA");
		super.setSeqName("seq_team");
		setIdteam(super.construirePK(get_sequence()));
		setName(name);
	}

	public Vector<Team> get_Tab(Vector<Object> o)
	{
		Vector<Team> result=new Vector<Team>();
		for(int i=0;i<o.size();i++)
		{
			result.add((Team)o.get(i));
		}
		return result;
	}
}