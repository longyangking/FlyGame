import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.Canvas;
//import javafx.scene.effect.BlendMode;
//import javafx.scene.effect.Reflection;
import javafx.scene.effect.Reflection;

public class MyPlane extends FlyObject{
	
	public MyPlane() {	
		this.imageview = new ImageView();
		this.imageview.setImage(Config.getImage(Config.ImageMyPlane));
		this.height = Config.getImage(Config.ImageMyPlane).getHeight();
		this.width = Config.getImage(Config.ImageMyPlane).getWidth();
		this.imageview.setFitWidth(Config.MyPlaneWidth);
		this.imageview.setFitHeight(Config.MyPlaneHeight);
		getChildren().add(this.imageview);	
		//getChildren().add(canvas);
	}	
	
	public void fire(Pane root){
		Canvas canvas = new Canvas(Config.SCREEN_WIDTH,Config.SCREEN_HEIGHT);
	    //canvas.setBlendMode(BlendMode.ADD);
		canvas.setEffect(new Reflection(0, 0.4, 0.15, 0));
	    root.getChildren().add(canvas);
		MyBullet mybullet = new MyBullet(this.getTranslateX()+Config.MyPlaneWidth/2,this.getTranslateY(),canvas.getGraphicsContext2D());
		//System.out.println("Fire!");
		mybullet.InitBullet();
	}
	
	public void dead(Pane pane){
		pane.getChildren().remove(this);
	}
	
}
