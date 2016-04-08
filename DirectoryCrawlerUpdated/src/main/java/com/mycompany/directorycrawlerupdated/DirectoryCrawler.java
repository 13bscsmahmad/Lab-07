package com.mycompany.directorycrawlerupdated;

/**
 * Created by MMA on 4/8/2016.
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class DirectoryCrawler {

    static int depth = -1;
    static HashMap index = new HashMap();
    static HashMap<String, String> txtContentsIndex = new HashMap<String, String>();

    static List<FolderFile> updatedIndex = new ArrayList<FolderFile>();
    static HashMap<String, String> regexMatches = new HashMap<String, String>(); //

    static void Crawler(File file, String path) {


        depth++;


        if (file.isFile()) {

            FolderFile fileStruct = new FolderFile();

            //System.out.println(path+"\\"+file.getName());
            index.put(file.getName(), path + "\\" + file.getName());
            fileStruct.name = file.getName();
            fileStruct.path = path + "\\" + file.getName();
            // get attributes and store
            try {
                fileStruct.attributes = Files.readAttributes(Paths.get(file.getAbsolutePath()), BasicFileAttributes.class);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // store the fileStruct into the updatedIndex list

            updatedIndex.add(fileStruct);

            //


            //writeContentsToFile("FileIndex.txt", file.getName() + "--> " + path + "\\" + file.getName() + "\n"); // write Index
            writeContentsToFile("UpdatedFileIndex.txt", "" +

                            "##############################################################" +
                            file.getName() + "\n" +
                            "Path: " + path + "\\" + file.getName() + "\n" +
                            "Size: " + fileStruct.attributes.size() + "\n" +
                            "Created time: " + fileStruct.attributes.creationTime() + "\n" +
                            "Last modified time: " + fileStruct.attributes.lastModifiedTime() + "\n" +
                            "##############################################################"
//                            "Posix File Permissions:-" + "\n\n" +
//                            Files.getPosixFilePermissions(Paths.get(file.getAbsolutePath()), LinkOption.NOFOLLOW_LINKS)

            );

            // if .txt, index the content as well
            if (file.getName().contains(".txt")) {

                System.out.println("Found txt: " + file.getName());
                String fileContents = "";

                try {
                    fileContents = readFile(path + "\\" + file.getName());
                } catch (Exception e) {
                }

                txtContentsIndex.put(path + "\\" + file.getName(), fileContents);

                // Store indexed files and content into a persistent storage (e.g) output file
                writeContentsToFile("ContentIndex.txt", path + "\\" + file.getName() + "\n" + fileContents + "\n"); // write Index

            }

        } else if (file.isDirectory()) {
            String rootPath;
            FolderFile folderStruct = new FolderFile();

            if (depth == 0) {
                rootPath = path;
            } else {
                rootPath = path + "\\" + file.getName();
                index.put(file.getName(), path + "\\" + file.getName());


                folderStruct.name = file.getName();
                folderStruct.path = path + "\\" + file.getName();
                // get attributes and store
                try {
                    folderStruct.attributes = Files.readAttributes(Paths.get(file.getAbsolutePath()), BasicFileAttributes.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                updatedIndex.add(folderStruct);

                writeContentsToFile("UpdatedFileIndex.txt", "" +

                                "##############################################################" +
                                file.getName() + "\n" +
                                "Path: " + path + "\\" + file.getName() + "\n" +
                                "Size: " + folderStruct.attributes.size() + "\n" +
                                "Number of sub-items: " + new File(folderStruct.path).listFiles().length + "\n" +
                                "Created time: " + folderStruct.attributes.creationTime() + "\n" +
                                "Last modified time: " + folderStruct.attributes.lastModifiedTime() + "\n" +
                                "##############################################################"
//                            "Posix File Permissions:-" + "\n\n" +
//                            Files.getPosixFilePermissions(Paths.get(file.getAbsolutePath()), LinkOption.NOFOLLOW_LINKS)

                );


            }
            File[] listOfFiles = file.listFiles();
            if (listOfFiles != null) {
                for (int i = 0; i < listOfFiles.length; i++) {
                    Crawler(listOfFiles[i], rootPath);
                }
            }
        }
        depth--;
    }

    static void writeContentsToFile(String filePathWithExtension, String stringToWrite) {

        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filePathWithExtension, true)))) {
            out.println(stringToWrite);
        } catch (IOException e) {

        }

    }

    static String readFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }

    static Vector<String> SearchFile(String keyword) {
        Set set = index.entrySet();
        Iterator i = set.iterator();
        Vector searchResults = new Vector();
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            String key = (String) me.getKey();
            if (key.indexOf(keyword) != -1) {
                searchResults.add(me.getValue());
            }
        }
        return searchResults;
    }

    static List<String> SearchContent(String keyword) {

        List<String> regexMatches = new ArrayList<String>();

        // Create a Pattern object

        Pattern r = null;
        try {
            r = Pattern.compile(".*"+keyword+".*");
        } catch (PatternSyntaxException e){
            e.printStackTrace();
        }

        // Now create matcher object.

        // iterate through all file names, contents, paths, and attributes

        // 1. Through file names, paths and attributes from List<FolderFile> updatedIndex

        for (int i = 0; i < updatedIndex.size(); i++) {
            //Matcher m = r.matcher(updatedIndex.get(i).name);
            Matcher pathMatcher = r.matcher(updatedIndex.get(i).path); // path also contains the file name, so that covers searching file names too
            if (pathMatcher.find()){
                regexMatches.add(updatedIndex.get(i).path);
            }
        }

        // 2. Through .txt contents


        Set set = txtContentsIndex.entrySet();
        Iterator i = set.iterator();

        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            String key = (String) me.getKey();
            String value = (String) me.getValue();
            //System.out.println(value);

            Matcher contentMatcher = r.matcher(value);
            if (contentMatcher.find()){
                regexMatches.add(key);
            }

        }
        return regexMatches;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String rootPath = "C:\\Users\\MMA\\Desktop";
        File file = new File(rootPath);
        Crawler(file, rootPath);

        Scanner reader = new Scanner(System.in);

        String option;
        System.out.println("1) Search file name 2) Search using regex.");
        option = reader.nextLine();

        if (option.equals("1")) {

            System.out.println("Enter file name (with extension): ");
            String keyword = reader.nextLine();

            Vector<String> searchResults = SearchFile(keyword);
            System.out.println("Search Results: \n\n");
            if (!searchResults.isEmpty()) {
                System.out.println("Results: " + searchResults.size());
                for (int i = 0; i < searchResults.size(); i++) {
                    System.out.println(searchResults.get(i));
                }
            } else {
                System.out.println("No results found.");
            }

        }

        if (option.equals("2")) {

            System.out.println("Enter keyword: ");
            String keyword = reader.nextLine();

            List<String> searchResults = SearchContent(keyword);

            if (!searchResults.isEmpty()) {
                System.out.println("Search Results: \n\n");
                System.out.println("Found results: " + searchResults.size());
                for (int i = 0; i < searchResults.size(); i++) {
                    System.out.println(searchResults.get(i));
                }
            } else {
                System.out.println("No results found.");
            }

        }

        //_______________________________________________
    }


    private class crawl implements Runnable {

        @Override
        public void run() {

        }


    }

}

