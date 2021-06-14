package _04_class_object.exercise;

public class StopWatch {
    private long startTime = System.currentTimeMillis();
    private long endTime;

    public StopWatch() {
    }

    public long getStartTime() {

        return startTime;
    }

    public long getEndTime() {

        return endTime;
    }

    public long start() {
        return this.startTime;
    }

    public long end() {
        this.endTime = System.currentTimeMillis();
        return this.endTime;
    }

    public float getElapsedTime() {
        return (this.end() - this.start());
    }

    public static void main(String[] args) {
        StopWatch newStop = new StopWatch();
        System.out.println("Thời gian bắt đầu: " + newStop.start());
        for (int i = 1; i < 100; i++) ;
        System.out.println("Thời gian kết thúc: " + newStop.end());
        System.out.println("Thời gian thực hiện: " + newStop.getElapsedTime());
    }
}

