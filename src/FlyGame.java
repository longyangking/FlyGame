import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FlyGame extends Application {

	public Parent createContent(){		
		Pane root = new Pane();		
		root.setPrefSize(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
		root.setMaxSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);
        root.setMinSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);
        
        GameEngine game = new GameEngine(root);
        System.out.println("Game Engine Start!");
        game.Start(); 
        
        return root;
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setResizable(false);
		stage.setTitle("´ò·É»ú");
		stage.setScene(new Scene(createContent()));
		stage.show();
	}
	
	public static void main(String[] args){
		Application.launch(args);
	}
	
}