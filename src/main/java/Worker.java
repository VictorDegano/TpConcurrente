public class Worker extends Thread {
    private Buffer buffer;
    public Worker(Buffer buffer) { this.buffer = buffer; }

    @Override
    public void run() {
        while (buffer.isEmpty()){
            try { wait(); }
            catch (InterruptedException e) {}
        }

    }
}
