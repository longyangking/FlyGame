import javafx.scene.canvas.GraphicsContext;

public class MyBullet extends Bullet {
	public MyBullet(double posX, double posY, GraphicsContext gc){
		this.posX = posX;
		this.posY = posY;
		this.velX = 0;
		this.velY = -Config.MyPlaneBulletVelocity;
		this.size = Config.MyPlaneBulletSize;
		this.alpha = Config.MyPlaneBulletAlpha;
		this.color = Config.MyPlaneBulletColor;
		this.hasTail = false;
		this.aLive = true;
		this.context = gc;
	}
}
