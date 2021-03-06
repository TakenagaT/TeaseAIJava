package me.goddragon.teaseai.gui.settings;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import me.goddragon.teaseai.TeaseAI;

import java.io.IOException;


/**
 * Created by GodDragon on 27.03.2018.
 */
public class SettingsController {


    private static SettingsController controller;

    protected MediaSettings mediaSettings = new MediaSettings(this);
    protected ContactSettings contactSettings = new ContactSettings(this);
    protected GeneralSettings generalSettings = new GeneralSettings(this);
    protected DebugSettings debugSettings = new DebugSettings(this);

    protected Stage stage;

    //General
    @FXML
    protected TextField preferredTeaseLengthField;

    @FXML
    protected Button saveGeneralSettingsButton;

    @FXML
    protected ListView urlFilesList;

    @FXML
    protected TextField addURLTextField;

    @FXML
    protected Button addURLButton;

    @FXML
    protected Button deleteURLButton;

    @FXML
    protected Button refreshURLButton;

    @FXML
    protected Label urlProgressLabel;

    @FXML
    protected StackPane urlImageViewStackPane;

    @FXML
    protected ImageView urlFileImagePreview;

    @FXML
    protected CheckBox useURLForTease;

    @FXML
    protected ListView urlFileDragDropList;

    @FXML
    protected ListView assignedURLFileList;

    @FXML
    protected ListView urlFetishTypeList;

    //Media Files and Folders
    @FXML
    protected ListView mediaFetishTypeList;

    @FXML
    protected Button addImagePathButton;

    @FXML
    protected TextField addImagePathTextBox;

    @FXML
    protected Button addImagePathFileChooserButton;

    @FXML
    protected ListView imagePathListView;

    @FXML
    protected Button addVideoPathButton;

    @FXML
    protected TextField addVideoPathTextBox;

    @FXML
    protected Button addVideoPathFileChooserButton;

    @FXML
    protected ListView videoPathListView;

    //Contacts
    @FXML
    protected ListView domContactListView;

    @FXML
    protected ImageView domContactImageView;

    @FXML
    protected TextField domContactNameField;

    @FXML
    protected Button saveContactButton;

    @FXML
    protected StackPane domContactImageStackPane;

    @FXML
    protected TextField domContactImageSetPathText;

    @FXML
    protected Button domContactImageSetPathButton;

    @FXML
    protected Label clickContactAvatarText;

    //Debug
    @FXML
    protected ListView variableListView;

    @FXML
    protected TextField variableValueTextField;

    @FXML
    protected Button variableSaveButton;

    public void initiate() {
        mediaSettings.initiate();
        contactSettings.initiate();
        generalSettings.initiate();
        debugSettings.initiate();
    }

    public static void openGUI() {
        controller = new SettingsController();
        FXMLLoader loader = new FXMLLoader(TeaseAI.class.getResource("gui/settings/settings.fxml"));
        loader.setController(SettingsController.getController());

        try {
            Parent root = loader.load();
            controller.stage = new Stage();
            controller.stage.setTitle("Tease-AI Settings");
            controller.stage.setScene(new Scene(root, 1280, 650));
            controller.stage.show();

            controller.initiate();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SettingsController getController() {
        return controller;
    }

    public static void setController(SettingsController controller) {
        SettingsController.controller = controller;
    }
}
