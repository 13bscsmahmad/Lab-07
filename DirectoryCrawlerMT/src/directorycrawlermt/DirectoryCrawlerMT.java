package directorycrawlermt;

import java.util.*;
import java.io.*;

/**
 * Created by MMA on 4/1/2016.
 * 
 * This lab crawls and indexes file names, which can be searched.
 * 
 */

public class DirectoryCrawlerMT {


    
    public ArrayList<String> fileList = new ArrayList<String>();
    public WorkQueue workQ;
    static int i = 0;

    private class Worker implements Runnable {

        private WorkQueue queue;

        public Worker(WorkQueue q) {
            queue = q;
        }


        public void run() {
            String name;
            while ((name = queue.remove()) != null) {
                File file = new File(name);
                String entries[] = file.list();
                if (entries == null)
                    continue;
                for (String entry : entries) {
                    if (entry.compareTo(".") == 0)
                        continue;
                    if (entry.compareTo("..") == 0)
                        continue;
                    String fn = name + "\\" + entry;
                    //every loop adds the new directory as key and all sub-directories as values
                    fileList.add(fn);
                    System.out.println(fn);
                }
            }
        }
    }

    public DirectoryCrawlerMT() {
        workQ = new WorkQueue();
    }

    public Worker createWorker() {
        return new Worker(workQ);
    }


// need try ... catch below in case the directory is not legal

    public void processDirectory(String dir) {
        try{
            File file = new File(dir);
            if (file.isDirectory()) {
                String entries[] = file.list();
                if (entries != null)
                    workQ.add(dir);

                for (String entry : entries) {
                    String subdir;

                    if (entry.compareTo(".") == 0)
                        continue;
                    if (entry.compareTo("..") == 0)
                        continue;
                    if (dir.endsWith("\\"))
                        subdir = dir+entry;

                    else
                        subdir = dir+"\\"+entry;
                    processDirectory(subdir);

                }
            }}catch(Exception e){}
    }

    public static void main(String Args[]) {

        DirectoryCrawlerMT lc = new DirectoryCrawlerMT();

//  now start all of the worker threads

        int N = 5;
        ArrayList<Thread> thread = new ArrayList<Thread>(N);
        for (int i = 0; i < N; i++) {
            Thread t = new Thread(lc.createWorker());
            thread.add(t);
            t.start();
        }

//  place each directory into the workQ

        String query;
        Scanner scanner = new Scanner(System.in);
        lc.processDirectory("C:\\Users\\MMA\\Desktop");
        System.out.println("Enter keyword for search:");
        query = scanner.nextLine();
        

        int index;

        for(int i=0; i<lc.fileList.size() ; i++)
        {
            index = lc.fileList.get(i).indexOf(query);

            if(index != -1)
            {
                System.out.println(lc.fileList.get(i));
            }

            

        }

//  indicate that there are no more directories to add

        lc.workQ.finish();

        for (int i = 0; i < N; i++){
            try {
                thread.get(i).join();
            } catch (Exception e) {};
        }
    }

}