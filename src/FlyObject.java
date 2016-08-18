import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class FlyObject extends Parent {
	ImageView imageview;
	double posX;
	double posY;
	double velX;
	double velY;
	double alpha;
	double height;
	double width;
	boolean aLive;
	Pane root;
	/*
	public FlyObject(double posX, double posY, double velX, double velY,
			double alpha, ImageView image, boolean aLive){
		this.imageview = image;
		this.posX = posX;
		this.posY = posY;
		this.velX = velX;
		this.velY = velY;
		this.alpha = alpha;
		this.aLive = aLive;
	}
	*/
}
