import javafx.scene.canvas.Canvas;
import javafx.scene.effect.Reflection;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Enemy extends FlyObject{
	int waitTime = 0;
	public Enemy(Pane root){
		this.imageview = new ImageView();
		this.imageview.setImage(Config.getImage(Config.ImageEnemy));
		this.height = Config.getImage(Config.ImageEnemy).getHeight();
		this.width = Config.getImage(Config.ImageEnemy).getWidth();
		this.imageview.setFitWidth(Config.EnemyWidth);
		this.imageview.setFitHeight(Config.EnemyHeight);
		getChildren().add(this.imageview);
		this.posX = Config.SCREEN_WIDTH*3/4*Math.random()+Config.SCREEN_WIDTH/4;
		this.posY = -Config.EnemyHeight;
		this.setTranslateX(posX);
		this.setTranslateY(posY);
		this.velX = 0;	
		this.velY = Config.EnemyVelocity*Math.random()/2 + Config.EnemyVelocity/2;
		this.aLive = true;
		this.root = root;
		this.waitTime = 0;
	}
	
	public boolean update(MyPlane myplane){
		posX += velX;
		posY += velY;
		waitTime++;
		if (waitTime % 100 == 0){
			waitTime = 0;
			fire(myplane);
		}
		if (posY > Config.SCREEN_HEIGHT){
			aLive = false;
		}
		//this.setRotate(this.getRotate() + 1);
		return aLive;
	}
	
	public void fire(MyPlane myplane){
		Canvas canvas = new Canvas(Config.SCREEN_WIDTH,Config.SCREEN_HEIGHT);
		canvas.setEffect(new Reflection(0, 0.4, 0.15, 0));
	    root.getChildren().add(canvas);
	    double X = myplane.getTranslateX() - posX;
	    double Y = myplane.getTranslateY() - posY;
	    double T = Math.sqrt(Math.pow(X, 2) + Math.pow(Y, 2));
	    EnemyBullet enemybullet = new EnemyBullet(
	    		posX + Config.EnemyWidth/2,
	    		posY + Config.EnemyHeight/2,
	    		Config.EnemyBulletVelocity*X/T,
	    		Config.EnemyBulletVelocity*Y/T,
	    		canvas.getGraphicsContext2D());
	    enemybullet.InitBullet();
	}
	
	public void draw(){
		this.setTranslateX(posX);
		this.setTranslateY(posY);
	}
}
