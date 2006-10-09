/**
 *<p>Title: DynamicExtensionsSystemException</p>
 *<p>Description: System level exception for dynamic extensions </p>
 *<p>Copyright:TODO</p>
 *@author Vishvesh Mulay
 *@version 1.0
 */ 
package edu.common.dynamicextensions.exception;


/**
 *<p>Title:DynamicExtensionsSystemException </p>
 *<p>Description: This exception class represents a system level exception for example
 *<BR> Conncection to the database is reset or lost.
 *<BR> Hibernate exception is thrown or JDBCException is thrown <BR>
 *In such cases whenever this excepion is cuaght, application cannot recover from the situation
 *and error page is shown to the user specifying that fatal error has occured.
 *Proper logging should be done with the detailed stack trace using the wrapped exception.</p>
 *@author Vishvesh Mulay
 */ 
public class DynamicExtensionsSystemException
        extends
            BaseDynamicExtensionsException
{
    
    
}
