/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE643_Unsafe_Treatment_of_XPath_Input__fromFile_61a.java
Label Definition File: CWE643_Unsafe_Treatment_of_XPath_Input.label.xml
Template File: sources-sinks-61a.tmpl.java
*/
/*
 * @description
 * CWE: 643 Unsafe Treatment of XPath Input
 * BadSource: fromFile Read data from file (named c:\data.txt)
 * GoodSource: A hardcoded string
 * Sinks: unvalidatedXPath
 *    GoodSink: validate input through StringEscapeUtils
 *    BadSink : user input is used without validate
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
 *
 * */

package testcases.CWE643_Unsafe_Treatment_of_XPath_Input;

import testcasesupport.*;

import java.io.*;
import javax.xml.xpath.*;
import javax.servlet.http.*;

import org.xml.sax.InputSource;

import org.apache.commons.lang.StringEscapeUtils;

public class CWE643_Unsafe_Treatment_of_XPath_Input__fromFile_61a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data = (new CWE643_Unsafe_Treatment_of_XPath_Input__fromFile_61b()).bad_source();

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

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data = (new CWE643_Unsafe_Treatment_of_XPath_Input__fromFile_61b()).goodG2B_source();

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

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        String data = (new CWE643_Unsafe_Treatment_of_XPath_Input__fromFile_61b()).goodB2G_source();

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
