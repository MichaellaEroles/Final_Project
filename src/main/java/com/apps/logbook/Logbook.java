/*
 * Main class for launching the Logbook application.
 */
package com.apps.logbook;

import com.apps.logbook.forms.LoginForm;
import com.apps.logbook.config.DbConnector;

public class Logbook {

    public static void main(String[] args) {
        // Initialize the database
        
    new DbConnector();

    }
}
