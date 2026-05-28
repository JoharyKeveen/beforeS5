package object;
import connection.*;
import java.util.*;

public class Matche extends BddClass
{
    String idmatche;
    String teama;
    int scora;
    String teamb;
    int scorb;
	long daty;
	

	public long getDaty() {
		return daty;
	}

	public void setDaty(long daty) {
		this.daty = daty;
	}

	public String getIdmatche() {
		return idmatche;
	}

	public void setIdmatche(String idmatche) {
		this.idmatche = idmatche;
	}

	public String getTeama() {
		return teama;
	}

	public void setTeama(String teama) {
		this.teama = teama;
	}

	public int getScora() {
		return scora;
	}

	public void setScora(int scora) {
		this.scora = scora;
	}

	public String getTeamb() {
		return teamb;
	}

	public void setTeamb(String teamb) {
		this.teamb = teamb;
	}

	public int getScorb() {
		return scorb;
	}

	public void setScorb(int scorb) {
		this.scorb = scorb;
	}

	public Matche()
	{}
	public Matche(String idmatche,String teama,String teamb)
	{
		setIdmatche(idmatche);
        setTeama(teama);
        setTeamb(teamb);
        setScora(0);
        setScorb(0);
	}
	public Matche(String idmatche,String teama,String teamb,long daty)
	{
		setIdmatche(idmatche);
        setTeama(teama);
        setTeamb(teamb);
        setScora(0);
        setScorb(0);
		setDaty(daty);
	}
	public Matche(String teama,String teamb,long daty)throws Exception
	{
		super.setPrefix("MTC");
		super.setSeqName("seq_matche");
		setIdmatche(super.construirePK(get_sequence()));
        setTeama(teama);
        setTeamb(teamb);
        setScora(0);
        setScorb(0);
		setDaty(daty);
	}

	public Vector<Matche> get_Tab(Vector<Object> o)
	{
		Vector<Matche> result=new Vector<Matche>();
		for(int i=0;i<o.size();i++)
		{
			result.add((Matche)o.get(i));
		}
		return result;
	}
}