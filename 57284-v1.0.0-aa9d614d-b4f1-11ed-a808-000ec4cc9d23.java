/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE643_Unsafe_Treatment_of_XPath_Input__console_readLine_41.java
Label Definition File: CWE643_Unsafe_Treatment_of_XPath_Input.label.xml
Template File: sources-sinks-41.tmpl.java
*/
/*
 * @description
 * CWE: 643 Unsafe Treatment of XPath Input
 * BadSource: console_readLine Read data from the console using readLine
 * GoodSource: A hardcoded string
 * Sinks: unvalidatedXPath
 *    GoodSink: validate input through StringEscapeUtils
 *    BadSink : user input is used without validate
 * Flow Variant: 41 Data flow: data passed as an argument from one method to another in the same class
 *
 * */

package testcases.CWE643_Unsafe_Treatment_of_XPath_Input;

import testcasesupport.*;

import java.io.*;
import javax.xml.xpath.*;
import javax.servlet.http.*;

import org.xml.sax.InputSource;

import org.apache.commons.lang.StringEscapeUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.logging.Logger;

public class CWE643_Unsafe_Treatment_of_XPath_Input__console_readLine_41 extends AbstractTestCase
{

    private void bad_sink(String data ) throws Throwable
    {

        final String xmldoc = "\\src\\testcases\\CWE643_Unsafe_Treatment_of_XPath_Input\\console_to_evaluate\\CWE643_Unsafe_Treatment_of_XPath_Input__helper.xml";

        /* assume username||password as source */
        String [] tokens = data.split("||");
        if( tokens.length < 2 )
        {
            return;
        }
        String uname = tokens[0];
        String pword = tokens[1];

        /* build xpath */
        XPath xp = XPathFactory.newInstance().newXPath();
        InputSource inxml = new InputSource(xmldoc);
        /* INCIDENTAL: CWE180 Incorrect Behavior Order: Validate Before Canonicalize
         * 	The user input should be canonicalized before validation.
         */
        /* FLAW: user input is used without validate */
        String query = "//users/user[name/text()='" + uname +
        "' and pass/text()='" + pword + "']" +
        "/secret/text()";
        String secret = (String)xp.evaluate(query, inxml, XPathConstants.STRING);

    }

    public void bad() throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        data = ""; /* init data */

        /* read user input from console with readLine*/
        BufferedReader buffread = null;
        InputStreamReader instrread = null;
        try {
            instrread = new InputStreamReader(System.in);
            buffread = new BufferedReader(instrread);
            data = buffread.readLine();
        }
        catch( IOException ioe )
        {
            log_bad.warning("Error with stream reading");
        }
        finally {
            /* clean up stream reading objects */
            try {
                if( buffread != null )
                {
                    buffread.close();
                }
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error closing buffread");
            }
            finally {
                try {
                    if( instrread != null )
                    {
                        instrread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing instrread");
                }
            }
        }

        bad_sink(data  );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    private void goodG2B_sink(String data ) throws Throwable
    {

        final String xmldoc = "\\src\\testcases\\CWE643_Unsafe_Treatment_of_XPath_Input\\console_to_evaluate\\CWE643_Unsafe_Treatment_of_XPath_Input__helper.xml";

        /* assume username||password as source */
        String [] tokens = data.split("||");
        if( tokens.length < 2 )
        {
            return;
        }
        String uname = tokens[0];
        String pword = tokens[1];

        /* build xpath */
        XPath xp = XPathFactory.newInstance().newXPath();
        InputSource inxml = new InputSource(xmldoc);
        /* INCIDENTAL: CWE180 Incorrect Behavior Order: Validate Before Canonicalize
         * 	The user input should be canonicalized before validation.
         */
        /* FLAW: user input is used without validate */
        String query = "//users/user[name/text()='" + uname +
        "' and pass/text()='" + pword + "']" +
        "/secret/text()";
        String secret = (String)xp.evaluate(query, inxml, XPathConstants.STRING);

    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data;

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded string */
        data = "foo";

        goodG2B_sink(data  );
    }

    private void goodB2G_sink(String data ) throws Throwable
    {

        final String xmldoc = "\\src\\testcases\\CWE643_Unsafe_Treatment_of_XPath_Input\\console_to_evaluate\\CWE643_Unsafe_Treatment_of_XPath_Input__helper.xml";

        /* assume username||password as source */
        String [] tokens = data.split("||");
        if( tokens.length < 2 )
        {
            return;
        }

        /* FIX: validate input using StringEscapeUtils */
        String uname = StringEscapeUtils.escapeXml(tokens[0]);
        String pword = StringEscapeUtils.escapeXml(tokens[1]);

        /* build xpath */
        XPath xp = XPathFactory.newInstance().newXPath();
        InputSource inxml = new InputSource(xmldoc);

        String query = "//users/user[name/text()='" + uname +
        "' and pass/text()='" + pword + "']" +
        "/secret/text()";
        String secret = (String)xp.evaluate(query, inxml, XPathConstants.STRING);

    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        data = ""; /* init data */

        /* read user input from console with readLine*/
        BufferedReader buffread = null;
        InputStreamReader instrread = null;
        try {
            instrread = new InputStreamReader(System.in);
            buffread = new BufferedReader(instrread);
            data = buffread.readLine();
        }
        catch( IOException ioe )
        {
            log_bad.warning("Error with stream reading");
        }
        finally {
            /* clean up stream reading objects */
            try {
                if( buffread != null )
                {
                    buffread.close();
                }
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error closing buffread");
            }
            finally {
                try {
                    if( instrread != null )
                    {
                        instrread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing instrread");
                }
            }
        }

        goodB2G_sink(data  );
    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }

}
