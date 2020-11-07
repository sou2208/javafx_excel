package excel_cli_rd;

import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import sun.misc.IOUtils;

/**
 *
 * @author sdidi
 */
public class FXMLDocumentController implements Initializable {
    
   //VARIABLES-------------------------------------------------------------------------------------------
    @FXML
    private Tab GP;

    @FXML
    private Tab GC;
    
    @FXML
    private Tab WD;

    @FXML
    private AnchorPane anchor;

    @FXML
    private TabPane tab_pane;

    @FXML
    private AnchorPane tab1;

    @FXML
    private TextField txft_1;

    @FXML
    private TextField txft_5;

    @FXML
    private TextField txft_4;

    @FXML
    private TextField txft_3;

    @FXML
    private TextField txft_2;

    @FXML
    private Button bouton_parcourir_1;

    @FXML
    private Button bouton_parcourir_5;

    @FXML
    private Button bouton_parcourir_4;

    @FXML
    private Button bouton_parcourir_3;

    @FXML
    private Button bouton_parcourir_2;

    @FXML
    private TextField txft_6;

    @FXML
    private Button bouton_parcourir_6;

    @FXML
    private Button bouton_ouvrir_excel;

    @FXML
    private AnchorPane tab2;

    @FXML
    private TextField txft_7;

    @FXML
    private TextField txft_8;

    @FXML
    private Button bouton_parcourir_7;

    @FXML
    private Button bouton_parcourir_8;

    @FXML
    private Button bouton_ouvrir_excel1;

    @FXML
    private TextField txft_9;

    @FXML
    private Button bouton_parcourir_9;

    @FXML
    private Button bouton_ouvrir_excel_2;
    
    
    @FXML
    private Button bouton_ouvrir_word;

    @FXML
    private TabPane tab_pane1;

    @FXML
    private Tab GP1;

    @FXML
    private AnchorPane tab11;

    @FXML
    private TextField txft_11;

    @FXML
    private TextField txft_21;

    @FXML
    private Button bouton_parcourir_10;

    @FXML
    private Button bouton_parcourir_11;

    @FXML
    private ComboBox<String> Type,combo1,combo2;

    @FXML
    private Tab GC1;

    @FXML
    private AnchorPane tab21;

    @FXML
    private TextField txft_71;

    @FXML
    private TextField txft_81;

    @FXML
    private Button bouton_parcourir_71;

    @FXML
    private Button bouton_parcourir_81;

    @FXML
    private Button bouton_ouvrir_excel11;

    @FXML
    private TextField txft_91;

    @FXML
    private Button bouton_parcourir_91;

    @FXML
    private Button bouton_ouvrir_excel_21;
    
    @FXML
    private ImageView img,img2,img3,img4,img5,img6;
    String line = System.getProperty("line.separator");
    String workspace;
    public static String chemin_ref;
    public static String nomSession = System.getProperty("user.home"),session;  
    public static  String tab[]=nomSession.split("Users");
//FONCTION initialize-------------------------------------------------------------------------------------------
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        workspace=new File("").getAbsolutePath(); 
       
        anchor.setTopAnchor(tab_pane,0.0);
        anchor.setBottomAnchor(tab_pane,0.0);
        anchor.setRightAnchor(tab_pane,0.0);
        anchor.setLeftAnchor(tab_pane,0.0);
        //GP.setStyle("-fx-border-color:#689D71; -fx-text-fill: #c4d8de;");
        ArrayList<String>list5=new ArrayList<String>();
        list5.add("DLL");list5.add("PROG/COPY");list5.add("PROC/MBR/JCL");
        Type.setItems(FXCollections.observableList(list5));
        
        ArrayList<String>list=new ArrayList<String>();
        list.add("Complete");list.add("Delta");list.add("Pas de compilation");
        combo1.setItems(FXCollections.observableList(list));
        
        ArrayList<String>list2=new ArrayList<String>();
        list2.add("Complete");list2.add("Delta");list2.add("Pas de compilation");
        combo2.setItems(FXCollections.observableList(list2));
        
        String localUrl =getClass().getResource("pss.png").toString();
        Image image = new Image(localUrl);
        img.setImage(image);
        
        String localUrl1 =getClass().getResource("pss.png").toString();
        Image image1 = new Image(localUrl1);
        img2.setImage(image1);
        
        String localUrl2 =getClass().getResource("pss.png").toString();
        Image image2 = new Image(localUrl2);
        img3.setImage(image2);
        
        String localUrl3 =getClass().getResource("word.png").toString();
        Image image3 = new Image(localUrl3);
        img4.setImage(image3);
        
