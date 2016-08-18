import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.input.KeyCode;
import javafx.scene.canvas.Canvas;
import javafx.animation.AnimationTimer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameEngine{
	Pane root;
	ImageView background, otherground;
	Canvas canvas;
	AnimationTimer timer;
	
	MyPlane myplane;
	List<Enemy> enemys = new ArrayList<>();
	int countEnemy = 3;
	List<Rock> rocks = new ArrayList<>();
	int countRock = 2;
	AnimationTimer enemytimer;
	
	public GameEngine(Pane root){
		Config.Initialize();
		
		this.root = root;
		this.background = new ImageView();
		this.background.setFocusTraversable(true);
		this.background.setImage(Config.getImage(Config.ImageBackground));
		this.background.setOpacity(0.7);
		this.background.setFitWidth(Config.SCREEN_WIDTH);
		this.background.setFitHeight(Config.SCREEN_HEIGHT);
		
		this.otherground = new ImageView();
		//this.otherground.setFocusTraversable(true);
		this.otherground.setImage(Config.getImage(Config.ImageBackground));
		this.otherground.setOpacity(0.7);
		this.otherground.setFitWidth(Config.SCREEN_WIDTH);
		this.otherground.setFitHeight(Config.SCREEN_HEIGHT);
		this.otherground.setTranslateY(-Config.SCREEN_HEIGHT);
		root.getChildren().addAll(background,otherground);
		
		timer = new AnimationTimer() {
			@Override
			public void handle(long now){
				double newY = background.getTranslateY() + Config.BackgroundSpeed;
				if (newY <= Config.SCREEN_HEIGHT){
					background.setTranslateY(newY);
				} else{
					background.setTranslateY(-Config.SCREEN_HEIGHT);
				}
				newY = otherground.getTranslateY() + Config.BackgroundSpeed;
				if (newY <= Config.SCREEN_HEIGHT){
					otherground.setTranslateY(newY);
				} else{
					otherground.setTranslateY(-Config.SCREEN_HEIGHT);
				}
				}
			};
		timer.start();
		

        myplane = new MyPlane();
        myplane.setTranslateX(Config.SCREEN_WIDTH/2 - Config.MyPlaneWidth/2);
        myplane.setTranslateY(Config.SCREEN_HEIGHT - Config.MyPlaneHeight);
        
        try {
        	root.getChildren().add(myplane);
        }catch(NullPointerException ex){
        	System.out.println("MyPlane is Null!");
        	System.out.println(myplane.toString());
        }
        
        background.setOnKeyPressed((KeyEvent ke) ->{
        	if (ke.getCode() == KeyCode.LEFT){
        		double newX = myplane.getTranslateX() - Config.MyPlaneVelocity;
        		if (newX >=0){
        			myplane.setTranslateX(newX);
        		}else{
        			myplane.setTranslateX(0);
        		}
        	}
        	if (ke.getCode() == KeyCode.RIGHT){
        		double newX = myplane.getTranslateX() + Config.MyPlaneVelocity;
        		if (newX <= Config.SCREEN_WIDTH - Config.MyPlaneWidth){
        			myplane.setTranslateX(newX);
        		}else{
        			myplane.setTranslateX(Config.SCREEN_WIDTH - Config.MyPlaneWidth);
        		}
        	}
        	if (ke.getCode() == KeyCode.UP) {
        		double newY = myplane.getTranslateY() - Config.MyPlaneVelocity;
        		if (newY >=0) {
        			myplane.setTranslateY(newY);
        		}else{
        			myplane.setTranslateY(0);
        		}
        	}
        	if (ke.getCode() == KeyCode.DOWN) {
        		double newY = myplane.getTranslateY() + Config.MyPlaneVelocity;
        		if (newY <= Config.SCREEN_HEIGHT- Config.MyPlaneHeight) {
        			myplane.setTranslateY(newY);
        		}else{
        			myplane.setTranslateY(Config.SCREEN_HEIGHT - Config.MyPlaneHeight);
        		}
        	}
        	if (ke.getCode() == KeyCode.SPACE){
        		myplane.fire(root);
        	}
        	/*
        	if (ke.getCode() == KeyCode.SPACE || ke.getCode() == KeyCode.RIGHT){
        		myplane.fire(root);
        		double newX = myplane.getTranslateX() + Config.MyPlaneVelocity;
        		if (newX <= Config.SCREEN_WIDTH - Config.MyPlaneWidth){
        			myplane.setTranslateX(newX);
        		}else{
        			myplane.setTranslateX(Config.SCREEN_WIDTH - Config.MyPlaneWidth);
        		}
        	}
        	if (ke.getCode() == KeyCode.SPACE && ke.getCode() == KeyCode.LEFT){
        		myplane.fire(root);
        		double newX = myplane.getTranslateX() - Config.MyPlaneVelocity;
        		if (newX >=0){
        			myplane.setTranslateX(newX);
        		}else{
        			myplane.setTranslateX(0);
        		}
        	}
        	*/
        });
        background.setOnKeyReleased((KeyEvent ke) ->{
        	if (ke.getCode() == KeyCode.LEFT || ke.getCode() == KeyCode.RIGHT || ke.getCode() == KeyCode.SPACE || ke.getCode() == KeyCode.UP || ke.getCode() == KeyCode.DOWN){
        		ke.consume();
        	}
        });       
	}
	
	public void Start(){
		enemytimer = new AnimationTimer() {
			@Override
			public void handle(long now){
				loadEnemy();
				if (countEnemy > 0){
					newEnemy();
					countEnemy--;
				}
				loadRock();
				if (countRock > 0) {
					newRock();
					countRock--;
				}
			}
		};
		enemytimer.start();
	}
	
	public void loadEnemy(){
		Iterator<Enemy> iter = enemys.iterator();
		while (iter.hasNext()){
			Enemy next = iter.next();
			if (next.update(myplane)){
				next.draw();
			} else{
				iter.remove();
				root.getChildren().remove(next);
				countEnemy++;
			}
		}
	}
	
	public void newEnemy(){
		Enemy enemy = new Enemy(root);
		enemys.add(enemy);
		this.root.getChildren().add(enemy);
	}
	
	public void loadRock(){
		Iterator<Rock> iter = rocks.iterator();
		while (iter.hasNext()){
			Rock next = iter.next();
			if (next.update()){
				next.draw();
			} else{
				iter.remove();
				root.getChildren().remove(next);
				countRock++;
			}
		}
	}
	
	public void newRock(){
		Rock rock = new Rock(root);
		rocks.add(rock);
		this.root.getChildren().add(rock);
	}

}
