package Rockstew;

import greenfoot.*;


public class Score extends Actor
{
    public static final float FONT_SIZE = 48.0f;
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    public Score(int kills, int time)
    {
        makeImage("Game Over", "Kills: ", kills, "Time:", time);
    }

    private void makeImage(String title, String prefix1, int kills, String prefix2, int time)
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);
        image.setColor(new Color(0, 0, 0, 160));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(255, 255, 255, 100));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        
        image.drawString(title, 60, 70);
        image.drawString(prefix1 + kills, 60, 145);
        image.drawString(prefix2 + time, 60, 205);
        image.drawString("GG", 60, 270);
        setImage(image);
    }
}
