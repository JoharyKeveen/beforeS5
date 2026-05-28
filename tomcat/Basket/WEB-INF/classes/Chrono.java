package object;
import connection.*;
import java.util.*;

public class Chrono extends BddClass
{
    String idchrono;
    String idmatche;
    String idsend;
    String idreceive;
    int fotoana;
    public Chrono()
    {}
    public Chrono(String idmatche)
    {
        setIdmatche(idmatche);
    }
    public Chrono(String idmatche, String idsend, String idreceive, int fotoana)throws Exception
    {
		super.setPrefix("CHR");
		super.setSeqName("seq_chrono");
		setIdchrono(super.construirePK(get_sequence()));
        setIdmatche(idmatche);
        setIdsend(idsend);
        setIdreceive(idreceive);
        setFotoana(fotoana);
    }
    public String getIdchrono() {
        return idchrono;
    }
    public void setIdchrono(String idchrono) {
        this.idchrono = idchrono;
    }
    public String getIdmatche() {
        return idmatche;
    }
    public void setIdmatche(String idmatche) {
        this.idmatche = idmatche;
    }
    public String getIdsend() {
        return idsend;
    }
    public void setIdsend(String idsend) {
        this.idsend = idsend;
    }
    public String getIdreceive() {
        return idreceive;
    }
    public void setIdreceive(String idreceive) {
        this.idreceive = idreceive;
    }
    public int getFotoana() {
        return fotoana;
    }
    public void setFotoana(int fotoana) {
        this.fotoana = fotoana;
    }
	public Vector<Chrono> get_Tab(Vector<Object> o)
	{
		Vector<Chrono> result=new Vector<Chrono>();
		for(int i=0;i<o.size();i++)
		{
			result.add((Chrono)o.get(i));
		}
		return result;
	}
}