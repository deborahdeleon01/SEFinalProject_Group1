package database;

import java.io.File;

/**
 *
 * @author Juan Delgado
 * This class will create our directories and contains all the paths to them.
 * The paths are retrievable.
 */
public final class DirectoryStructure {
    
    //Directory paths
    private static final String VACPAC_XML = "./VacPac/XML/";
    private static final String VACPAC_CSS = "./VacPac/STYLES/";
    private static final String VACPAC_PDF = "./VacPac/pdf/";
    private static final String VACPAC_PDF_EMAIL = "./VacPac/pdf/EmailAttachment/";
    private static final String VACPAC_HTML = "./VacPac/html";
    private static final String VACPAC_ROOT = "./VacPac/";
    
    /**
     * @author Juan Delgado
     * This class will have pure static methods,
     * so there is no need to instantiate it.
     */
    private DirectoryStructure (){
        
    }
    
    /**
     * 
     * @return VACPAC_XML
     */
    public static String getVACPAC_XML() {
        return VACPAC_XML;
    }
    
    /**
     * 
     * @return VACPAC_CSS
     */
    public static String getVACPAC_CSS() {
        return VACPAC_CSS;
    }
    
    /**
     * 
     * @return VACPAC_PDF
     */
    public static String getVACPAC_PDF() {
        return VACPAC_PDF;
    }
    
    /**
     * 
     * @return VACPAC_HTML
     */
    public static String getVACPAC_HTML() {
        return VACPAC_HTML;
    }
    
    /**
     * 
     * @return VACPAC_ROOT
     */
    public static String getVACPAC_ROOT() {
        return VACPAC_ROOT;
    }
    
    /**
     * 
     * @return VACPAC_PDF_EMAIL
     */
    public static String getVACPAC_PDF_EMAIL() {
        return VACPAC_PDF_EMAIL;
    }
    
    /**
     * @author Juan Delgado
     * Creates the necessary directories. 
     * The function uses the File function mkdirs instead of mkdir so vacpac and css can be created.
     */
    public static void createDirectoriesIfNotExists(){
        File directory = new File(VACPAC_XML);
        if(!directory.exists())
            directory.mkdirs();
        directory = new File(VACPAC_PDF);
        if(!directory.exists())
            directory.mkdirs();
        directory = new File(VACPAC_HTML);
        if(!directory.exists())
            directory.mkdirs();
        directory = new File(VACPAC_CSS);
        if(!directory.exists())
            directory.mkdirs();
        directory = new File(VACPAC_PDF_EMAIL);
        if(!directory.exists())
            directory.mkdirs();
    } 
}
