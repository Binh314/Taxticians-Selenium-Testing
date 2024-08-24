package com.skillstorm.selenium;

public final class Utility {
    private Utility() {

    }
    
    /**
     * Puts the thread to sleep for a specified number of seconds.
     * 
     * @param seconds number of seconds to sleep
     */
    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