        String localUrl4 =getClass().getResource("pss.png").toString();
        Image image4 = new Image(localUrl4);
        img5.setImage(image4);
        
        String localUrl5 =getClass().getResource("pss.png").toString();
        Image image5 = new Image(localUrl5);
        img6.setImage(image5);
        System.out.println(getClass().getResourceAsStream("gener_ref_param_complet.xlsm"));
        
    } 
//Generateur referentiels de parametrage complet----------------------------------------------------------------
    @FXML
    void bouton_parcourir_2(ActionEvent event)throws Exception {
        final FileChooser fileChooser = new FileChooser();
        File fileC=fileChooser.showOpenDialog(null);
        txft_2.setText(fileC.getName());
        chemin_ref=fileC.getParent();
               
    }
    
    @FXML
    void bouton_parcourir_3(ActionEvent event)throws Exception {
       final FileChooser fileChooser = new FileChooser();
        File fileC=fileChooser.showOpenDialog(null);
        txft_3.setText(fileC.getName());
        
                
    }
    
    @FXML
    void bouton_parcourir_4(ActionEvent event)throws Exception {
        final FileChooser fileChooser = new FileChooser();
        File fileC=fileChooser.showOpenDialog(null);
        txft_4.setText(fileC.getName());
        
    }
    
    @FXML
    void bouton_parcourir_5(ActionEvent event)throws Exception {
        final FileChooser fileChooser = new FileChooser();
        File fileC=fileChooser.showOpenDialog(null);
        txft_5.setText(fileC.getName());
        
                
    }
   
    @FXML
    void bouton_parcourir_6(ActionEvent event)throws Exception{
        final DirectoryChooser  fileChooser = new DirectoryChooser ();
        File fileC=fileChooser.showDialog(null);
        txft_6.setText(fileC.getPath());
        InputStream is=getClass().getResourceAsStream("gener_ref_param_complet.xlsm");
        XSSFWorkbook wb = new XSSFWorkbook(is);
        XSSFSheet sheet = wb.getSheet(wb.getSheetName(0));
        
        XSSFRow row3 = sheet.getRow(3);XSSFCell  cell3 = row3.getCell(4);cell3.setCellValue(chemin_ref);
        XSSFRow row5 = sheet.getRow(5);XSSFCell  cell5 = row5.getCell(4);cell5.setCellValue(txft_2.getText());
        XSSFRow row7 = sheet.getRow(7);XSSFCell  cell7 = row7.getCell(4);cell7.setCellValue(txft_3.getText());
        if(txft_4.getText().compareTo("")!=0){XSSFRow row9 = sheet.getRow(9);XSSFCell  cell9 = row9.getCell(4);cell9.setCellValue(txft_4.getText());}
        if(txft_5.getText().compareTo("")!=0){XSSFRow row11 = sheet.getRow(11);XSSFCell  cell11 = row11.getCell(4);cell11.setCellValue(txft_5.getText());}
        XSSFRow row14 = sheet.getRow(14);XSSFCell  cell14 = row14.getCell(3);cell14.setCellValue(txft_6.getText());
        FileOutputStream fileOut= new FileOutputStream(txft_6.getText()+"\\gener_ref_param_complet.xlsm");
        wb.write(fileOut);
        fileOut.close(); 
                
    }
    
    @FXML
    void bouton_ouvrir_excel(ActionEvent event) throws Exception {
        //si ils y'a un champs vide on affiche un msg d'err
        if(txft_2.getText().compareTo("")==0 ||txft_3.getText().compareTo("")==0 ||txft_6.getText().compareTo("")==0 ){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erreur");
            alert.setHeaderText("Alerte Champs Vide");
            alert.setContentText("Veuillez SVP renseigner tous les champs, Merci");
            alert.showAndWait();
        }
        else{
            String txt="Option Explicit" +line+
            "On Error Resume Next" +line+
            "ExempleMacroExcel" +line+
            "Sub ExempleMacroExcel()" +line+
            "Dim ApplicationExcel" +line+
            "Dim ClasseurExcel" +line+
            "Set ApplicationExcel = CreateObject(\"Excel.Application\") " +line+
            "Set ClasseurExcel = ApplicationExcel.Workbooks.Open(\""+txft_6.getText()+"\\gener_ref_param_complet.xlsm"+"\")"+line+
            "ApplicationExcel.Visible = True"+line+
            "ApplicationExcel.Run \"GenererListe\""+line +
            "ApplicationExcel.Quit"+line +
            "Set ClasseurExcel = Nothing"+line +
            "Set ApplicationExcel = Nothing"+line +
            "End Sub";
            
            File fileToWrite = new File(txft_6.getText()+"script.vbs");
            RandomAccessFile raf = new RandomAccessFile(txft_6.getText()+"\\script.vbs", "rw");
            raf.seek(0);
            raf.write(txt.getBytes());
            raf.close();
            Runtime.getRuntime().exec("wscript "+txft_6.getText()+"\\script.vbs");
            ////supp_script(txft_6.getText());
            //String[] commande = {"cmd.exe", "/C",  "gener_ref_param_complet.xlsm"};
            //Runtime.getRuntime().exec(commande);
        }
    }
    
    
