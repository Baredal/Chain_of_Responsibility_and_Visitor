package ucu.edu.ua.apps.task2;



import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

public class Signature<T> extends Task<T> {
    public Consumer<T> consumer;
    public Signature(Consumer<T> consumer) {
        this.consumer = consumer;
    }

    public void apply(T arg) {
        this.freeze();
        consumer.accept(arg);
    }

    public void stamp(StampingVisitor<T> stampingVisitor) {
        stampingVisitor.onSignature(this);
        this.setHeader("signature", stampingVisitor.onSignature(this).get("signature"));
    }

}
