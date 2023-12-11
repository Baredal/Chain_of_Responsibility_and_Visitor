package ucu.edu.ua.apps.task2;

import java.util.Map;

public interface StampingVisitor<T> {
    Map<String, String> onGroupStart(Task<T> task);
    Map<String, String> onGroupEnd(Task<T> task);
    Map<String, String> onSignature(Task<T> task);
}
