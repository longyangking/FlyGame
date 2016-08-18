import javafx.scene.canvas.GraphicsContext;

public class EnemyBullet extends Bullet{
	public EnemyBullet(double posX, double posY, double velX, double velY, GraphicsContext gc){
		this.posX = posX;
		this.posY = posY;
		this.velX = velX;
		this.velY = velY;
		this.size = Config.EnemyBulletSize;
		this.alpha = Config.EnemyBulletAlpha;
		this.color = Config.EnemyBulletColor;
		this.hasTail = false;
		this.aLive = true;
		this.context = gc;
	}
}
