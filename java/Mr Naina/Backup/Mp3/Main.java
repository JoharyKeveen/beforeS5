package print;
import java.sql.*;
import java.util.*;
import traitement.*;
public class Main
{
	public static void main(String[] args) throws Exception
	{
		TraitementMp3 test=new TraitementMp3();
		// test.retrieveMetaData("C:/Users/Achyl/Desktop/Mp3/audio/1 Young.mp3");
		// test.reset("C:/Users/Achyl/Desktop/Mp3/audio");
		test.reset_latest_update("C:/Users/Achyl/Desktop/Mp3/audio");
	}
}