//Generateur Composants a livrer----------------------------------------------------------------------------------   
     @FXML
    void bouton_parcourir_7(ActionEvent event)throws Exception {
        final DirectoryChooser  fileChooser = new DirectoryChooser ();
        File fileC=fileChooser.showDialog(null);
        txft_7.setText(fileC.getPath());
        
       
    }
   
    @FXML
    void bouton_parcourir_8(ActionEvent event)throws Exception {
        final FileChooser fileChooser = new FileChooser ();
        File fileC=fileChooser.showOpenDialog(null);
        txft_8.setText(fileC.getPath());
        
        
    }
    
    @FXML
    void bouton_parcourir_9(ActionEvent event) throws Exception{
        final DirectoryChooser  fileChooser = new DirectoryChooser ();
        File fileC=fileChooser.showDialog(null);
        txft_9.setText(fileC.getPath());
        InputStream is=getClass().getResourceAsStream("gener_liste_composants_a_livrer.xlsm");
        XSSFWorkbook wb = new XSSFWorkbook(is);
        XSSFSheet sheet = wb.getSheet(wb.getSheetName(0));
        XSSFRow row3 = sheet.getRow(3);XSSFCell  cell3 = row3.getCell(4);cell3.setCellValue(txft_7.getText());
        XSSFRow row5 = sheet.getRow(5);XSSFCell  cell5 = row5.getCell(4);cell5.setCellValue(txft_8.getText());
        //METTRE PSS PAR DEFAUT
        XSSFRow row11 = sheet.getRow(11);XSSFCell  cell11 = row11.getCell(6);cell11.setCellValue("X");
        XSSFRow row12 = sheet.getRow(12);XSSFCell  cell12 = row12.getCell(6);cell12.setCellValue("");
        XSSFRow row7 = sheet.getRow(7);XSSFCell  cell7 = row7.getCell(4);cell7.setCellValue(txft_9.getText());
        FileOutputStream fileOut= new FileOutputStream(txft_9.getText()+"gener_liste_composants_a_livrer.xlsm");
        wb.write(fileOut);
        fileOut.close(); 
    }
    
    @FXML
    void bouton_ouvrir_excel_2(ActionEvent event)throws Exception {
        if(txft_7.getText().compareTo("")==0 ||txft_8.getText().compareTo("")==0 ||txft_9.getText().compareTo("")==0 ){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erreur");
            alert.setHeaderText("Alerte Champs Vide");
            alert.setContentText("Veuillez SVP renseigner tous les champs, Merci");
            alert.showAndWait();
            
        }
        else{
            String[] commande = {"cmd.exe", "/C", txft_9.getText()+"gener_liste_composants_a_livrer.xlsm"};
            Runtime.getRuntime().exec(commande);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("pour lancer l'outil");
            alert.setContentText("Veuillez SVP cliquer sur le boutton de l'Excel, Merci");
            alert.showAndWait();
        }
    }


