import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Rock extends FlyObject {
	public Rock (Pane root) {
		this.imageview = new ImageView();
		this.imageview.setImage(Config.getImage(Config.ImageRock));
		this.height = Config.getImage(Config.ImageRock).getHeight();
		this.width = Config.getImage(Config.ImageRock).getWidth();
		this.imageview.setFitWidth(Config.RockWidth);
		this.imageview.setFitHeight(Config.RockHeight);
		getChildren().add(this.imageview);	
		this.posX = Config.SCREEN_WIDTH*3/4*Math.random()+Config.SCREEN_WIDTH/4;
		this.posY = -Config.RockHeight;
		this.setTranslateX(posX);
		this.setTranslateY(posY);
		this.velX = 0;	
		this.velY = Config.EnemyVelocity*Math.random()/2 + Config.EnemyVelocity/2;
		this.aLive = true;
		this.root = root;
	}
	
	public boolean update(){
		posX += velX;
		posY += velY;
		this.setRotate(this.getRotate() + 1);
		if (posY > Config.SCREEN_HEIGHT){
			aLive = false;
		}
		return aLive;
	}
	
	public void draw(){
		this.setTranslateX(posX);
		this.setTranslateY(posY);
	}
}
