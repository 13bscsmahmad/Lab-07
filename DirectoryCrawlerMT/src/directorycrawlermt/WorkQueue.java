/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directorycrawlermt;

import java.util.LinkedList;

/**
 *
 * @author MMA
 */
public class WorkQueue {

    //
// since we are providing the concurrency control, can use non-thread-safe
// linked list
//
    private LinkedList<String> workQ;
    private boolean done;  // no more directories to be added
    private int size;  // number of directories in the queue

    public WorkQueue() {
        workQ = new LinkedList<String>();
        done = false;
        size = 0;
    }

    public synchronized void add(String s) {
        workQ.add(s);
        size++;
        notifyAll();
    }

    public synchronized String remove() {
        String s;
        while (!done && size == 0) {
            try {
                wait();
            } catch (Exception e) {
            };
        }
        if (size > 0) {
            s = workQ.remove();
            size--;
            notifyAll();
        } else {
            s = null;
        }
        return s;
    }

    public synchronized void finish() {
        done = true;
        notifyAll();
    }

}