//Generateur listes habillage----------------------------------------------------------------------------------   
    @FXML
    void bouton_parcourir_10(ActionEvent event) throws Exception{
        final DirectoryChooser  fileChooser = new DirectoryChooser ();
        File fileC=fileChooser.showDialog(null);
        if(fileC!=null){
            txft_11.setText(fileC.getPath());
            
        }
        
    }
    
    @FXML
    void bouton_parcourir_11(ActionEvent event)throws Exception {
        final FileChooser fileChooser = new FileChooser ();
        File fileC=fileChooser.showOpenDialog(null);
        txft_21.setText(fileC.getName());
        
    }
    
    @FXML
    void bouton_ouvrir_excel_3(ActionEvent event)throws Exception {
        if(txft_11.getText().compareTo("")==0 ||txft_21.getText().compareTo("")==0  ){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erreur");
            alert.setHeaderText("Alerte Champs Vide");
            alert.setContentText("Veuillez SVP renseigner tous les champs, Merci");
            alert.showAndWait();
            
        }
        else{
            InputStream is=getClass().getResourceAsStream("gener_listes_habillage .xlsm");
            XSSFWorkbook wb = new XSSFWorkbook(is);
            XSSFSheet sheet = wb.getSheet(wb.getSheetName(0));
            XSSFRow row1_ = sheet.getRow(1);XSSFCell  cell2 = row1_.getCell(2);cell2.setCellValue(txft_11.getText());
            XSSFRow row1__ = sheet.getRow(1);XSSFCell  cell3 = row1__.getCell(3);cell3.setCellValue(txft_21.getText());
            XSSFRow row1 = sheet.getRow(1);
            XSSFCell  cell7 = row1.getCell(7);XSSFCell  cell8 = row1.getCell(8);XSSFCell  cell9 = row1.getCell(9);
            if(Type.getValue().compareTo("DLL")==0){
               cell7.setCellValue("X");
               cell8.setCellValue("");cell9.setCellValue("");
            }
            if(Type.getValue().compareTo("PROG/COPY")==0){
                cell8.setCellValue("X");
                cell7.setCellValue("");cell9.setCellValue("");
            }
            if(Type.getValue().compareTo("PROC/MBR/JCL")==0){
                cell9.setCellValue("X");
                cell8.setCellValue("");cell7.setCellValue("");
            }
            FileOutputStream fileOut= new FileOutputStream(workspace+"\\gener_listes_habillage .xlsm");
            wb.write(fileOut);
            fileOut.close(); 
            
            String txt="Option Explicit" +line+
            "On Error Resume Next" +line+
            "ExempleMacroExcel" +line+
            "Sub ExempleMacroExcel()" +line+
            "Dim ApplicationExcel" +line+
            "Dim ClasseurExcel" +line+
            "Set ApplicationExcel = CreateObject(\"Excel.Application\") " +line+
            "Set ClasseurExcel = ApplicationExcel.Workbooks.Open(\""+workspace+"\\gener_listes_habillage .xlsm"+"\")"+line+
            "ApplicationExcel.Visible = True"+line+
            "ApplicationExcel.Run \"Generer_Liste_PDSMAN\""+line +
            "ApplicationExcel.Quit"+line +
            "Set ClasseurExcel = Nothing"+line +
            "Set ApplicationExcel = Nothing"+line +
            "End Sub";
            
            File fileToWrite = new File(workspace+"/script.vbs");
            RandomAccessFile raf = new RandomAccessFile(workspace+"\\script.vbs", "rw");
            raf.seek(0);
            raf.write(txt.getBytes());
            raf.close();
            Runtime.getRuntime().exec("wscript "+workspace+"\\script.vbs");
            //supp_script(txft_11.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("vous trouverai votre fichier dans votre ");
            alert.setContentText(workspace);
            alert.showAndWait();
        }
    }


