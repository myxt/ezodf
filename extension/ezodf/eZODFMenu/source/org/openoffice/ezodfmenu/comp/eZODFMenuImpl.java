package org.openoffice.ezodfmenu.comp;

import com.sun.star.uno.XComponentContext;
import com.sun.star.lib.uno.helper.Factory;
import com.sun.star.lang.XSingleComponentFactory;
import com.sun.star.registry.XRegistryKey;
import com.sun.star.lib.uno.helper.WeakBase;


public final class eZODFMenuImpl extends WeakBase
   implements com.sun.star.lang.XServiceInfo,
              org.openoffice.ezodfmenu.XEzodfmenu
{
    private final XComponentContext m_xContext;
    private static final String m_implementationName = eZODFMenuImpl.class.getName();
    private static final String[] m_serviceNames = {
        "org.openoffice.ezodfmenu.eZODFMenu" };


    public eZODFMenuImpl( XComponentContext context )
    {
        m_xContext = context;
    };

    public static XSingleComponentFactory __getComponentFactory(String sImplementationName ) {
        XSingleComponentFactory xFactory = null;

        if ( sImplementationName.equals( m_implementationName ) )
            xFactory = Factory.createComponentFactory(eZODFMenuImpl.class, m_serviceNames);
        return xFactory;
    }

    public static boolean __writeRegistryServiceInfo(XRegistryKey xRegistryKey ) {
        return Factory.writeRegistryServiceInfo(m_implementationName,
                                                m_serviceNames,
                                                xRegistryKey);
    }

    // com.sun.star.lang.XServiceInfo:
    public String getImplementationName() {
         return m_implementationName;
    }

    public boolean supportsService( String sService ) {
        int len = m_serviceNames.length;

        for( int i=0; i < len; i++) {
            if (sService.equals(m_serviceNames[i]))
                return true;
        }
        return false;
    }

    public String[] getSupportedServiceNames() {
        return m_serviceNames;
    }

    // org.openoffice.ezodfmenu.XEzodfmenu:
    public void open()
    {
    	OpenController openController = OpenController.getInstance( m_xContext );
    	openController.openDialog();
    }

    public void save()
    {
		SaveController saveController = SaveController.getInstance( m_xContext );
		saveController.saveDocument();
    }

    public void saveAs()
    {
		SaveAsController saveAsController = SaveAsController.getInstance( m_xContext );
		saveAsController.openDialog();
    }
    
    public static void main( String[] argv )
    {
    	SaveAsController saveAsController = SaveAsController.getInstance( null );
		saveAsController.openDialog();
/*    	OpenController openController = new OpenController( null );
    	openController.openDialog();*/
    }

}
