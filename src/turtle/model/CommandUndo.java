package turtle.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

import turtle.ihm.Grid;
import turtle.ihm.PatternPanel;

public final class CommandUndo {
	
	private final static String path = Turtle.chemin;
    private final static File file = new File(path); 
    private static int nbSaveLines=0;
	private static BufferedReader b;
	
    /**
     * write the command in the save file
     * @param txt the command
     */
	public static void writeSave(String txt){
		try {
            final FileWriter writer = new FileWriter(file,true);
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
	
	/**
	 * delete the last line of a file
	 * @param fileName name of the file
	 * @param lineNumber number of lines in the file
	 * @return true if the line is deleted
	 */
	public static void deleteLine(String fileName, int lineNumber) {
		Vector<String> monVector = new Vector<>(); 
        File f = new File(fileName); 
        try {
        	b = new BufferedReader(new FileReader(f)); 
            String line = b.readLine(); 
            while (line != null){ 
                monVector.addElement(line); 
                line = b.readLine(); 
            } 
            monVector.removeElementAt(lineNumber); 
            PrintWriter P = new PrintWriter (new FileWriter(f)); 
            for (int i = 0; i < monVector.size(); i++){ 
                P.println(monVector.get(i)); 
            } 
            P.close(); 
        }catch (Exception e) {
        	System.out.println(e);
        }

    }
	
	/**
	 * used to return the last line of the file "fileName"
	 * @param fileName name of the file
	 * @return the last line of the file "fileName"
	 */
	public static String lastLine(){
		String line = null;
		try {
			Scanner scanner = new Scanner(CommandUndo.file);
		    while (scanner.hasNextLine()) {
		        line = scanner.nextLine();
		    }
		    scanner.close();
		}catch (Exception e) {
			System.out.println(e);
		}
		return line;
	}
	
	public static void use(Turtle t, Grid g, PatternPanel p){
		switch (CommandUndo.lastLine()) {
			case "go()":
				CommandGo.undo(t);
				g.repaint();
				break;
			case "turn()":
				CommandTurn.undo(t);
				p.repaint();
				break;
			case "color()":
				break;
			case "draw()":
				CommandDraw.use(t);
				break;
			default:
				break;
		}
		CommandUndo.deleteLine(CommandUndo.path,CommandUndo.nbSaveLines);
		CommandUndo.nbSaveLines--;
	}
}
