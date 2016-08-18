import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.image.Image;
import javafx.scene.paint.Paint;


public class Config {
	//Screen Info
	public static final int SCREEN_WIDTH = 960;
	public static final int SCREEN_HEIGHT = 720;
	//Game field Info
	public static final Paint MyPlaneBulletColor = new RadialGradient(0, 0, 0.5, 0.5, 0.5, true, CycleMethod.NO_CYCLE,
            new Stop(0, Color.WHITE),
            new Stop(0.2, Color.hsb(200, 1, 1)),
            new Stop(0.6, Color.hsb(200, 1, 1, 0.1)),
            new Stop(1, Color.hsb(200, 1, 1, 0)));
	public static final double MyPlaneBulletAlpha = 1;
	public static final int MyPlaneBulletSize = 18;
	public static final double MyPlaneBulletVelocity = 20;
	public static final Paint EnemyBulletColor = new RadialGradient(0, 0, 0.5, 0.5, 0.5, true, CycleMethod.NO_CYCLE,
            new Stop(0, Color.WHITE),
            new Stop(0.2, Color.hsb(1, 1, 1)),
            new Stop(0.6, Color.hsb(1, 1, 1, 0.1)),
            new Stop(1, Color.hsb(1, 1, 1, 0)));
	public static final double EnemyBulletAlpha = 1;
	public static final int EnemyBulletSize = 20;
	public static final double EnemyBulletVelocity = 5;
	
	//Objects Info
	public static final double MyPlaneHeight = 100;
	public static final double MyPlaneWidth = 100;
	public static final double RockHeight = 120;
	public static final double RockWidth = 120;
	public static final double EnemyHeight = 100;
	public static final double EnemyWidth = 100;
	
	public static final double BackgroundSpeed = 2;
	
	public static final double MyPlaneVelocity = 15;
	public static final double EnemyVelocity = 2;
	public static final double RockVelocity = 5;
	
	public static final int MAXLives = 3;
	//Resource Info
	public static final int ImageMyPlane = 0;
	public static final int ImageEnemy = 1;
	public static final int ImageRock = 2;
	public static final int ImageBackground = 3;
	public static final int ImageLogo = 4;
	public static final int ImageStart = 5;
	public static final int ImageEnd = 6;
	public static final int ImageScore = 7;
	
    private static ObservableList<Image> images = javafx.collections.FXCollections.<Image>observableArrayList();
    
    //Image Process
    public static Image getImage(int num){
    	return images.get(num);
    }
    public static void Initialize(){
    	images.clear();
    	images.add(new Image(Config.class.getResourceAsStream("Resources/MyPlane.png")));
    	images.add(new Image(Config.class.getResourceAsStream("Resources/Enemy.png")));
    	images.add(new Image(Config.class.getResourceAsStream("Resources/Rock.png")));
    	images.add(new Image(Config.class.getResourceAsStream("Resources/Background.png")));
    	images.add(new Image(Config.class.getResourceAsStream("Resources/Logo.png")));
    	images.add(new Image(Config.class.getResourceAsStream("Resources/Start.png")));
    	images.add(new Image(Config.class.getResourceAsStream("Resources/End.png")));
    	images.add(new Image(Config.class.getResourceAsStream("Resources/Score.png")));
    }
    private Config(){
    }
}
