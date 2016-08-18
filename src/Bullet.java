import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import javafx.scene.Parent;
import javafx.animation.AnimationTimer;

public class Bullet extends Parent{
	GraphicsContext context;
	AnimationTimer timer;
	double alpha;
	double posX;
	double posY;
	double velX;
	double velY;
	int size;
	Paint color;
	boolean hasTail;
	boolean aLive;
	double fade = 0.1;
	/*
	public Bullet(double posX, double posY, double velX, double velY,
			int size, Paint color, boolean hasTail, double alpha){
		this.posX = posX;
		this.posY = posY;
		this.velX = velX;
		this.velY = velY;
		this.size = size;
		this.alpha = alpha;
		this.color = color;
		this.hasTail = hasTail;
		this.aLive = true;
	}
	*/
	public void InitBullet(){
		timer = new AnimationTimer() {
			@Override
			public void handle(long now){
				//context.setFill(Color.rgb(0,0,0,0.2));
				//context.fillRect(0, 0, Config.SCREEN_WIDTH,Config.SCREEN_HEIGHT);
				context.clearRect(0,0, Config.SCREEN_WIDTH,Config.SCREEN_HEIGHT);
				if (update()) {
					draw();
				}
			}
		};
		timer.start();
	}
	
	public boolean update(){
		posX += velX;
		posY += velY;
		if (posY < 0) {
			timer.stop();
			context.clearRect(0,0, Config.SCREEN_WIDTH,Config.SCREEN_HEIGHT);
			aLive = false;
		}
		return aLive;
	}
	
	public void draw() {
		final double x = Math.round(posX);
		final double y = Math.round(posY);
		context.setGlobalAlpha(alpha);
		context.setFill(color);
		context.fillOval(x-size, y+size, size+size, size+size);
		if(hasTail){
			context.setFill(color);
			context.fillPolygon(
					new double[]{posX + 2*size, posX + velX, posX - 2*size},
                    new double[]{posY, posY + velY, posY}, 3);
		}
	}
}
