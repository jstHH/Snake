package jst.snake;

public class SnakeSegment {
    private int currentX, currentY;
    private int lastX, lastY;
    private SnakeSegment previousSegment;
    private SnakeSegment nextSegment;

    public SnakeSegment(int posX, int posY) {
        currentX = posX;
        currentY = posY;

    }

    public void move() {
        lastX = currentX;
        lastY = currentY;
        currentX = previousSegment.getLastX();
        currentY = previousSegment.getLastY();

    }

    public void moveWhenFirstSegment(int newX, int newY) {
        lastX = currentX;
        lastY = currentY;
        currentX = newX;
        currentY = newY;
    }

    public void addNewSegment() {
        SnakeSegment newSegment = new SnakeSegment(lastX, lastY);
        newSegment.setPreviousSegment(this);
        nextSegment = newSegment;
    }



    //Getter und setter


    public int getCurrentX() {
        return currentX;
    }

    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    public int getLastX() {
        return lastX;
    }

    public void setLastX(int lastX) {
        this.lastX = lastX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }

    public int getLastY() {
        return lastY;
    }

    public void setLastY(int lastY) {
        this.lastY = lastY;
    }

    public SnakeSegment getPreviousSegment() {
        return previousSegment;
    }

    public void setPreviousSegment(SnakeSegment previousSegment) {
        this.previousSegment = previousSegment;
    }

    public SnakeSegment getNextSegment() {
        return nextSegment;
    }

    public void setNextSegment(SnakeSegment nextSegment) {
        this.nextSegment = nextSegment;
    }
}
