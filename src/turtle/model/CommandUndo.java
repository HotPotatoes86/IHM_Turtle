package turtle.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public final class CommandUndo {
	
	private final static String chemin = Turtle.chemin;
    private final static File fichier = new File(chemin); 
    private static int nbSaveLines=0;
	
	public static void writeSave(String txt){
		try {
            final FileWriter writer = new FileWriter(fichier,true);
            try {
            	CommandUndo.nbSaveLines++;
                writer.write(txt+"\n");
            } finally {
                writer.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
	}
	
	public static boolean deleteLine(String fileName, int lineNumber) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            StringBuffer sb = new StringBuffer(); 
            String line;    
            int nbLinesRead = 0;       
            while ((line = reader.readLine()) != null) {
                if (nbLinesRead != lineNumber) {
                    sb.append(line + "\n");
                }
                nbLinesRead++;
            }
            reader.close();
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
            out.write(sb.toString());
            out.close();
 
        } catch (Exception e) {
            return false;
        }
        return true;
    }
	
	public static void use(){
		CommandUndo.deleteLine("sauvegarde.txt",CommandUndo.nbSaveLines-1);
		CommandUndo.nbSaveLines--;
	}
}
