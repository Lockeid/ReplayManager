/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sc2_replaymanager;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Arthur
 */
public class ReplayLocation {

    public static ArrayList main () {
        String home = System.getProperty("user.home");
        String docs = home + "\\Documents\\Starcraft II\\Accounts";
        File dir = new File(docs);
        System.out.println();
        System.out.println("Simple file listing...");
        System.out.println("----------------------");


        String[] children = dir.list();

        ArrayList folders = printFiles(children, docs);
        return folders;

    }

    public static ArrayList printFiles(String[] children, String dirName) {
        ArrayList path_list = new ArrayList();
        if (children == null) {
            System.out.println("Error with " + dirName);
            System.out.println("Either directory does not exist or is not a directory");
            return null;
        } else {
            for (int i=0; i<children.length; i++) {
                // Get filename of file or directory
                String filename = children[i];
                File dir = new File(dirName + File.separator + filename);
                if (dir.isDirectory()) {
                    String[] folders = dir.list();
                    for(int j=0; j<folders.length; j++) {
                        String filename2 = folders[j];
                        File fullrep = new File(dir.getPath() + File.separator + filename2);
                        System.out.println("Fullrep : " + fullrep.getPath());
                        if(fullrep.isDirectory()) {
                            // Last Step
                            String fullpath = fullrep +  File.separator + "Replays" + File.separator + "Multiplayer" + File.separator;
                            boolean success = path_list.add(fullpath);
                            if (success != false) {
                                System.out.println("Success : " + fullpath);
                            }
                        }
                    }
                    //System.out.print("[D] : ");
                }
                else {
                    return null;
                }                
            }
        }
        System.out.println(path_list);
        return path_list;
    }

}