//Generateur compil masse----------------------------------------------------------------------------------   
    @FXML
    void bouton_parcourir_12(ActionEvent event) throws Exception{
        final DirectoryChooser  fileChooser = new DirectoryChooser ();
        File fileC=fileChooser.showDialog(null);
        if(fileC!=null){
            txft_71.setText(fileC.getPath());
            
        }
        
    }
    
    @FXML
    void bouton_parcourir_13(ActionEvent event) throws Exception{
        final FileChooser  fileChooser = new FileChooser ();
        File fileC=fileChooser.showOpenDialog(null);
        if(fileC!=null){
            txft_81.setText(fileC.getPath());
           
        }
        
    }
    
    @FXML
    void bouton_ouvrir_excel_4(ActionEvent event)throws Exception {
        if(txft_71.getText().compareTo("")==0 ||txft_81.getText().compareTo("")==0  ){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erreur");
            alert.setHeaderText("Alerte Champs Vide");
            alert.setContentText("Veuillez SVP renseigner tous les champs, Merci");
            alert.showAndWait();
            
        }
        else{
            FileInputStream file = new FileInputStream(new File("generer_compil_masse.xlsm"));
            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheet(wb.getSheetName(0));
            XSSFRow row9 = sheet.getRow(9);
            XSSFCell  cell4 = row9.getCell(4);XSSFCell  cell6 = row9.getCell(6);XSSFCell  cell8 = row9.getCell(8);
            XSSFRow row3 = sheet.getRow(3);XSSFCell  cell4_ = row3.getCell(4);cell4_.setCellValue(txft_71.getText());
            XSSFRow row5 = sheet.getRow(5);XSSFCell  cell4__ = row5.getCell(4);cell4__.setCellValue(txft_81.getText());
            if(combo1.getValue().compareTo("Complete")==0){
               cell4.setCellValue("X");
               cell6.setCellValue("");cell8.setCellValue("");
            }
            if(combo1.getValue().compareTo("Delta")==0){
                cell6.setCellValue("X");
                cell4.setCellValue("");cell8.setCellValue("");
            }
            if(combo1.getValue().compareTo("Pas de compilation")==0){
                cell8.setCellValue("X");
                cell4.setCellValue("");cell6.setCellValue("");
            }
            ///////////
            XSSFRow row11 = sheet.getRow(11);
            XSSFCell  cell04 = row11.getCell(4);XSSFCell  cell06 = row11.getCell(6);XSSFCell  cell08 = row11.getCell(8);
            if(combo2.getValue().compareTo("Complete")==0){
               cell04.setCellValue("X");
               cell06.setCellValue("");cell08.setCellValue("");
            }
            if(combo2.getValue().compareTo("Delta")==0){
                cell06.setCellValue("X");
                cell04.setCellValue("");cell08.setCellValue("");
            }
            if(combo2.getValue().compareTo("Pas de compilation")==0){
                cell08.setCellValue("X");
                cell04.setCellValue("");cell06.setCellValue("");
            }
            /////////////////
            FileOutputStream fileOut= new FileOutputStream("generer_compil_masse.xlsm");
            wb.write(fileOut);
            fileOut.close(); 
            
            String txt="Option Explicit" +line+
            "On Error Resume Next" +line+
            "ExempleMacroExcel" +line+
            "Sub ExempleMacroExcel()" +line+
            "Dim ApplicationExcel" +line+
            "Dim ClasseurExcel" +line+
            "Set ApplicationExcel = CreateObject(\"Excel.Application\") " +line+
            "Set ClasseurExcel = ApplicationExcel.Workbooks.Open(\""+workspace+"\\generer_compil_masse.xlsm"+"\")"+line+
            "ApplicationExcel.Visible = True"+line+
            "ApplicationExcel.Run \"GenererListe\""+line +
            "ApplicationExcel.Quit"+line +
            "Set ClasseurExcel = Nothing"+line +
            "Set ApplicationExcel = Nothing"+line +
            "End Sub";
            
            File fileToWrite = new File(txft_71.getText()+"script.vbs");
            RandomAccessFile raf = new RandomAccessFile(txft_71.getText()+"\\script.vbs", "rw");
            raf.seek(0);
            raf.write(txt.getBytes());
            raf.close();
            Runtime.getRuntime().exec("wscript "+txft_71.getText()+"\\script.vbs");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("vous trouverai votre fichier dans :");
            alert.setContentText(workspace);
            alert.showAndWait();
        }
    }
    

//FONCTION bouton_ouvrir_word----------------------------------------------------------------------------------  
    @FXML
    void bouton_ouvrir_word(ActionEvent event)throws Exception {
        URL url =  getClass().getResource("CEXP_V1.0.2_C.99_BL20180703-001_V1.0.doc");
        File f = getTemporaryFile(url, "CEXP_V1.0.2_C.99_BL20180703-001_V1.0.doc", ".doc");
        Desktop.getDesktop().open(f);
                          
			
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("vous trouverai votre fichier dans :");
        alert.setContentText(f.getPath());
        alert.showAndWait();
        String[] commande = {"cmd.exe", "/C", workspace+"\\CEXP_V1.0.2_C.99_BL20180703-001_V1.0.doc"};
        Runtime.getRuntime().exec(commande);
        
    }

//------------------------------------------------------------------------------------------------
    public void supp_script(String path){
       
        File repertoire = new File(path);
        String liste[] = repertoire.list();     
        if (repertoire.exists() ){
            File[] files = repertoire.listFiles();
            if (files.length>0) {         
                for (int i = 0; i < files.length; i++) {
                    if(files[i].getName().compareTo("script.vbs")==0){
                        files[i].delete();
                    }
                }
            }   
        }
    }

//extraire un fichier dans un ficher temporaire------------------------------------------------------------------------------------------------
    public static File getTemporaryFile(URL url, String prefix, String suffix) throws IOException {
		// Creation du fichier temporaire dans le dossier temporaire système
		File file = File.createTempFile(prefix, suffix);
		// Le fichier sera automatiquement supprimé à la fin de l'application
		file.deleteOnExit();
 
		// Ouverture du fichier en écriture
		OutputStream out = new FileOutputStream(file);
		try {
			// Ouverture de l'URL en lecture
			InputStream in = url.openStream();
			try {
				// Copie par bloc de 8192 bytes :
				byte[] buf = new byte[8192];
				int len = 0;
				while ( (len=in.read(buf)) >= 0 ) {
					out.write(buf, 0, len);
				}
			} finally {
				in.close();
			}
		} finally {
			out.close();
		}
		return file;
	}

}
