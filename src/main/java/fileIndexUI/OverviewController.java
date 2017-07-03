package fileIndexUI;

import java.io.IOException;

import fileIndexProject.IndexingController;
import fileIndexProject.Pair;
import fileIndexProject.WordContainer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class OverviewController {
	@FXML
    private TableView<Pair> searchTable;
	@FXML
    private TableColumn<Pair, Integer> wordPositionColumn;
    @FXML
    private TableColumn<Pair, String> filePathColumn;

    @FXML
    private Label errorLabel;
    
    @FXML
    private TextField directoryField;
    @FXML
    private TextField wordPhraseField;
    
    private boolean searchClicked = false;
    
   
    private WordContainer wordContainer = new WordContainer();
	private IndexingController indexer = new IndexingController();
    
    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public OverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        wordPositionColumn.setCellValueFactory(cellData -> cellData.getValue().getPositionProperty().asObject());
        filePathColumn.setCellValueFactory(cellData -> cellData.getValue().getfilePathProperty());
    }
    
    @FXML
	private void handleSearch() {
    	System.out.println(directoryField.getText());
	    String dir = directoryField.getText();
	    System.out.println(wordPhraseField.getText());
	    String word = wordPhraseField.getText();
	    
	    this.wordContainer = new WordContainer();
		this.indexer = new IndexingController();
		
		if(!dir.equals(indexer.getDirectory())){
			try {
				errorLabel.setText("");
				searchTable.getItems().clear();
				
				wordContainer = indexer.indexDirectory(dir);
 				if(wordContainer == null){
					errorLabel.setText("Directory is Invalid.");
					errorLabel.setTextFill(Color.RED);
					searchTable.getItems().clear();
					return;
				}
 				
				ObservableList<Pair> listCheck = FXCollections.observableArrayList();
				listCheck = wordContainer.findPhrase(word);
				if(listCheck == null){
					errorLabel.setText(word + " not found.");
					errorLabel.setTextFill(Color.RED);
					searchTable.getItems().clear();
					return;
				}
				
				searchTable.setItems(listCheck);
				wordPositionColumn.setCellValueFactory(cellData -> cellData.getValue().getPositionProperty().asObject());
		        filePathColumn.setCellValueFactory(cellData -> cellData.getValue().getfilePathProperty());
			
			} catch (IOException e) {
				errorLabel.setText("Directory is Invalid.");
				errorLabel.setTextFill(Color.RED);
				searchTable.getItems().clear();
			}
		}
		else{
			
		}
		
	    
	    
	    searchClicked = true;
	}
    
    public boolean isSearchClicked(){
		return searchClicked;
	}

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        Stage primaryStage = mainApp.getPrimaryStage();
        
        ObservableList<Pair> obsList = FXCollections.observableArrayList();
        searchTable.setItems(obsList);
        
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println("Stage is closing: Killing all threads");
            }
        });
    }
}
