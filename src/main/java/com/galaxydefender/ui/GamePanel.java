package com.galaxydefender.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.galaxydefender.adapter.KeyboardAdapter;
import com.galaxydefender.bullets.Bullet;
 import com.galaxydefender.bullets.EnemyBullet;
 import com.galaxydefender.decorator.DoubleDamageDecorator;
 import com.galaxydefender.decorator.RapidFireDecorator;
import com.galaxydefender.decorator.ShieldDecorator;
import com.galaxydefender.enemy.BossEnemy;
import com.galaxydefender.enemy.Enemy;
import com.galaxydefender.factorymethod.BossFactory;
import com.galaxydefender.factorymethod.EnemyFactory;
import com.galaxydefender.factorymethod.FighterFactory;
import com.galaxydefender.factorymethod.HeavyFactory;
import com.galaxydefender.factorymethod.ScoutFactory;
import com.galaxydefender.game.CollisionManager;
import com.galaxydefender.game.GameLoop;
import com.galaxydefender.game.ScoreManager;
import com.galaxydefender.player.Player;
import com.galaxydefender.powerup.HealthPack;
import com.galaxydefender.powerup.PowerUp;
import com.galaxydefender.singleton.GameManager;
import com.galaxydefender.util.Constants;

public final class GamePanel extends JPanel {
    private final JFrame frame; private final Player player=new Player(); private final ScoreManager score=new ScoreManager();
    private final java.util.List<Enemy> enemies=new ArrayList<>(); private final java.util.List<Bullet> shots=new ArrayList<>(); private final java.util.List<EnemyBullet> enemyShots=new ArrayList<>(); private final java.util.List<PowerUp> powerUps=new ArrayList<>();
    private final GameLoop loop; private ShieldDecorator shield; private RapidFireDecorator rapid; private DoubleDamageDecorator doubleDamage; private long lastShot; private int fireMode=1;
    public GamePanel(JFrame frame){this.frame=frame;setPreferredSize(new Dimension(Constants.WIDTH,Constants.HEIGHT));setBackground(new Color(4,8,25));setFocusable(true); GameManager.getInstance().reset();spawnLevel(); KeyboardAdapter keys=new KeyboardAdapter(this); addKeyListener(new KeyAdapter(){public void keyPressed(KeyEvent e){keys.pressed(e.getKeyCode());}public void keyReleased(KeyEvent e){keys.released(e.getKeyCode());}}); loop=new GameLoop(e->tick());loop.start();SwingUtilities.invokeLater(this::requestFocusInWindow);}
    public void handleKey(int key,boolean down){if(key==KeyEvent.VK_ESCAPE&&down){loop.stop();frame.dispose();return;} if(key==KeyEvent.VK_P&&down){GameManager.getInstance().togglePause();repaint();return;} if(down&&key>=KeyEvent.VK_1&&key<=KeyEvent.VK_3){fireMode=key-KeyEvent.VK_0;} player.up=key==KeyEvent.VK_W?down:player.up;player.down=key==KeyEvent.VK_S?down:player.down;player.left=key==KeyEvent.VK_A?down:player.left;player.right=key==KeyEvent.VK_D?down:player.right;}
    private void fire(){long now=System.currentTimeMillis();int delay=rapid!=null&&rapid.active()?45:(fireMode==1?135:fireMode==2?80:45);if(now-lastShot<delay)return;lastShot=now;int damage=doubleDamage!=null&&doubleDamage.active()?20:10;shots.add(new Bullet(player.x()+15,player.y()-10,-11,damage));if(fireMode==3)shots.add(new Bullet(player.x()+28,player.y()-10,-11,damage));}
    private void tick(){if(GameManager.getInstance().paused())return;player.update();fire(); enemies.forEach(Enemy::update); shots.forEach(Bullet::update); enemyShots.forEach(Bullet::update); powerUps.forEach(PowerUp::update); for(Enemy e:enemies)enemyShots.addAll(e.shoot()); collisions(); shots.removeIf(b->b.y<-20);enemyShots.removeIf(b->b.y>670);powerUps.removeIf(p->p.y>670);enemies.removeIf(e->e.bounds().y>670);if(enemies.isEmpty())advance();repaint();}
    private void collisions(){
        for(Iterator<Bullet> it=shots.iterator();it.hasNext();){Bullet b=it.next();for(Iterator<Enemy> ei=enemies.iterator();ei.hasNext();){Enemy e=ei.next();if(CollisionManager.intersects(b.bounds(),e.bounds())){it.remove();if(e.hit(b.damage)){score.add(e.score());if(Math.random()<.18)powerUps.add(new PowerUp(PowerUp.Type.values()[(int)(Math.random()*4)],e.bounds().x,e.bounds().y));ei.remove();}break;}}}
        for(Iterator<EnemyBullet> it=enemyShots.iterator();it.hasNext();){EnemyBullet b=it.next();if(CollisionManager.intersects(b.bounds(),player.bounds())){it.remove();damage(10);}}
        for(Enemy e:enemies)if(CollisionManager.intersects(e.bounds(),player.bounds()))damage(20);
        for(Iterator<PowerUp> it=powerUps.iterator();it.hasNext();){PowerUp p=it.next();if(CollisionManager.intersects(p.bounds(),player.bounds())){activate(p.type);it.remove();}}
        for(Enemy e:enemies)if(e instanceof BossEnemy boss&&boss.laserNow())damage(30);
    }
    private void damage(int amount){if(shield!=null&&shield.active())return;if(player.damage(amount)){end(false);return;}player.resetPosition();}
    private void activate(PowerUp.Type type){switch(type){case SHIELD->shield=new ShieldDecorator(player);case RAPID_FIRE->rapid=new RapidFireDecorator(player);case DOUBLE_DAMAGE->doubleDamage=new DoubleDamageDecorator(player);case HEALTH->new HealthPack().apply(player);}}
    private void advance(){score.add(100);if(GameManager.getInstance().level()>=4){score.add(500);end(true);return;}GameManager.getInstance().nextLevel();spawnLevel();}
    private void spawnLevel(){enemies.clear();int level=GameManager.getInstance().level();if(level==1)add(new ScoutFactory(),10);else if(level==2){add(new FighterFactory(),8);add(new ScoutFactory(),5);}else if(level==3){add(new HeavyFactory(),5);add(new FighterFactory(),8);}else enemies.add(new BossFactory().create(415,80));}
    private void add(EnemyFactory factory,int count){for(int i=0;i<count;i++)enemies.add(factory.create(45+(i%10)*82,45+(i/10)*58));}
    private void end(boolean won){loop.stop();frame.setContentPane(won?new VictoryScreen(frame,score.value()):new GameOverScreen(frame,score.value()));frame.revalidate();}
    protected void paintComponent(Graphics g){super.paintComponent(g);Graphics2D d=(Graphics2D)g;d.setColor(Color.WHITE);for(int i=0;i<80;i++)d.fillRect((i*71)%900,(i*113)%650,2,2);d.setColor(Color.CYAN);d.fillPolygon(new int[]{player.x()+21,player.x(),player.x()+42},new int[]{player.y(),player.y()+42,player.y()+42},3);for(Bullet b:shots){d.setColor(Color.YELLOW);d.fillRect((int)b.x,(int)b.y,12,16);}for(EnemyBullet b:enemyShots){d.setColor(Color.RED);d.fillRect((int)b.x,(int)b.y,5,12);}for(Enemy e:enemies){d.setColor(e.color());Rectangle r=e.bounds();d.fillRoundRect(r.x,r.y,r.width,r.height,10,10);d.setColor(Color.BLACK);d.drawString(e.label(),r.x+3,r.y+21);}for(PowerUp p:powerUps){d.setColor(Color.WHITE);d.fillOval((int)p.x,(int)p.y,20,20);d.setColor(Color.BLACK);d.drawString(p.type.toString().substring(0,1),(int)p.x+7,(int)p.y+14);}d.setColor(Color.WHITE);d.drawString("HP: "+player.health()+"   Lives: "+player.lives()+"   Score: "+score.value()+"   Level: "+GameManager.getInstance().level()+"   Auto-fire: "+(fireMode==1?"Normal [1]":fireMode==2?"Rapid [2]":"Turbo [3]"),15,22);if(shield!=null&&shield.active()){d.setColor(Color.CYAN);d.drawOval(player.x()-5,player.y()-5,52,52);}if(GameManager.getInstance().paused()){d.setColor(new Color(0,0,0,180));d.fillRect(0,0,getWidth(),getHeight());d.setColor(Color.WHITE);d.setFont(d.getFont().deriveFont(36f));d.drawString("PAUSED",370,320);}}
}
