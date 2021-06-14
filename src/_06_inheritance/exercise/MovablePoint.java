package _06_inheritance.exercise;

public class MovablePoint extends Point{
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;
    public MovablePoint(){}
    public MovablePoint(float xSpeed,float ySpeed){
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;
    }
    public MovablePoint(float x,float y, float xSpeed,float ySpeed ){
        super.setXY(x,y);
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
//        float[] getSpeed = {this.xSpeed, this.ySpeed};
//        return getSpeed;
        return new float[]{this.xSpeed, this.ySpeed};
    }

    @Override
    public String toString() {
        return  super.toString()+
                " MovablePoint {" +
                "xSpeed= " + xSpeed +
                ", ySpeed= " + ySpeed +
                '}';
    }
    public MovablePoint move() {
        this.setX(super.getX() + this.getxSpeed());
        this.setY(super.getY() + this.getySpeed());
        return this;
    }

    public static void main(String[] args) {
        MovablePoint movePoint = new MovablePoint(10, 15);
        System.out.println(movePoint.toString());
        movePoint.setXY(5, 9);

        System.out.println(movePoint.toString());
        movePoint.move();
        System.out.println("move point: " + movePoint.toString());
    }
}
